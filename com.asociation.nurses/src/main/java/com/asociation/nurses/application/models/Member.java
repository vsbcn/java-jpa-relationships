package com.asociation.nurses.application.models;

import com.asociation.nurses.application.enums.Status;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate renewalDate;
    @ManyToOne
    @JoinColumn(name = "chapters_id")
    private Chapter chapterReference;

    @OneToOne(mappedBy = "president")
    private Chapter chapterPresident;

    public Member() {
    }

    public Member(String name, Status status, LocalDate renewalDate, Chapter chapter) {
        this.name = name;
        this.status = status;
        this.renewalDate = renewalDate;
        this.chapterReference = chapter;
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

    public LocalDate getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(LocalDate renewalDate) {
        this.renewalDate = renewalDate;
    }

    public Chapter getChapter() {
        return chapterReference;
    }

    public Integer getId() {
        return id;
    }
}
