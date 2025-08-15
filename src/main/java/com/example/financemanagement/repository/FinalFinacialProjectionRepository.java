package com.example.financemanagement.repository;

import com.example.financemanagement.entity.FinalFinancialProjection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinalFinacialProjectionRepository extends JpaRepository<FinalFinancialProjection, Long> {
    FinalFinancialProjection findByYear(int year);
}
