package com.ej.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface MemberController {
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	public ModelAndView form(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	public ModelAndView modMember(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse reponse) throws Exception;
		
}
