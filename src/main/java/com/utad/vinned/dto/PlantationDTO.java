package com.utad.vinned.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlantationDTO {
    private Long id;

    @NotBlank(message = "Grape variety is required")
    private String grapeVariety;

    @NotBlank(message = "Date planted is required")
    private String datePlanted;

    @NotNull(message = "Plot ID is required")
    private Long plotId;
}
