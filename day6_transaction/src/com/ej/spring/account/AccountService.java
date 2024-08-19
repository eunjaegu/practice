package com.ej.spring.account;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**action-mybatis.xml (tx:~~~) **/
@Transactional(propagation=Propagation.REQUIRED)
public class AccountService {
	private AccountDAO accDAO;

	public void setAccDAO(AccountDAO accDAO) {
		this.accDAO = accDAO;
	}
	
	public void sendMoney() throws Exception{
		accDAO.updateBalanve1();	//출금 : 문제(오류)발생 시 롤백됨.
		accDAO.updateBalanve2();	//입금 : 문제(오류)발생 시 롤백됨. 2번 발생 시 1번도 발생됨.
		
	}

}
