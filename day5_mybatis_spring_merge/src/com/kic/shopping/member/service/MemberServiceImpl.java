package com.kic.shopping.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.kic.shopping.member.dao.MemberDAO;
import com.kic.shopping.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public MemberServiceImpl() {
	}

	@Override
	public List<MemberVO> listMembers() throws DataAccessException {
		List<MemberVO> membersList = memberDAO.selectAllMemberList();
		return membersList;
	}

	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		int result = memberDAO.insertMember(memberVO);
		return result;
	}

	@Override
	public int modifyMember(MemberVO memberVO) throws DataAccessException {
		int result = memberDAO.updateMember(memberVO);
		return result;
	}

	@Override
	public int removeMember(String member_id) throws DataAccessException {
		int result = memberDAO.deleteMember(member_id);
		return result;
	}

	@Override
	public MemberVO selectMemberById(String member_id) throws DataAccessException {
		MemberVO memberVO = memberDAO.selectMemberById(member_id);
		return memberVO;
	}

	

	

}
