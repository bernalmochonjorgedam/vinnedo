package com.utad.vinned.service;

import com.utad.vinned.dto.HarvestDTO;
import com.utad.vinned.mapper.HarvestMapper;
import com.utad.vinned.models.Harvest;
import com.utad.vinned.repository.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HarvestService {
    @Autowired
    private HarvestRepository harvestRepository;

    @Autowired
    private HarvestMapper harvestMapper;

    public List<HarvestDTO> getAllHarvests() {
        return harvestRepository.findAll().stream().map(harvestMapper::toDTO).collect(Collectors.toList());
    }

    public Optional<HarvestDTO> getHarvestById(Long id) {
        return harvestRepository.findById(id).map(harvestMapper::toDTO);
    }

    public HarvestDTO createHarvest(HarvestDTO harvestDTO) {
        Harvest harvest = new Harvest();
        harvest.setDateHarvest(harvestDTO.getDateHarvest());
        harvest.setQuantityKg(harvestDTO.getQuantityKg());
        Harvest savedHarvest = harvestRepository.save(harvest);
        return harvestMapper.toDTO(savedHarvest);
    }

    public void deleteHarvest(Long id) {
        harvestRepository.deleteById(id);
    }
}
