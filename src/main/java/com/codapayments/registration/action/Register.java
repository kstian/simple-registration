/*
 * $Id: HelloWorld.java 739661 2009-02-01 00:06:00Z davenewton $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.codapayments.registration.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codapayments.registration.entity.Account;
import com.codapayments.registration.service.AccountService;
import com.codapayments.registration.util.HtmlDate;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class Register extends ActionSupport {
	private static final Logger log = Logger.getLogger(Register.class);
	private HtmlDate date; 
	private String message;
	private Map<String, String> response = new HashMap<String, String>();
	private Account account;
	
	@Autowired
	private AccountService accountService;
    public String execute() throws Exception {
        setMessage("Register");
        return SUCCESS;
    }
    public String register() throws Exception {
    	if(this.accountService.findByMobileNumber(account.getMobileNumber()) == null){
	    	this.account.setDob(date.getParsedate());
	        accountService.save(this.account);
	        log.info("Account saved with id = " + account.getId());
	        response.put("status", "success");
    	}else{
    		response.put("status", "error");
    		response.put("message", "Mobile phone already registered");
    	}
        
        return SUCCESS;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
  	public Map<String, String> getResponse() {
		return response;
	}
	public void setResponse(Map<String, String> response) {
		this.response = response;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
		
	public AccountService getAccountService() {
		return accountService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public HtmlDate getDate() {
		return date;
	}
	public void setDate(HtmlDate date) {
		this.date = date;
	}
	
}
