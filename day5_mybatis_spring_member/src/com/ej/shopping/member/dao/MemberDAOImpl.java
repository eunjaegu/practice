package com.ej.shopping.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import com.ej.shopping.member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO{
	private SqlSession sqlSession;

	public MemberDAOImpl() {
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<MemberVO> selectAllMemberList() throws DataAccessException {
		// 세션 쿼리 조회
		//System.out.println(member_id);
		List<MemberVO> memberList = null;
		memberList = this.sqlSession.selectList("mapper.member.selectAllMemberList");
		return memberList;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		//정보 추가
		int result = this.sqlSession.insert("mapper.member.insertMember", memberVO);
		System.out.println(memberVO.getMember_id());
		System.out.println(memberVO.getMember_pw());
		System.out.println(memberVO.getMember_name());
		System.out.println(memberVO.getEmail1());
		System.out.println(memberVO.getJibunaddress());
		return result;
	}

	@Override
	public int deleteMember(String member_id) throws DataAccessException {
		//System.out.println(member_id);
		int result = this.sqlSession.update("mapper.member.deleteMember", member_id);
		return result;
	}

	@Override
	public MemberVO selectMemberById(String member_id) throws DataAccessException {
		MemberVO memberVO = new MemberVO();
		memberVO = (MemberVO) this.sqlSession.selectOne("mapper.member.selectMemberById", member_id); 
		return memberVO;
	}

	@Override
	public int updateMember(MemberVO memberVO) throws DataAccessException {
//		System.out.println(memberVO.getMember_id());
//		System.out.println(memberVO.getMember_pw());
//		System.out.println(memberVO.getMember_name());
//		System.out.println(memberVO.getEmail1());
//		System.out.println(memberVO.getEmail2());
		int result = this.sqlSession.update("mapper.member.updateMember", memberVO);
		return result;
	}

	@Override
	public int leaveMember(String del_yn) throws DataAccessException {
		int result = this.sqlSession.update("mapper.member.leaveMember", del_yn);
		return result;

			
	}

}
