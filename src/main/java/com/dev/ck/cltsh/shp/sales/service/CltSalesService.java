package com.dev.ck.cltsh.shp.sales.service;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.cltsh.cmm.util.DateUtils;
import com.dev.ck.cltsh.cmm.util.StringUtils;
import com.dev.ck.cltsh.shp.sales.CltSalesDto;

@Service
public class CltSalesService {
	@Autowired private CltSalesMapper dao;
	
	public CltSalesDto parameterSetting(HttpServletRequest req){
		long saleBoardSeq = StringUtils.nullToLong(req.getParameter("saleBoardSeq"));
		int goodsCd = StringUtils.nullToInt(req.getParameter("goodsCd"));
		int entrNo = StringUtils.nullToInt(req.getParameter("entrNo"));
		String ntcSctCd = StringUtils.nullToStr(req.getParameter("ntcSctCd"));
		String bulYn = StringUtils.nullToStr(req.getParameter("bulYn"));
		Date bulStrtDt = DateUtils.stringToSqlDate(req.getParameter("bulStrtDt"));
		Date bulEndDt = DateUtils.stringToSqlDate(req.getParameter("bulEndDt"));
		String bulTitNm = StringUtils.nullToStr(req.getParameter("bulTitNm"));
		String bulCont = StringUtils.nullToStr(req.getParameter("bulCont"));
		int qryCnt = StringUtils.nullToInt(req.getParameter("qryCnt"));
		int lkeCnt = StringUtils.nullToInt(req.getParameter("lkeCnt"));
		int goodsPrc = StringUtils.nullToInt(req.getParameter("goodsPrc"));
		int goodsSalePrc = StringUtils.nullToInt(req.getParameter("goodsSalePrc"));
		String prclWay = StringUtils.nullToStr(req.getParameter("prclWay"));
		int saleCnt = StringUtils.nullToInt(req.getParameter("saleCnt"));
		String rgstId = StringUtils.nullToStr(req.getParameter("rgstId"));
		Date rgstDate = DateUtils.stringToSqlDate(req.getParameter("rgstDate"));
		String updtId = StringUtils.nullToStr(req.getParameter("updtId"));
		Date updtDate = DateUtils.stringToSqlDate(req.getParameter("updtDate"));
		String saleStatCd = StringUtils.nullToStr(req.getParameter("saleStatCd"));
		String useYn = StringUtils.nullToStr(req.getParameter("useYn"));
		String description = StringUtils.nullToStr(req.getParameter("description"));

		String searchEntrNo = StringUtils.nullToStr(req.getParameter("searchEntrNo"));

		CltSalesDto pvo = new CltSalesDto();
		pvo.setSaleBoardSeq(saleBoardSeq);
		pvo.setGoodsCd(goodsCd);
		pvo.setEntrNo(entrNo);
		pvo.setNtcSctCd(ntcSctCd);
		pvo.setBulYn(bulYn);
		pvo.setBulStrtDt(bulStrtDt);
		pvo.setBulEndDt(bulEndDt);
		pvo.setBulTitNm(bulTitNm);
		pvo.setBulCont(bulCont);
		pvo.setQryCnt(qryCnt);
		pvo.setLkeCnt(lkeCnt);
		pvo.setGoodsPrc(goodsPrc);
		pvo.setGoodsSalePrc(goodsSalePrc);
		pvo.setPrclWay(prclWay);
		pvo.setSaleCnt(saleCnt);
		pvo.setRgstId(rgstId);
		pvo.setRgstDate(rgstDate);
		pvo.setUpdtId(updtId);
		pvo.setUpdtDate(updtDate);
		pvo.setSaleStatCd(saleStatCd);
		pvo.setUseYn(useYn);
		pvo.setDescription(description);
		pvo.setSearchEntrNo(searchEntrNo);

		return pvo;
	}
	
	public int insertSales(CltSalesDto pvo) {
		return dao.insertSales(pvo);
	}
	
	public int deleteSales(CltSalesDto pvo) {
		return dao.deleteSales(pvo);
	}
	
	public int deleteSalesAll() {
		return dao.deleteSalesAll();
	}
	
	public int updateSales(CltSalesDto pvo) {
		return dao.updateSales(pvo);
	}
	
	public List<CltSalesDto> entrSalesList(CltSalesDto pvo){
		return dao.entrSalesList(pvo);
	}
	public List<CltSalesDto> selectSalesList(CltSalesDto pvo){
		return dao.selectSalesList(pvo);
	}
	
	public CltSalesDto selectSalesOne(CltSalesDto pvo) {
		return dao.selectSalesOne(pvo);
	}
	
	public int dropSeq() {
		return dao.dropSeq();
	}
	
	public int createSeq() {
		return dao.createSeq();
	}
}
