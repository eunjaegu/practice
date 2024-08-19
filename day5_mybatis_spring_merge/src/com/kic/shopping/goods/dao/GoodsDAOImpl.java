package com.kic.shopping.goods.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import com.kic.shopping.goods.vo.GoodsVO;

public class GoodsDAOImpl implements GoodsDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public GoodsDAOImpl() {
		
	}

	@Override
	public List<GoodsVO> selectAllGoodsList() throws DataAccessException {
		List<GoodsVO> goodsList = sqlSession.selectList("mapper.goods.selectAllGoodsList");
		return goodsList;
	}

}
