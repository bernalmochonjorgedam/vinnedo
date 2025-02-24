package com.utad.vinned.controller;

import com.utad.vinned.dto.ViticulturistDTO;
import com.utad.vinned.service.ViticulturistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viticulturists")
public class ViticulturistController {

    @Autowired
    private ViticulturistService viticulturistService;

    @GetMapping
    public List<ViticulturistDTO> getAllViticulturists() {
        return viticulturistService.getAllViticulturists();
    }

    @PostMapping
    public ResponseEntity<ViticulturistDTO> createViticulturist(@Valid @RequestBody ViticulturistDTO viticulturistDTO) {
        return ResponseEntity.ok(viticulturistService.createViticulturist(viticulturistDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteViticulturist(@PathVariable Long id) {
        viticulturistService.deleteViticulturist(id);
        return ResponseEntity.noContent().build();
    }
}
