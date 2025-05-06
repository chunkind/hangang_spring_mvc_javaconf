package com.dev.ck.cltsh.shp.payment;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;

import java.util.Map;

import com.dev.ck.cltsh.shp.payment.service.CltPaymentService;
import com.dev.ck.cltsh.shp.payment.CltPaymentDto;
import com.inicis.std.util.HttpUtil;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CltPaymentServiceTest {

	@Mock
	private HttpUtil httpUtil;

	@InjectMocks
	private CltPaymentService service;

	private CltPaymentDto param;

	@Before
	public void setUp() {
		param = new CltPaymentDto();
		param.setPResultCode("0000");
		param.setPAuthUrl("https://approval.url");
		param.setPIdc_name("fc");
		param.setPMid("INIpayTestMid");
		param.setPAuthToken("auth_token_test");
		param.setPNetCancelUrl("https://netcancel.url");
		param.setPMerchantData("testData");
		param.setBuyerTel("01012341234");
		param.setBuyerNm("이메리");
		param.setBuyerEmail("dudtlr102@naver.com");
		param.setTid("StdpayVBNKINIpayTest20250505231019414456");
		param.setVactBankName("케이지이니시스");
		param.setGoodsNm("맨투맨10");
		param.setGoodsPrc("3500");
		
		
//		  "payMethod": "VBank",
//		  "VACT_BankCode": "03",
//		  "MOID": "2025050523100994224",
//		  "vactBankName": "기업은행",
//		  "currency": "WON",
//		  "applTime": "231021",
//		  "goodsName": "맨투맨10",
//		  "FlgNotiSendChk": "",
//		  "buyerName": "이메리",
//		  "p_SubCnt": "",
//		  "resultMsg": "정상처리되었습니다.",
//		  "custEmail": "dudtlr102@naver.com",
//		  "VACT_Num": "07502270397836",
//		  "payDevice": "PC"
		
	}

	@Test
	public void 주문_성공() throws Exception {
		// given
		String fakeApiResponse = "{ \"resultCode\":\"0000\", \"tid\":\"123456\", \"TotPrice\":\"10000\" }";

		// when
		when(httpUtil.processHTTP((Map) any(), (String) eq("https://approval.url"))).thenReturn(fakeApiResponse);

		Map<String, String> result = service.processPayment(param);

		// then
//		assertEquals("123456", result.get("tid"));
//		assertEquals("10000", result.get("TotPrice"));
	}
}