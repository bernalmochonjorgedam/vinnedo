package com.utad.vinned.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlotDTO {
    private Long id;
    private String name;
    private double sizeHectares;
    private String location;
}
