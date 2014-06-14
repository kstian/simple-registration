package com.codapayments.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codapayments.registration.dao.AccountDAO;
import com.codapayments.registration.entity.Account;

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	
	public Account findByMobileNumber(String mobileNumber) {
		return this.accountDAO.findByMobileNumber(mobileNumber);
	}
	
	@Transactional(readOnly = false)
	public Account save(Account account) {
		return this.accountDAO.save(account);
	}

}
