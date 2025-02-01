package com.utad.vinned.mapper;

import com.utad.vinned.dto.ViticulturistDTO;
import com.utad.vinned.models.Viticulturist;
import org.springframework.stereotype.Component;

@Component
public class ViticulturistMapper {
    public ViticulturistDTO toDTO(Viticulturist viticulturist) {
        return new ViticulturistDTO(viticulturist.getId(), viticulturist.getName(), viticulturist.getPhone());
    }
}
