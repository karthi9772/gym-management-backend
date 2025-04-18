package dev.karthi.gym_project.dao;

import java.util.List;

import dev.karthi.gym_project.entity.Member;

public interface MemberDao {

	public List<Member> getAllMember();
	
	public List<Member> getMemberByID(String Id);
	
	public Member UpdateMember(Member mem);
}
