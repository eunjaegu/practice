package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;
import org.zerock.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public void create(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.create(vo);
	}

	@Override
	public BoardVO read(Integer bno) {
		// TODO Auto-generated method stub
		return dao.read(bno);
	}

	@Override
	public void update(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void delete(Integer bno) {
		// TODO Auto-generated method stub
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) {
		
		return dao.listCriteria(cri);
	}

	@Override
	public Integer boardTotalCount() {
		// TODO Auto-generated method stub
		return dao.boardTotalCount();
	}

	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.listSearchCriteria(cri);
	}

	@Override
	public Integer searchBoardTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.searchBoardTotalCount(cri);
	}

}// class
