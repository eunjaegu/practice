package com.kms.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.kms.spring.member.vo.MemberVO;

public interface MemberDAO {
	public List<MemberVO> selectAllMemberList() throws DataAccessException;
	public String insertMember(MemberVO memberVO) throws DataAccessException;
	public String deleteMember(String id) throws DataAccessException;
	public String updateMember(MemberVO memberVO) throws DataAccessException;
	public MemberVO selectMemberById(String id) throws DataAccessException;
}
