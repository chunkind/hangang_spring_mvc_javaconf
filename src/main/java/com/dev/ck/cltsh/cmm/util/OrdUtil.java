package com.dev.ck.cltsh.cmm.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class OrdUtil {
	
	/**
	 * 주문번호 20자리.
	 */
	public static String getPinNo() {
		return OrdUtil.createRandomNo(20);
	}
	
	/**
	 * 랜덤 자리수 숫자 구하기.
	 */
	public static String createRandomNo(int length) throws RuntimeException {
		if(length >= 15){
			length = length - 15;
		}else{
			throw new RuntimeException("20이상 입력해 주세요.");
		}
		StringBuffer cpnNoBuf = new StringBuffer();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		int nmVal = length; //생성되어야 하는 난수의 자릿수
		cpnNoBuf.delete(0, cpnNoBuf.length());
		cpnNoBuf.append(sf.format(new Date()));
		cpnNoBuf.append(nextLong(nmVal)); //난수 추가 - 0~99999999까지의 난수
		return cpnNoBuf.toString();
	}
	/**
	 * int size : 난수크기
	 */
	public static String nextLong(int size) {
		SecureRandom random = new SecureRandom();
		StringBuffer sb = new StringBuffer();
		String format = "999999999";
		if(size > 9){
			sb.append(StringUtils.leftPad(String.valueOf(random.nextInt(Integer.valueOf(format))), 9, '0'))
				.append(StringUtils.leftPad(String.valueOf(random.nextInt(Integer.valueOf(format.substring(0, size % 9)))), size % 9, '0'));
		}else if(size < 1){
			sb.append(StringUtils.leftPad(String.valueOf(random.nextInt(Integer.valueOf(format.substring(0,8)))), 8, '0'));
		}else{
			sb.append(StringUtils.leftPad(String.valueOf(random.nextInt(Integer.valueOf(format.substring(0,size)))), size, '0'));
		}
		return sb.toString();
	}
	public static void fileLog_req_info(HttpServletRequest request) {
		String ua = request.getHeader("User-Agent").toUpperCase();
		String channel = inputCHannel(ua);
		filelog();
	}
	
	private static String inputCHannel(String ua) {
		String channel = "Web";
		if(ua.toUpperCase().indexOf("IPHONE")!=-1 || ua.toUpperCase().indexOf("IPAD")!=-1) {
			if(ua.toUpperCase().indexOf("APPIOS")!=-1) {
				channel = "APP";
			}else if(ua.toUpperCase().indexOf("APPIOS")==-1) {
				channel = "MobileWeb";
			}
		}else if(ua.toUpperCase().indexOf("ANDROID")!=-1) {
			channel = "MobileWeb";
		}else if(ua.indexOf("BlackBerry")!=-1
				|| ua.indexOf("symbian")!=-1
				|| ua.indexOf("sony")!=-1
				|| ua.indexOf("Mobile")!=-1) {
			channel = "MobileWeb";
		}else if(ua.toUpperCase().indexOf("EDGE")!=-1) {
			channel = "Web";
		}else if(ua.toUpperCase().indexOf("WHALE")!=-1) {
			channel = "Web";
		}else if(ua.toUpperCase().indexOf("CHROME")!=-1) {
			channel = "Web";
		}else if(ua.toUpperCase().indexOf("FIREFOX")!=-1) {
			channel = "Web";
		}else {
			channel = "Web";
		}
		return channel;
	}
	
	public static void filelog() {
		String path = ".log";
		
		File file = new File(path);
		
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write("[log]");
			fw.append("\r\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}