package dev.karthi.gym_project.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.karthi.gym_project.entity.Members;
import dev.karthi.gym_project.dao.MemberDao;

@Service
public class MemberService {
	
	@Autowired
	MemberDao memDao;
	
	public Members GetMember(String memId) {
		
		return memDao.findByIdIgnoreCase(memId);
	}
	
	
	public List<Members> getAllMembers(){
		return memDao.findAll();
	}


	public Members AddNewMember(Members mem) {
		return memDao.save(mem);
	}
}
