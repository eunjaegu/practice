package com.kms.spring.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.kms.spring.member.service.MemberService;

public class AdminControllerImpl extends MultiActionController implements AdminController {
	private MemberService memberService;
	
	public AdminControllerImpl() {
		
	}
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public ModelAndView listMembers(HttpServletRequest reuqest, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ModelAndView removeMember(HttpServletRequest reuqest, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ModelAndView form(HttpServletRequest reuqest, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
