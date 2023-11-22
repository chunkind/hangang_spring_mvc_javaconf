package com.dev.ck.cltsh.adm.prom;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.ck.cltsh.cmm.util.PagingUtil;
import com.dev.ck.cltsh.shp.prom.CltPromDto;
import com.dev.ck.cltsh.shp.prom.service.CltPromService;

@Controller
@SuppressWarnings("unchecked")
public class CltAdmPromController {
	@Autowired private CltPromService promService;

	//프로모션 리스트 화면
	@RequestMapping("/cltsh/adm/prom/admPromList.do")
	public String admPromList(HttpServletRequest req, HttpServletResponse res, CltPromDto pvo) {
		String requestURI = (String) req.getAttribute("requestURI"); //페이징
		String page = req.getParameter("page");
		int totalCnt = promService.promCnt();
		
		pvo.setPath(requestURI);
		pvo.setParamPage(page);
		pvo.setTotalCnt(totalCnt);
		PagingUtil.getPagingKeys(pvo);
		
		List<CltPromDto> list = promService.selectPromList(pvo);
		
		req.setAttribute("list", list);
		req.setAttribute("paging", pvo.getHtml());
		
		return "cltsh/adm/prom/adm_prom_list";
	}
	
	//프로모션 수정 화면
	@RequestMapping("/cltsh/adm/prom/admPromEdit.do")
	public String admPromEdit(HttpServletRequest req, HttpServletResponse res, CltPromDto pvo) {
		CltPromDto rvo = promService.selectPromOne(pvo);
		
		req.setAttribute("pvo", rvo);
		
		return "cltsh/adm/prom/adm_prom_edit";
	}
	
	//프로모션 수정 기능
	@RequestMapping("/cltsh/adm/prom/admPromEditAct.do")
	public String admPromEditAct(HttpServletRequest req, HttpServletResponse res, CltPromDto pvo) {
		String returnUrl = "redirect:/cltsh/adm/prom/admPromEdit.do?promSeq="+pvo.getPromSeq();
		
		promService.updateProm(pvo);
		
		return returnUrl;
	}
}