package com.kic.shopping.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.kic.shopping.member.service.MemberService;
import com.kic.shopping.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController {
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public MemberControllerImpl() {
	}

	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName= "member/" + getViewName(request);
		List<MemberVO> membersList = memberService.listMembers();
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}
	
	@Override
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");
		String member_name = request.getParameter("member_name");
		String hp = request.getParameter("hp"); // 집 전화번호 
		
		String[] hpList = hp.split("-");
		String hp1 = hpList[0].trim();
		String hp2 = hpList[1].trim();
		String hp3 = hpList[2].trim();

		
		String tel = request.getParameter("tel"); // 휴대번호
		String[] telList = tel.split("-");
		String tel1 = telList[0].trim();
		String tel2 = telList[1].trim();
		String tel3 = telList[2].trim();
		String member_gender = request.getParameter("member_gender");
		
		String smssts_yn = request.getParameter("smssts_yn"); //문자 수신 여부
		String email = request.getParameter("email");
		String[] emailList = email.split("@");
		String email1 = emailList[0].trim();
		String email2 = emailList[1].trim();
		String emailsts_yn = request.getParameter("emailsts_yn");
		String zipcode = request.getParameter("zipcode");
		String roadAddress = request.getParameter("roadAddress");
		String jibunAddress = request.getParameter("jibunAddress");
		String namujiAddress = request.getParameter("namujiAddress");
		
		String member_birth = request.getParameter("member_birth");
		String[] member_birthList = member_birth.split("-");
		String member_birth_y = member_birthList[0].trim();
		String member_birth_m = member_birthList[1].trim();
		String member_birth_d = member_birthList[2].trim();
		String member_birth_gn = request.getParameter("member_birth_gn");
		String del_yn = request.getParameter("del_yn");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMember_id(member_id);
		memberVO.setMember_pw(member_pw);
		memberVO.setMember_name(member_name);
		memberVO.setHp1(hp1);
		memberVO.setHp2(hp2);
		memberVO.setHp3(hp3);
		memberVO.setTel1(tel1);
		memberVO.setTel2(tel2);
		memberVO.setTel3(tel3);
		memberVO.setMember_gender(member_gender);
		memberVO.setSmssts_yn(smssts_yn);
		memberVO.setEmail1(email1);
		memberVO.setEmail2(email2);
		memberVO.setEmailsts_yn(emailsts_yn);
		memberVO.setZipcode(zipcode);
		memberVO.setRoadAddress(roadAddress);
		memberVO.setJibunAddress(jibunAddress);
		memberVO.setNamujiAddress(namujiAddress);
		memberVO.setMember_birth_y(member_birth_y);
		memberVO.setMember_birth_m(member_birth_m);
		memberVO.setMember_birth_d(member_birth_d);
		memberVO.setMember_birth_gn(member_birth_gn);
		memberVO.setDel_yn(del_yn);
		
		System.out.println(memberVO);
		
		int result = memberService.addMember(memberVO);
		ModelAndView mav = new ModelAndView();
		if(result > 0) {
			mav.setViewName("redirect:/member/listMembers.do");
		} else {
			mav.setViewName("error");
		}
	
		return mav;
	}

	@Override
	public ModelAndView modifyMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");
		String member_name = request.getParameter("member_name");
		
		String email = request.getParameter("email");
		String[] emailList = email.split("@");
		String email1 = emailList[0].trim();
		String email2 = emailList[1].trim();
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMember_id(member_id);
		memberVO.setMember_pw(member_pw);
		memberVO.setMember_name(member_name);
		memberVO.setEmail1(email1);
		memberVO.setEmail2(email2);
		
		int result = memberService.modifyMember(memberVO);
		
		ModelAndView mav = new ModelAndView();
		if(result > 0) {
			mav.setViewName("redirect:/member/listMembers.do");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}

	@Override
	public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String member_id = request.getParameter("id");
		
		
		int result = memberService.removeMember(member_id);
		
		ModelAndView mav = new ModelAndView();
		if(result > 0) {
			mav.setViewName("redirect:/member/listMembers.do");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}


	@Override
	public ModelAndView modMemberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String member_id = request.getParameter("id");
		MemberVO memberVO = memberService.selectMemberById(member_id);
		
		ModelAndView mav = new ModelAndView("member/modMemberForm");
		mav.addObject("member", memberVO);
		return mav;
	}
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
	
		
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
	
		
		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		
		
		int begin = 0;
		if(!((contextPath == null) || ("".equals(contextPath)))){
			begin = contextPath.length();
		}
		
		
		
		int end;
		if(uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
			
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
			
		} else {
			end = uri.length();

		}
		
		String fileName = uri.substring(begin, end);
		
		if(fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));

		}
		
		if(fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/")+1, fileName.length());
			
		}
		
		return fileName;
	}

	
	@Override
	public ModelAndView addMemberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("member/addMemberForm");
		return mav;
	}

	
	


}
