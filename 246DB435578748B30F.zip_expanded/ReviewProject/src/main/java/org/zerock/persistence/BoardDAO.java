package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

public interface BoardDAO {

	// 게시물 생성
	public void create(BoardVO vo);
	
	// 게시물 조회(bno에 해당하는 단일 게시물 조회)
	public BoardVO read(Integer bno);
	
	// 게시물 업데이트
	public void update(BoardVO vo);
	
	// 게시물 삭제
	public void delete(Integer bno);
	
	// 게시물( 모든 게시물 조회 )
	public List<BoardVO> listAll();

	// 게시물 ( 페이징 처리 게시물 조회)	
	public List<BoardVO> listCriteria(Criteria cri);

	// 총 게시물 수 계산
	public Integer boardTotalCount();
	
	// 게시물 ( 페이징 처리 + 검색결과 게시물 조회)	
	public List<BoardVO> listSearchCriteria(SearchCriteria cri);
	
	// 총 검색 결과 게시물 수 계산
	public Integer searchBoardTotalCount(SearchCriteria cri);
	
}// interface
