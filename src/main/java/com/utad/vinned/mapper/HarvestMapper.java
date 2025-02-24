package com.utad.vinned.mapper;

import com.utad.vinned.dto.HarvestDTO;
import com.utad.vinned.models.Harvest;
import org.springframework.stereotype.Component;

@Component
public class HarvestMapper {
    public HarvestDTO toDTO(Harvest harvest) {
        return new HarvestDTO(
                harvest.getId(),
                harvest.getDateHarvest(),
                harvest.getQuantityKg(),
                harvest.getPlantation().getId()
        );
    }

    public Harvest toEntity(HarvestDTO dto) {
        Harvest harvest = new Harvest();
        harvest.setId(dto.getId());
        harvest.setDateHarvest(dto.getDateHarvest());
        harvest.setQuantityKg(dto.getQuantityKg());
        return harvest;
    }
}
