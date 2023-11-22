package com.dev.ck.cltsh.shp.prom.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.cltsh.shp.prom.CltPromDto;

@Service
public class CltPromService {
	@Autowired private CltPromMapper dao;
	
	public CltPromDto parameterSetting(HttpServletRequest req) {
		long promSeq = req.getParameter("promSeq") == null? 0L : Long.parseLong(req.getParameter("promSeq"));
		long promNum = req.getParameter("promNum") == null? 0L : Long.parseLong(req.getParameter("promNum"));
		String promName = req.getParameter("promName");
		String promTp = req.getParameter("promTp");
		int promDiscount = req.getParameter("promDiscount") == null? 0 : Integer.parseInt(req.getParameter("promDiscount"));
		String promRegistDate = req.getParameter("promRegistDate");
		String promEndDate = req.getParameter("promEndDate");
		String promCont = req.getParameter("promCont");
		String imgPath = req.getParameter("imgPath");
		String imgNm = req.getParameter("imgNm");
		String rgstId = req.getParameter("rgstId");
		String rgstDate = req.getParameter("rgstDate");
		String updtId = req.getParameter("updtId");
		String updtDate = req.getParameter("updtDate");
		
		
		CltPromDto pvo = new CltPromDto();
		pvo.setPromSeq(promSeq);
		pvo.setPromNum(promNum);
		pvo.setPromName(promName);
		pvo.setPromTp(promTp);
		pvo.setPromDiscount(promDiscount);
		pvo.setPromRegistDate(promRegistDate);
		pvo.setPromEndDate(promEndDate);
		pvo.setPromCont(promCont);
		pvo.setImgPath(imgPath);
		pvo.setImgNm(imgNm);
		pvo.setRgstId(rgstId);
		pvo.setRgstDate(rgstDate);
		pvo.setUpdtId(updtId);
		pvo.setUpdtDate(updtDate);
		
		return pvo;
	}
	public int promCnt() {
		return dao.promCnt();
	};
	public int insertProm(CltPromDto pvo) {
		return dao.insertProm(pvo);
	};
	
	public CltPromDto selectPromOne(CltPromDto pvo) {
		return dao.selectPromOne(pvo);
	};
	
	public List<CltPromDto> selectPromList(CltPromDto pvo){
		return dao.selectPromList(pvo);
	};

	public int updateProm(CltPromDto pvo) {
		return dao.updateProm(pvo);
	};
	
	public int deleteProm(CltPromDto pvo) {
		return dao.deleteProm(pvo);
	}
}
