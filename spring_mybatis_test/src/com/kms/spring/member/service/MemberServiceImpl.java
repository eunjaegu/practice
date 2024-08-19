package com.kms.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.kms.spring.member.dao.MemberDAO;
import com.kms.spring.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	private MemberDAO memberDAO;
	
	public MemberServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public List<MemberVO> listMembers() throws DataAccessException {
		List<MemberVO> memberList = null;
		memberList = memberDAO.selectAllMemberList();
		return memberList;
	}
	
	@Override
	public String addMember(MemberVO memberVO) throws DataAccessException {
		String result = null;
		result = memberDAO.insertMember(memberVO);
		
		return result;
	}
	
	@Override
	public String removeMember(String id) throws DataAccessException {
		String result = null;
		result = memberDAO.deleteMember(id);
		
		return result;
	}
	
	@Override
	public MemberVO modMember(String id) throws DataAccessException {
		MemberVO memberVO = new MemberVO();
		memberVO = memberDAO.selectMemberById(id);
		
		return memberVO;
	}
	
	@Override
	public String updateMember(MemberVO memberVO) throws DataAccessException {
		String result = null;
		result = memberDAO.updateMember(memberVO);
		
		return result;
	}
}
