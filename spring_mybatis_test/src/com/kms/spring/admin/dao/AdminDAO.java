package com.kms.spring.admin.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.kms.spring.member.vo.MemberVO;

public interface AdminDAO {
	public List<MemberVO> selectAllMemberList() throws DataAccessException;
	public int insertMember(MemberVO memberVO) throws DataAccessException;
	public int deleteMember(String id) throws DataAccessException;
	
}
