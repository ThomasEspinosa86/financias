package com.example.financemanagement.repository;

import com.example.financemanagement.entity.FinalFinancialProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface FinalFinacialProjectionRepository extends JpaRepository<FinalFinancialProjection, Long> {
    FinalFinancialProjection findByTargetDate(LocalDate targetDate);
}