package com.example.database.Service;

import com.example.database.exception.ResourceNotFoundException;
import com.example.database.model.Candidate;
//import com.example.database.model.Student;
import com.example.database.repository.CandidateRepo;
//import com.example.database.repository.StudentRepo;
import com.example.database.ServiceInterface.CandidateServiceInterface;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CandidateService implements CandidateServiceInterface {
    public CandidateService(CandidateRepo candidateRepo) {
        this.candidateRepo = candidateRepo;
    }

    public CandidateRepo candidateRepo;

    public Candidate saveCandidate(String firstName, String lastName, LocalDate dob, String gender, String specialization, int yearsOfExperiance, String address, String state, String country, String resume) {

        return candidateRepo.save(new Candidate(firstName,lastName,dob,gender,specialization,yearsOfExperiance,address,state,country,resume)

        );
    }

    @Override
    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepo.save(candidate);
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepo.findAll();
    }

    @Override
    public Candidate getCandidateById(long candidateId) {
        return candidateRepo.findById(candidateId).orElseThrow(() -> new ResourceNotFoundException("Candidate","Id",candidateId));


    }

    @Override
    public Candidate updateCandidate(Candidate candidate, long candidateId) {
        Candidate existingCandidate = candidateRepo.findById(candidateId).orElseThrow(() -> new ResourceNotFoundException("Candidate","Id",candidateId));
        existingCandidate.setCandidateId(candidate.getCandidateId());
        existingCandidate.setFirstName(candidate.getFirstName());
        existingCandidate.setLastName(candidate.getLastName());
        existingCandidate.setDob(candidate.getDob());
        existingCandidate.setGender(candidate.getGender());
        existingCandidate.setSpecialization(candidate.getSpecialization());
        existingCandidate.setYearsOfExperiance(candidate.getYearsOfExperiance());
        existingCandidate.setAddress(candidate.getAddress());
        existingCandidate.setState(candidate.getState());
        existingCandidate.setCountry(candidate.getCountry());
        existingCandidate.setResume(candidate.getResume());

        candidateRepo.save(existingCandidate);

        return existingCandidate;


    }

    @Override
    public void deleteCandidate(long candidateId) {
        candidateRepo.findById(candidateId).orElseThrow(() -> new ResourceNotFoundException("Candidate","Id",candidateId));
        candidateRepo.deleteById(candidateId);

    }
}
