package dev.karthi.gym_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.karthi.gym_project.dao.MemberDao;
import dev.karthi.gym_project.entity.Member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/gym")
public class MemberController {
	
	@Autowired
	MemberDao memberDao;
	
	@GetMapping("/all")
	public List<Member> getAllMembers() {
		List<Member> mem=memberDao.getAllMember();
		return mem;
	}
	
	@GetMapping("/get/{id}")
	public List<Member> getByID(@PathVariable String id) {
	return memberDao.getMemberByID(id);
	}
	
	
}
