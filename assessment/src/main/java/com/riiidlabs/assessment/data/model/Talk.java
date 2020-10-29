package com.riiidlabs.assessment.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TALK")
public class Talk implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "talk_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String room;

    @OneToMany(mappedBy = "talk")
    private List<Attendee> attendees;

    @ManyToOne
    @JoinColumn(name="speaker_id", nullable=false)
    private Speaker speaker;

    public Talk() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Talk talk = (Talk) o;
        return Objects.equals(id, talk.id) &&
                Objects.equals(title, talk.title) &&
                Objects.equals(room, talk.room) &&
                Objects.equals(attendees, talk.attendees) &&
                Objects.equals(speaker, talk.speaker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, room, attendees, speaker);
    }
}
