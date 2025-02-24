package com.utad.vinned.service;

import com.utad.vinned.dto.PlantationDTO;
import com.utad.vinned.mapper.PlantationMapper;
import com.utad.vinned.models.Plantation;
import com.utad.vinned.models.Plot;
import com.utad.vinned.repository.PlantationRepository;
import com.utad.vinned.repository.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantationService {

    @Autowired
    private PlantationRepository plantationRepository;

    @Autowired
    private PlotRepository plotRepository;

    @Autowired
    private PlantationMapper plantationMapper;

    public List<PlantationDTO> getAllPlantations() {
        return plantationRepository.findAll().stream()
                .map(plantationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PlantationDTO createPlantation(PlantationDTO dto) {
        Plot plot = plotRepository.findById(dto.getPlotId())
                .orElseThrow(() -> new RuntimeException("Plot not found"));

        Plantation plantation = plantationMapper.toEntity(dto);
        plantation.setPlot(plot);

        plantationRepository.save(plantation);
        return plantationMapper.toDTO(plantation);
    }

    public void deletePlantation(Long id) {
        Plantation plantation = plantationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plantation not found"));
        plantationRepository.delete(plantation);
    }

}
