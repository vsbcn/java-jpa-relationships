package com.event.managment.application.models;

import com.event.managment.application.enums.Status;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="guests")
@Inheritance(strategy = InheritanceType.JOINED)
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToMany(mappedBy = "eventGuests")
    private List<Event> events;
    @ManyToMany(mappedBy = "conferenceGuests")
    private List<Conference> conferences;
    @ManyToMany(mappedBy = "expositionGuests")
    private List<Exposition> expositions;

    public Guest() {
    }

    public Guest(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    public Guest(String name, Status status, List<Event> events, List<Conference> conferences, List<Exposition> expositions) {
        this.name = name;
        this.status = status;
        this.events = events;
        this.conferences = conferences;
        this.expositions = expositions;
    }

    public Guest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Conference> getConferences() {
        return conferences;
    }

    public void setConferences(List<Conference> conferences) {
        this.conferences = conferences;
    }

    public List<Exposition> getExpositions() {
        return expositions;
    }

    public void setExpositions(List<Exposition> expositions) {
        this.expositions = expositions;
    }
}
