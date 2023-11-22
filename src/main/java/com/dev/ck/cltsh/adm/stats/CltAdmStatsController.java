package com.dev.ck.cltsh.adm.stats;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.ck.cltsh.shp.order.CltOrderDto;
import com.dev.ck.cltsh.shp.order.service.CltOrderService;

@Controller
public class CltAdmStatsController{
	@Autowired private CltOrderService orderService;
	
	// 매출 통계
	@RequestMapping("/cltsh/adm/stats/admStatsSales.do")
	public String admStatsSales(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		List<CltOrderDto> orderBaseList = orderService.selectOrdBaseList(pvo);
		long payMnyResult = 0L;
		int detailOrderCount = orderBaseList.size();
		
		for (int i = 0; i < detailOrderCount; i++) {
			payMnyResult += orderBaseList.get(i).getPayMny();
		}
		
		req.setAttribute("detailOrderCount", detailOrderCount);
		req.setAttribute("payMnyResult", payMnyResult);
		
		return "cltsh/adm/stats/stats_sales";
	}
}
