package com.utad.vinned.service;

import com.utad.vinned.dto.CollectedHarvestDTO;
import com.utad.vinned.mapper.CollectedHarvestMapper;
import com.utad.vinned.repository.CollectedHarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollectedHarvestService {

    @Autowired
    private CollectedHarvestRepository collectedHarvestRepository;

    @Autowired
    private CollectedHarvestMapper collectedHarvestMapper;

    public List<CollectedHarvestDTO> getAllCollectedHarvests() {
        return collectedHarvestRepository.findAll().stream()
                .map(collectedHarvestMapper::toDTO)
                .collect(Collectors.toList());
    }
}
