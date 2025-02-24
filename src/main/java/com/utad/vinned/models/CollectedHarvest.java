package com.utad.vinned.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "collected_harvests")
public class CollectedHarvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String collectionDate;
    private double quantityKg;

    @ManyToOne
    @JoinColumn(name = "viticulturist_id", nullable = false)
    private Viticulturist viticulturist;

    @ManyToOne
    @JoinColumn(name = "plantation_id", nullable = false)
    private Plantation plantation;

    @ManyToOne
    @JoinColumn(name = "plot_id", nullable = false)
    private Plot plot;
}
