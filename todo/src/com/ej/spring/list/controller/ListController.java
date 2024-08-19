package com.ej.spring.list.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ej.spring.list.vo.ListVO;

public interface ListController {
	public ModelAndView lists(@ModelAttribute("listVO") ListVO listVO, HttpServletRequest request,
									HttpServletResponse response) throws Exception;
	public ModelAndView addlist(@ModelAttribute("info") ListVO listVO,
									HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView modlist(@ModelAttribute("tno") String tno,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView modifylist(ListVO listVO,@RequestParam("date") String date,
									HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removelist(@ModelAttribute("tno") String tno,
									HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
	
	
	
}
