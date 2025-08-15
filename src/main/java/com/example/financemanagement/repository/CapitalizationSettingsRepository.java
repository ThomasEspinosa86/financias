package com.example.financemanagement.repository;

import com.example.financemanagement.entity.CapitalizationSettings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapitalizationSettingsRepository extends JpaRepository<CapitalizationSettings, Long> {
    CapitalizationSettings findByName(String name);
}
