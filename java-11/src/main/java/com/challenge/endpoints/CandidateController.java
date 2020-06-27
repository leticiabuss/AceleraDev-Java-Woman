package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.CandidateDTO;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;

@RestController
@RequestMapping("candidate")
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private CandidateMapper mapper;
	
	@GetMapping("/{userId}/{accelerationId}/{companyId}")
    public CandidateDTO findById(@PathVariable("userId") Long userId,@PathVariable("companyId") Long companyId,@PathVariable("accelerationId") Long accelerationId) {
        return mapper.map(candidateService.findById(userId, companyId, accelerationId).get());
    }
	
	@GetMapping(params="companyId")
	public List<CandidateDTO> findByCompanyId(@RequestParam("companyId") Long companyId) {
		return mapper.map(candidateService.findByCompanyId(companyId));
	}
	@GetMapping(params="accelerationId")
	public List<CandidateDTO> findByAccelerationId(@RequestParam("accelerationId") Long accelerationId) {
	     return mapper.map(candidateService.findByAccelerationId(accelerationId));
	}

}
