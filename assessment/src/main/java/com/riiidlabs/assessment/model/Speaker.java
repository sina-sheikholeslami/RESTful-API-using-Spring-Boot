package com.riiidlabs.assessment.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "SPEAKERS")
public class Speaker implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String bio;

    public Speaker(Long id, String name, String company, String email, String bio) {
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
        Speaker that = (Speaker) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                company.equals(that.company) &&
                email.equals(that.email) &&
                bio.equals(that.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, company, email, bio);
    }
}
