package com.event.managment.application.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="speakers")
public class Speaker extends Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer presentationDuration;
    @ManyToMany(mappedBy = "speakers")
    private List<Conference> conferences;

    public Speaker() {
    }

    public Speaker(Integer presentationDuration) {
        this.presentationDuration = presentationDuration;
    }

    public Speaker(String name, Integer presentationDuration) {
        super(name);
        this.presentationDuration = presentationDuration;
    }

    public Integer getPresentationDuration() {
        return presentationDuration;
    }

    public void setPresentationDuration(Integer presentationDuration) {
        this.presentationDuration = presentationDuration;
    }
}
