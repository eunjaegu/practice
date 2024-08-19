package com.ej.shopping.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ej.shopping.member.dao.MemberDAO;
import com.ej.shopping.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	private MemberDAO memberDAO;
	
	public MemberServiceImpl() {
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public List<MemberVO> listMembers() throws DataAccessException {
		List<MemberVO> memberlist=null;
		memberlist = memberDAO.selectAllMemberList();
		return memberlist;
	}

	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		int result = 0;
		result = memberDAO.insertMember(memberVO);
		return result;
	}

	@Override
	public int removeMember(String member_id) throws DataAccessException {
		int result = 0;
		result = memberDAO.deleteMember(member_id);
		return result;
	}

	@Override
	public MemberVO modMember(String member_id) throws DataAccessException {
		MemberVO memberVO = new MemberVO();
		memberVO = memberDAO.selectMemberById(member_id);
		return memberVO;
	}

	@Override
	public int updateMember(MemberVO memberVO) throws DataAccessException {
		int result = 0;
		result = memberDAO.updateMember(memberVO);
		return result;
	}

}
