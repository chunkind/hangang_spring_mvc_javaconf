package com.dev.ck.cm.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("sendUtil")
public class SendUtil {
	private final int CONNECTION_TIMEOUT = 10 * 1000;
	private final int SOCKET_TIMEOUT = 5 * 60 * 1000;

	/**
	 * @Date: 2022. 09. 19.
	 * @Auth: chunkind.
	 * URL 파라미터 맵을 스트링으로 변환.
	 */
	public String transParamMapToStr(Map<String, Object> param) {
		String returnStr = "";
		try {
			Iterator<String> iterKeys = param.keySet().iterator();
			StringBuilder postData = new StringBuilder();
			while(iterKeys.hasNext()){
				String key = iterKeys.next();
				if(null != param.get(key) && !"".equals(param.get(key))){
					String value = param.get(key).toString().trim();
					postData.append("&");
					postData.append(URLEncoder.encode(key, "UTF-8"));
					postData.append('=');
					postData.append(URLEncoder.encode(value, "UTF-8"));
				}else{
					postData.append("&"+key+"=");
				}
			}
			returnStr = postData.toString();
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return returnStr;
	}

	public String sendHttpsPost(String strUrl, Map<String, Object> params){
		String result = "";
		String strParams = transParamMapToStr(params);
		return result;
	}


	public static void main(String[] args) {
		SendUtil send = new SendUtil();

	}
}