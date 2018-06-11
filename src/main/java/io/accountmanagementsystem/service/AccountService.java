package io.accountmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.accountmanagementsystem.exception.AccountNotFoundException;
import io.accountmanagementsystem.exception.InsuffecientFundsException;
import io.accountmanagementsystem.exception.InvalidAmountException;
import io.accountmanagementsystem.model.Account;
import io.accountmanagementsystem.repository.AccountRepository;


@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	
	public List<Account> getAllAccounts()
	{
		List<Account> accounts = new ArrayList<>();
		accountRepository.findAll()
		.forEach(accounts::add);
		return accounts;
	}
	
	public Optional<Account> getAccount(String id)
	{
		Optional<Account> account = accountRepository.findById(id);
		if(!account.isPresent())
			throw new AccountNotFoundException("accountNo - " + id);
		return account;
	}
	
	public void createAccount(Account account)
	{
		accountRepository.save(account);
	}
	
	public void withdraw(String id, double amount)
	{
		Optional<Account> account = accountRepository.findById(id);
		if(!account.isPresent())
			throw new AccountNotFoundException("accountNo - " + id);
		if(account.get().getBalance() < amount)
			throw new InsuffecientFundsException("accountNo - " + id + "Insuffecient Funds");
		account.get().setBalance(account.get().getBalance() - amount);
		accountRepository.save(account.get());
	}
	
	public void deposit(String id, double amount)
	{
		Optional<Account> account = accountRepository.findById(id);
		if(!account.isPresent())
			throw new AccountNotFoundException("accountNo - " + id);
		if(amount < 0)
			throw new InvalidAmountException("accountNo - " + id + "Invalid Amount");
		account.get().setBalance(account.get().getBalance() + amount);
		accountRepository.save(account.get());
	}
	
	public void deleteAccount(String id)
	{
		accountRepository.deleteById(id);
	}
}
