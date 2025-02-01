package com.utad.vinned.service;

import com.utad.vinned.dto.PlotDTO;
import com.utad.vinned.mapper.PlotMapper;
import com.utad.vinned.models.Plot;
import com.utad.vinned.repository.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlotService {
    @Autowired
    private PlotRepository plotRepository;

    @Autowired
    private PlotMapper plotMapper;

    public List<PlotDTO> getAllPlots() {
        return plotRepository.findAll().stream()
                .map(plotMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<PlotDTO> getPlotById(Long id) {
        return plotRepository.findById(id).map(plotMapper::toDTO);
    }

    public PlotDTO createPlot(PlotDTO plotDTO) {
        Plot plot = new Plot();
        plot.setName(plotDTO.getName());
        plot.setSizeHectares(plotDTO.getSizeHectares());
        plot.setLocation(plotDTO.getLocation());
        Plot savedPlot = plotRepository.save(plot);
        return plotMapper.toDTO(savedPlot);
    }

    public void deletePlot(Long id) {
        plotRepository.deleteById(id);
    }
}
