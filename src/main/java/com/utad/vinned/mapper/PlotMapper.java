package com.utad.vinned.mapper;

import com.utad.vinned.dto.PlotDTO;
import com.utad.vinned.models.Plot;
import org.springframework.stereotype.Component;

@Component
public class PlotMapper {
    public PlotDTO toDTO(Plot plot) {
        return new PlotDTO(plot.getId(), plot.getName(), plot.getSizeHectares(), plot.getLocation());
    }
}
