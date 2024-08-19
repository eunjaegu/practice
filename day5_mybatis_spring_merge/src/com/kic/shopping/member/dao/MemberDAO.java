package com.kic.shopping.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.kic.shopping.member.vo.MemberVO;

public interface MemberDAO {
	public List<MemberVO> selectAllMemberList() throws DataAccessException;
	public int insertMember(MemberVO memberVO) throws DataAccessException;
	public int updateMember(MemberVO memberVO) throws DataAccessException;
	public int deleteMember(String member_id) throws DataAccessException;
	public MemberVO selectMemberById(String member_id) throws DataAccessException;
}
