package dev.karthi.gym_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.karthi.gym_project.entity.Members;
import dev.karthi.gym_project.service.MemberService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/gym/members")
public class MemberController {

	@Autowired
	MemberService memberService;

	@GetMapping("/get/{id}")
	public Members getMemberById(@PathVariable("id") String id) {

		return memberService.GetMember(id);
	}

	@GetMapping("/all")
	public List<Members> getMethodName() {
		return memberService.getAllMembers();
	}

	@PostMapping("/add")
	public Members AddMembers(@RequestBody Members mem) {
		return memberService.AddNewMember(mem);
	}

	@PutMapping("/update")
	public Members putMethodName(@RequestBody Members mem) {
		Members currentMem = memberService.GetMember(mem.getId());
		currentMem.setCity(mem.getCity());
		return memberService.AddNewMember(currentMem);
	}

	@GetMapping("/search")
	public Members FindByName(@RequestParam String firstName,String lastName) {
//		if(lastName==null) {
//			return memberService.getByName(firstName);
//		}
		return memberService.GetByName(firstName,lastName);
	}
	
	@GetMapping("/searchh")
	public List<Members> FindByName1(@RequestParam String firstName) {
			return memberService.getByName(firstName);
	}

}
