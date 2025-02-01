package com.utad.vinned.mapper;

import com.utad.vinned.dto.HarvestDTO;
import com.utad.vinned.models.Harvest;
import org.springframework.stereotype.Component;

@Component
public class HarvestMapper {
    public HarvestDTO toDTO(Harvest harvest) {
        return new HarvestDTO(
                harvest.getId(),
                harvest.getPlantation().getId(),
                harvest.getDateHarvest(),
                harvest.getQuantityKg()
        );
    }
}
