package com.example.financemanagement.service;

import com.example.financemanagement.dto.SavingPlanDTO;

public interface SavingPlanService {
    SavingPlanDTO createSavingPlan(SavingPlanDTO savingPlanDTO);
    SavingPlanDTO getSavingPlanById(Long id);
    SavingPlanDTO updateSavingPlan(Long id, SavingPlanDTO savingPlanDTO);
    void deleteSavingPlan(Long id);
    SavingPlanDTO findSavingPlanByName(String name);
}
