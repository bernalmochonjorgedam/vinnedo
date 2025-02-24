package com.utad.vinned.repository;

import com.utad.vinned.models.CollectedHarvest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectedHarvestRepository extends JpaRepository<CollectedHarvest, Long> {
}
