package com.asociation.nurses.application.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chapters")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String district;
    @ManyToOne
    @JoinColumn(name = "association_id")
    private Association association;
    @OneToOne
    @JoinColumn(name = "president_id")
    private Member president;
    @OneToMany(mappedBy = "chapterReference")
    private List<Member> members;

    public Chapter() {
    }

    public Chapter(String name, String district,Association association, Member president) {
        this.name = name;
        this.district = district;
        this.president = president;
        this.association = association;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Member getPresident() {
        return president;
    }

    public void setPresident(Member president) {
        this.president = president;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public Integer getId() {
        return id;
    }
}
