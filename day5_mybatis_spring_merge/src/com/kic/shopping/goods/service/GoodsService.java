package com.kic.shopping.goods.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.kic.shopping.goods.vo.GoodsVO;

public interface GoodsService {
	List<GoodsVO> listGoods() throws DataAccessException;
}
