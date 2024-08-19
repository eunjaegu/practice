package com.ej.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ej.spring.member.service.MemberService;
import com.ej.spring.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController{
	
	private MemberService memberService;
	
	public MemberControllerImpl() {
		
	}
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService; //controller에서 호출 
		System.out.println("this.memberService = memberService"); // setter 를 통해서  memberService 주입
	}

	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		String viewName = getViewName(request);
		System.out.println(viewName);
		
		List<MemberVO> memberList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		
		//3.
		mav.addObject("membersList", memberList);
		return mav;
	}
	
	@Override
	public ModelAndView addMembers(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}
	@Override
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}
	@Override
	public ModelAndView memberDetail(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}
	
	 private String getViewName(HttpServletRequest request) throws Exception {
			// 현재 웹애플리케이션의 컨텍스트 경로를 확인하고, 요청된 자원의 URI를 확인.
	    	String contextPath = request.getContextPath();
			String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
			
			// 사용자가 빈 경로로 요청을 보낸경우
			// uri.trim().equals("") : uri가 null이 아니라면, 
			// trim() 메서드를 사용하여 uri의 앞뒤 공백을 제거하고, 
			// 그 결과가 빈 문자열인지 확인
			if(uri == null || uri.trim().equals("")) {
			   uri = request.getRequestURI();
			}
			System.out.println(uri);
			
			
			
			
			// 컨텍스트 경로의 존재 여부에 따라 파일 이름 추출 과정에서 시작 위치(begin)를 설정
			// 컨텍스트 경로가 존재하면, 파일 이름 추출 과정에서 컨텍스트 경로의 길이만큼의 위치부터 시작
			int begin = 0;
			if(!((contextPath == null)||("".equals(contextPath)))) {
				begin = contextPath.length();
				//프로젝트이름
			}
			System.out.println("begin=>" + begin);
			
			
			
			
			
			// 파일이름의 끝 위치를 설정
			// 세미콜론(;)이 있는지 확인. URI에 세미콜론이 포함되어 있다면, 파일 이름은 세미콜론 이전까지
			int end;
			if(uri.indexOf(";") !=-1) {
				end =uri.indexOf(";");
				
			// 쿼리 문자열(?)이 있는지 확인. URI에 쿼리 문자열이 포함되어 있다면, 파일 이름은 쿼리 문자열 이전까지	
			} else if (uri.indexOf("?") !=-1) {
				end =uri.indexOf("?");
			
			//그렇지 않으면 URI에 세미콜론이나 쿼리 문자열이 없으므로 파일 이름은 URI의 끝까지이며, 
			//이때는 URI의 길이를 end 변수에 할당
			} else {
				end = uri.length();
			}
			
			System.out.println("end ==> " + end);
			
			
			//추출된 파일 이름에서 확장자와 경로를 제거하는 과정
			//추출된 파일 이름을 uri 문자열에서 begin 위치부터 end 위치까지의 부분 문자열로 설정
			String fileName = uri.substring(begin, end); 
			System.out.println(fileName);//값이 뭐가 들었는지 어떻게 변화되는지
			
			//추출된 파일 이름에 확장자가 있는지 확인
			//확장자가 있으면, 마지막 점(.)을 기준으로 왼쪽에 있는 부분을 추출하여 확장자를 제거
			//file.txt라면, 이 코드는 file로 파일 이름을 변경
			//indexOf - char 속성
			if(fileName.indexOf(".") !=-1) {
				System.out.println("indexOf ==>" + fileName.indexOf("."));
				fileName = fileName.substring(0, fileName.lastIndexOf("."));	// /test/login
			}
			
			// 마지막 슬래시(/)를 기준으로 오른쪽에 있는 부분을 추출하여 순수한 파일 이름만을 남김.
			if(fileName.indexOf("/") !=-1) {
				fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
				// /login
			}
			System.out.println("fileName ==> " + fileName);
			return fileName;
		}

}
