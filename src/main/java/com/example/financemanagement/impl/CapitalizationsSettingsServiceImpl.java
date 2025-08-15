package com.example.financemanagement.impl;

import com.example.financemanagement.dto.CapitalizationSettingsDTO;
import com.example.financemanagement.repository.CapitalizationSettingsRepository;
import com.example.financemanagement.service.CapitalizationSettingsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CapitalizationsSettingsServiceImpl implements CapitalizationSettingsService {
    private final CapitalizationSettingsRepository capitalizationSettingsRepository;
    private final ModelMapper modelMapper;

    public CapitalizationsSettingsServiceImpl(CapitalizationSettingsRepository capitalizationSettingsRepository, ModelMapper modelMapper) {
        this.capitalizationSettingsRepository = capitalizationSettingsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CapitalizationSettingsDTO createSettings(CapitalizationSettingsDTO settingsDTO) {
        return null;
    }

    @Override
    public CapitalizationSettingsDTO getSettingsById(Long id) {
        return null;
    }

    @Override
    public CapitalizationSettingsDTO updateSettings(Long id, CapitalizationSettingsDTO settingsDTO) {
        return null;
    }

    @Override
    public void deleteSettings(Long id) {

    }

    @Override
    public CapitalizationSettingsDTO findSettingsByUserId(Long userId) {
        return null;
    }
}
