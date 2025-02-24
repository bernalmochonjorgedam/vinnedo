package com.utad.vinned.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "plantations")
public class Plantation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String grapeVariety;
    private String datePlanted;

    @ManyToOne
    @JoinColumn(name = "plot_id", nullable = false)
    private Plot plot;

    @OneToMany(mappedBy = "plantation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Harvest> harvests;
}
