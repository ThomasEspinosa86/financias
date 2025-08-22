package com.example.financemanagement.service;

import com.example.financemanagement.dto.FinalFinancialProjectionDTO;

public interface FinalFinancialProjectionService {
    FinalFinancialProjectionDTO createFinalFinancialProjection(FinalFinancialProjectionDTO finalFinancialProjectionDTO);
    FinalFinancialProjectionDTO getFinalFinancialProjectionById(Long id);
    FinalFinancialProjectionDTO updateFinalFinancialProjection(Long id, FinalFinancialProjectionDTO finalFinancialProjectionDTO);
    void deleteFinalFinancialProjection(Long id);

    // Este método debería ser revisado o eliminado de la interfaz, como mencionamos anteriormente.
    FinalFinancialProjectionDTO findFinalFinancialProjectionByName(String name);
    // Método anterior eliminado. Se podría considerar un método como:
    // FinalFinancialProjectionDTO findByTargetDate(LocalDate targetDate);
}