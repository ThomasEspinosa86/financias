package com.example.financemanagement.service;

import com.example.financemanagement.dto.FinalFinancialProjectionDTO;

public interface FinalFinancialProjectionService {
    FinalFinancialProjectionDTO createFinalFinancialProjection(FinalFinancialProjectionDTO finalFinancialProjectionDTO);
    FinalFinancialProjectionDTO getFinalFinancialProjectionById(Long id);
    FinalFinancialProjectionDTO updateFinalFinancialProjection(Long id, FinalFinancialProjectionDTO finalFinancialProjectionDTO);
    void deleteFinalFinancialProjection(Long id);
    FinalFinancialProjectionDTO findFinalFinancialProjectionByName(String name);
}
