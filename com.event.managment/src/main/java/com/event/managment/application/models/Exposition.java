package com.event.managment.application.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name ="expositions")
public class Exposition extends Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "exposition_guests",
            joinColumns = {@JoinColumn(name = "expositions_id")},
            inverseJoinColumns = {@JoinColumn(name = "guest_id")}
    )
    private List<Guest> expositionGuests;

    public Exposition() {
    }

    public Exposition(LocalDate date, int duration, String location, String title) {
        super(date, duration, location, title);
    }

    public Exposition(LocalDate date, int duration, String location, String title, List<Guest> expositionGuests) {
        super(date, duration, location, title);
        this.expositionGuests = expositionGuests;
    }

    public List<Guest> getExpositionGuests() {
        return expositionGuests;
    }

    public void setExpositionGuests(List<Guest> expositionGuests) {
        this.expositionGuests = expositionGuests;
    }
}
