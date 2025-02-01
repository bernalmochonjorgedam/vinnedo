package com.utad.vinned.controller;

import com.utad.vinned.dto.PlantationDTO;
import com.utad.vinned.service.PlantationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plantations")
public class PlantationController {
    @Autowired
    private PlantationService plantationService;

    @GetMapping
    public List<PlantationDTO> getAllPlantations() {
        return plantationService.getAllPlantations();
    }

    @GetMapping("/{id}")
    public Optional<PlantationDTO> getPlantationById(@PathVariable Long id) {
        return plantationService.getPlantationById(id);
    }

    @PostMapping
    public PlantationDTO createPlantation(@RequestBody PlantationDTO plantationDTO) {
        return plantationService.createPlantation(plantationDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePlantation(@PathVariable Long id) {
        plantationService.deletePlantation(id);
    }
}
