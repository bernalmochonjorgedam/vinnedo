package com.utad.vinned.service;

import com.utad.vinned.dto.PlantationDTO;
import com.utad.vinned.mapper.PlantationMapper;
import com.utad.vinned.models.Plantation;
import com.utad.vinned.repository.PlantationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlantationService {
    @Autowired
    private PlantationRepository plantationRepository;

    @Autowired
    private PlantationMapper plantationMapper;

    public List<PlantationDTO> getAllPlantations() {
        return plantationRepository.findAll().stream()
                .map(plantationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<PlantationDTO> getPlantationById(Long id) {
        return plantationRepository.findById(id).map(plantationMapper::toDTO);
    }

    public PlantationDTO createPlantation(PlantationDTO plantationDTO) {
        Plantation plantation = new Plantation();
        plantation.setGrapeVariety(plantationDTO.getGrapeVariety());
        plantation.setDatePlantation(plantationDTO.getDatePlantation());
        Plantation savedPlantation = plantationRepository.save(plantation);
        return plantationMapper.toDTO(savedPlantation);
    }

    public void deletePlantation(Long id) {
        plantationRepository.deleteById(id);
    }
}
