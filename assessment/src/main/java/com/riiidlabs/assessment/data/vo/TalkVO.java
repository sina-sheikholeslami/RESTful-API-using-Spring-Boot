package com.riiidlabs.assessment.data.vo;

import java.io.Serializable;
import java.util.Objects;

public class TalkVO implements Serializable {

    private Long id;
    private String title;
    private String room;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TalkVO talkVO = (TalkVO) o;
        return Objects.equals(id, talkVO.id) &&
                Objects.equals(title, talkVO.title) &&
                Objects.equals(room, talkVO.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, room);
    }
}
