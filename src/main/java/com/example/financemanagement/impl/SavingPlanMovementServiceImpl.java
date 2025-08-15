package com.example.financemanagement.impl;

import com.example.financemanagement.dto.SavingMovementDTO;
import com.example.financemanagement.repository.SavingMovementRepository;
import com.example.financemanagement.repository.SavingPlanRepository;
import com.example.financemanagement.service.SavingMovementService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SavingPlanMovementServiceImpl implements SavingMovementService {
    private final SavingMovementRepository savingMovementRepository;
    private final ModelMapper modelMapper;

    public SavingPlanMovementServiceImpl(SavingMovementRepository savingMovementRepository, ModelMapper modelMapper) {
        this.savingMovementRepository = savingMovementRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SavingMovementDTO createSavingMovement(SavingMovementDTO savingMovementDTO) {
        return null;
    }

    @Override
    public SavingMovementDTO getSavingMovementById(Long id) {
        return null;
    }

    @Override
    public SavingMovementDTO updateSavingMovement(Long id, SavingMovementDTO savingMovementDTO) {
        return null;
    }

    @Override
    public void deleteSavingMovement(Long id) {

    }

    @Override
    public SavingMovementDTO findSavingMovementByDescription(String description) {
        return null;
    }
}
