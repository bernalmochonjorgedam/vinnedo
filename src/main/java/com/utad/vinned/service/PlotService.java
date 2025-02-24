package com.utad.vinned.service;

import com.utad.vinned.dto.PlotDTO;
import com.utad.vinned.mapper.PlotMapper;
import com.utad.vinned.models.Plot;
import com.utad.vinned.models.Viticulturist;
import com.utad.vinned.repository.PlotRepository;
import com.utad.vinned.repository.ViticulturistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlotService {
    @Autowired
    private PlotRepository plotRepository;

    @Autowired
    private ViticulturistRepository viticulturistRepository;

    @Autowired
    private PlotMapper plotMapper;

    public List<PlotDTO> getAllPlots() {
        return plotRepository.findAll().stream()
                .map(plotMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PlotDTO createPlot(PlotDTO dto) {
        Viticulturist viticulturist = viticulturistRepository.findById(dto.getViticulturistId())
                .orElseThrow(() -> new RuntimeException("Viticulturist not found with ID: " + dto.getViticulturistId()));
        Plot plot = plotMapper.toEntity(dto);
        plot.setViticulturist(viticulturist);
        plotRepository.save(plot);
        return plotMapper.toDTO(plot);
    }

    public void deletePlot(Long id) {
        Plot plot = plotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plot not found"));

        plotRepository.delete(plot);
    }
}
