package com.utad.vinned.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "plots")
public class Plot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double sizeHectares;
    private String location;

    @ManyToOne
    @JoinColumn(name = "viticulturist_id", nullable = false)
    private Viticulturist viticulturist;

    @OneToMany(mappedBy = "plot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Plantation> plantations;
}
