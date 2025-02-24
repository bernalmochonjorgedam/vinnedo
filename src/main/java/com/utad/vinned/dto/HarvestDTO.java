package com.utad.vinned.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HarvestDTO {
    private Long id;

    @NotBlank(message = "Harvest date is required")
    private String dateHarvest;

    @NotNull(message = "Quantity in kg is required")
    private double quantityKg;

    @NotNull(message = "Plantation ID is required")
    private Long plantationId;
}
