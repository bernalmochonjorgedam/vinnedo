package com.utad.vinned.controller;

import com.utad.vinned.dto.HarvestDTO;
import com.utad.vinned.dto.CollectedHarvestDTO;
import com.utad.vinned.service.HarvestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/harvests")
public class HarvestController {

    @Autowired
    private HarvestService harvestService;

    @GetMapping
    public List<HarvestDTO> getAllHarvests() {
        return harvestService.getAllHarvests();
    }

    @PostMapping
    public ResponseEntity<HarvestDTO> createHarvest(@Valid @RequestBody HarvestDTO harvestDTO) {
        return ResponseEntity.ok(harvestService.createHarvest(harvestDTO));
    }

    @PutMapping("/{harvestId}/collect/{viticulturistId}")
    public ResponseEntity<CollectedHarvestDTO> collectHarvest(@PathVariable Long harvestId, @PathVariable Long viticulturistId) {
        CollectedHarvestDTO collectedHarvest = harvestService.collectHarvest(harvestId, viticulturistId);
        return ResponseEntity.ok(collectedHarvest);
    }
}
