package com.event.managment.application.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name ="conferences")
public class Conference extends Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    @JoinTable(
            name = "conference_speakers",
            joinColumns = {@JoinColumn(name = "conferences_id")},
            inverseJoinColumns = {@JoinColumn(name = "speakers_id")}
    )
    private List<Speaker> speakers;
    @ManyToMany
    @JoinTable(
            name = "conference_guests",
            joinColumns = {@JoinColumn(name = "conferences_id")},
            inverseJoinColumns = {@JoinColumn(name = "guest_id")}
    )
    private List<Guest> conferenceGuests;

    public Conference() {
    }

    public Conference(LocalDate date, int duration, String location, String title) {
        super(date, duration, location, title);
    }

    public Conference(LocalDate date, int duration, String location, String title, List<Speaker> speakers, List<Guest> conferenceGuests) {
        super(date, duration, location, title);
        this.speakers = speakers;
        this.conferenceGuests = conferenceGuests;
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    public List<Guest> getConferenceGuests() {
        return conferenceGuests;
    }

    public void setConferenceGuests(List<Guest> conferenceGuests) {
        this.conferenceGuests = conferenceGuests;
    }
}
