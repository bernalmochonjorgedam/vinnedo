package com.utad.vinned.repository;

import com.utad.vinned.models.Viticulturist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViticulturistRepository extends JpaRepository<Viticulturist, Long> {
}
