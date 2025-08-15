package com.example.financemanagement.service;

import com.example.financemanagement.dto.CapitalizationSettingsDTO;

public interface CapitalizationSettingsService {
    CapitalizationSettingsDTO createSettings(CapitalizationSettingsDTO settingsDTO);
    CapitalizationSettingsDTO getSettingsById(Long id);
    CapitalizationSettingsDTO updateSettings(Long id, CapitalizationSettingsDTO settingsDTO);
    void deleteSettings(Long id);
    CapitalizationSettingsDTO findSettingsByUserId(Long userId);
}
