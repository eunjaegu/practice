package com.ej.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ej.spring.member.vo.MemberVO;

public interface MemberDAO {
	public List<MemberVO> selectAllMemberList() throws DataAccessException;
	public int insertMember(MemberVO memberVO) throws DataAccessException;
	public int deleteMember(String id) throws DataAccessException;
}
