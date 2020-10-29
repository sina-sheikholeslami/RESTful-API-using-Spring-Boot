package com.riiidlabs.assessment.data.vo;

import com.riiidlabs.assessment.data.model.Talk;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class SpeakerVO implements Serializable {

    private Long id;
    private String name;
    private String company;
    private String email;
    private String bio;
    private List<Talk> talks;

    public SpeakerVO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Talk> getTalks() {
        return talks;
    }

    public void setTalks(List<Talk> talks) {
        this.talks = talks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpeakerVO speakerVO = (SpeakerVO) o;
        return Objects.equals(id, speakerVO.id) &&
                Objects.equals(name, speakerVO.name) &&
                Objects.equals(company, speakerVO.company) &&
                Objects.equals(email, speakerVO.email) &&
                Objects.equals(bio, speakerVO.bio) &&
                Objects.equals(talks, speakerVO.talks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, company, email, bio, talks);
    }
}
