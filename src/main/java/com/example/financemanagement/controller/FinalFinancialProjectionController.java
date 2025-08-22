package com.example.financemanagement.controller;

import com.example.financemanagement.dto.FinalFinancialProjectionDTO;
import com.example.financemanagement.service.FinalFinancialProjectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projections")
public class FinalFinancialProjectionController {

    private final FinalFinancialProjectionService finalFinancialProjectionService;

    public FinalFinancialProjectionController(FinalFinancialProjectionService finalFinancialProjectionService) {
        this.finalFinancialProjectionService = finalFinancialProjectionService;
    }

    @PostMapping
    public ResponseEntity<FinalFinancialProjectionDTO> createProjection(@RequestBody FinalFinancialProjectionDTO projectionDTO) {
        FinalFinancialProjectionDTO createdProjection = finalFinancialProjectionService.createFinalFinancialProjection(projectionDTO);
        return new ResponseEntity<>(createdProjection, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinalFinancialProjectionDTO> getProjectionById(@PathVariable Long id) {
        FinalFinancialProjectionDTO projection = finalFinancialProjectionService.getFinalFinancialProjectionById(id);
        return ResponseEntity.ok(projection);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinalFinancialProjectionDTO> updateProjection(@PathVariable Long id, @RequestBody FinalFinancialProjectionDTO projectionDTO) {
        FinalFinancialProjectionDTO updatedProjection = finalFinancialProjectionService.updateFinalFinancialProjection(id, projectionDTO);
        return ResponseEntity.ok(updatedProjection);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjection(@PathVariable Long id) {
        finalFinancialProjectionService.deleteFinalFinancialProjection(id);
        return ResponseEntity.noContent().build();
    }
}