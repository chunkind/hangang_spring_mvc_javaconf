package com.dev.ck.cltsh.shp.dress.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.cltsh.shp.dress.CltDressDto;

@Service
public class CltDressService {
	@Autowired private CltDressMapper dao;
	
	public CltDressDto parameterSetting(HttpServletRequest req) {
		int saleBoardRpySeq = req.getParameter("saleBoardRpySeq") == null? 0 : Integer.parseInt(req.getParameter("saleBoardRpySeq"));
		int saleBoardSeq = req.getParameter("saleBoardSeq") == null? 0 : Integer.parseInt(req.getParameter("saleBoardSeq"));
		int goodsCd = req.getParameter("goodsCd") == null? 0 : Integer.parseInt(req.getParameter("goodsCd"));
		int entrNo = req.getParameter("entrNo") == null? 0 : Integer.parseInt(req.getParameter("entrNo"));
		String bulTitNm = req.getParameter("bulTitNm");
		String bulCont = req.getParameter("bulCont");
		int rpyLvl = req.getParameter("rpyLvl") == null? 0 : Integer.parseInt(req.getParameter("rpyLvl"));
		int parSaleBoardRpySn = req.getParameter("parSaleBoardRpySn") == null? 0 : Integer.parseInt(req.getParameter("parSaleBoardRpySn"));
		int qryCnt = req.getParameter("qryCnt") == null? 0 : Integer.parseInt(req.getParameter("qryCnt"));
		int lkeCnt = req.getParameter("lkeCnt") == null? 0 : Integer.parseInt(req.getParameter("lkeCnt"));
		String rgstId = req.getParameter("rgstId");
		String rgstDate = req.getParameter("rgstDate");
		String updtId = req.getParameter("updtId");
		String updtDate = req.getParameter("updtDate");
		String useYn = req.getParameter("useYn");
		String rvwTag = req.getParameter("rvwTag");

		String noticeDoc = req.getParameter("noticeDoc");

		String selectedSaleRvwItem = req.getParameter("selectedSaleRvwItem");

		CltDressDto pvo = new CltDressDto();
		
		pvo.setSaleBoardRpySeq(saleBoardRpySeq);
		pvo.setSaleBoardSeq(saleBoardSeq);
		pvo.setGoodsCd(goodsCd);
		pvo.setEntrNo(entrNo);
		pvo.setBulTitNm(bulTitNm);
		pvo.setBulCont(bulCont);
		pvo.setRpyLvl(rpyLvl);
		pvo.setParSaleBoardRpySn(parSaleBoardRpySn);
		pvo.setQryCnt(qryCnt);
		pvo.setLkeCnt(lkeCnt);
		pvo.setRgstId(rgstId);
		pvo.setRgstDate(rgstDate);
		pvo.setUpdtId(updtId);
		pvo.setUpdtDate(updtDate);
		pvo.setUseYn(useYn);
		pvo.setNoticeDoc(noticeDoc);
		pvo.setSelectedSaleRvwItem(selectedSaleRvwItem);
		pvo.setRvwTag(rvwTag);
		
		//첨부파일 있으면 셋팅
		String imgPath = (String) req.getAttribute("imgPath");
		if(null == imgPath || "".equals(imgPath)) {
			imgPath = req.getParameter("imgPath");
		}
		String imgNm = (String) req.getAttribute("imgNm");
		if(null == imgNm || "".equals(imgNm)) {
			imgNm = req.getParameter("imgNm");
		}
		
		if(null != imgPath && !"".equals(imgPath)) {
			pvo.setImgPath(imgPath);
		}
		if(null != imgNm && !"".equals(imgNm)) {
			pvo.setImgNm(imgNm);
		}

		return pvo;
	}

	public int insertDress(CltDressDto pvo) {
		return dao.insertDress(pvo);
	};
	
	public CltDressDto selectDressOne(CltDressDto pvo) {
		return dao.selectDressOne(pvo);
	};
	
	public List<CltDressDto> selectDressList(CltDressDto pvo){
		return dao.selectDressList(pvo);
	};
	
	public int updateDress(CltDressDto pvo) {
		return dao.updateDress(pvo);
	};
	
	public int deleteDress(CltDressDto pvo) {
		return dao.deleteDress(pvo);
	};
	
	public List<CltDressDto> goodsDtlDressList(CltDressDto pvo){
		return dao.goodsDtlDressList(pvo);
	};
	
	public List<CltDressDto> selectWriteSaleRvw(CltDressDto pvo){
		return dao.selectWriteSaleRvw(pvo);
	};
}
