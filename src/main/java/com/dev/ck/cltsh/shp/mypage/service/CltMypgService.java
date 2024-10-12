package com.dev.ck.cltsh.shp.mypage.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.cltsh.shp.mypage.CltMypgDto;
import com.dev.ck.cltsh.shp.order.CltOrderDto;

@Service
public class CltMypgService {
	@Autowired private CltMypgMapper dao;

	public CltMypgDto parameterSetting(HttpServletRequest req) {
		String ordNo = req.getParameter("ordNo");
		String rgstDate = req.getParameter("rgstDate");
		String ordrId = req.getParameter("ordrId");
		String ordrNm = req.getParameter("ordrNm");
		String ordrPhon = req.getParameter("ordrPhon");
		long payMny = Long.parseLong(req.getParameter("payMny"));
		String imgPath = req.getParameter("imgPath");
		String imgNm = req.getParameter("imgNm");
		String bulTitNm = req.getParameter("bulTitNm");
		int goodsQty = Integer.parseInt(req.getParameter("goodsQty"));
		long goodsPrc = Long.parseLong(req.getParameter("goodsPrc"));
		String ordDtlStatCd = req.getParameter("ordDtlStatCd");
		String codeNm = req.getParameter("codeNm");
		String payWay = req.getParameter("payWay");
		long dlvPrc = Long.parseLong(req.getParameter("dlvPrc"));
		String acqrNm = req.getParameter("acqrNm");
		String acqrPhon = req.getParameter("acqrPhon");
		String acqrAddr = req.getParameter("acqrAddr");
		String acqrAddrDtl = req.getParameter("acqrAddrDtl");
		String reqMemo = req.getParameter("reqMemo");
		long saleBoardRpySeq = req.getParameter("saleBoardRpySeq") == null ? 0 : Long.parseLong(req.getParameter("saleBoardRpySeq"));

		String usrId = req.getParameter("usrId");

		CltMypgDto pvo = new CltMypgDto();
		pvo.setOrdNo(ordNo);
		pvo.setRgstDate(rgstDate);
		pvo.setOrdrId(ordrId);
		pvo.setOrdrNm(ordrNm);
		pvo.setOrdrPhon(ordrPhon);
		pvo.setPayMny(payMny);
		pvo.setImgPath(imgPath);
		pvo.setImgNm(imgNm);
		pvo.setBulTitNm(bulTitNm);
		pvo.setGoodsQty(goodsQty);
		pvo.setGoodsPrc(goodsPrc);
		pvo.setOrdDtlStatCd(ordDtlStatCd);
		pvo.setCodeNm(codeNm);
		pvo.setPayWay(payWay);
		pvo.setDlvPrc(dlvPrc);
		pvo.setAcqrNm(acqrNm);
		pvo.setAcqrPhon(acqrPhon);
		pvo.setAcqrAddr(acqrAddr);
		pvo.setAcqrAddrDtl(acqrAddrDtl);
		pvo.setReqMemo(reqMemo);
		pvo.setSaleBoardRpySeq(saleBoardRpySeq);
		pvo.setUsrId(usrId);
		return pvo;
	}
	
	public int ordCnt(){
		return dao.ordCnt();
	};
	
	public List<CltMypgDto> selectMypgList(CltMypgDto pvo){
		return dao.selectMypgList(pvo);
	};
	
	public List<CltMypgDto> getOrderList(CltMypgDto pvo) {
		List<CltMypgDto> orders = selectMypgList(pvo);

		// 주문 취소 여부 확인을 위한 Map (ordNo 기준)
		Map<String, CltMypgDto> orderMap = new HashMap<>();

		for (CltMypgDto order : orders) {
			String ordNo = order.getOrdNo(); // 주문 번호
			String clmSctCd = order.getClmSctCd(); // 클레임 구분 코드 (01: 주문, 02: 취소)
			String clmStatCd = order.getClmStatCd(); // 클레임 상태 코드

			// 취소 주문인지 확인
			boolean isCanceled = "02".equals(clmSctCd.trim())
					&& ("01".equals(clmStatCd.trim()) || "02".equals(clmStatCd.trim()));

			// 기존에 같은 주문 번호의 주문이 없다면 추가
			if (!orderMap.containsKey(ordNo)) {
				orderMap.put(ordNo, order); // 처음 들어온 주문 추가
			} else {
				// 같은 주문 번호가 이미 있고, 취소된 주문인 경우 덮어쓰기
				if (isCanceled) {
					orderMap.put(ordNo, order); // 취소된 주문으로 덮어쓰기
				}
				// 기존 주문이 일반 주문이면 아무것도 하지 않음
			}
		}

		// Map에서 주문 리스트로 변환
		return new ArrayList<>(orderMap.values());
	}
}
