package com.utad.vinned.controller;

import com.utad.vinned.dto.ViticulturistDTO;
import com.utad.vinned.service.ViticulturistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/viticulturists")
public class ViticulturistController {
    @Autowired
    private ViticulturistService viticulturistService;

    @GetMapping
    public List<ViticulturistDTO> getAllViticulturists() {
        return viticulturistService.getAllViticulturists();
    }

    @GetMapping("/{id}")
    public Optional<ViticulturistDTO> getViticulturistById(@PathVariable Long id) {
        return viticulturistService.getViticulturistById(id);
    }

    @PostMapping
    public ViticulturistDTO createViticulturist(@RequestBody ViticulturistDTO viticulturistDTO) {
        return viticulturistService.createViticulturist(viticulturistDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteViticulturist(@PathVariable Long id) {
        viticulturistService.deleteViticulturist(id);
    }
}
