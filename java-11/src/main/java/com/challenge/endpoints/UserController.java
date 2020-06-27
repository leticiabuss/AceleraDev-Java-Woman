package com.challenge.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{userId}")
    public Optional<User> findById(@PathVariable("userId") Long userId) {
        return userService.findById(userId);
    }
	
	@GetMapping(params="accelerationName")
    public List<User> findByAccelerationName(@RequestParam("accelerationName") String name) {
        return userService.findByAccelerationName(name);
    }
	
	@GetMapping(params="companyId")
    public List<User> findByCompanyId(@RequestParam("companyId") Long companyId) {
        return userService.findByCompanyId(companyId);
    }
}
