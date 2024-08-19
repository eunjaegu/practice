package org.zerock.controller;

import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/")
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/doC", method=RequestMethod.GET)
	public String doC(RedirectAttributes rttr){
		logger.info("doC is called...");

		// doD로 redirect하기전에 msg라는 이름으로 "Message"라는 추가적인 데이터를 같이 담아보내고 싶을때
		// RedirectAttributes.addFlashAttribute()를 사용하면 된다.
		rttr.addFlashAttribute("msg", "Message");
		return "redirect:/doD";
		
	}// doA()

	@RequestMapping(value="/doD", method=RequestMethod.GET)
	public void doD(@ModelAttribute("msg") String msg){
		logger.info("doD is called..."); 
		logger.info(msg);
		
	}// doA()
	
}// class
