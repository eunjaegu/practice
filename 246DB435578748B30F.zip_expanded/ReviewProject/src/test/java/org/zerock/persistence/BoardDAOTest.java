package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zerock.controller.AbstractTest;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

public class BoardDAOTest extends AbstractTest{

	@Inject
	private BoardDAO dao;
	
	private static final String namespaace = "org.zerock.mapper.BoardMapper";
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Test
	public void createTest() {
		
		BoardVO bVO = new BoardVO();
		bVO.setTitle("새로운 글");
		bVO.setContent("새로운 내용");
		bVO.setWriter("user00");
		
		dao.create(bVO);
		
		
	}// createTest()
	
	
	@Test
	public void readTest() {
		
		logger.info(""+dao.read(1));
	}// readTest()
	
	@Test
	public void updateTest() {
		
		BoardVO bVO = new BoardVO();
		bVO.setBno(1);
		bVO.setTitle("수정된 글");
		bVO.setContent("수정된 내용");
		bVO.setWriter("user00");
		
	}// updateTest()
	
	
	@Test
	public void deleteTest() {
		
		dao.delete(728);
	}// deleteTest()
	
	@Test
	public void criteriaTest() {
		
		
		Criteria cri = new Criteria();
		
		cri.setPage(1);
		cri.setPerPageNum(10);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		logger.info(list.toString());
		
	}// criteriaTest()
	
	@Test
	public void totalCountTest() {
		
		logger.info(dao.boardTotalCount().toString());
		
	}// totalCountTest()
	
	@Test
	public void searchCriteriaTest() {
		
		SearchCriteria cri = new SearchCriteria();
		
		cri.setPage(1);
		cri.setPerPageNum(10);
		cri.setSearchType("c");
		cri.setKeyword("내용");
		
		List<BoardVO> list = dao.listSearchCriteria(cri);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.toString());
		}
		
	}// searchCriteriaTest()
	
	@Test
	public void searchTotalCountTest() {
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setPerPageNum(10);
		cri.setSearchType("t");
		cri.setKeyword("수정");
		
		logger.info(dao.searchBoardTotalCount(cri).toString());
		
	}// searchTotalCountTest()
		
	
	@Test
	public void dynamicSQLTest(){
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setPerPageNum(10);
		cri.setSearchType("t");
		cri.setKeyword("수정");
		
		List<BoardVO> list = dao.listSearchCriteria(cri);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.toString());
		}
		
		logger.info("총 갯수 : " + dao.searchBoardTotalCount(cri).toString());
		
		
		
	}// dynamicSQLTest()
	

}
