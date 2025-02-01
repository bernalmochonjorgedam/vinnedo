package com.utad.vinned.controller;

import com.utad.vinned.dto.HarvestDTO;
import com.utad.vinned.service.HarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/harvests")
public class HarvestController {
    @Autowired
    private HarvestService harvestService;

    @GetMapping
    public List<HarvestDTO> getAllHarvests() {
        return harvestService.getAllHarvests();
    }

    @GetMapping("/{id}")
    public Optional<HarvestDTO> getHarvestById(@PathVariable Long id) {
        return harvestService.getHarvestById(id);
    }

    @PostMapping
    public HarvestDTO createHarvest(@RequestBody HarvestDTO harvestDTO) {
        return harvestService.createHarvest(harvestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteHarvest(@PathVariable Long id) {
        harvestService.deleteHarvest(id);
    }
}
