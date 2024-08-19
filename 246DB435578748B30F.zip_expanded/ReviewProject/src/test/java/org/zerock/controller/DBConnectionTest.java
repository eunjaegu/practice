package org.zerock.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBConnectionTest extends AbstractTest {

	@Inject
	private SqlSessionTemplate session;

	private static final Logger logger = 
			LoggerFactory.getLogger(DBConnectionTest.class);

	
	@Test
	public void test() {
		logger.info(""+session.getConnection());
		
		logger.info(""+session.selectOne("org.zerock.mapper.MemberMapper.getNow"));
		
		
	}// test()

}// class
