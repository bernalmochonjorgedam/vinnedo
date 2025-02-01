package com.utad.vinned.repository;

import com.utad.vinned.models.Plantation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantationRepository extends JpaRepository<Plantation, Long> {
}
