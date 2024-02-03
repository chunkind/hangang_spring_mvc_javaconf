package com.dev.ck.cltsh.shp.order.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.cltsh.shp.order.CltOrderDto;
import com.dev.ck.cltsh.shp.sales.service.CltSalesService;

@Service
public class CltOrderService {
	@Autowired public CltOrderMapper dao;
	
	public CltOrderDto parameterSetting(HttpServletRequest req) {
		// 주문 기본
		String ordNo = req.getParameter("ordNo");
		String usrId = req.getParameter("usrId");
		long entrNo = req.getParameter("entrNo") == null ? 0L : Long.parseLong(req.getParameter("entrNo"));
		String ordStat = req.getParameter("ordStat");
		String ordrId = req.getParameter("ordrId");
		String ordrNm = req.getParameter("ordrNm");
		String ordrPhon = req.getParameter("ordrPhon");
		String ordrEmail = req.getParameter("ordrEmail");
		String acqrPhon = req.getParameter("acqrPhon");
		String acqrNm = req.getParameter("acqrNm");
		String acqrAddr = req.getParameter("acqrAddr");
		String acqrAddrDtl = req.getParameter("acqrAddrDtl");
		String acqrEmail = req.getParameter("acqrEmail");
		String prclWay = req.getParameter("prclWay");
		String packWay = req.getParameter("packWay");
		String payWay = req.getParameter("payWay");
		long payMny = req.getParameter("payMny") == null ? 0L : Long.parseLong(req.getParameter("payMny"));
		String reqMemo = req.getParameter("reqMemo");
		String ordDate = req.getParameter("ordDate");
		String updtDate = req.getParameter("updtDate");
		String updtId = req.getParameter("updtId");
		String rgstDate = req.getParameter("rgstDate");
		String rgstId = req.getParameter("rgstId");
		long billNum = req.getParameter("billNum") == null ? 0L : Long.parseLong(req.getParameter("billNum"));

		// 주문 상세
		long ordDtlNo = req.getParameter("ordDtlNo") == null ? 0L : Long.parseLong(req.getParameter("ordDtlNo"));
		String goodsNm = req.getParameter("goodsNm");
		int goodsCd = req.getParameter("goodsCd") == null ? 0 : Integer.parseInt(req.getParameter("goodsCd"));
		int goodsQty = req.getParameter("goodsQty") == null ? 0 : Integer.parseInt(req.getParameter("goodsQty"));

		// 장바구니
		Long ordBasketSeq = req.getParameter("ordBasketSeq") == null ? 0L
				: Long.parseLong(req.getParameter("ordBasketSeq"));
		String useYn = req.getParameter("useYn");
		Long saleBoardSeq = req.getParameter("saleBoardSeq") == null ? 0L
				: Long.parseLong(req.getParameter("saleBoardSeq"));
		String searchSaleBoardSeq = req.getParameter("searchSaleBoardSeq");
		String checkedList = req.getParameter("checkedList");

		// 상세페이지 상품 옵션
		String colorOption = req.getParameter("colorOption");
		String sizeOption = req.getParameter("sizeOption");

		String[] goodsNmArry = req.getParameterValues("goodsNm");
		String[] strGoodsCdArry = req.getParameterValues("goodsCd");
		String[] strGoodsQtyArry = req.getParameterValues("goodsQty");
		String[] saleBoardSeqs = req.getParameterValues("saleBoardSeqs");

		int goodsCdArryCnt = 1;
		int goodsQtyArryCnt = 1;

		if (strGoodsCdArry != null) {
			goodsCdArryCnt = strGoodsCdArry.length;
			goodsQtyArryCnt = strGoodsQtyArry.length;
		}

		Long[] goodsCdArry = new Long[goodsCdArryCnt];
		int[] goodsQtyArry = new int[goodsQtyArryCnt];

		if (strGoodsCdArry != null) {
			for (int i = 0; i < strGoodsCdArry.length; i++) {
				goodsCdArry[i] = Long.parseLong(strGoodsCdArry[i]);
				goodsQtyArry[i] = Integer.parseInt(strGoodsQtyArry[i]);
			}
		}

		CltOrderDto pvo = new CltOrderDto();

		pvo.setOrdNo(ordNo);
		pvo.setUsrId(usrId);
		pvo.setEntrNo(entrNo);
		pvo.setOrdStat(ordStat);
		pvo.setOrdrId(ordrId);
		pvo.setOrdrNm(ordrNm);
		pvo.setOrdrPhon(ordrPhon);
		pvo.setOrdrEmail(ordrEmail);
		pvo.setAcqrPhon(acqrPhon);
		pvo.setAcqrNm(acqrNm);
		pvo.setAcqrAddr(acqrAddr);
		pvo.setAcqrAddrDtl(acqrAddrDtl);
		pvo.setAcqrEmail(acqrEmail);
		pvo.setPrclWay(prclWay);
		pvo.setPackWay(packWay);
		pvo.setPayWay(payWay);
		pvo.setPayMny(payMny);
		pvo.setReqMemo(reqMemo);
		pvo.setOrdDate(ordDate);
		pvo.setUpdtDate(updtDate);
		pvo.setUpdtId(updtId);
		pvo.setRgstDate(rgstDate);
		pvo.setRgstId(rgstId);
		pvo.setBillNum(billNum);
		pvo.setOrdDtlNo(ordDtlNo);
		pvo.setGoodsNm(goodsNm);
		pvo.setGoodsCd(goodsCd);
		pvo.setGoodsQty(goodsQty);
		pvo.setOrdBasketSeq(ordBasketSeq);
		pvo.setUseYn(useYn);
		pvo.setSaleBoardSeq(saleBoardSeq);
		pvo.setSearchSaleBoardSeq(searchSaleBoardSeq);
		pvo.setCheckedList(checkedList);
		pvo.setColorOption(colorOption);
		pvo.setSizeOption(sizeOption);
		pvo.setGoodsNmArry(goodsNmArry);
		pvo.setGoodsCdArry(goodsCdArry);
		pvo.setGoodsQtyArry(goodsQtyArry);
		pvo.setSaleBoardSeqs(saleBoardSeqs);

		return pvo;
	}
	
		public int ordCnt() {
			return dao.ordCnt();
		}
	//주문 기본
		public int insertOrd(CltOrderDto pvo) {
			return dao.insertOrd(pvo);
		}
		
		public CltOrderDto selectOrdOne(CltOrderDto pvo) {
			return dao.selectOrdOne(pvo);
		}
		
		public List<CltOrderDto> selectOrdList(CltOrderDto pvo){
			return dao.selectOrdList(pvo);
		}
		
		public int updateOrd(CltOrderDto pvo) {
			return dao.updateOrd(pvo);
		}
		
		public int deleteOrd(CltOrderDto pvo) {
			return dao.deleteOrd(pvo);
		}
		
		//주문 상세
		public int insertOrdDtl(CltOrderDto pvo) {
			return dao.insertOrdDtl(pvo);
		}
		
		public CltOrderDto selectOrdDtlOne(CltOrderDto pvo) {
			return dao.selectOrdDtlOne(pvo);
		}

		public CltOrderDto selectOrdDtlNoOne(CltOrderDto pvo) {
			return dao.selectOrdDtlNoOne(pvo);
		}
		
		public List<CltOrderDto> selectOrdDtlList(CltOrderDto pvo){
			return dao.selectOrdDtlList(pvo);
		}
		
		public int updateOrdDtl(CltOrderDto pvo) {
			return dao.updateOrdDtl(pvo);
		}
		
		public int deleteOrdDtl(CltOrderDto pvo) {
			return dao.deleteOrdDtl(pvo);
		}
		
		public int admOrdStateChange(CltOrderDto pvo) {
			return dao.admOrdStateChange(pvo);  
		}
		
		public List<CltOrderDto> searchIdOrdList(CltOrderDto pvo){
			return dao.searchIdOrdList(pvo);
		}
		
		public List<CltOrderDto> searchOrdNoList(CltOrderDto pvo) {
			return dao.searchOrdNoList(pvo);
		}
		
		public CltOrderDto searchOrdNoOne(CltOrderDto pvo) {
			return dao.searchOrdNoOne(pvo);
		}
		
		public List<CltOrderDto> searchOrdDtlGoods(CltOrderDto pvo){
			return dao.searchOrdDtlGoods(pvo);
		}
		
		//매출관리 통계
		public List<CltOrderDto> selectOrdBaseList(CltOrderDto pvo){
			return dao.selectOrdBaseList(pvo);
		}
		
		//장바구니
		public int insertBasket(CltOrderDto pvo) {
			return dao.insertBasket(pvo);
		}
		
		public int deleteBasket(CltOrderDto pvo) {
			return dao.deleteBasket(pvo);
		}
		
		public int updateBasket(CltOrderDto pvo) {
			return dao.updateBasket(pvo);
		}
		
		public List<CltOrderDto> selectBasketList(CltOrderDto pvo){
			return dao.selectBasketList(pvo);
		}
		
		public CltOrderDto ordBasketSelect(CltOrderDto pvo){
			return dao.ordBasketSelect(pvo);
		}
		
		public List<CltOrderDto> selectCartOrdDtlList(CltOrderDto pvo){
			return dao.selectCartOrdDtlList(pvo);
		}

	
	public int insertCartOrdDtl(CltOrderDto pvo) {
		int result = 1;
//		String seq = pvo.getCheckedList();
//		String[] GoodsNmArry = pvo.getGoodsNmArry();
//		String[] seqs = seq.split(",");
//		
//		if(seqs != null && GoodsNmArry != null) {
//			pvo.setSaleBoardSeq(Long.parseLong(pvo.getSaleBoardSeqs()[pvo.getIndex()]));
//			pvo.setGoodsNm(GoodsNmArry[pvo.getIndex()]);
//			pvo.setGoodsCd(Integer.parseInt((seqs[pvo.getIndex()])));
//			pvo.setGoodsQty(1);
//			dao.insertOrdDtl(pvo);
//		}else {
//			result = 0;
//		}
		pvo.setGoodsQty(1);
		dao.insertOrdDtl(pvo);
		return result;
	}
}