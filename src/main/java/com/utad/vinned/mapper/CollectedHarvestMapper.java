package com.utad.vinned.mapper;

import com.utad.vinned.dto.CollectedHarvestDTO;
import com.utad.vinned.models.CollectedHarvest;
import org.springframework.stereotype.Component;

@Component
public class CollectedHarvestMapper {
    public CollectedHarvestDTO toDTO(CollectedHarvest collectedHarvest) {
        return new CollectedHarvestDTO(
                collectedHarvest.getId(),
                collectedHarvest.getCollectionDate(),
                collectedHarvest.getQuantityKg(),
                collectedHarvest.getViticulturist().getId(),
                collectedHarvest.getPlantation().getId(),
                collectedHarvest.getPlot().getId()
        );
    }

    public CollectedHarvest toEntity(CollectedHarvestDTO dto) {
        CollectedHarvest collectedHarvest = new CollectedHarvest();
        collectedHarvest.setId(dto.getId());
        collectedHarvest.setCollectionDate(dto.getCollectionDate());
        collectedHarvest.setQuantityKg(dto.getQuantityKg());
        return collectedHarvest;
    }
}
