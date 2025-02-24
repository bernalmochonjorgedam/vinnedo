package com.utad.vinned.service;

import com.utad.vinned.dto.ViticulturistDTO;
import com.utad.vinned.mapper.ViticulturistMapper;
import com.utad.vinned.models.Viticulturist;
import com.utad.vinned.repository.ViticulturistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ViticulturistService {

    @Autowired
    private ViticulturistRepository viticulturistRepository;

    @Autowired
    private ViticulturistMapper viticulturistMapper;

    public List<ViticulturistDTO> getAllViticulturists() {
        return viticulturistRepository.findAll().stream()
                .map(viticulturistMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ViticulturistDTO createViticulturist(ViticulturistDTO dto) {
        Viticulturist viticulturist = viticulturistMapper.toEntity(dto);
        viticulturistRepository.save(viticulturist);
        return viticulturistMapper.toDTO(viticulturist);
    }

    public void deleteViticulturist(Long id) {
        Viticulturist viticulturist = viticulturistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viticulturist not found"));

        viticulturistRepository.delete(viticulturist);
    }
}
