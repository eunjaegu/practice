package com.kang.shopping.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.kang.shopping.member.service.MemberService;
import com.kang.shopping.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController {
	private MemberService memberService;
	
	public MemberControllerImpl() {
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//System.out.println("===>public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception{");
		String viewName = getViewName(request);
		//System.out.println(viewName);
		
		List<MemberVO> membersList = memberService.listMembers();
		//System.out.println("viewName :" + viewName);
		// "listMembers"
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
	
		return mav;
	}
	
	@Override
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	
	@Override
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String member_id = request.getParameter("id");
		String member_pw = request.getParameter("pwd");
		String member_name = request.getParameter("name");
		String tel1 = request.getParameter("tel");		
		String email1 = request.getParameter("email");
		
//		System.out.println("member_id=====>" + member_id);
//		System.out.println("member_pw=====>" + member_pw);
//		System.out.println("member_name=====>" + member_name);
//		System.out.println("tel1=====>" + tel1);
//		System.out.println("email1=====>" + email1);
		
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMember_id(member_id);
		memberVO.setMember_pw(member_pw);
		memberVO.setMember_name(member_name);
		memberVO.setTel1(tel1);		
		memberVO.setEmail1(email1);	
		
		int result = memberService.addMember(memberVO);
		ModelAndView mav = new ModelAndView();
		if(result > 0) {
			mav.setViewName("index");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}

	@Override
	public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String member_id  = request.getParameter("id");
		ModelAndView mav = new ModelAndView();
		
		int result = memberService.removeMember(member_id);
		
		if(result > 0) {
			mav.setViewName("index");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@Override
	public ModelAndView modMemberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.setCharacterEncoding("utf-8");
		String member_id  = request.getParameter("id");
		String viewName = getViewName(request);
	
		
		MemberVO member = memberService.modMemberForm(member_id);
		ModelAndView mav = new ModelAndView(viewName);
		System.out.println("viewName"+ viewName);
		mav.addObject("member", member);
		return mav;
	}

	@Override
	public ModelAndView modMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String member_id = request.getParameter("id");
		String member_pw = request.getParameter("pwd");
		String member_name = request.getParameter("name");
		String tel1 = request.getParameter("tel");
		String email1 = request.getParameter("email");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMember_id(member_id);
		memberVO.setMember_pw(member_pw);
		memberVO.setMember_name(member_name);
		memberVO.setTel1(tel1);
		memberVO.setEmail1(email1);
		
		int result = memberService.modMember(memberVO);
		
		ModelAndView mav = new ModelAndView();
		if(result > 0) {
			mav.setViewName("redirect:/member/listMembers.do");
			//mav.setViewName("/member/listMembers.do");
			//mav.setViewName("index");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		//System.out.println(" uri=> " + uri);
		
		int begin = 0;
		if(!((contextPath == null) || ("".equals(contextPath)))){
			begin = contextPath.length();
		}
		//System.out.println("begin=>" + begin);
		
		int end;
		if(uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
			
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
			
		} else {
			end = uri.length();
		}
		//System.out.println("end=>" + end);
		
		String fileName = uri.substring(begin, end);
		if(fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}
		if(fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/")+1, fileName.length());
		}
		//System.out.println(" fileName==> " + fileName);
		
		return fileName;
	}

	

	
}
