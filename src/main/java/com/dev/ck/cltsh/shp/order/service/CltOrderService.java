package com.dev.ck.cltsh.shp.order.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.ackwd.utils.StringUtil;
import com.dev.ck.cltsh.cmm.util.OrdUtil;
import com.dev.ck.cltsh.shp.mypage.service.CltMypgMapper;
import com.dev.ck.cltsh.shp.order.CltOrderDto;
import com.dev.ck.cltsh.shp.user.CltUserDto;

@Service
public class CltOrderService {
	@Autowired public CltOrderMapper dao;
	
	public CltOrderDto parameterSetting(HttpServletRequest req) {
		// 주문 기본
		String ordNo = req.getParameter("ordNo");
		String ordClmNo = req.getParameter("ordClmNo");
		String clmSctCd = req.getParameter("clmSctCd");
		String clmStatCd = req.getParameter("clmStatCd");
		String usrId = req.getParameter("usrId");
		long entrNo = req.getParameter("entrNo") == null ? 0L : Long.parseLong(req.getParameter("entrNo"));
		String ordDtlStatCd = req.getParameter("ordDtlStatCd");
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
		int ordClmDtlSn = req.getParameter("ordClmDtlSn") == null ? 0 : Integer.parseInt(req.getParameter("ordClmDtlSn"));
		int sndGoodsQty = req.getParameter("sndGoodsQty") == null ? 0 : Integer.parseInt(req.getParameter("sndGoodsQty"));
		int rtnGoodsQty = req.getParameter("rtnGoodsQty") == null ? 0 : Integer.parseInt(req.getParameter("rtnGoodsQty"));
		String goodsNm = req.getParameter("goodsNm");
		int goodsCd = req.getParameter("goodsCd") == null ? 0 : Integer.parseInt(req.getParameter("goodsCd"));
		int goodsQty = req.getParameter("goodsQty") == null ? 0 : Integer.parseInt(req.getParameter("goodsQty"));
		String codeNm = req.getParameter("codeNm");

		//주문 이력
		String procDate = req.getParameter("procDate");
		String clmRasn = req.getParameter("clmRasn");
		String histMemo = req.getParameter("histMemo");
		
		// 장바구니
		Long ordBasketSeq = req.getParameter("ordBasketSeq") == null ? 0L : Long.parseLong(req.getParameter("ordBasketSeq"));
		String useYn = req.getParameter("useYn");
		Long saleBoardSeq = req.getParameter("saleBoardSeq") == null ? 0L : Long.parseLong(req.getParameter("saleBoardSeq"));
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
		pvo.setOrdClmNo(ordClmNo);
		pvo.setClmSctCd(clmSctCd);
		pvo.setClmStatCd(clmStatCd);
		pvo.setOrdDtlStatCd(ordDtlStatCd);
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
		pvo.setOrdClmDtlSn(ordClmDtlSn);
		pvo.setSndGoodsQty(sndGoodsQty);
		pvo.setRtnGoodsQty(rtnGoodsQty);
		pvo.setGoodsNm(goodsNm);
		pvo.setGoodsCd(goodsCd);
		pvo.setGoodsQty(goodsQty);
		pvo.setCodeNm(codeNm);
		pvo.setProcDate(procDate);
		pvo.setClmRasn(clmRasn);
		pvo.setHistMemo(histMemo);
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
	
	public void createOrder(CltOrderDto pvo, CltUserDto loginVo) {
		
		String seq = pvo.getCheckedList();
//		String pinNo = OrdUtil.getPinNo();
		
		// 비즈니스 로직 처리
		pvo.setOrdDtlStatCd("02"); // 주문 상태 - 결제 완료
//		pvo.setOrdNo(pinNo);
//		pvo.setOrdClmNo(pinNo);
		pvo.setOrdClmDtlSn(1);
		pvo.setRgstId(loginVo.getUsrId());
		pvo.setUpdtId(loginVo.getUsrId());
		pvo.setOrdrId(loginVo.getUsrId());
		pvo.setPrclWay("");  // 포장 방식 - 공란 처리
		pvo.setPackWay("");  // 배송 방식 - 공란 처리
		pvo.setBillNum((long) 0);  // 기본 값 설정
		
		// 주문 저장 로직
		insertOrd(pvo);
		
		if(StringUtil.isEmpty(seq)) {
			// 단건
			//주문 이력 처리
//			pvo.setClmRasn(""); //주문은 null
			pvo.setHistMemo("주문 완료");
			
			insertOrdDtl(pvo);
			insertOrdHist(pvo);
		}else {
			String goodsNm = pvo.getGoodsNm();
			String[] seqs = seq.split(",");
			String[] goodsNmArry = goodsNm.split(",");
			
			//다건
			for(int i = 0; i < seqs.length; i++) {
				pvo.setOrdBasketSeq(Long.parseLong(seqs[i]));
				CltOrderDto ordBasket = ordBasketSelect(pvo);
				pvo.setSaleBoardSeq(ordBasket.getSaleBoardSeq());
				pvo.setHistMemo("주문 완료");
				
				if(null != goodsNmArry && null != goodsNmArry[i] && !"".equals(goodsNmArry[i])) {
					pvo.setGoodsNm(goodsNmArry[i]);
					pvo.setGoodsCd(ordBasket.getGoodsCd());
					pvo.setOrdClmDtlSn(i + 1);
				}
				
				insertCartOrdDtl(pvo);	
				insertOrdHist(pvo);
			}

			for(int i = 0; i < seqs.length; i++) {
				pvo.setOrdBasketSeq(Long.parseLong(seqs[i]));
				updateBasket(pvo);
			}
		}
		
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

	//주문 이력 생성
	public int insertOrdHist(CltOrderDto pvo) {
		return dao.insertOrdHist(pvo);
	}
	
	//주문 이력 조회 
	public CltOrderDto selectOrdHistOne(CltOrderDto pvo) {
		return dao.selectOrdHistOne(pvo);
	}

	//취소 주문 이력 생성
	public int insertCancelOrdHist(CltOrderDto pvo) {
		//취소 주문 생성
		CltOrderDto orderVo = selectOrdOne(pvo); //취소 할 주문 정보
		
		// 비즈니스 로직 처리
		
		/*	01 주문
			02 취소(배송 나가면 X, 환불이 완료)
			03 가격변동
			04 반품(배송 나간게 회수, 환불이 완료)
			05 교환(배송 나간건 회수, 새로보내줘야될것은 배송완료, 환불은 없다) */
		orderVo.setClmSctCd("02");
		
		/*	01 대기
			02 완료
			03 취소 */
		orderVo.setClmStatCd("01");
		
		orderVo.setOrdDtlStatCd("01"); // 주문 상태 - 취소 신청
		orderVo.setOrdClmNo(OrdUtil.getPinNo());
		orderVo.setOrdClmDtlSn(1);
		orderVo.setGoodsCd(pvo.getGoodsCd());
		orderVo.setGoodsNm(pvo.getGoodsNm());
		orderVo.setGoodsQty(pvo.getGoodsQty());
		orderVo.setClmRasn(pvo.getClmRasn());
		orderVo.setHistMemo(pvo.getHistMemo());
		
		// 주문 저장 로직
		insertOrd(orderVo);
		insertOrdDtl(orderVo);

		return insertOrdHist(orderVo);
	}

	//취소 주문 승인
	public int ordCancelConfirm(CltOrderDto pvo) {
		//취소 주문 생성
		CltOrderDto orderVo = selectOrdOne(pvo); //취소 할 주문 정보
		
		// 비즈니스 로직 처리
		
		/*	01 주문
			02 취소(배송 나가면 X, 환불이 완료)
			03 가격변동
			04 반품(배송 나간게 회수, 환불이 완료)
			05 교환(배송 나간건 회수, 새로보내줘야될것은 배송완료, 환불은 없다) */
		orderVo.setClmSctCd("02");
		
		/*	01 대기
			02 완료
			03 취소 */
		orderVo.setClmStatCd("02");
		
		orderVo.setOrdDtlStatCd("01"); // 주문 상태 - 취소 신청
		orderVo.setOrdClmNo(OrdUtil.getPinNo());
		orderVo.setOrdClmDtlSn(1);
		orderVo.setGoodsCd(pvo.getGoodsCd());
		orderVo.setGoodsNm(pvo.getGoodsNm());
		orderVo.setGoodsQty(pvo.getGoodsQty());
		orderVo.setClmRasn(pvo.getClmRasn());
		orderVo.setHistMemo(pvo.getHistMemo());
		
		// 주문 저장 로직
		insertOrd(orderVo);
		insertOrdDtl(orderVo);
		
		return insertOrdHist(orderVo);
	}
	
	//취소 주문 업데이트
	public int ordCancelUpdate(CltOrderDto pvo) {
		/*
			SND_GOODS_QTY = #{sndGoodsQty}
			RTN_GOODS_QTY = #{rtnGoodsQty}
		*/

		// 비즈니스 로직 처리
		
		/*	01 주문
			02 취소(배송 나가면 X, 환불이 완료)
			03 가격변동
			04 반품(배송 나간게 회수, 환불이 완료)
			05 교환(배송 나간건 회수, 새로보내줘야될것은 배송완료, 환불은 없다) */
		pvo.setClmSctCd("02");
		
		/*	01 대기
			02 완료
			03 취소 */
		pvo.setClmStatCd("02");
		
		// 취소 완료  - 05
		pvo.setOrdDtlStatCd("05");
		
		dao.admOrdBaseUpdate(pvo);
		dao.admOrdDtlUpdate(pvo);
		
		return insertOrdHist(pvo);
	}
	
	//주문 상세
	public int insertOrdDtl(CltOrderDto pvo) {
		return dao.insertOrdDtl(pvo);
	}
	
	public CltOrderDto selectOrdDtlOne(CltOrderDto pvo) {
		return dao.selectOrdDtlOne(pvo);
	}

	public CltOrderDto selectOrdClmNoOne(CltOrderDto pvo) {
		return dao.selectOrdClmNoOne(pvo);
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
	
	public int admOrdDtlStatCdChange(CltOrderDto pvo) {
		return dao.admOrdDtlStatCdChange(pvo);  
	}
	
	public List<CltOrderDto> searchIdOrdList(CltOrderDto pvo){
		return dao.searchIdOrdList(pvo);
	}
	
	public List<CltOrderDto> searchOrdNoList(CltOrderDto pvo) {
		return dao.searchOrdNoList(pvo);
	}
	
	public CltOrderDto searchOrdClmNoList(CltOrderDto pvo) {
		return dao.searchOrdClmNoList(pvo);
	}
	
	public CltOrderDto searchOrdNoOne(CltOrderDto pvo) {
		return dao.searchOrdNoOne(pvo);
	}
	
	public List<CltOrderDto> mypgOrdDtl(CltOrderDto pvo) {
		return dao.mypgOrdDtl(pvo);
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