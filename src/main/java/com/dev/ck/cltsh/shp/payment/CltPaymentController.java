package com.dev.ck.cltsh.shp.payment;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.ck.cltsh.shp.order.CltOrderDto;
import com.dev.ck.cltsh.shp.payment.service.CltPaymentService;

@Controller
@SuppressWarnings("unchecked")
public class CltPaymentController {
	@Autowired private CltPaymentService paymentService;

	@RequestMapping("/cltsh/order/payPcReq.do")
	public String payPcReq(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		req.setAttribute("pvo", pvo);
		return "inss/INIstdpay_pc_req.view";
	}
	@RequestMapping("/cltsh/order/payPcReturn.do")
	public String payPcReturn(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo, CltPaymentDto payVo) {
		// 결제 결과 확인
		String paymentStatus = req.getParameter("paymentStatus");
		String orderId = req.getParameter("orderId");

		/*if ("SUCCESS".equals(paymentStatus)) {
			// 주문 정보를 생성 및 저장
			// orderService.saveOrder(pvo); // 결제 성공 후 주문 저장
			return "inss/INIstdpay_pc_return.view"; // 결제 성공 페이지
		} else {
			// 결제 실패 처리
			return "inss/payment_failed.view"; // 결제 실패 페이지
		}*/
		return "inss/INIstdpay_pc_return.view";
	}
	@RequestMapping("/cltsh/order/payPcClose.do")
	public String payPcClose(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		return "inss/close.view";
	}
	
	@RequestMapping("/cltsh/payment/processPayment")
	public String processPayment(@RequestParam Map<String, String> requestParams, Model model) {
		// 파라미터에 UTF-8 인코딩 설정
		try {
			requestParams.put("charset", "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 서비스 호출하여 비즈니스 로직 수행
		Map<String, String> resultMap = paymentService.processPayment(requestParams);

		// 결과 모델에 추가
		model.addAttribute("resultMap", resultMap);

		// 결과 페이지로 이동
		return "paymentResult";
	}
}
