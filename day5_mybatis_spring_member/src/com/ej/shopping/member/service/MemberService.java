package com.ej.shopping.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ej.shopping.member.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> listMembers() throws DataAccessException;	// 조회
	public int addMember(MemberVO memberVO) throws DataAccessException;	// 회원가입
	public int removeMember(String member_id) throws DataAccessException;	//삭제, ID값으로 제거하기
	public MemberVO modMember(String member_id) throws DataAccessException; //수정폼, ID 값으로 불러오기
	public int updateMember(MemberVO memberVO) throws DataAccessException;	// 수정완료  
}
