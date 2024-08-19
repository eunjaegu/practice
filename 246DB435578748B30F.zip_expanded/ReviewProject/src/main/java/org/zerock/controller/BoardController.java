package org.zerock.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	BoardService service;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// c
	// /create, GET		:	게시물의 등록 페이지를 보여준다.
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public void createGET(){
		
		logger.info("createGET is called......");
		
	}// createGET()
	
	
	// /create, POST	:	게시물을 실제로 등록한다.
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String createPOST(BoardVO boardVO, RedirectAttributes rttr){
		
		logger.info("createPOST is called......");
		
		service.create(boardVO);
		
		// 리다이렉트 시 한 번만 값이 담겨져 뷰로 간다.
		rttr.addFlashAttribute("createMsg", "success");
		
		return "redirect:/board/listAll";
		
	}// createPOST()
	
	// r
	// /readPage?bno=?&page=?&perPageNum=?, GET		:	bno에 해당하는 게시물을 조회한다.
	@RequestMapping(value="/readPage", method= RequestMethod.GET)
	public void readPageGET(@RequestParam("bno") Integer bno, 
						@ModelAttribute("cri") Criteria cri,
						Model model)
	{
		
		logger.info("readPageGET is called......");
		logger.info(" page : " + cri.getPage().toString());
		logger.info(" perPageNum : " +cri.getPerPageNum().toString());
		
		model.addAttribute("boardVO", service.read(bno));
		
		
		
	}// readPageGET()
	
	
	// u
	// /update?bno=?, GET	:	bno에 해당하는 게시물의 내용을 수정하기 위해 조회한다.
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public void updateGET(@RequestParam("bno") Integer bno,
				Criteria cri,
				Model model){
		
		logger.info("updateGET is called......");
		logger.info(" page : " + cri.getPage().toString());
		logger.info(" perPageNum : " + cri.getPerPageNum().toString());
		
		model.addAttribute("boardVO", service.read(bno));
		model.addAttribute("cri", cri);
		
	}// updateGET()
	
	
	// /update, POST		:	게시물을 업데이트한다.
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updatePOST(BoardVO boardVO, Criteria cri, RedirectAttributes rttr){
		
		logger.info(" board updatePOST is called......");
		logger.info(" page : " + cri.getPage().toString());
		logger.info(" perPageNum : " + cri.getPerPageNum().toString());
		
		service.update(boardVO);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
	
		rttr.addFlashAttribute("updateMsg", "success");
		
		return "redirect:/board/listPage";	
	}// updatePOST()
	
	
	// d
	// /delete?, POST	:	bno에 해당하는 게시글을 삭제한다.
	@RequestMapping(value="/delete", method= RequestMethod.POST)
	public String deletePOST(@RequestParam("bno") Integer bno,
					Criteria cri,
					RedirectAttributes rttr){
		
		// 삭제하고, 
		service.delete(bno);
		
		logger.info("deletePOST is called......");
		logger.info(" page : " + cri.getPage().toString());
		logger.info(" perPageNum : " + cri.getPerPageNum().toString());
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		// 리스트페이지로 리다이렉트 하자.
		return "redirect:/board/listPage";
	}
	
/*	
*/	
	// listAll
	// /listAll, GET		:	DB에 있는 모든 게시물을 조회한다.
	@RequestMapping(value="/listAll", method = RequestMethod.GET)
	public void listAllGET(Model model){
		
		logger.info("listAllGET is called......");
		
		model.addAttribute("list", service.listAll());
		
		
	}// listAllGET()
	

	@RequestMapping(value="/listCri", method=RequestMethod.GET)
	public void listCriteriaGET(Model model, Criteria cri){
		
		logger.info("listCriteriaGET is called......");

		logger.info(cri.toString());
		
		model.addAttribute("listCri", service.listCriteria(cri));
		
	}// listCriteriaGET()
	
	
	// page, perPageNum 파라미터 수집(Criteria 객체로)
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public void listPageGET(Model model, Criteria cri){
		
		logger.info("listPageGET is called......");
		logger.info(" page : " + cri.getPage().toString());
		logger.info(" perPageNum : " + cri.getPerPageNum().toString());
			
		// page, perPageNum을 넘겨서 해당 게시물 리스트를 가져온다.
		model.addAttribute("listPage", service.listCriteria(cri));
		
		// PageMaker
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.boardTotalCount());
		
		// 현재 startPage, endPage, prev, next 모두 계산된 상태이다. 이 데이터를 갖고 view단에서 화면처리를 해주면된다.
		model.addAttribute("pageMaker", pageMaker);
		
	}// listPageGET()	
	
	
	
}// class
