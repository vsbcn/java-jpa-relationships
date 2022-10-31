package com.asociation.nurses.application.repositories;

import com.asociation.nurses.application.models.Association;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociationRepository extends JpaRepository<Association, Integer> {
}
