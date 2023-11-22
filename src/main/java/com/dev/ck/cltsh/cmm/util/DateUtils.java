package com.dev.ck.cltsh.cmm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {
	public static final String FORMAT8 = "yyyyMMdd";
	public static final String FORMAT10 = "yyyy-MM-dd";
	public static final String FORMAT16 = "yyyyMMddHHmmss";

	public static java.util.Date stringToUtilDate(String strDate){
		SimpleDateFormat format = new SimpleDateFormat(DateUtils.FORMAT10);
		java.util.Date date = null;
		try {
			if(null == strDate || "null".equals(strDate) || "".equals(strDate)) {
				date = null;
			}else {
				date = format.parse(strDate);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static java.sql.Date stringToSqlDate(String strDate){
		return DateUtils.transSqlDate(DateUtils.stringToUtilDate(strDate));
	}
	
	public static java.sql.Date transSqlDate(java.util.Date date){
		if(null == date || "null".equals(date) || "".equals(date)) {
			return null;
		}else {
			return new java.sql.Date(date.getTime());
		}
	}
	
	public static void main(String[] args) {
		String strDate = "2022-05-07";
		
		java.util.Date date = stringToUtilDate(strDate);
		System.out.println(date);
	}
}
