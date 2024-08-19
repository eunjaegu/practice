package com.ej.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ej.spring.member.vo.MemberVO;

public interface MemberService {
	public List listMembers() throws DataAccessException;
	public int addMember(MemberVO MemberVO) throws DataAccessException;
	public int removeMember(String id) throws DataAccessException;
	
}
