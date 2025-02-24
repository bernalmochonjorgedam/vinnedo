package com.utad.vinned.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CollectedHarvestDTO {
    private Long id;
    private String collectionDate;
    private double quantityKg;
    private Long viticulturistId;
    private Long plantationId;
    private Long plotId;
}
