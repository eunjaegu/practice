package com.ej.shopping.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ej.shopping.member.service.MemberService;
import com.ej.shopping.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController {
	private MemberService memberService;

	public MemberControllerImpl() {

	}

	public void setmemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		System.out.println(viewName);

		List<MemberVO> memberList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);

		mav.addObject("memberList", memberList);
		return mav;
	}

	@Override
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");
		String member_name = request.getParameter("member_name");
		String member_gender = request.getParameter("member_gender");	//성별
		
		String tel = request.getParameter("tel"); 						// 유선번호
		String[] telList = tel.split("-");
		String tel1 = telList[0].trim();
		String tel2 = telList[1].trim();
		String tel3 = telList[2].trim();
		
		String hp = request.getParameter("hp"); 						// 휴대폰번호
		String[] hpList = hp.split("-");
		String hp1 = hpList[0].trim();
		String hp2 = hpList[1].trim();
		String hp3 = hpList[2].trim();

		String smssts_yn = request.getParameter("smssts_yn"); 			//문자 수신 여부
		String email1 = request.getParameter("email1"); 				//이메일1 수신여부
		String email2 = request.getParameter("email2"); 				//이메일2 수신여부
		String emailsts_yn = request.getParameter("emailsts_yn");		//이메일 수신 여부
		String zipcode = request.getParameter("zipcode");				//우편번호
		String roadaddress = request.getParameter("roadaddress");		//도로명주소
		String jibunaddress = request.getParameter("jibunaddress");		//지번주소
		System.out.println("jibunaddress=====>" + jibunaddress);
		
		String namujiaddress = request.getParameter("namujiaddress");	//나머지주소
		
		String member_birth = request.getParameter("member_birth");		//생일
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
		memberVO.setRoadaddress(roadaddress);
		memberVO.setJibunaddress(jibunaddress);
		memberVO.setNamujiaddress(namujiaddress);
		memberVO.setMember_birth_y(member_birth_y);
		memberVO.setMember_birth_m(member_birth_m);
		memberVO.setMember_birth_d(member_birth_d);
		memberVO.setMember_birth_gn(member_birth_gn);
		memberVO.setDel_yn(del_yn);

//		memberVO.setMember_id(request.getParameter("id"));	// jsp에서 요청해서 가져온다. => vo 객체에 넣는다.
//		memberVO.setMember_pw(request.getParameter("pwd"));
//		memberVO.setMember_name(request.getParameter("name"));
//		memberVO.setEmail1(request.getParameter("email1"));
//		memberVO.setEmail2(request.getParameter("email2"));

		int result = memberService.addMember(memberVO);
		ModelAndView mav = new ModelAndView("index");
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
		String member_id = request.getParameter("id");
		//System.out.println("member_id=====>" + member_id);
		memberService.removeMember(member_id);
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@Override
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}

	@Override
	public ModelAndView modMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String member_id = request.getParameter("id");	// jsp 에서 요청한 값을 가져와야함.
		String viewName = getViewName(request);
		
		MemberVO member = memberService.modMember(member_id);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("member", member);
		return mav;
	}

	@Override
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		request.setCharacterEncoding("utf-8");

		String member_id = request.getParameter("id");
		String member_pw = request.getParameter("pwd");
		String member_name = request.getParameter("name");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");

		MemberVO memberVO = new MemberVO();
		memberVO.setMember_id(member_id);
		memberVO.setMember_pw(member_pw);
		memberVO.setMember_name(member_name);
		memberVO.setEmail1(email1);
		memberVO.setEmail2(email2);
		
		int result = memberService.updateMember(memberVO);
		
		
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}


	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		} // 사용자가 빈경로로 요청 시 공백을 제거하고 문자열일지 확인
		System.out.println(uri);

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length(); // 프로젝트이름
		}
		System.out.println("begin=>" + begin);

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}
		System.out.println("end=>" + end);

		String fileName = uri.substring(begin, end);
		System.out.println(fileName);
		if (fileName.indexOf(".") != -1) {
			System.out.println("indexOf ==>" + fileName.indexOf("."));
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}

		if (fileName.indexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		}
		System.out.println("fileName==>" + fileName);
		
		return fileName;

	}


}
