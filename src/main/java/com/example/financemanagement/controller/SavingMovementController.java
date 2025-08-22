package com.example.financemanagement.controller;

import com.example.financemanagement.dto.SavingMovementDTO;
import com.example.financemanagement.service.SavingMovementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/saving-movements")
public class SavingMovementController {

    private final SavingMovementService savingMovementService;

    public SavingMovementController(SavingMovementService savingMovementService) {
        this.savingMovementService = savingMovementService;
    }

    @PostMapping
    public ResponseEntity<SavingMovementDTO> createSavingMovement(@RequestBody SavingMovementDTO savingMovementDTO) {
        SavingMovementDTO createdMovement = savingMovementService.createSavingMovement(savingMovementDTO);
        return new ResponseEntity<>(createdMovement, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingMovementDTO> getSavingMovementById(@PathVariable Long id) {
        SavingMovementDTO movement = savingMovementService.getSavingMovementById(id);
        return ResponseEntity.ok(movement);
    }

    // NOTA: Se recomienda no tener un PUT o DELETE para movimientos,
    // sino crear un movimiento que compense el anterior.
    // Sin embargo, si tu lógica lo requiere, aquí está la base.
    @PutMapping("/{id}")
    public ResponseEntity<SavingMovementDTO> updateSavingMovement(@PathVariable Long id, @RequestBody SavingMovementDTO savingMovementDTO) {
        SavingMovementDTO updatedMovement = savingMovementService.updateSavingMovement(id, savingMovementDTO);
        return ResponseEntity.ok(updatedMovement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavingMovement(@PathVariable Long id) {
        savingMovementService.deleteSavingMovement(id);
        return ResponseEntity.noContent().build();
    }
}