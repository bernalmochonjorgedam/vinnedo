package com.utad.vinned.controller;

import com.utad.vinned.service.TensorFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/predict")
public class TensorFlowController {

    @Autowired
    private TensorFlowService tensorFlowService;

    @GetMapping("/harvest/{sizeHectares}/{grapeVariety}")
    public Map<String, Float> predictHarvest(@PathVariable float sizeHectares, @PathVariable int grapeVariety) {
        float prediction = tensorFlowService.predictHarvest(sizeHectares, grapeVariety);
        Map<String, Float> response = new HashMap<>();
        response.put("predicted_harvest", prediction);
        return response;
    }
}
