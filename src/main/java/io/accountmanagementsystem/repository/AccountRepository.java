package io.accountmanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;

import io.accountmanagementsystem.model.Account;

public interface AccountRepository extends CrudRepository<Account, String>{
	
}
