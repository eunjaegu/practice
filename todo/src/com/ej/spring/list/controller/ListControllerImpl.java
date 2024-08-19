package com.ej.spring.list.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ej.spring.list.vo.ListVO;
import com.ej.spring.member.service.ListService;


@Controller("listController")
public class ListControllerImpl implements ListController {

	@Autowired
	private ListService listService;
	@Autowired
	ListVO listVO;
	private String tno;
	
/**	private static final Logger logger = LoggerFactory.getLogger(ListControllerImpl.class);

	@RequestMapping(value = "/list/lists.do", method = RequestMethod.GET)
	public void listGET(com.ej.spring.list.vo.SearchCriteria cri, Model model) {
		
		logger.info("listGET is called.....");
		logger.info("searchCriteria" + cri.toString());
		
		model.addAttribute("list", .listSearchCriteria(cri));
		
		PageMaker pageMaker=new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotlaCount(service.sear);

	}
**/		
	
	//게시물 조회
	@Override
	@RequestMapping(value = "/list/lists.do", method = RequestMethod.GET)
	public ModelAndView lists(@ModelAttribute("listVO") ListVO listVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		//System.out.println(listVO.getResult());
		List<ListVO> todolist = listService.lists(listVO);
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("todolist", todolist);
		return mav;
	}

	//게시물 등록
	@Override
	@RequestMapping(value = "/list/addlist.do", method = RequestMethod.POST)
	public ModelAndView addlist(ListVO listVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		listVO.setUserid("user6");
		result = listService.addList(listVO);
		ModelAndView mav = new ModelAndView("redirect:/list/lists.do");
		return mav;
	}

	//게시물 수정폼
	@Override
	@RequestMapping(value = "/list/modListForm.do", method = RequestMethod.GET)
	public ModelAndView modlist(String tno, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName =getViewName(request);
		
		ListVO todolist = listService.modList(tno);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("todolist", todolist);
		return mav;
	}

	//게시물 수정하기
	@Override
	@RequestMapping(value = "/list/modifylist.do", method = RequestMethod.POST)
	public ModelAndView modifylist(@ModelAttribute("listVO") ListVO listVO, @RequestParam("date") String date, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println("수정할 목록" + listVO.getTno());
		//regdate를 String에서 Date로 변환하여 listVO에 설정
		//SimpleDateFormat changeFormat = new SimpleDateFormat("yyyy-MM-dd");
		//String transDate = changeFormat.format(newDate);
		//System.out.println("변환된 data: " + transDate);
		Date regDate = Date.valueOf(date);
		listVO.setRegdate(regDate);
		listVO.setUserid("user6");
		int result = 0; 
		result = listService.modifyList(listVO);
		ModelAndView mav = new ModelAndView("redirect:/list/lists.do");
		return mav;
	}

	@Override
	@RequestMapping(value = "/list/removeList.do", method=RequestMethod.GET)
	public ModelAndView removelist(String tno, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("수정한 목록" + listVO);
		int result = 0;
		result = listService.removeList(tno);
		ModelAndView mav = new ModelAndView("redirect:/list/lists.do");
		return mav;
	}
	
	@RequestMapping(value = "/list/rigForm.do", method=RequestMethod.GET)
	public ModelAndView form(String tno, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
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
