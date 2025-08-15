package com.example.financemanagement.repository;

import com.example.financemanagement.entity.SavingMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingMovementRepository extends JpaRepository<SavingMovement, Long> {
    SavingMovement findByDescription(String description);
}
