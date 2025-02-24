package com.utad.vinned.controller;

import com.utad.vinned.dto.PlotDTO;
import com.utad.vinned.service.PlotService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plots")
public class PlotController {

    @Autowired
    private PlotService plotService;

    @GetMapping
    public List<PlotDTO> getAllPlots() {
        return plotService.getAllPlots();
    }

    @PostMapping
    public ResponseEntity<PlotDTO> createPlot(@Valid @RequestBody PlotDTO plotDTO) {
        return ResponseEntity.ok(plotService.createPlot(plotDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlot(@PathVariable Long id) {
        plotService.deletePlot(id);
        return ResponseEntity.noContent().build();
    }
}
