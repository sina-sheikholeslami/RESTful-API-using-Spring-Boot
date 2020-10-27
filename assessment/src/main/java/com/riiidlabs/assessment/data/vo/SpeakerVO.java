package com.riiidlabs.assessment.data.vo;

import java.io.Serializable;
import java.util.Objects;

public class SpeakerVO implements Serializable {

    private Long id;
    private String name;
    private String company;
    private String email;
    private String bio;

    public SpeakerVO(Long id, String name, String company, String email, String bio) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.email = email;
        this.bio = bio;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpeakerVO speakerVO = (SpeakerVO) o;
        return Objects.equals(id, speakerVO.id) &&
                Objects.equals(name, speakerVO.name) &&
                Objects.equals(company, speakerVO.company) &&
                Objects.equals(email, speakerVO.email) &&
                Objects.equals(bio, speakerVO.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, company, email, bio);
    }
}
