package com.codapayments.registration.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.codapayments.registration.entity.Account;

@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO{

	@PersistenceContext
    private EntityManager entityManager;
	
	public Account findByMobileNumber(String mobileNumber) {
		String hql = "FROM Account a WHERE a.mobileNumber=:mobileNumber";
        TypedQuery<Account> query = this.entityManager.createQuery(hql, Account.class).setParameter("mobileNumber",
                mobileNumber);
        List<Account> accounts = query.getResultList();

        return accounts.size() == 1 ? accounts.get(0) : null;
	}

	public Account save(Account account) {
		if (account.getId() != null) {
            return this.entityManager.merge(account);
        } else {
            this.entityManager.persist(account);
            this.entityManager.flush();
            return account;
        }
	}

}
