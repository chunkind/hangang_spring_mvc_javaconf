package com.dev.ck.cltsh.shp.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inicis.std.util.HttpUtil;
import com.inicis.std.util.ParseUtil;
import com.inicis.std.util.SignatureUtil;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.dev.ck.cltsh.cmm.util.OrdUtil;
import com.dev.ck.cltsh.shp.goods.CltGoodsDto;
import com.dev.ck.cltsh.shp.order.CltOrderDto;
import com.dev.ck.cltsh.shp.payment.CltPaymentDto;

@Service
public class CltPaymentService {
	@Autowired public CltPaymentMapper dao;
	
	public CltPaymentDto createPaymentParameters(CltGoodsDto goodsVo) throws Exception {
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
		payVo.setGoodsPrc(price);
		payVo.setOrdNo(pinNo);
		payVo.setUseChkfake(useChkfake);
		
		return payVo;
	}
	
	public Map<String, String> processPayment(HttpServletRequest req) throws Exception {
		Map<String, String> resultMap = new HashMap<String, String>();
		CltPaymentDto pvo = new CltPaymentDto();
		
		try{
			//#############################
			// 인증결과 파라미터 일괄 수신
			//#############################
			req.setCharacterEncoding("UTF-8");

			Map<String,String> paramMap = new Hashtable<String,String>();
			
			Enumeration elems = req.getParameterNames();
			
			String temp = "";

			while(elems.hasMoreElements())
			{
				temp = (String) elems.nextElement();
				paramMap.put(temp, req.getParameter(temp));
			}
			
			pvo.setPaymentStatus(paramMap.get("resultMsg"));
			//##############################
			// 인증성공 resultCode=0000 확인
			// IDC센터 확인 [idc_name=fc,ks,stg]	
			// idc_name 으로 수신 받은 값 기준 properties 에 설정된 승인URL과 authURL 이 같은지 비교
			// 승인URL은  https://manual.inicis.com 참조
			//##############################
			
			if("0000".equals(paramMap.get("resultCode")) && paramMap.get("authUrl").equals(ResourceBundle.getBundle("properties/idc_name").getString(paramMap.get("idc_name")))){			
				
				System.out.println("####인증성공/승인요청####");

				//############################################
				// 1.전문 필드 값 설정(***가맹점 개발수정***)
				//############################################
				
				String mid 		= paramMap.get("mid");
				String timestamp= SignatureUtil.getTimestamp();
				String charset 	= "UTF-8";
				String format 	= "JSON";
				String authToken= paramMap.get("authToken");
				String authUrl	= paramMap.get("authUrl");
				String netCancel= paramMap.get("netCancelUrl");	
				String merchantData = paramMap.get("merchantData");
				
				//#####################
				// 2.signature 생성
				//#####################
				Map<String, String> signParam = new HashMap<String, String>();

				signParam.put("authToken",	authToken);		// 필수
				signParam.put("timestamp",	timestamp);		// 필수

				// signature 데이터 생성 (모듈에서 자동으로 signParam을 알파벳 순으로 정렬후 NVP 방식으로 나열해 hash)
				String signature = SignatureUtil.makeSignature(signParam);
				
				signParam.put("signKey",	"SU5JTElURV9UUklQTEVERVNfS0VZU1RS");		// 필수
				
				// signature 데이터 생성 (모듈에서 자동으로 signParam을 알파벳 순으로 정렬후 NVP 방식으로 나열해 hash)
				String verification = SignatureUtil.makeSignature(signParam);
				
				

				//#####################
				// 3.API 요청 전문 생성
				//#####################
				Map<String, String> authMap = new Hashtable<String, String>();
				
				authMap.put("mid"			,mid);			// 필수
				authMap.put("authToken"		,authToken);	// 필수
				authMap.put("signature"		,signature);	// 필수
				authMap.put("verification"	,verification);	// 필수
				authMap.put("timestamp"		,timestamp);	// 필수
				authMap.put("charset"		,charset);		// default=UTF-8
				authMap.put("format"		,format);

				HttpUtil httpUtil = new HttpUtil();

				try{
					//#####################
					// 4.API 통신 시작
					//#####################

					String authResultString = "";
					
					authResultString = httpUtil.processHTTP(authMap, authUrl);
					
					//############################################################
					//6.API 통신결과 처리(***가맹점 개발수정***)
					//############################################################
					
					String test = authResultString.replace(",", "&").replace(":", "=").replace("\"", "").replace(" ","").replace("\n", "").replace("}", "").replace("{", "");
								
					resultMap = ParseUtil.parseStringToMap(test); //문자열을 MAP형식으로 파싱
					
					//파라미터 셋팅//
					pvo.setTid(resultMap.get("tid"));
					pvo.setMid(mid);
					pvo.setTimestamp(timestamp);
					pvo.setSignature(signature);
					pvo.setVerification(verification);
					pvo.setBuyerNm(resultMap.get("buyerName"));
					pvo.setBuyerTel(resultMap.get("buyerTel"));
					pvo.setBuyerEmail(resultMap.get("buyerEmail"));
					pvo.setOrdNo(resultMap.get("MOID"));
					pvo.setGoodsPrc(resultMap.get("TotPrice"));
					pvo.setCurrency(resultMap.get("currency"));
					pvo.setGoodsNm(resultMap.get("goodsName"));
					pvo.setPaymethod(resultMap.get("payMethod"));
					pvo.setVactBankName(resultMap.get("vactBankName"));
					pvo.setPayDevice(resultMap.get("payDevice"));
					
					CltPaymentDto payVo = ordNoSearch(resultMap.get("MOID"));
					pvo.setOrdClmNo(payVo.getOrdClmNo());
					pvo.setOrdClmDtlSn(payVo.getOrdClmDtlSn());
					pvo.setPayStateCd(payVo.getPayStateCd());
					
					insertPayment(pvo);
					insertPayDtlInfo(pvo);
					
					// 수신결과를 파싱후 resultCode가 "0000"이면 승인성공 이외 실패
					//throw new Exception("강제 망취소 요청 Exception ");
					
					return resultMap;
					
				} catch (Exception ex) {

					//####################################
					// 실패시 처리(***가맹점 개발수정***)
					//####################################

					//---- db 저장 실패시 등 예외처리----//
					System.out.println(ex);

					//#####################
					// 망취소 API
					//#####################
					String netcancelResultString = httpUtil.processHTTP(authMap, netCancel);	// 망취소 요청 API url(고정, 임의 세팅 금지)

					System.out.println("## 망취소 API 결과 ##");

					// 망취소 결과 확인
					System.out.println("<p>"+netcancelResultString.replaceAll("<", "&lt;").replaceAll(">", "&gt;")+"</p>");
				}

			}else{
				
				resultMap.put("resultCode", paramMap.get("resultCode"));
				resultMap.put("resultMsg", paramMap.get("resultMsg"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return resultMap;
	}
	
	public int insertPayment(CltPaymentDto data) {
		return dao.insertPayment(data);
	}
	public CltPaymentDto selectPaymentOne(CltPaymentDto pvo) {
		return dao.selectPaymentOne(pvo);
	}
	public List<CltPaymentDto> selectPaymentList(CltPaymentDto pvo){
		return dao.selectPaymentList(pvo);
	}
	public CltPaymentDto ordNoSearch(String ordNo) {
		return dao.ordNoSearch(ordNo);
	}
	public int insertPayDtlInfo(CltPaymentDto data) {
		return dao.insertPayDtlInfo(data);
	}
	public CltPaymentDto selectPayDtlInfoOne(CltPaymentDto pvo) {
		return dao.selectPayDtlInfoOne(pvo);
	}
	public List<CltPaymentDto> selectPayDtlInfoList(CltPaymentDto pvo){
		return dao.selectPayDtlInfoList(pvo);
	}
}