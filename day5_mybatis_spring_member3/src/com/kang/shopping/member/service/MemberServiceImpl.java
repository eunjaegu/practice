package com.kang.shopping.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.kang.shopping.member.dao.MemberDAO;
import com.kang.shopping.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;
	
	public MemberServiceImpl() {
	}
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
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
	public int removeMember(String member_id) throws DataAccessException {
		int result = memberDAO.deleteMember(member_id);
		System.out.println(member_id);
		return result;
	}

	@Override
	public MemberVO modMemberForm(String member_id) throws DataAccessException {
		MemberVO memberVO = new MemberVO();
		memberVO = memberDAO.selectMemberById(member_id);
		return memberVO;
	}

	@Override
	public int modMember(MemberVO memberVO) throws DataAccessException {
		System.out.println(memberVO);
		int result = memberDAO.updateMember(memberVO);
		return result;
	}



}
