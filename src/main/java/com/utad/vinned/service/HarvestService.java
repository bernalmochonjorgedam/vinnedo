package com.utad.vinned.service;

import com.utad.vinned.dto.HarvestDTO;
import com.utad.vinned.dto.CollectedHarvestDTO;
import com.utad.vinned.mapper.HarvestMapper;
import com.utad.vinned.mapper.CollectedHarvestMapper;
import com.utad.vinned.models.Harvest;
import com.utad.vinned.models.CollectedHarvest;
import com.utad.vinned.models.Plantation;
import com.utad.vinned.models.Viticulturist;
import com.utad.vinned.repository.HarvestRepository;
import com.utad.vinned.repository.CollectedHarvestRepository;
import com.utad.vinned.repository.PlantationRepository;
import com.utad.vinned.repository.ViticulturistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HarvestService {

    @Autowired
    private HarvestRepository harvestRepository;

    @Autowired
    private CollectedHarvestRepository collectedHarvestRepository;

    @Autowired
    private PlantationRepository plantationRepository;

    @Autowired
    private ViticulturistRepository viticulturistRepository;

    @Autowired
    private HarvestMapper harvestMapper;

    @Autowired
    private CollectedHarvestMapper collectedHarvestMapper;

    public List<HarvestDTO> getAllHarvests() {
        return harvestRepository.findAll().stream()
                .map(harvestMapper::toDTO)
                .collect(Collectors.toList());
    }

    public HarvestDTO createHarvest(HarvestDTO dto) {
        Plantation plantation = plantationRepository.findById(dto.getPlantationId())
                .orElseThrow(() -> new RuntimeException("Plantation not found"));

        Harvest harvest = harvestMapper.toEntity(dto);
        harvest.setPlantation(plantation);

        harvestRepository.save(harvest);
        return harvestMapper.toDTO(harvest);
    }

    public CollectedHarvestDTO collectHarvest(Long harvestId, Long viticulturistId) {
        Harvest harvest = harvestRepository.findById(harvestId)
                .orElseThrow(() -> new RuntimeException("Harvest not found"));

        Viticulturist viticulturist = viticulturistRepository.findById(viticulturistId)
                .orElseThrow(() -> new RuntimeException("Viticulturist not found"));

        CollectedHarvest collectedHarvest = new CollectedHarvest();
        collectedHarvest.setCollectionDate(LocalDate.now().toString());
        collectedHarvest.setQuantityKg(harvest.getQuantityKg());
        collectedHarvest.setViticulturist(viticulturist);
        collectedHarvest.setPlantation(harvest.getPlantation());
        collectedHarvest.setPlot(harvest.getPlantation().getPlot());

        collectedHarvestRepository.save(collectedHarvest);
        harvestRepository.delete(harvest);

        return collectedHarvestMapper.toDTO(collectedHarvest);
    }
}
