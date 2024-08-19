package com.kic.shopping.goods.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.kic.shopping.goods.vo.GoodsVO;

public interface GoodsDAO {
	public List<GoodsVO> selectAllGoodsList() throws DataAccessException;
}
