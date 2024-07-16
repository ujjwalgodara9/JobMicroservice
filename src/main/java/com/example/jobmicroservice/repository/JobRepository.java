package com.example.jobmicroservice.repository;

import com.example.jobmicroservice.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
