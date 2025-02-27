package com.example.database.ServiceInterface;

import com.example.database.model.Candidate;

import java.time.LocalDate;
import java.util.List;

public interface CandidateServiceInterface {

    Candidate saveCandidate(Candidate candidate);
    List<Candidate> getAllCandidates();
    Candidate getCandidateById(long candidateId);
    Candidate updateCandidate(Candidate candidate,long candidateId);
    void deleteCandidate(long candidateId);
    Candidate saveCandidate(String firstName, String lastName, LocalDate dob, String gender, String specialization, int yearsOfExperiance, String address, String state, String country, String resume) ;

    }
