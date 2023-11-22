package com.dev.ck.cltsh.adm.qna;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.ck.cltsh.cmm.util.PagingUtil;
import com.dev.ck.cltsh.shp.qna.CltQnaDto;
import com.dev.ck.cltsh.shp.qna.service.CltQnaService;

@Controller
public class CltAdmQnaController{
	@Autowired private CltQnaService qnaService;
	
	//문의 관리 리스트
	@RequestMapping("/cltsh/adm/qna/admQnaList.do")
	public String admQnaList(HttpServletRequest req, HttpServletResponse res, CltQnaDto pvo) {
		String requestURI = (String) req.getAttribute("requestURI"); //페이징
		String page = req.getParameter("page");
		int totalCnt = qnaService.admQnaCnt();
		pvo.setPath(requestURI);
		pvo.setParamPage(page);
		pvo.setTotalCnt(totalCnt);
		PagingUtil.getPagingKeys(pvo);
		
		List<CltQnaDto> rvo = qnaService.unansweredQnaList(pvo);
		
		req.setAttribute("rvo", rvo);
		req.setAttribute("paging", pvo.getHtml());

		return "cltsh/adm/qna/qna_list";
	}
	
	//문의 답변 화면
	@RequestMapping("/cltsh/adm/qna/admQnaAnswer.do")
	public String admQnaAnswer(HttpServletRequest req, HttpServletResponse res, CltQnaDto pvo) {
		CltQnaDto rvo = qnaService.selectQnaOne(pvo);
		
		req.setAttribute("pvo", rvo);
		
		return "cltsh/adm/qna/qna_answer";
	}
	
	//문의 답변
	@RequestMapping("/cltsh/adm/qna/admQnaAnswerAct.do")
	public String admQnaAnswerAct(HttpServletRequest req, HttpServletResponse res, CltQnaDto pvo) {
		int result = qnaService.updateAnswerQna(pvo);
		
		return "redirect:/cltsh/adm/qna/admQnaList.do";
	}
}
