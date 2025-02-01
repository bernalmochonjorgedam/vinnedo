package com.utad.vinned.service;

import com.utad.vinned.dto.ViticulturistDTO;
import com.utad.vinned.mapper.ViticulturistMapper;
import com.utad.vinned.models.Viticulturist;
import com.utad.vinned.repository.ViticulturistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Optional<ViticulturistDTO> getViticulturistById(Long id) {
        return viticulturistRepository.findById(id).map(viticulturistMapper::toDTO);
    }

    public ViticulturistDTO createViticulturist(ViticulturistDTO viticulturistDTO) {
        Viticulturist viticulturist = new Viticulturist();
        viticulturist.setName(viticulturistDTO.getName());
        viticulturist.setPhone(viticulturistDTO.getPhone());
        Viticulturist savedViticulturist = viticulturistRepository.save(viticulturist);
        return viticulturistMapper.toDTO(savedViticulturist);
    }

    public void deleteViticulturist(Long id) {
        viticulturistRepository.deleteById(id);
    }
}
