package com.ej.spring.account;

public class AccountVO {
	private String accountNo;
	private String custName;
	private int balance;
		
	public AccountVO() {
	}

	public void setAccountNo(String accountNo, String custName, int balance) {
		this.accountNo = accountNo;
		this.custName = custName;
		this.balance = balance;
	}
	
}
