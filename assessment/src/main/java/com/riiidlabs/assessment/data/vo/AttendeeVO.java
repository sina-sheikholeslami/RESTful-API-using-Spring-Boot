package com.riiidlabs.assessment.data.vo;

import java.io.Serializable;
import java.util.Objects;

public class AttendeeVO implements Serializable {

    private Long id;
    private String name;
    private String company;
    private String email;
    private String registered;

    public AttendeeVO() {

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

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendeeVO that = (AttendeeVO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(company, that.company) &&
                Objects.equals(email, that.email) &&
                Objects.equals(registered, that.registered);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, company, email, registered);
    }
}
