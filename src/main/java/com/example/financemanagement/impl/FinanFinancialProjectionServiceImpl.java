// Código corregido para FinanFinancialProjectionServiceImpl
package com.example.financemanagement.impl;

import com.example.financemanagement.dto.FinalFinancialProjectionDTO;
import com.example.financemanagement.entity.FinalFinancialProjection;
import com.example.financemanagement.entity.User;
import com.example.financemanagement.exceptions.ResourceNotFoundException;
import com.example.financemanagement.repository.FinalFinacialProjectionRepository;
import com.example.financemanagement.repository.UserRepository;
import com.example.financemanagement.service.FinalFinancialProjectionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class FinanFinancialProjectionServiceImpl implements FinalFinancialProjectionService {

    private final FinalFinacialProjectionRepository finalFinacialProjectionRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public FinanFinancialProjectionServiceImpl(FinalFinacialProjectionRepository finalFinacialProjectionRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.finalFinacialProjectionRepository = finalFinacialProjectionRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FinalFinancialProjectionDTO createFinalFinancialProjection(FinalFinancialProjectionDTO finalFinancialProjectionDTO) {
        User user = userRepository.findById(finalFinancialProjectionDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + finalFinancialProjectionDTO.getUserId()));

        FinalFinancialProjection projection = modelMapper.map(finalFinancialProjectionDTO, FinalFinancialProjection.class);
        projection.setUser(user);

        // Sumamos los montos del DTO para obtener el total proyectado
        BigDecimal projectedAmount = BigDecimal.valueOf(finalFinancialProjectionDTO.getProjectedIncome())
                .subtract(BigDecimal.valueOf(finalFinancialProjectionDTO.getProjectedExpenses()))
                .add(BigDecimal.valueOf(finalFinancialProjectionDTO.getProjectedSavings()));

        projection.setProjectedAmount(projectedAmount);

        // Se asume que el DTO tiene un campo de fecha que se puede parsear
        projection.setTargetDate(LocalDate.parse(finalFinancialProjectionDTO.getProjectionDate()));

        FinalFinancialProjection savedProjection = finalFinacialProjectionRepository.save(projection);
        return modelMapper.map(savedProjection, FinalFinancialProjectionDTO.class);
    }

    @Override
    public FinalFinancialProjectionDTO getFinalFinancialProjectionById(Long id) {
        FinalFinancialProjection projection = finalFinacialProjectionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FinalFinancialProjection not found with id: " + id));
        return modelMapper.map(projection, FinalFinancialProjectionDTO.class);
    }

    @Override
    public FinalFinancialProjectionDTO updateFinalFinancialProjection(Long id, FinalFinancialProjectionDTO finalFinancialProjectionDTO) {
        FinalFinancialProjection existingProjection = finalFinacialProjectionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FinalFinancialProjection not found with id: " + id));

        // Sumamos los montos del DTO para obtener el total proyectado
        BigDecimal projectedAmount = BigDecimal.valueOf(finalFinancialProjectionDTO.getProjectedIncome())
                .subtract(BigDecimal.valueOf(finalFinancialProjectionDTO.getProjectedExpenses()))
                .add(BigDecimal.valueOf(finalFinancialProjectionDTO.getProjectedSavings()));

        existingProjection.setProjectedAmount(projectedAmount);
        existingProjection.setTargetDate(LocalDate.parse(finalFinancialProjectionDTO.getProjectionDate()));
        existingProjection.setStatus("Activo"); // O el estado que corresponda

        FinalFinancialProjection updatedProjection = finalFinacialProjectionRepository.save(existingProjection);
        return modelMapper.map(updatedProjection, FinalFinancialProjectionDTO.class);
    }

    @Override
    public void deleteFinalFinancialProjection(Long id) {
        if (!finalFinacialProjectionRepository.existsById(id)) {
            throw new ResourceNotFoundException("FinalFinancialProjection not found with id: " + id);
        }
        finalFinacialProjectionRepository.deleteById(id);
    }

    // Este método debería ser revisado o eliminado de la interfaz, como mencionamos anteriormente.
    @Override
    public FinalFinancialProjectionDTO findFinalFinancialProjectionByName(String name) {
        return null;
    }
}