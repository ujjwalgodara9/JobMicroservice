package com.example.jobmicroservice.dto;

import com.example.jobmicroservice.external.Company;
import com.example.jobmicroservice.external.Review;
import lombok.Data;

import java.util.List;

@Data
public class JobDTO {

    private Long id;
    private String name;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private Company company;
    private List<Review> review;

}
