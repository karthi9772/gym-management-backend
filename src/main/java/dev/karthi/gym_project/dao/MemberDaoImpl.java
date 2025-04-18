package dev.karthi.gym_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dev.karthi.gym_project.dbutil.DBUtil;
import dev.karthi.gym_project.entity.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	DBUtil DbUtil;

	@Override
	public List<Member> getAllMember() {
		return DbUtil.fetchDatas(MemberQuery.retriveQRY, Member.class, null);
	}

	@Override
	public List<Member> getMemberByID(String Id) {
		
		return  DbUtil.fetchDatas(MemberQuery.GetById, Member.class, null);
	}

	@Override
	public Member UpdateMember(Member mem) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
