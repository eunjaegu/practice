package com.ej.shopping.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ej.shopping.member.vo.MemberVO;

public interface MemberDAO {
	public List<MemberVO> selectAllMemberList() throws DataAccessException; // 목록조회 
	public int insertMember(MemberVO memberVO) throws DataAccessException; // 회원가입(추가)
	public int deleteMember(String member_id) throws DataAccessException;	// 삭제, id값으로 조회
	public MemberVO selectMemberById(String member_id) throws DataAccessException; // 조회, id값으로 조회
	public int updateMember(MemberVO memberVO) throws DataAccessException;//수정완료
	public int leaveMember(String del_yn) throws DataAccessException;//탈퇴, yn 값으로 조회
}
