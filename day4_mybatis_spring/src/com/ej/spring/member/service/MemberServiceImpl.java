package com.ej.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ej.spring.member.dao.MemberDAO;
import com.ej.spring.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	private MemberDAO memberDAO;
	
	public MemberServiceImpl() {
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public List listMembers() throws DataAccessException {
		List memberList = null;
		memberList = memberDAO.selectAllMemberList();
		
		return memberList;
	}

	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		return memberDAO.insertMember(memberVO);
	
	}

	@Override
	public int removeMember(String id) throws DataAccessException {
		return memberDAO.deleteMember(id);
	}

	@Override
	public MemberVO modMember(String id) throws DataAccessException {
		return memberDAO.selectMemberById(id);
	}

	@Override
	public int updateMember(MemberVO membervo) throws DataAccessException {
		return memberDAO.updateMember(membervo);

	}


}
