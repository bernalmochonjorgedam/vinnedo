package com.utad.vinned.controller;

import com.utad.vinned.dto.PlotDTO;
import com.utad.vinned.service.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plots")
public class PlotController {
    @Autowired
    private PlotService plotService;

    @GetMapping
    public List<PlotDTO> getAllPlots() {
        return plotService.getAllPlots();
    }

    @GetMapping("/{id}")
    public Optional<PlotDTO> getPlotById(@PathVariable Long id) {
        return plotService.getPlotById(id);
    }

    @PostMapping
    public PlotDTO createPlot(@RequestBody PlotDTO plotDTO) {
        return plotService.createPlot(plotDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePlot(@PathVariable Long id) {
        plotService.deletePlot(id);
    }
}
