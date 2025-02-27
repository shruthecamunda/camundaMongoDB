package com.example.database.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.sql.Date;
import java.time.LocalDate;


@Data
@Document("candidate")
//@Table(name = "candidate")
@NoArgsConstructor
public class Candidate {

    public long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(long candidateId) {
        this.candidateId = candidateId;
    }

    @Id
    private long candidateId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getYearsOfExperiance() {
        return yearsOfExperiance;
    }

    public void setYearsOfExperiance(int yearsOfExperiance) {
        this.yearsOfExperiance = yearsOfExperiance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Candidate(String firstName, String lastName, LocalDate dob, String gender, String specialization, int yearsOfExperiance, String address, String state, String country, String resume) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.specialization = specialization;
        this.yearsOfExperiance = yearsOfExperiance;
        this.address = address;
        this.state = state;
        this.country = country;
        this.resume = resume;
    }

    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String gender;
    private String specialization;
    private int yearsOfExperiance;
    private String address;
    private String state;
    private String country;
    private String resume;
}
