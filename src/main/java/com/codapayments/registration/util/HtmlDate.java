package com.codapayments.registration.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HtmlDate {
	private String date;
	private String month;
	private String year;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Date getParsedate(){
		Date date = null;
		try {
			date = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH).parse(this.date + '-' + this.month + '-' + this.year);
		} catch (ParseException e) {
			if(e != null){
				return null;
			}
		}
		return date;
	}
	
}
