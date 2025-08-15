package com.example.financemanagement.service;

import com.example.financemanagement.dto.SavingMovementDTO;

public interface SavingMovementService {
    SavingMovementDTO createSavingMovement(SavingMovementDTO savingMovementDTO);
    SavingMovementDTO getSavingMovementById(Long id);
    SavingMovementDTO updateSavingMovement(Long id, SavingMovementDTO savingMovementDTO);
    void deleteSavingMovement(Long id);
    SavingMovementDTO findSavingMovementByDescription(String description);
}
