package com.example.financemanagement.controller;

import com.example.financemanagement.dto.SavingPlanDTO;
import com.example.financemanagement.service.SavingPlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/saving-plans")
public class SavingPlanController {

    private final SavingPlanService savingPlanService;

    public SavingPlanController(SavingPlanService savingPlanService) {
        this.savingPlanService = savingPlanService;
    }

    @PostMapping
    public ResponseEntity<SavingPlanDTO> createSavingPlan(@RequestBody SavingPlanDTO savingPlanDTO) {
        SavingPlanDTO createdSavingPlan = savingPlanService.createSavingPlan(savingPlanDTO);
        return new ResponseEntity<>(createdSavingPlan, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SavingPlanDTO> getSavingPlanById(@PathVariable Long id) {
        SavingPlanDTO savingPlan = savingPlanService.getSavingPlanById(id);
        return ResponseEntity.ok(savingPlan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SavingPlanDTO> updateSavingPlan(@PathVariable Long id, @RequestBody SavingPlanDTO savingPlanDTO) {
        SavingPlanDTO updatedSavingPlan = savingPlanService.updateSavingPlan(id, savingPlanDTO);
        return ResponseEntity.ok(updatedSavingPlan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavingPlan(@PathVariable Long id) {
        savingPlanService.deleteSavingPlan(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<SavingPlanDTO> getSavingPlanByName(@PathVariable String name) {
        SavingPlanDTO savingPlan = savingPlanService.findSavingPlanByGoalName(name);
        return ResponseEntity.ok(savingPlan);
    }
}