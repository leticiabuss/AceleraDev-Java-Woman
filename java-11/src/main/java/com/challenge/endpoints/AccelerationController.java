package com.challenge.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;

@RestController
@RequestMapping("acceleration")
public class AccelerationController {
	
	@Autowired
	private AccelerationService accelerationService;
	
	@GetMapping("/{id}")
	public Optional<Acceleration> findById(@PathVariable(required = false) Long id) {
	   return accelerationService.findById(id);
	}

	@GetMapping(params="companyId")
	public List<Acceleration> findByCompanyId(@RequestParam("companyId") Long companyId) {
	   return accelerationService.findByCompanyId(companyId);
	}

}
