package com.example.financemanagement.impl;

import com.example.financemanagement.dto.FinalFinancialProjectionDTO;
import com.example.financemanagement.repository.FinalFinacialProjectionRepository;
import com.example.financemanagement.service.FinalFinancialProjectionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class FinanFinancialProjectionServiceImpl implements FinalFinancialProjectionService {
    private final FinalFinacialProjectionRepository finalFinacialProjectionRepository;
    private final ModelMapper modelMapper;

    public FinanFinancialProjectionServiceImpl(FinalFinacialProjectionRepository finalFinacialProjectionRepository, ModelMapper modelMapper) {
        this.finalFinacialProjectionRepository = finalFinacialProjectionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FinalFinancialProjectionDTO createFinalFinancialProjection(FinalFinancialProjectionDTO finalFinancialProjectionDTO) {
        return null;
    }

    @Override
    public FinalFinancialProjectionDTO getFinalFinancialProjectionById(Long id) {
        return null;
    }

    @Override
    public FinalFinancialProjectionDTO updateFinalFinancialProjection(Long id, FinalFinancialProjectionDTO finalFinancialProjectionDTO) {
        return null;
    }

    @Override
    public void deleteFinalFinancialProjection(Long id) {

    }

    @Override
    public FinalFinancialProjectionDTO findFinalFinancialProjectionByName(String name) {
        return null;
    }
}
