package com.kic.shopping.goods.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.kic.shopping.goods.dao.GoodsDAO;
import com.kic.shopping.goods.vo.GoodsVO;

public class GoodsServiceImpl implements GoodsService {
	private GoodsDAO goodsDAO;

	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

	public GoodsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<GoodsVO> listGoods() throws DataAccessException {
		List<GoodsVO> goodsList = goodsDAO.selectAllGoodsList();
		return goodsList;
	}



	

	

}
