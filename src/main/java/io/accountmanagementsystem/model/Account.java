package io.accountmanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/*Account Model*/

@Entity
public class Account {
	
	@Id
	private String acccountNo;
	
	private String customerName;
	private double balance;
	
	public Account()
	{
		
	}
	
	public Account(String accountNo,String customerName,double balance)
	{
		this.acccountNo = accountNo;
		this.customerName = customerName;
		this.balance = balance;
	}
	
	public String getAcccountNo() {
		return acccountNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}	
}
