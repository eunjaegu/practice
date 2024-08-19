package com.kms.spring.member.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.dao.DataAccessException;

import com.kms.spring.member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {
	private SqlSession sqlSession;
	
	public MemberDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<MemberVO> selectAllMemberList() throws DataAccessException {
		
		List<MemberVO> memberList = null;
		memberList = sqlSession.selectList("mapper.member.selectAllMemberList");
		
		return memberList;
	}
	
	@Override
	public String insertMember(MemberVO memberVO) throws DataAccessException {
		int result = 0;
		result = sqlSession.insert("mapper.member.insertMember", memberVO);
		if(result >= 1)
			return "success";
		else
			return "fail";
	}
	
	@Override
	public String deleteMember(String id) throws DataAccessException {
		int result = 0;
		result = sqlSession.insert("mapper.member.deleteMember", id);
		if(result >= 1)
			return "success";
		else
			return "fail";
	}
	
	@Override
	public MemberVO selectMemberById(String id) throws DataAccessException {
		MemberVO memberVO = new MemberVO();
		memberVO = (MemberVO) sqlSession.selectOne("mapper.member.selectMemberById", id);
		
		return memberVO;
	}
	
	@Override
	public String updateMember(MemberVO memberVO) throws DataAccessException {
		int result = 0;
		result = sqlSession.update("mapper.member.updateMember", memberVO);
		if(result >= 1)
			return "success";
		else
			return "fail";
	}
}
