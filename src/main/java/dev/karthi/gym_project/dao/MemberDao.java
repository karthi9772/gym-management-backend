package dev.karthi.gym_project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.karthi.gym_project.entity.Members;


@Repository
public interface MemberDao extends JpaRepository<Members, String> {
	public Members findByIdIgnoreCase(String memId);
	
	public List<Members> findAll();
	
	public Members save(Members member);
}
