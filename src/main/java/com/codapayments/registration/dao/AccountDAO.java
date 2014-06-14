package com.codapayments.registration.dao;

import com.codapayments.registration.entity.Account;



public interface AccountDAO {
	
	Account findByMobileNumber(String mobileNumber);
    Account save(Account account);
	
}
