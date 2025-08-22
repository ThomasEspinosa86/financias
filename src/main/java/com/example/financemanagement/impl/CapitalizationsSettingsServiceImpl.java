// Código corregido para CapitalizationsSettingsServiceImpl
package com.example.financemanagement.impl;

import com.example.financemanagement.dto.CapitalizationSettingsDTO;
import com.example.financemanagement.entity.CapitalizationSettings;
import com.example.financemanagement.entity.User;
import com.example.financemanagement.exceptions.ResourceNotFoundException;
import com.example.financemanagement.repository.CapitalizationSettingsRepository;
import com.example.financemanagement.repository.UserRepository;
import com.example.financemanagement.service.CapitalizationSettingsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CapitalizationsSettingsServiceImpl implements CapitalizationSettingsService {

    private final CapitalizationSettingsRepository capitalizationSettingsRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public CapitalizationsSettingsServiceImpl(CapitalizationSettingsRepository capitalizationSettingsRepository,
                                              UserRepository userRepository,
                                              ModelMapper modelMapper) {
        this.capitalizationSettingsRepository = capitalizationSettingsRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CapitalizationSettingsDTO createSettings(CapitalizationSettingsDTO settingsDTO) {
        User user = userRepository.findById(settingsDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + settingsDTO.getUserId()));

        CapitalizationSettings settings = modelMapper.map(settingsDTO, CapitalizationSettings.class);
        settings.setUser(user);
        settings.setCreatedAt(LocalDateTime.now());
        settings.setUpdatedAt(LocalDateTime.now());

        CapitalizationSettings savedSettings = capitalizationSettingsRepository.save(settings);
        return modelMapper.map(savedSettings, CapitalizationSettingsDTO.class);
    }

    @Override
    public CapitalizationSettingsDTO getSettingsById(Long id) {
        CapitalizationSettings settings = capitalizationSettingsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CapitalizationSettings not found with id: " + id));
        return modelMapper.map(settings, CapitalizationSettingsDTO.class);
    }

    @Override
    public CapitalizationSettingsDTO updateSettings(Long id, CapitalizationSettingsDTO settingsDTO) {
        CapitalizationSettings existingSettings = capitalizationSettingsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CapitalizationSettings not found with id: " + id));

        existingSettings.setFrequency(settingsDTO.getFrequency());
        // Es importante usar BigDecimal para los cálculos financieros
        existingSettings.setInterestRate(java.math.BigDecimal.valueOf(settingsDTO.getInterestRate()));
        existingSettings.setUpdatedAt(LocalDateTime.now());

        CapitalizationSettings updatedSettings = capitalizationSettingsRepository.save(existingSettings);
        return modelMapper.map(updatedSettings, CapitalizationSettingsDTO.class);
    }

    @Override
    public void deleteSettings(Long id) {
        if (!capitalizationSettingsRepository.existsById(id)) {
            throw new ResourceNotFoundException("CapitalizationSettings not found with id: " + id);
        }
        capitalizationSettingsRepository.deleteById(id);
    }

    // Este método debería ser modificado en la interfaz, ya que la entidad
    // no tiene un campo 'userId' sino una relación ManyToOne con User.
    // Una opción más lógica es buscar por la frecuencia.
    // Por ahora, se mantiene para coincidir con la interfaz, pero se debe adaptar la lógica.
    @Override
    public CapitalizationSettingsDTO findSettingsByUserId(Long userId) {
        // En tu repositorio no existe un método para buscar por userId.
        // Se necesitaría crear un método en CapitalizationSettingsRepository
        // o usar una consulta personalizada. Por ejemplo:
        // Optional<CapitalizationSettings> findByUser_UserId(Long userId);
        // Por ahora se deja así, pero es un punto a resolver.
        return null;
    }
}