package com.kms.spring.admin.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.kms.spring.member.vo.MemberVO;

public interface AdminService {
	public List<MemberVO> listMembers() throws DataAccessException;
	public int addMember(MemberVO memberVO) throws DataAccessException;
	public int removeMember(String id) throws DataAccessException;

}
