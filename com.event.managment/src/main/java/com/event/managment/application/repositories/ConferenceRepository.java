package com.event.managment.application.repositories;

import com.event.managment.application.models.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, Integer> {
}