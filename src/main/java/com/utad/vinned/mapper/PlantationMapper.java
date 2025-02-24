package com.utad.vinned.mapper;

import com.utad.vinned.dto.PlantationDTO;
import com.utad.vinned.models.Plantation;
import org.springframework.stereotype.Component;

@Component
public class PlantationMapper {
    public PlantationDTO toDTO(Plantation plantation) {
        return new PlantationDTO(
                plantation.getId(),
                plantation.getGrapeVariety(),
                plantation.getDatePlanted(),
                plantation.getPlot().getId()
        );
    }

    public Plantation toEntity(PlantationDTO dto) {
        Plantation plantation = new Plantation();
        plantation.setId(dto.getId());
        plantation.setGrapeVariety(dto.getGrapeVariety());
        plantation.setDatePlanted(dto.getDatePlanted());
        return plantation;
    }
}
