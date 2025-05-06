package com.dev.ck.cltsh.shp.order.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

import com.dev.ck.TestApp;
import com.dev.ck.cltsh.shp.order.CltOrderController;
import com.dev.ck.cltsh.shp.order.CltOrderDto;

public class CltOrderServiceTest extends TestApp{
	
	@Autowired CltOrderController controller;
	
	private MockHttpServletRequest req;
	private MockHttpServletResponse res;
	private MockHttpSession session;
	
	@Before
	public void setting() {
		req = new MockHttpServletRequest();
		res = new MockHttpServletResponse();
		session = new MockHttpSession();
	}
	
	@Test
	public void 주문() {
		/*CltOrderDto pvo = CltOrderDto.builder()
		.ordrNm("이메리")
		.ordrPhon("01012341234")
		.ordrEmail("dudtlr102@naver.com")
		.acqrEmail("dudtlr102@naver.com")
		.acqrNm("이메리")
		.acqrPhon("01012341234")
		.acqrAddr("경인로 122")
		.acqrAddrDtl("1동")
		.reqMemo("fewfawef")
		.goodsNm("코트9")
		.goodsCd(209)
		.goodsQty(1)
		.payMny(101500L)
		.payWay("card")
		.build();
		
		controller.orderRegister(req, res, pvo);*/
	}

}
