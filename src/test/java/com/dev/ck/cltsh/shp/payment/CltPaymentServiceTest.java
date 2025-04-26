package com.dev.ck.cltsh.shp.payment;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

import com.dev.ck.TestApp;
import com.dev.ck.cltsh.shp.order.CltOrderController;
import com.dev.ck.cltsh.shp.order.CltOrderDto;

public class CltPaymentServiceTest extends TestApp{
	
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
		
	}

}
