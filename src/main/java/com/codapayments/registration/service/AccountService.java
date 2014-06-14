package com.codapayments.registration.service;

import com.codapayments.registration.entity.Account;

public interface AccountService {
	Account findByMobileNumber(String mobileNumber);
    Account save(Account account);
}
