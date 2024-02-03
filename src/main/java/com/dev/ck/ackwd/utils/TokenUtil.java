package com.dev.ck.ackwd.utils;

import com.dev.ck.ackwd.utils.aes.AES256;

public class TokenUtil {
	public static String getTokken(){
		String strToken = DateUtil.toDay();
		int randomCnt = (int)(Math.random() * 1000000);
		String strCount = StringUtil.lPad(String.valueOf(randomCnt), 6, '0');
		String result = AES256.encode(strToken+"_"+strCount);
		return result;
	}
}