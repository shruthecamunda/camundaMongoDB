package com.example.database.repository;

import com.example.database.model.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CandidateRepo extends MongoRepository<Candidate,Long> {

}
