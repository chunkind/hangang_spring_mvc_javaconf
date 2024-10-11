package com.dev.ck.cltsh.adm.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.ck.cltsh.cmm.util.PagingUtil;
import com.dev.ck.cltsh.shp.code.CltCodeDto;
import com.dev.ck.cltsh.shp.code.service.CltCodeService;
import com.dev.ck.cltsh.shp.order.CltOrderDto;
import com.dev.ck.cltsh.shp.order.service.CltOrderService;
import com.dev.ck.cltsh.shp.user.CltUserDto;

@Controller
public class CltAdmOrderController{
	@Autowired private CltOrderService orderService;
	@Autowired private CltCodeService codeService;

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
		
		req.setAttribute("paging", pvo.getHtml());
		req.setAttribute("orderList", orderList);
		
		return "cltsh/adm/order/order_list";
	}
	//주문 관리 상세
	@RequestMapping("/cltsh/adm/order/admOrderDetail.do")
	public String admOrderDetail(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		CltOrderDto ordVo = orderService.searchOrdNoOne(pvo);
		
		String ordDtlStatCd = ordVo.getOrdDtlStatCd();

		if (ordDtlStatCd != null) {
			if (ordDtlStatCd.equals("01")) {
				ordVo.setOrdStatNm("결제대기");
			} else if (ordDtlStatCd.equals("02")) {
				ordVo.setOrdStatNm("결제완료");
			} else if (ordDtlStatCd.equals("03")) {
				ordVo.setOrdStatNm("상품준비중");
			} else if (ordDtlStatCd.equals("04")) {
				ordVo.setOrdStatNm("배송중");
			} else if (ordDtlStatCd.equals("05")) {
				ordVo.setOrdStatNm("배송완료");
			} else if (ordDtlStatCd.equals("06")) {
				ordVo.setOrdStatNm("수취완료");
			} else if (ordDtlStatCd.equals("07")) {
				ordVo.setOrdStatNm("반품신청");
			} else if (ordDtlStatCd.equals("08")) {
				ordVo.setOrdStatNm("반품완료");
			} else if (ordDtlStatCd.equals("09")) {
				ordVo.setOrdStatNm("취소신청");
			} else if (ordDtlStatCd.equals("10")) {
				ordVo.setOrdStatNm("취소완료");
			}
		}
		
		List<CltCodeDto> ordDtlStatCdList = codeService.selectOrdDtlStatCdList();
		req.setAttribute("ordVo", ordVo);
		req.setAttribute("ordDtlStatCdList", ordDtlStatCdList);
		
		return "cltsh/adm/order/order_detail";
	}
	
	//주문 관리 - 주문 취소 확인
	@RequestMapping("/cltsh/adm/order/admOrderCancelConfirm.do")
	public String admOrderCancelConfirm(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		CltOrderDto ordVo = orderService.searchOrdNoOne(pvo);
		CltOrderDto ordHistVo = orderService.selectOrdHistOne(pvo);
	
		req.setAttribute("ordVo", ordVo);
		req.setAttribute("ordHistVo", ordHistVo);
		return "cltsh/adm/order/order_cancel_confirm";
	}
	
	//주문 관리 - 주문 취소 확인 액션
	@RequestMapping("/cltsh/adm/order/admOrderCancelConfirmAct.do")
	public String admOrderCancelConfirmAct(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		//로그인 정보 가져오기
		HttpSession session = req.getSession();
		CltUserDto loginVo = (CltUserDto) session.getAttribute("loginInfo");
		pvo.setRgstId(loginVo.getUsrId());
		
		orderService.ordCancelUpdate(pvo);
		
		return "redirect:/cltsh/adm/order/admOrderList.do";
	}
	
	//주문 상태 변경
	@RequestMapping("/cltsh/adm/order/admOrdDtlStatCdChange.do")
	public String admOrdDtlStatCdChange(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		orderService.admOrdDtlStatCdeChange(pvo);
		return "redirect:/cltsh/adm/order/admOrderList.do";
	}
}
