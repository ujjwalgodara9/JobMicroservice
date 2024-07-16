package com.example.jobmicroservice.clients;

import com.example.jobmicroservice.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="COMPANYMICROSERVICE",
        url="${company-service.url}")
public interface CompanyClient {

    @GetMapping("/company/{id}")
    Company getCompany(@PathVariable Long id);
}
