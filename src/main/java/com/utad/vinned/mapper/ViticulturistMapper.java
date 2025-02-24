package com.utad.vinned.mapper;

import com.utad.vinned.dto.ViticulturistDTO;
import com.utad.vinned.models.Viticulturist;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ViticulturistMapper {
    public ViticulturistDTO toDTO(Viticulturist viticulturist) {
        Long plotId = null;
        if (viticulturist.getPlots() != null && !viticulturist.getPlots().isEmpty()) {
            plotId = viticulturist.getPlots().get(0).getId();
        }

        return new ViticulturistDTO(
                viticulturist.getId(),
                viticulturist.getName(),
                viticulturist.getEmail(),
                plotId
        );
    }

    public Viticulturist toEntity(ViticulturistDTO dto) {
        Viticulturist viticulturist = new Viticulturist();
        viticulturist.setId(dto.getId());
        viticulturist.setName(dto.getName());
        viticulturist.setEmail(dto.getEmail());
        viticulturist.setPlots(Collections.emptyList());
        return viticulturist;
    }
}
