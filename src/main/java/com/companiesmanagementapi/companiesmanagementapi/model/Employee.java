package com.companiesmanagementapi.companiesmanagementapi.model;

import com.companiesmanagementapi.companiesmanagementapi.constants.Message;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=2, max=30)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    @Email(message = Message.Error.INVALID_EMAIL)
    private String email;

    @NotNull
    @Size(min = 11, max = 11)
    private String cpf;

    private long employer;

    @Column(name = "job_title")
    private String jobTitle;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public long getEmployer() {
        return employer;
    }

    public void setEmployer(long employer) {
        this.employer = employer;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
