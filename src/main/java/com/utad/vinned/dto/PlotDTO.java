package com.utad.vinned.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlotDTO {
    private Long id;

    @NotBlank(message = "Plot name is required")
    private String name;

    @NotNull(message = "Size must be specified")
    private double sizeHectares;

    @NotBlank(message = "Location is required")
    private String location;

    @NotNull(message = "Viticulturist ID is required")
    private Long viticulturistId;
}
