package com.example.jobmicroservice.mapper;

import com.example.jobmicroservice.dto.JobDTO;
import com.example.jobmicroservice.external.Company;
import com.example.jobmicroservice.external.Review;
import com.example.jobmicroservice.model.Job;

import java.util.List;

public class JobMapper {
    public static JobDTO maptoJobCompanyDTO(Job job, Company company, List<Review> review) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setName(job.getName());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setMaxSalary(job.getMaxSalary());
        jobDTO.setMinSalary(job.getMinSalary());
        jobDTO.setCompany(company);
        jobDTO.setReview(review);
        return jobDTO;
    }
}