package io.accountmanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.accountmanagementsystem.model.Account;
import io.accountmanagementsystem.service.AccountService;

/*Account Controller*/

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	/*Get All the Accounts*/
	@RequestMapping("/accounts")
	public List<Account> getAllAccounts()
	{
		return accountService.getAllAccounts();
	}
	
	/*Get An Individual Account by AccountNo*/
	@RequestMapping("/accounts/{accountNo}")
	public Optional<Account> getAccount(@PathVariable String accountNo)
	{
		return accountService.getAccount(accountNo);
	}
	
	/*Get Balance Amount for a particular Account No*/
	@RequestMapping("/accounts/{accountNo}/balance")
	public double displayBalance(@PathVariable String accountNo)
	{
		Optional<Account> account = accountService.getAccount(accountNo);
		return account.get().getBalance();
	}
	
	/*Create a new Account*/
	@RequestMapping(method=RequestMethod.POST, value="/accounts/create")
	public void createAccount(@RequestBody Account account)
	{
		accountService.createAccount(account);
	}
	
	/*Withdraw money from a specific account*/
	@RequestMapping(method=RequestMethod.PUT, value="/accounts/{accountNo}/withdraw/{amount}")
	public void withdraw(@PathVariable String accountNo, @PathVariable double amount)
	{
		accountService.withdraw(accountNo,amount);
	}
	
	/*Deposit money to a specific account*/
	@RequestMapping(method=RequestMethod.PUT, value="/accounts/{accountNo}/deposit/{amount}")
	public void deposit(@PathVariable String accountNo, @PathVariable double amount)
	{
		accountService.deposit(accountNo,amount);
	}
	
	/*Delete an account*/
	@RequestMapping(method=RequestMethod.DELETE, value="/accounts/{accountNo}")
	public void deleteAccount(@PathVariable String accountNo)
	{
		accountService.deleteAccount(accountNo);
	}
	
}
