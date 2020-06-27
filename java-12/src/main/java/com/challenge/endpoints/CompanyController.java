package com.challenge.endpoints;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CompanyController {

	@Autowired
    private CompanyService service;

    @GetMapping("/company/{id}")
    public Company findById(@PathVariable("id") Long id) {
        return service.findById(id).orElse(null);
    }

    @GetMapping("/company")
    public List<Company> findAll(@RequestParam Optional<Long> accelerationId, @RequestParam Optional<Long> userId) {
        return accelerationId.map(service::findByAccelerationId)
                .orElseGet(() -> userId.map(service::findByUserId).orElse(new ArrayList<>()));
    }

}