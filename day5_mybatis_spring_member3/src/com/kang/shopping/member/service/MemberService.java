package com.kang.shopping.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.kang.shopping.member.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> listMembers() throws DataAccessException;
	public int addMember(MemberVO memberVO) throws DataAccessException;
	public int removeMember(String member_id) throws DataAccessException;
	public MemberVO modMemberForm(String member_id) throws DataAccessException;
	public int modMember(MemberVO memberVO) throws DataAccessException; 
}
