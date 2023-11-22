package com.dev.ck.cltsh.shp.cpn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.cltsh.shp.cpn.CltCpnDto;

@Service
public class CltCpnService {
	@Autowired private CltCpnMapper dao;
	
	public CltCpnDto parameterSetting(HttpServletRequest req) {
		long couInfoSeq = req.getParameter("couInfoSeq") == null? 0L : Long.parseLong(req.getParameter("couInfoSeq"));
		long couNum = req.getParameter("couNum") == null? 0L : Long.parseLong(req.getParameter("couNum"));
		String couName = req.getParameter("couName");
		int couDiscount = req.getParameter("couDiscount") == null? 0 : Integer.parseInt(req.getParameter("couDiscount"));
		String couEndDate = req.getParameter("couEndDate");
		int couCount = req.getParameter("couCount") == null? 0 : Integer.parseInt(req.getParameter("couCount"));

		CltCpnDto pvo = new CltCpnDto();
		pvo.setCouInfoSeq(couInfoSeq);
		pvo.setCouNum(couNum);
		pvo.setCouName(couName);
		pvo.setCouDiscount(couDiscount);
		pvo.setCouEndDate(couEndDate);
		pvo.setCouCount(couCount);
		
		return pvo;
	}
	
	public int cpnCnt() {
		return dao.cpnCnt();
	};
	public int insertCpn(CltCpnDto pvo) {
		return dao.insertCpn(pvo);
	};
	
	public CltCpnDto selectCpnOne(CltCpnDto pvo) {
		return dao.selectCpnOne(pvo);
	};
	
	public List<CltCpnDto> selectCpnList(CltCpnDto pvo){
		return dao.selectCpnList(pvo);
	};

	public int updateCpn(CltCpnDto pvo) {
		return dao.updateCpn(pvo);
	};
	
	public int deleteCpn(CltCpnDto pvo) {
		return dao.deleteCpn(pvo);
	}
}
