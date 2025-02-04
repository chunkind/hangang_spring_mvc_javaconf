package com.dev.ck.cltsh.shp.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dev.ck.cltsh.cmm.util.OrdUtil;
import com.dev.ck.cltsh.shp.cate.CltCateDto;
import com.dev.ck.cltsh.shp.cate.service.CltCateService;
import com.dev.ck.cltsh.shp.goods.CltGoodsDto;
import com.dev.ck.cltsh.shp.goods.service.CltGoodsService;
import com.dev.ck.cltsh.shp.order.service.CltOrderService;
import com.dev.ck.cltsh.shp.payment.CltPaymentDto;
import com.dev.ck.cltsh.shp.payment.service.CltPaymentService;
import com.dev.ck.cltsh.shp.sales.CltSalesDto;
import com.dev.ck.cltsh.shp.sales.service.CltSalesService;
import com.dev.ck.cltsh.shp.user.CltUserDto;

@Controller
@SuppressWarnings("unchecked")
public class CltOrderController{
	@Autowired private CltOrderService orderService;
	@Autowired private CltGoodsService goodsService;
	@Autowired private CltSalesService salesService;
	@Autowired private CltCateService cateService;
	@Autowired private CltPaymentService paymentService;
	
	//주문
	@RequestMapping("/cltsh/order/order.do")
	public String order(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) throws Exception {
		String optionInfo[] = {pvo.getColorOption(),pvo.getSizeOption()};
		req.setAttribute("optionInfo", optionInfo);
		
		CltGoodsDto detail = goodsService.selectGoodsDetail(pvo.getSearchSaleBoardSeq());
		req.setAttribute("detail", detail);
		
		List<CltOrderDto> orderList = orderService.selectOrdList(pvo);
		req.setAttribute("orderList", orderList);
		
		CltPaymentDto payVo = paymentService.createPaymentParameters(detail, pvo);
		req.setAttribute("payVo", payVo);
		
		return "cltsh/shp/order/order";
	}
	
	//주문 생성 (결제 하기 전)
	@RequestMapping("/cltsh/order/payOrder.do")
	@ResponseBody
	public Map<String, Object> payOrder(HttpServletRequest req, @ModelAttribute CltOrderDto pvo) {
		Map<String, Object> response = new HashMap<>();
		try {
			HttpSession session = req.getSession();
			CltUserDto loginVo = (CltUserDto) session.getAttribute("loginInfo");
			pvo.setOrdNo(req.getParameter("oid"));
			pvo.setOrdClmNo(req.getParameter("oid"));
			
			// 서비스 호출
			orderService.createOrder(pvo, loginVo);
			response.put("result", "success");
			
		}catch (Exception e) {
			response.put("result", "fail");
			response.put("message", e.getMessage());
		}
		return response;
	}

	//주문 생성
	@RequestMapping("/cltsh/order/orderRegister.do")
	public String orderRegister(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		HttpSession session = req.getSession();
		CltUserDto loginVo = (CltUserDto) session.getAttribute("loginInfo");
		
		// 주문 생성 로직을 서비스로 위임
		orderService.createOrder(pvo, loginVo);
		
		CltOrderDto orderOne = orderService.selectOrdOne(pvo);
		CltOrderDto orderDtlOne = orderService.selectOrdDtlOne(pvo);
		
		req.setAttribute("orderOne", orderOne);
		req.setAttribute("orderDtlOne", orderDtlOne);
		
		return "cltsh/shp/order/order_confirm";
	}
	
	//주문 리스트
	@RequestMapping("/cltsh/order/orderList.do")
	public String orderList(HttpServletRequest req, HttpServletResponse res) {
		CltOrderDto pvo = new CltOrderDto();
		List<CltOrderDto> orderList = orderService.selectOrdList(pvo);
		req.setAttribute("orderList", orderList);
		
		return "cltsh/shp/order/order_list";
	}
	
	//카트 리스트
	@RequestMapping("/cltsh/order/orderCartList.do")
	public String orderCartList(HttpServletRequest req, HttpServletResponse res) {
		//공통 코드 가져오기
		CltCateDto cateVO = new CltCateDto();
		List<CltCateDto> oneDepthCateList = cateService.selectCateList(cateVO);
		req.setAttribute("oneDepthCateList", oneDepthCateList);
		
		return "cltsh/shp/order/order_cart";
	}
	
	//장바구니 구매
	@RequestMapping("/cltsh/order/orderCartRegister.do")
	public String orderCartRegister(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		String seq = pvo.getCheckedList();
		String key = seq.substring(0, seq.length() - 1);
		pvo.setKey(key);
		
		String[] ordBasketSeq = key.split(",");
		List<CltOrderDto> detail = new ArrayList<CltOrderDto>();
		
		for(int i = 0; i < ordBasketSeq.length; i++) {
			pvo.setOrdBasketSeq(Long.parseLong(ordBasketSeq[i]));
			detail.add(orderService.ordBasketSelect(pvo));
		}

//		List<OrderVO> detail = orderService.ordBasketSelect(pvo);
		Long totalPayment = (long) (detail.get(0).getDlvPrc());
		Long totalDlvPrc = (long) (detail.get(0).getDlvPrc());
		Long totalGoodsPrc = 0L;

		for (int i = 0; i < detail.size(); i++) {
			totalPayment += (long) (detail.get(i).getGoodsPrc() - detail.get(i).getGoodsSalePrc());
			totalGoodsPrc += (long) (detail.get(i).getGoodsPrc() - detail.get(i).getGoodsSalePrc());
		}

		req.setAttribute("detail", detail);
		req.setAttribute("totalPayment", totalPayment);
		req.setAttribute("totalDlvPrc", totalDlvPrc);
		req.setAttribute("totalGoodsPrc", totalGoodsPrc);
		req.setAttribute("key", key);

		return "cltsh/shp/order/order_basket";
	}
	
	//장바구니 구매 액션 (주문테이블에 넣기)order_cart_register_act
	@RequestMapping("/cltsh/order/orderCartRegisterAct.do")
	public String orderCartRegisterAct(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		HttpSession session = req.getSession();
		CltUserDto loginVo = (CltUserDto) session.getAttribute("loginInfo");
		
		String[] seqs = pvo.getCheckedList().split(",");
		
		orderService.createOrder(pvo, loginVo);
		
		if(seqs.length > 1) {
			CltOrderDto orderOne = orderService.selectOrdOne(pvo);
			List<CltOrderDto> orderDtlList = orderService.selectCartOrdDtlList(pvo);
			req.setAttribute("orderOne", orderOne);
			req.setAttribute("orderDtlList", orderDtlList);
		} else {
			CltOrderDto orderOne = orderService.selectOrdOne(pvo);
			CltOrderDto orderDtlOne = orderService.selectOrdDtlOne(pvo);
			req.setAttribute("orderOne", orderOne);
			req.setAttribute("orderDtlOne", orderDtlOne);
		}
		
		return "cltsh/shp/order/order_basket_confirm";
	}
	
	//장바구니 리스트
	@RequestMapping("/cltsh/order/orderCartListAjax.do")
	@ResponseBody
	public JSONObject orderCartListAjax(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		JSONObject data = new JSONObject();
		JSONArray jArry = new JSONArray();
		
		HttpSession session = req.getSession();
		CltUserDto loginVo = (CltUserDto) session.getAttribute("loginInfo");
		pvo.setUsrId(loginVo.getUsrId());
		List<CltOrderDto> basketList = orderService.selectBasketList(pvo);
		
		for(int i=0; i<basketList.size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("ordBasketSeq", basketList.get(i).getOrdBasketSeq());
			obj.put("usrId", basketList.get(i).getUsrId());
			obj.put("goodsQty", basketList.get(i).getGoodsQty());
			obj.put("saleBoardSeq", basketList.get(i).getSaleBoardSeq());
			obj.put("imgPath", basketList.get(i).getImgPath());
			obj.put("imgNm", basketList.get(i).getImgNm());
			obj.put("bulTitNm", basketList.get(i).getBulTitNm());
			obj.put("goodsCd", basketList.get(i).getGoodsCd());
			obj.put("entrNo", basketList.get(i).getEntrNo());
			obj.put("goodsPrc", basketList.get(i).getGoodsPrc());
			obj.put("goodsSalePrc", basketList.get(i).getGoodsSalePrc());
			obj.put("saleCnt", basketList.get(i).getSaleCnt());
			obj.put("saleStatCd", basketList.get(i).getSaleStatCd());
			obj.put("description", basketList.get(i).getDescription());
			jArry.add(obj);
		}
		
		data.put("result", "success");
		data.put("dataList", jArry);
		
		return data;
	}
	
	//장바구니 담기
	@RequestMapping("/cltsh/order/orderCartInsertAjax.do")
	@ResponseBody
	public JSONObject orderCartInsertAjax(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		JSONObject data = new JSONObject();
		
		HttpSession session = req.getSession();
		CltUserDto loginVo = (CltUserDto) session.getAttribute("loginInfo");
		
		CltSalesDto pSaleVO = new CltSalesDto();
		pSaleVO.setSaleBoardSeq(Long.parseLong(req.getParameter("searchSaleBoardSeq")));
		
		CltSalesDto saleVO = salesService.selectSalesOne(pSaleVO);
		
		pvo.setGoodsCd(Integer.parseInt(String.valueOf(saleVO.getGoodsCd())));
		pvo.setEntrNo(saleVO.getEntrNo());
		pvo.setSaleBoardSeq(pSaleVO.getSaleBoardSeq()); //saleBoardSeq
		pvo.setUsrId(loginVo.getUsrId());
		
		if(pvo.getGoodsQty() == 0) {
			pvo.setGoodsQty(1);
		}
		
		int result = orderService.insertBasket(pvo);
		
		data.put("result", "success");
		
		return data;
	}
	
	//장바구니 삭제
	@RequestMapping("/cltsh/order/orderCartDeleteAjax.do")
	@ResponseBody
	public JSONObject orderCartDeleteAjax(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		JSONObject data = new JSONObject();

		String seq = pvo.getCheckedList();
		String[] seqs = seq.split(",");
		int result = 0;
		
		for(int i = 0; i < seqs.length; i++) {
			pvo.setOrdBasketSeq(Long.parseLong(seqs[i]));
			result = orderService.deleteBasket(pvo);
		}
		
		data.put("result", "success");
		
		return data;
	}
	
	//주문 취소
	@RequestMapping("/cltsh/order/order_cancel.do")
	public String orderCancel(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		CltOrderDto ordDtlVo = orderService.selectOrdClmNoOne(pvo);
		
		req.setAttribute("ordDtlVo", ordDtlVo);
		
		return "cltsh/shp/order/order_cancel";
	}
	
	//주문 취소 액션
	@RequestMapping("/cltsh/order/order_cancelAct.do")
	public String orderCancelAct(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		orderService.insertCancelOrdHist(pvo);
		return "redirect:/cltsh/mypage/mypageOrder.do";
	}
	
	//주문 취소 현황
		@RequestMapping("/cltsh/order/order_cancel_ing.do")
		public String orderCancelIng(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
			CltOrderDto ordDtlVo = orderService.searchOrdClmNoList(pvo);
			CltOrderDto ordHistVo = orderService.selectOrdHistOne(ordDtlVo);

			req.setAttribute("ordDtlVo", ordDtlVo);
			req.setAttribute("ordHistVo", ordHistVo);
			
			return "cltsh/shp/order/order_cancel_ing";
		}

	//반품 및 교환
	@RequestMapping("/cltsh/order/order_return.do")
	public String orderReturn(HttpServletRequest req, HttpServletResponse res, CltOrderDto pvo) {
		CltOrderDto ordVo = orderService.selectOrdOne(pvo);
//		List<CltOrderDto> ordDtlVo = orderService.searchOrdClmNoList(pvo);
		
		req.setAttribute("ordVo", ordVo);
//		req.setAttribute("ordDtlVo", ordDtlVo);
		
		return "cltsh/shp/order/order_return";
	}
}
