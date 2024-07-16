package com.example.jobmicroservice.service;

import com.example.jobmicroservice.clients.CompanyClient;
import com.example.jobmicroservice.clients.ReviewClient;
import com.example.jobmicroservice.dto.JobDTO;
import com.example.jobmicroservice.external.Company;
import com.example.jobmicroservice.external.Review;
import com.example.jobmicroservice.mapper.JobMapper;
import com.example.jobmicroservice.model.Job;
import com.example.jobmicroservice.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceimpl implements JobService {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    CompanyClient companyClient;

    @Autowired
    ReviewClient reviewClient;

    @Override
    public List<JobDTO> getalljobs() {

        try{
            List<Job> jobs = jobRepository.findAll();

            List<JobDTO> jobDTOs = new ArrayList<>();

            for (Job job : jobs) {
                JobDTO jobDTO = converttoDto(job);
                jobDTOs.add(jobDTO);
            }

            return jobDTOs;
        }catch(Exception e){
            System.out.println("Error in getalljobs");
            return null;
        }


    }

    @Override
    public JobDTO getJobById(Long id) {

        try{
            Optional<Job> jobget = jobRepository.findById(id);

            if(jobget.isPresent()){

                Job job = jobget.get();

                JobDTO jobDTO = converttoDto(job);

                return jobDTO;
            }

            return null;
        }
        catch(Exception e){
            System.out.println("Error in getJobById");
            return null;
        }


    }

    private JobDTO converttoDto(Job job) {
        Company company = companyClient.getCompany(job.getCompanyId());

        List<Review> reviews = reviewClient.getReview(job.getCompanyId());

        JobDTO jobDTO= JobMapper.maptoJobCompanyDTO(job,company,reviews);

        return jobDTO;

    }

    @Override
    public boolean createjob(Job job) {
        try{
            jobRepository.save(job);
            return true;
        }catch(Exception e){
            System.out.println("Error in creating job");
            return false;
        }
    }

    @Override
    public boolean updatejob(Job job, Long id) {
        try{
            Optional<Job> jobget = jobRepository.findById(id);
            if(jobget.isPresent()){
                Job job1 = jobget.get();

                Job updatedjob = Job.builder()
                                .id(id)
                                .name(job.getName()).
                                description(job.getDescription())
                                        .location(job.getLocation())
                                                .maxSalary(job.getMaxSalary())
                                                        .minSalary(job.getMinSalary())
                                                                .companyId(job.getCompanyId())
                                                                        .build();

                jobRepository.save(updatedjob);
                return true;
            }
            return false;
        }
        catch(Exception e){
            System.out.println("Error in updating job");
            return false;
        }
    }

    @Override
    public boolean deletejobbyid(Long id) {

        try{
            jobRepository.deleteById(id);
            return true;
        }catch(Exception e){
            System.out.println("Error in deleting job");
            return false;
        }

    }
}
