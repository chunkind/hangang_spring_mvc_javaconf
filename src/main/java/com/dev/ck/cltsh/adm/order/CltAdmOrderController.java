package com.dev.ck.cltsh.adm.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.ck.cltsh.cmm.util.PagingUtil;
import com.dev.ck.cltsh.shp.order.CltOrderDto;
import com.dev.ck.cltsh.shp.order.service.CltOrderService;

@Controller
public class CltAdmOrderController{
	@Autowired
	private CltOrderService orderService;

	//주문 관리
	@RequestMapping("/cltsh/adm/order/admOrderList.do")
	public String admOrderList(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		String requestURI = (String) req.getAttribute("requestURI"); //페이징
		String page = req.getParameter("page");
		int totalCnt = orderService.ordCnt();
		pvo.setPath(requestURI);
		pvo.setParamPage(page);
		pvo.setTotalCnt(totalCnt);
		PagingUtil.getPagingKeys(pvo);
		
		List<CltOrderDto> orderList = orderService.selectOrdList(pvo);
		
		req.setAttribute("orderList", orderList);
		
		return "cltsh/adm/order/order_list";
	}
	//주문 관리 상세
	@RequestMapping("/cltsh/adm/order/admOrderDetail.do")
	public String admOrderDetail(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		CltOrderDto ordVo = orderService.searchOrdNoList(pvo);
		req.setAttribute("ordVo", ordVo);
		
		return "cltsh/adm/order/order_detail";
	}
	
	//주문 상태 변경
	@RequestMapping("/cltsh/adm/order/admOrdStateChange.do")
	public String admOrdStateChange(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
//		CltOrderDto ordVo = orderService.searchOrdNoList(pvo);
//		req.setAttribute("ordVo", ordVo);
		
		return "cltsh/adm/order/order_detail";
	}
}
