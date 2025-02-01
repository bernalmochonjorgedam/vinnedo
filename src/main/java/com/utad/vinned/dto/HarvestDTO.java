package com.utad.vinned.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HarvestDTO {
    private Long id;
    private Long plantationId;
    private String dateHarvest;
    private double quantityKg;
}
