package com.utad.vinned.controller;

import com.utad.vinned.dto.PlantationDTO;
import com.utad.vinned.service.PlantationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plantations")
public class PlantationController {

    @Autowired
    private PlantationService plantationService;

    @GetMapping
    public List<PlantationDTO> getAllPlantations() {
        return plantationService.getAllPlantations();
    }

    @PostMapping
    public ResponseEntity<PlantationDTO> createPlantation(@Valid @RequestBody PlantationDTO plantationDTO) {
        return ResponseEntity.ok(plantationService.createPlantation(plantationDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlantation(@PathVariable Long id) {
        plantationService.deletePlantation(id);
        return ResponseEntity.noContent().build();
    }

}
