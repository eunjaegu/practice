package com.kms.spring.admin.service;

import com.kms.spring.member.dao.MemberDAO;

public class AdminServiceImpl {
	private MemberDAO memberDAO;
	
	public AdminServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
}
