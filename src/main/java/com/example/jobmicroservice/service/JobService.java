package com.example.jobmicroservice.service;

import com.example.jobmicroservice.dto.JobDTO;
import com.example.jobmicroservice.model.Job;

import java.util.List;


public interface JobService {

    List<JobDTO> getalljobs();

    JobDTO getJobById(Long id);

    boolean createjob(Job job);

    boolean updatejob(Job job, Long id);

    boolean deletejobbyid(Long id);
}
