package com.event.managment.application.repositories;

import com.event.managment.application.models.Exposition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpositionRepository extends JpaRepository<Exposition, Integer> {
}