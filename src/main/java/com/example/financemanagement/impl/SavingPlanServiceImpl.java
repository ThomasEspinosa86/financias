package com.example.financemanagement.impl;

import com.example.financemanagement.dto.SavingPlanDTO;
import com.example.financemanagement.repository.SavingPlanRepository;
import com.example.financemanagement.service.SavingPlanService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SavingPlanServiceImpl implements SavingPlanService {
private final SavingPlanRepository savingPlanRepository;
private final ModelMapper modelMapper;

    public SavingPlanServiceImpl(SavingPlanRepository savingPlanRepository, ModelMapper modelMapper) {
        this.savingPlanRepository = savingPlanRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SavingPlanDTO createSavingPlan(SavingPlanDTO savingPlanDTO) {
        return null;
    }

    @Override
    public SavingPlanDTO getSavingPlanById(Long id) {
        return null;
    }

    @Override
    public SavingPlanDTO updateSavingPlan(Long id, SavingPlanDTO savingPlanDTO) {
        return null;
    }

    @Override
    public void deleteSavingPlan(Long id) {

    }

    @Override
    public SavingPlanDTO findSavingPlanByGoalName(String goalName) {
        return null;
    }

    @Override
    public SavingPlanDTO findSavingPlanByName(String name) {
        return null;
    }
}
