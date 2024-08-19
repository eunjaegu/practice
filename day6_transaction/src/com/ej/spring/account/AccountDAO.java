package com.ej.spring.account;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

public class AccountDAO {
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public void updateBalanve1() throws DataAccessException{
		sqlSession.update("mapper.account.updateBalance1");	// 송금하면 update 메서드
	}
	
	public void updateBalanve2() throws DataAccessException{
		sqlSession.update("mapper.account.updateBalance2");	// 
	}								
	
}
