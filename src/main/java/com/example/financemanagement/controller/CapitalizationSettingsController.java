package com.example.financemanagement.controller;

import com.example.financemanagement.dto.CapitalizationSettingsDTO;
import com.example.financemanagement.service.CapitalizationSettingsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/capitalization-settings")
public class CapitalizationSettingsController {

    private final CapitalizationSettingsService capitalizationSettingsService;

    public CapitalizationSettingsController(CapitalizationSettingsService capitalizationSettingsService) {
        this.capitalizationSettingsService = capitalizationSettingsService;
    }

    @PostMapping
    public ResponseEntity<CapitalizationSettingsDTO> createSettings(@RequestBody CapitalizationSettingsDTO settingsDTO) {
        CapitalizationSettingsDTO createdSettings = capitalizationSettingsService.createSettings(settingsDTO);
        return new ResponseEntity<>(createdSettings, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CapitalizationSettingsDTO> getSettingsById(@PathVariable Long id) {
        CapitalizationSettingsDTO settings = capitalizationSettingsService.getSettingsById(id);
        return ResponseEntity.ok(settings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CapitalizationSettingsDTO> updateSettings(@PathVariable Long id, @RequestBody CapitalizationSettingsDTO settingsDTO) {
        CapitalizationSettingsDTO updatedSettings = capitalizationSettingsService.updateSettings(id, settingsDTO);
        return ResponseEntity.ok(updatedSettings);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSettings(@PathVariable Long id) {
        capitalizationSettingsService.deleteSettings(id);
        return ResponseEntity.noContent().build();
    }
}