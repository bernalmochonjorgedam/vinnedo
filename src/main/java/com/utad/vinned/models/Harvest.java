package com.utad.vinned.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "harvests")
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dateHarvest;
    private double quantityKg;

    @ManyToOne
    @JoinColumn(name = "plantation_id", nullable = false)
    private Plantation plantation;
}
