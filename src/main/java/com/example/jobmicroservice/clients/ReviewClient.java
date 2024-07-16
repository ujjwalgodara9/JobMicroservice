package com.example.jobmicroservice.clients;

import com.example.jobmicroservice.external.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="REVIEWMICROSERVICE",
        url="${review-service.url}")
public interface ReviewClient {

    @GetMapping("/reviews")
    List<Review> getReview(@RequestParam Long companyId);

}