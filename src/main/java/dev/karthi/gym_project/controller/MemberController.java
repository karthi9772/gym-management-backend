package dev.karthi.gym_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/gym")
public class MemberController {
	@GetMapping("/")
	public String getMethodName() {
		return new String("Hello");
	}
	
}
