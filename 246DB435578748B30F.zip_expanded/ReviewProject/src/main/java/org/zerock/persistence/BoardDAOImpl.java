package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;
	
	private static final String namespace = "org.zerock.mapper.BoardMapper";
	
	@Override
	public void create(BoardVO vo) {
		session.insert(namespace+".create", vo);
		
	}

	@Override
	public BoardVO read(Integer bno) {
	
		return session.selectOne(namespace+".read", bno);
	}

	@Override
	public void update(BoardVO vo) {
		session.update(namespace+".update", vo);
		
	}

	@Override
	public void delete(Integer bno) {
		session.delete(namespace+".delete", bno);
	}

	@Override
	public List<BoardVO> listAll() {
		
		return session.selectList(namespace+".listAll");
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) {
		
		return session.selectList(namespace+".listCriteria", cri);
	}

	@Override
	public Integer boardTotalCount() {
		
		return session.selectOne(namespace+".boardTotalCount");
	}

	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".listSearchCriteria", cri);
	}

	@Override
	public Integer searchBoardTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".searchBoardTotalCount", cri);
	}


}// class
