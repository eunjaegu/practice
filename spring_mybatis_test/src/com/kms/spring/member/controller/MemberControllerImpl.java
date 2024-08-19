package com.kms.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.kms.spring.member.service.MemberService;
import com.kms.spring.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController {
	private MemberService memberService;
	
	public MemberControllerImpl() {
		
	}
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		
		return mav;
	}
	
	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List<MemberVO> memberList = memberService.listMembers();
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", memberList);
		return mav;
	}
	
	@Override
	public void addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId(request.getParameter("id"));
		memberVO.setName(request.getParameter("name"));
		memberVO.setPwd(request.getParameter("pwd"));
		memberVO.setEmail(request.getParameter("email"));
		
		String result = memberService.addMember(memberVO);
		if(result.equals("success"))
			response.sendRedirect("http://localhost:9000/spring_mybatis_test/index.jsp");
		if(result.equals("fail"))
			response.sendRedirect("http://localhost:9000/spring_mybatis_test/index.jsp");
	}
	
	@Override
	public void removeMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		String result = memberService.removeMember(id);
		
		if(result.equals("success"))
			response.sendRedirect("http://localhost:9000/spring_mybatis_test/index.jsp");
		if(result.equals("fail"))
			response.sendRedirect("http://localhost:9000/spring_mybatis_test/index.jsp");
	}
	
	@Override
	public ModelAndView modMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		MemberVO memberVO = new MemberVO();
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		memberVO = memberService.modMember(id);
		
		mav.addObject("member", memberVO);
		
		return mav;
	}
	
	@Override
	public void updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO memberVO = new MemberVO();

		memberVO.setId(request.getParameter("id"));
		memberVO.setName(request.getParameter("name"));
		memberVO.setPwd(request.getParameter("pwd"));
		memberVO.setEmail(request.getParameter("email"));
		
		String result = memberService.updateMember(memberVO);
		
		if(result.equals("success"))
			response.sendRedirect("http://localhost:9000/spring_mybatis_test/index.jsp");
		if(result.equals("fail"))
			response.sendRedirect("http://localhost:9000/spring_mybatis_test/index.jsp");
		
	}
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath(); 
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		
		if(uri == null || uri.trim().equals(""))
			uri = request.getRequestURI();
		
		int begin = 0;
		if(!(contextPath == null) || ("".equals(contextPath))) 
			begin = contextPath.length();
		
		int end;
		if(uri.indexOf(";") != -1) 
			end = uri.indexOf(";");
		else if(uri.indexOf("?") != -1)
			end = uri.indexOf("?");
		else
			end = uri.length();
		
		String fileName = uri.substring(begin, end);
		
		if(fileName.indexOf(".") != -1)
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		
		if(fileName.lastIndexOf("/") != -1)
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		
		return fileName;
	}
}
