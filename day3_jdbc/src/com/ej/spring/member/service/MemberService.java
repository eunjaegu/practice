package com.ej.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ej.spring.member.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> listMembers() throws DataAccessException;
//	public List<MemberVO> addMember() throws DataAccessException;
//	public List<MemberVO> memberDetail() throws DataAccessException;
}
