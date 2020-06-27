package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.SubmissionDTO;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;

@RestController
@RequestMapping("submission")
public class SubmissionController {

	@Autowired
	private SubmissionService submissionService;
	
	@Autowired
	private SubmissionMapper mapper;
	
	@GetMapping(params = {"challengeId", "accelerationId"})
    public List<SubmissionDTO> findByChallengeIdAndAccelerationId(@RequestParam("challengeId") Long challengeId, @RequestParam("accelerationId")Long accelerationId) {
        return mapper.map(submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId));
    }
}
