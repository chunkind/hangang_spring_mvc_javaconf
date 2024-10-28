package com.dev.ck.cltsh.shp.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inicis.std.util.HttpUtil;
import com.inicis.std.util.ParseUtil;
import com.inicis.std.util.SignatureUtil;
import java.util.*;

import com.dev.ck.cltsh.cmm.util.OrdUtil;
import com.dev.ck.cltsh.shp.goods.CltGoodsDto;
import com.dev.ck.cltsh.shp.order.CltOrderDto;
import com.dev.ck.cltsh.shp.payment.CltPaymentDto;

@Service
public class CltPaymentService {
	// @Autowired public CltPaymentMapper dao;

	public CltPaymentDto createPaymentParameters(CltGoodsDto goodsVo, CltOrderDto orderVo) throws Exception {
		CltPaymentDto payVo = new CltPaymentDto();
		
		String mid = "INIpayTest";
		String signKey = "SU5JTElURV9UUklQTEVERVNfS0VZU1RS";
		String mKey = SignatureUtil.hash(signKey, "SHA-256");
		String pinNo = OrdUtil.getPinNo();
		String price = Integer.toString(goodsVo.getGoodsPrc() - goodsVo.getGoodsSalePrc() + goodsVo.getDlvPrc());
		String timestamp = SignatureUtil.getTimestamp();
		String useChkfake = "Y";
		
		// signParam 설정
		Map<String, String> signParam = new HashMap<>();
		signParam.put("oid", pinNo);
		signParam.put("price", price);
		signParam.put("timestamp", timestamp);
		
		// signature 및 verification 생성
		String signature = SignatureUtil.makeSignature(signParam);
		signParam.put("signKey", signKey); // verification 생성 전 signKey 추가
		String verification = SignatureUtil.makeSignature(signParam);
		
		// payVo에 필요한 값 설정
		payVo.setSignature(signature);
		payVo.setVerification(verification);
		payVo.setMid(mid);
		payVo.setMKey(mKey);
		payVo.setTimestamp(timestamp);
		payVo.setPrice(price);
		payVo.setOid(pinNo);
		payVo.setUseChkfake(useChkfake);
		
		return payVo;
	}
	
	public Map<String, String> processPayment(Map<String, String> paramMap) {
		Map<String, String> resultMap = new HashMap<>();

		try {
			// 인증 성공 여부 체크
			if ("0000".equals(paramMap.get("resultCode")) && paramMap.get("authUrl")
					.equals(ResourceBundle.getBundle("properties/idc_name").getString(paramMap.get("idc_name")))) {

				String mid = paramMap.get("mid");
				String timestamp = SignatureUtil.getTimestamp();
				String charset = "UTF-8";
				String format = "JSON";
				String authToken = paramMap.get("authToken");
				String authUrl = paramMap.get("authUrl");
				String netCancelUrl = paramMap.get("netCancelUrl");

				// 서명 생성
				Map<String, String> signParam = new HashMap<>();
				signParam.put("authToken", authToken);
				signParam.put("timestamp", timestamp);

				String signature = SignatureUtil.makeSignature(signParam);

				// 인증 데이터 생성
				Map<String, String> authMap = new HashMap<>();
				authMap.put("mid", mid);
				authMap.put("authToken", authToken);
				authMap.put("signature", signature);
				authMap.put("timestamp", timestamp);
				authMap.put("charset", charset);
				authMap.put("format", format);

				// 승인 요청
				HttpUtil httpUtil = new HttpUtil();
				String authResultString = httpUtil.processHTTP(authMap, authUrl);
				resultMap = ParseUtil.parseStringToMap(authResultString);
			} else {
				resultMap.put("resultCode", paramMap.get("resultCode"));
				resultMap.put("resultMsg", paramMap.get("resultMsg"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultMap;
	}
}