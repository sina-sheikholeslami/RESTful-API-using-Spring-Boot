package com.riiidlabs.assessment.data.vo;

import com.riiidlabs.assessment.data.model.Attendee;
import com.riiidlabs.assessment.data.model.Speaker;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class TalkVO implements Serializable {

    private Long id;
    private String title;
    private String room;
    private List<Attendee> attendees;
    private Speaker speaker;

    public TalkVO() {

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
        TalkVO talkVO = (TalkVO) o;
        return Objects.equals(id, talkVO.id) &&
                Objects.equals(title, talkVO.title) &&
                Objects.equals(room, talkVO.room) &&
                Objects.equals(attendees, talkVO.attendees) &&
                Objects.equals(speaker, talkVO.speaker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, room, attendees, speaker);
    }
}
