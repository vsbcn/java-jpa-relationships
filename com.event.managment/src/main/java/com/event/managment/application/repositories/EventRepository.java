package com.event.managment.application.repositories;

import com.event.managment.application.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}