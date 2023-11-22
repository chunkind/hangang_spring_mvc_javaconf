package com.dev.ck.cltsh.shp.qna.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.cltsh.cmm.util.StringUtils;
import com.dev.ck.cltsh.shp.qna.CltQnaDto;

@Service
public class CltQnaService {
	@Autowired private CltQnaMapper dao;
	
	public CltQnaDto parameterSetting(HttpServletRequest req) {
		long qnaBoardSeq = req.getParameter("qnaBoardSeq") == null? 0L : Long.parseLong(req.getParameter("qnaBoardSeq"));
		String titNm = req.getParameter("titNm");
		String cont= req.getParameter("cont");
		String rgstId = req.getParameter("rgstId");
		String rgstDate = req.getParameter("rgstDate");
		String updtId = req.getParameter("updtId");
		String updtDate = req.getParameter("updtDate");
		String qnaTp = req.getParameter("qnaTp");
		String ansrStat = req.getParameter("ansrStat");
		String useYn = req.getParameter("useYn");
		String passYn = req.getParameter("passYn");
		String passWd = req.getParameter("passWd");
		long goodsCd = StringUtils.nullToInt(req.getParameter("goodsCd"));
		String answer= req.getParameter("answer");
		
		CltQnaDto pvo = new CltQnaDto();
		
		pvo.setQnaBoardSeq(qnaBoardSeq);
		pvo.setTitNm(titNm);
		pvo.setCont(cont);
		pvo.setRgstId(rgstId);
		pvo.setRgstDate(rgstDate);
		pvo.setUpdtId(updtId);
		pvo.setUpdtDate(updtDate);
		pvo.setQnaTp(qnaTp);
		pvo.setAnsrStat(ansrStat);
		pvo.setUseYn(useYn);
		pvo.setPassYn(passYn);
		pvo.setPassWd(passWd);
		pvo.setGoodsCd(goodsCd);
		pvo.setAnswer(answer);
		
		return pvo;
	}
	
	public int qnaCnt() {
		return dao.qnaCnt();
	}
	
	public int admQnaCnt() {
		return dao.admQnaCnt();
	}
	
	public List<CltQnaDto> qnaPageing(CltQnaDto pvo){
		return dao.qnaPageing(pvo);
	}
	
	public int insertQna(CltQnaDto pvo) {
		return dao.insertQna(pvo);
	}
	
	public CltQnaDto selectQnaOne(CltQnaDto pvo) {
		return dao.selectQnaOne(pvo);
	}
	
	public List<CltQnaDto> selectQnaList(CltQnaDto pvo){
		return dao.selectQnaList(pvo);
	}
	
	public int updateQna(CltQnaDto pvo) {
		return dao.updateQna(pvo);
	}
	
	public int deleteQna(CltQnaDto pvo) {
		return dao.deleteQna(pvo);
	}
	
	public List<CltQnaDto> searchIdQnaList(CltQnaDto pvo){
		return dao.searchIdQnaList(pvo);
	}
	
	public List<CltQnaDto> searchGoodsCdQna(CltQnaDto pvo){
		return dao.searchGoodsCdQna(pvo);
	}
	
	public List<CltQnaDto> unansweredQnaList(CltQnaDto pvo){
		return dao.unansweredQnaList(pvo);
	}
	
	public int updateAnswerQna(CltQnaDto pvo) {
		return dao.updateAnswerQna(pvo);
	}
}
