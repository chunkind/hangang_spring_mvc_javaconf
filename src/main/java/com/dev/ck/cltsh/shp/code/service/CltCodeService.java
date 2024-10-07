package com.dev.ck.cltsh.shp.code.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.cltsh.shp.code.CltCodeDto;

@Service
public class CltCodeService {
	@Autowired private CltCodeMapper dao;
	
	//파라미터 셋팅
	public CltCodeDto parameterSetting(HttpServletRequest req) {
		long stdCdBaseSeq = req.getParameter("stdCdBaseSeq") == null? 0L : Long.parseLong(req.getParameter("stdCdBaseSeq"));
		String codeNm = req.getParameter("codeNm");
		String codeVal = req.getParameter("codeVal");
		String codeDesc = req.getParameter("codeDesc");
		String grpCd = req.getParameter("grpCd");
		int grpOrdr = req.getParameter("grpOrdr") == null? 0 : Integer.parseInt(req.getParameter("grpOrdr"));
		String useYn = req.getParameter("useYn");
		String rgstId = req.getParameter("rgstId");
		String rgstDate = req.getParameter("rgstDate");
		String updtId = req.getParameter("updtId");
		String updtDate = req.getParameter("updtDate");
		
		CltCodeDto pvo = new CltCodeDto();
		
		pvo.setStdCdBaseSeq(stdCdBaseSeq);
		pvo.setCodeNm(codeNm);
		pvo.setCodeVal(codeVal);
		pvo.setCodeDesc(codeDesc);
		pvo.setGrpCd(grpCd);
		pvo.setGrpOrdr(grpOrdr);
		pvo.setUseYn(useYn);
		pvo.setRgstId(rgstId);
		pvo.setRgstDate(rgstDate);
		pvo.setUpdtId(updtId);
		pvo.setUpdtDate(updtDate);
		
		return pvo;
	}
	
	public int codeCnt() {
		return dao.codeCnt();
	};
	public int insertCode(CltCodeDto pvo) {
		return dao.insertCode(pvo);
	};
	public CltCodeDto selectCodeOne(CltCodeDto pvo) {
		return dao.selectCodeOne(pvo);
	};
	public List<CltCodeDto> selectCodeList(CltCodeDto pvo){
		return dao.selectCodeList(pvo);
	};
	public List<CltCodeDto> selectSaleStatCdList(CltCodeDto pvo){
		return dao.selectSaleStatCdList(pvo);
	};
	public List<CltCodeDto> selectOrdCdList(CltCodeDto pvo){
		return dao.selectOrdCdList(pvo);
	};
	public List<CltCodeDto> selectUsrCdList(CltCodeDto pvo){
		return dao.selectUsrCdList(pvo);
	};
	public List<CltCodeDto> selectAdmCdList(CltCodeDto pvo){
		return dao.selectAdmCdList(pvo);
	};
	public List<CltCodeDto> selectOrdDtlStatCdList(){ //주문 상태 코드 리스트
		return dao.selectOrdDtlStatCdList();
	};
	public int updateCode(CltCodeDto pvo) {
		return dao.updateCode(pvo);
	};
	public int deleteCodeOne(CltCodeDto pvo) {
		return dao.deleteCodeOne(pvo);
	};
	public int deleteCodeAll() {
		return dao.deleteCodeAll();
	};
	public int dropSeq() {
		return dao.dropSeq();
	};
	public int createSeq() {
		return dao.createSeq();
	};
}
