package com.utad.vinned.models;

import com.utad.vinned.models.Plot;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "viticulturists")
public class Viticulturist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "viticulturist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Plot> plots = new ArrayList<>();
}
