package com.utad.vinned.controller;

import com.utad.vinned.dto.CollectedHarvestDTO;
import com.utad.vinned.service.CollectedHarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collected-harvests")
public class CollectedHarvestController {

    @Autowired
    private CollectedHarvestService collectedHarvestService;

    @GetMapping
    public List<CollectedHarvestDTO> getAllCollectedHarvests() {
        return collectedHarvestService.getAllCollectedHarvests();
    }
}
