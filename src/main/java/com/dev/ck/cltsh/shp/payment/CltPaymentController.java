package com.dev.ck.cltsh.shp.payment;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.ck.cltsh.shp.order.CltOrderDto;
import com.dev.ck.cltsh.shp.order.service.CltOrderService;
import com.dev.ck.cltsh.shp.payment.service.CltPaymentService;
import com.dev.ck.cltsh.shp.user.CltUserDto;

@Controller
@SuppressWarnings("unchecked")
public class CltPaymentController {
	@Autowired private CltPaymentService paymentService;
	@Autowired private CltOrderService orderService;

	@RequestMapping("/cltsh/order/payPcReq.do")
	public String payPcReq(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		// 폼 데이터 세션에 저장
		HttpSession session = req.getSession();
		session.setAttribute("formData", req.getParameterMap());
		
		req.setAttribute("pvo", pvo);
		return "inss/INIstdpay_pc_req.view";
	}
	
	@RequestMapping("/cltsh/order/payPcReturn.do")
	public String payPcReturn(HttpServletRequest req, HttpServletResponse res) throws Exception {
		/*HttpSession session = req.getSession();
		CltUserDto loginVo = (CltUserDto) session.getAttribute("loginInfo");
		CltOrderDto orderVo = orderService.parameterSetting(req);
		// 주문 생성 로직을 서비스로 위임
		orderService.createOrder(orderVo, loginVo); // 결제 성공 후 주문 저장
*/		
		if ("0000".equals(req.getParameter("resultCode"))) {
			// 주문 정보를 생성 및 저장
			Map<String, String> resultMap = paymentService.processPayment(req);
			
			req.setAttribute("resultMap", resultMap);
			return "inss/INIstdpay_pc_return.view"; // 결제 성공 페이지
		} else {
			// 결제 실패 처리
			return "inss/payment_failed.view"; // 결제 실패 페이지
		}
//		return "inss/INIstdpay_pc_return.view";
	}
	
	@RequestMapping("/cltsh/order/payPcClose.do")
	public String payPcClose(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		return "inss/close.view";
	}
}