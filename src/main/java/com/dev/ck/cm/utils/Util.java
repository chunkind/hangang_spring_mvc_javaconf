package com.dev.ck.cm.utils;


import javax.servlet.http.HttpServletRequest;

import com.dev.ck.Config;

public class Util {
	public static String getUrl(HttpServletRequest req){
		return req.getRequestURL()+"?"+req.getQueryString();
	}

	public static String getClientIP(HttpServletRequest request) {
		String ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null || ip.length() == 0) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0) {
			ip = request.getHeader("WL-Proxy-Client-IP");  // 웹로직
		}
		if (ip == null || ip.length() == 0) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0) {
			ip = request.getRemoteAddr() ;
		}
		return ip;
	}
	
	public static boolean isValidAuth(String tbNm, String usrLv) {
		boolean isValid = true;
		//유저레벨 체크
		if(Config.NOTI_TABLE.equals(tbNm)) {
			if(!Config.ADMIN_USR_LV.equals(usrLv)) {
				isValid = false;
			}
		}
		//뉴스게시판
		else if(Config.NEWS_TABLE.equals(tbNm)){
			if(!Config.ADMIN_USR_LV.equals(usrLv)){
				isValid = false;
			}
		}
		return isValid;
	}
	
}