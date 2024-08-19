package com.kms.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.kms.spring.member.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> listMembers() throws DataAccessException;
	public String addMember(MemberVO memberVO) throws DataAccessException;
	public String removeMember(String id) throws DataAccessException;
	public MemberVO modMember(String id) throws DataAccessException;
	public String updateMember(MemberVO memberVO) throws DataAccessException;
}
