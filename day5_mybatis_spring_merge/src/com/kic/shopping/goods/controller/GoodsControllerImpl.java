package com.kic.shopping.goods.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.kic.shopping.goods.service.GoodsService;
import com.kic.shopping.goods.vo.GoodsVO;

public class GoodsControllerImpl extends MultiActionController implements GoodsController {
	private GoodsService goodsService;
	public GoodsControllerImpl() {
		
	}
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	@Override
	public ModelAndView listGoods(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = "goods/" + getViewName(request);
		List<GoodsVO> goodsList = goodsService.listGoods();
		
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("goodsList", goodsList);
		
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

}
