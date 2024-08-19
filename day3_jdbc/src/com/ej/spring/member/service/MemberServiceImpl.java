package com.ej.spring.member.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.ej.spring.member.dao.MemberDAO;
import com.ej.spring.member.vo.MemberVO;
import com.mysql.jdbc.ResultSet;

public class MemberServiceImpl implements MemberService{

	private MemberDAO memberDAO;
	
	public MemberServiceImpl() {
		System.out.println("public MemberServiceImpl()");
	}

	
	@Override
	public List listMembers() throws DataAccessException {
		List membersList = null;
		membersList = memberDAO.selectAllMembers();
		
		return membersList;

	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
		System.out.println("this.memberDAO");
	}


}
