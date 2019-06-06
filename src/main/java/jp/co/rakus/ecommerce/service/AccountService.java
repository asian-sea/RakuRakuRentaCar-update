package jp.co.rakus.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce.domain.Account;
import jp.co.rakus.ecommerce.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired 
	AccountRepository accountRepository;
	
	public Account save(Account account) {
		return accountRepository.save(account);
	}
	

}
