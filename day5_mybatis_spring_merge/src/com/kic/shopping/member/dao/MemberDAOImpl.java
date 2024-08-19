package com.kic.shopping.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import com.kic.shopping.member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public MemberDAOImpl() {
	}

	@Override
	public List<MemberVO> selectAllMemberList() throws DataAccessException {
		List<MemberVO> membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
		return membersList;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}

	@Override
	public int updateMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.update("mapper.member.updateMember", memberVO);
		return result;
	}

	@Override
	public int deleteMember(String member_id) throws DataAccessException{
		int result = sqlSession.delete("mapper.member.deleteMember", member_id);
		return result;
	}

	@Override
	public MemberVO selectMemberById(String member_id) throws DataAccessException {
		MemberVO memberVO = (MemberVO) sqlSession.selectOne("mapper.member.selectMemberById", member_id);
		return memberVO;
	}

}
