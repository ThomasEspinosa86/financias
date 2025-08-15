package com.example.financemanagement.repository;

import com.example.financemanagement.entity.SavingPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingPlanRepository extends JpaRepository <SavingPlan, Long> {
    SavingPlan findByName(String name);
}
