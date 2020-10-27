package com.riiidlabs.assessment.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TALKS")
public class Talk implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String room;

    public Talk(Long id, String title, String room) {
        this.id = id;
        this.title = title;
        this.room = room;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Talk that = (Talk) o;
        return id.equals(that.id) &&
                title.equals(that.title) &&
                room.equals(that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, room);
    }
}
