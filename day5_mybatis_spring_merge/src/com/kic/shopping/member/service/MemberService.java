package com.kic.shopping.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.kic.shopping.member.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> listMembers() throws DataAccessException;
	public int addMember(MemberVO memberVO) throws DataAccessException;
	public int modifyMember(MemberVO memberVO) throws DataAccessException;
	public int removeMember(String member_id) throws DataAccessException;
	public MemberVO selectMemberById(String member_id) throws DataAccessException;
}
