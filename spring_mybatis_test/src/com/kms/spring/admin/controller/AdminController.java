package com.kms.spring.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface AdminController {
	public ModelAndView listMembers(HttpServletRequest reuqest, HttpServletResponse response) throws Exception;
	public ModelAndView removeMember(HttpServletRequest reuqest, HttpServletResponse response) throws Exception;
	public ModelAndView form(HttpServletRequest reuqest, HttpServletResponse response) throws Exception;
	
}
