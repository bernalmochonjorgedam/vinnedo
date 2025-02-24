package com.utad.vinned.mapper;

import com.utad.vinned.dto.PlotDTO;
import com.utad.vinned.models.Plot;
import org.springframework.stereotype.Component;

@Component
public class PlotMapper {
    public PlotDTO toDTO(Plot plot) {
        if (plot == null) {
            return null;
        }

        return new PlotDTO(
                plot.getId(),
                plot.getName(),
                plot.getSizeHectares(),
                plot.getLocation(),
                (plot.getViticulturist() != null) ? plot.getViticulturist().getId() : null
        );
    }

    public Plot toEntity(PlotDTO dto) {
        if (dto == null) {
            return null;
        }
        Plot plot = new Plot();
        plot.setId(dto.getId());
        plot.setName(dto.getName());
        plot.setSizeHectares(dto.getSizeHectares());
        plot.setLocation(dto.getLocation());
        return plot;
    }
}
