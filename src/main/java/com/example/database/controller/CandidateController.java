package com.example.database.controller;

import com.example.database.Service.CandidateService;
import com.example.database.model.Candidate;
import com.example.database.model.Candidate;
import com.example.database.ServiceInterface.CandidateServiceInterface;
import com.example.database.repository.CandidateRepo;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateServiceInterface candidateServiceInterface;
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }

@JobWorker(type = "candidateApplication")

public void addCandidate(JobClient client, ActivatedJob job){
    String firstName = job.getVariable("firstName").toString();
    System.out.println(firstName);
    String lastName = job.getVariable("lastName").toString();
    String dob=  job.getVariablesAsMap().get("dob").toString();
    String pattern = "yyyy-MM-dd";
    LocalDate newdob=LocalDate.parse(dob, DateTimeFormatter.ofPattern(pattern));
    System.out.println(newdob);
    String gender = job.getVariable("gender").toString();
    String specialization = job.getVariable("specialization").toString();
    int yearsOfExperiance = Integer.parseInt(job.getVariable("yearsOfExperiance").toString());
    System.out.println(yearsOfExperiance);
    String address = job.getVariable("address").toString();
    String state = job.getVariable("state").toString();
    String country = job.getVariable("country").toString();
    String resume = "resume";

    candidateServiceInterface.saveCandidate(firstName, lastName, newdob, gender, specialization, yearsOfExperiance, address, state, country, resume);
}
    @PostMapping()
    public ResponseEntity<Candidate> saveCandidate(@RequestBody Candidate candidate) {
        return new ResponseEntity<Candidate>(candidateServiceInterface.saveCandidate(candidate), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Candidate> getAllCandidate() {
        return candidateServiceInterface.getAllCandidates();
    }

    @GetMapping("{candidateId}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable("candidateId") long candidateId) {
        return new ResponseEntity<Candidate>(candidateServiceInterface.getCandidateById(candidateId), HttpStatus.OK);
    }


    @DeleteMapping("{candidateId}")
    public ResponseEntity<String> deleteById(@PathVariable("candidateId") long candidateId) {
        candidateServiceInterface.deleteCandidate(candidateId);
        return new ResponseEntity<String>("Candidate Deleted", HttpStatus.OK);
    }

    @PutMapping("{candidateId}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable("candidateId") long candidateId, @RequestBody Candidate candidate) {
        return new ResponseEntity<Candidate>(candidateServiceInterface.updateCandidate(candidate, candidateId), HttpStatus.OK);
    }
}
