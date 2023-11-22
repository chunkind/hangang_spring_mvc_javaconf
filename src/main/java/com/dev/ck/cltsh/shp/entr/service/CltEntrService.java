package com.dev.ck.cltsh.shp.entr.service;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.cltsh.cmm.util.DateUtils;
import com.dev.ck.cltsh.shp.entr.CltEntrDto;

@Service
public class CltEntrService {
	@Autowired private CltEntrMapper dao;
	
	//파라미터 셋팅
	public CltEntrDto parameterSetting(HttpServletRequest req) {
		long entrNo = req.getParameter("entrNo") == null? 0L : Long.parseLong(req.getParameter("entrNo"));
		String usrId  = req.getParameter("usrId");
		String entrNm  = req.getParameter("entrNm");
		String bmanRegNo  = req.getParameter("bmanRegNo");
		String presNm = req.getParameter("presNm");
		String presTell = req.getParameter("presTell");
		String presEmail = req.getParameter("presEmail");
		String aempNm = req.getParameter("aempNm");
		String aempTell = req.getParameter("aempTell");
		String aempEmail = req.getParameter("aempEmail");
		int score = req.getParameter("score") == null? 0 : Integer.parseInt(req.getParameter("score"));
		String landAddrBase = req.getParameter("landAddrBase");
		String landAddrDtl = req.getParameter("landAddrDtl");
		String landPostNo = req.getParameter("landPostNo");
		String loadAddrBase = req.getParameter("loadAddrBase");
		String loadPostNo = req.getParameter("loadPostNo");
		Date opnDate = DateUtils.stringToSqlDate(req.getParameter("opnDate"));
		Date closeDate = DateUtils.stringToSqlDate(req.getParameter("closeDate"));
		String opnYn = req.getParameter("opnYn");
		String useYn = req.getParameter("useYn");
		
		CltEntrDto evo = new CltEntrDto();
		evo.setEntrNo(entrNo);
		evo.setUsrId(usrId);
		evo.setEntrNm(entrNm);
		evo.setBmanRegNo(bmanRegNo);
		evo.setPresNm(presNm);
		evo.setPresTell(presTell);
		evo.setPresEmail(presEmail);
		evo.setAempNm(aempNm);
		evo.setAempTell(aempTell);
		evo.setAempEmail(aempEmail);
		evo.setScore(score);
		evo.setLandAddrBase(landAddrBase);
		evo.setLandAddrDtl(landAddrDtl);
		evo.setLandPostNo(landPostNo);
		evo.setLoadAddrBase(loadAddrBase);
		evo.setLoadPostNo(loadPostNo);
		evo.setOpnDate(opnDate);
		evo.setCloseDate(closeDate);
		evo.setOpnYn(opnYn);
		evo.setUseYn(useYn);

		return evo;
	}
	
	public int entrCnt() {
		return dao.entrCnt();
	};
	public int insertEntr(CltEntrDto pvo) {
		return dao.insertEntr(pvo);
	};
	public CltEntrDto selectEntrOne(CltEntrDto pvo) {
		return dao.selectEntrOne(pvo);
	};
	public List<CltEntrDto> selectEntrList(CltEntrDto pvo){
		return dao.selectEntrList(pvo);
	};
	public List<CltEntrDto> selectIdEntrList(CltEntrDto pvo){
		return dao.selectIdEntrList(pvo);
	};
	public int updateEntr(CltEntrDto pvo) {
		return dao.updateEntr(pvo);
	};
	public int deleteEntr(CltEntrDto pvo) {
		return dao.deleteEntr(pvo);
	};
	public int deleteEntrAll() {
		return dao.deleteEntrAll();
	};
	public int dropSeq() {
		return dao.dropSeq();
	};
	public int createSeq() {
		return dao.createSeq();
	};
}
