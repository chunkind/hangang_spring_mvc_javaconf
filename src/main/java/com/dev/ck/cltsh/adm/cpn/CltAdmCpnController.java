package com.dev.ck.cltsh.adm.cpn;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.ck.cltsh.cmm.util.PagingUtil;
import com.dev.ck.cltsh.shp.cpn.CltCpnDto;
import com.dev.ck.cltsh.shp.cpn.service.CltCpnService;


@Controller
public class CltAdmCpnController{
	@Autowired private CltCpnService cpnService;
	
	// 쿠폰 리스트 화면
	@RequestMapping("/cltsh/adm/cpn/admCpnList.do")
	public String admCpnList(HttpServletRequest req, HttpServletResponse res, CltCpnDto pvo) {
		// 인터셉터에서 저장한 QueryString 가져오기
		String requestURI = (String) req.getAttribute("requestURI"); //페이징
		String page = req.getParameter("page");
		int totalCnt = cpnService.cpnCnt();
		
		pvo.setPath(requestURI);
		pvo.setParamPage(page);
		pvo.setTotalCnt(totalCnt);
		
		PagingUtil.getPagingKeys(pvo);
		List<CltCpnDto> list = cpnService.selectCpnList(pvo);
		
		req.setAttribute("list", list);
		req.setAttribute("paging", pvo.getHtml());
		
		return "cltsh/adm/coupon/adm_cpn_list";
	}
	// 쿠폰 등록 화면
	@RequestMapping("/cltsh/adm/cpn/admCpnRegister.do")
	public String admCpnRegister(HttpServletRequest req, HttpServletResponse res, CltCpnDto pvo) {
		return "cltsh/adm/coupon/adm_cpn_register";
	}
	// 쿠폰 등록 액션
	@RequestMapping("/cltsh/adm/cpn/admCpnRegisterAct.do")
	public String admCpnRegisterAct(HttpServletRequest req, HttpServletResponse res, CltCpnDto pvo) {
		int result = cpnService.insertCpn(pvo);
		req.setAttribute("pvo", pvo);
		
		return "redirect:/cltsh/adm/cpn/admCpnList.do";
	}
	// 쿠폰 수정 화면
	@RequestMapping("/cltsh/adm/cpn/admCpnEdit.do")
	public String admCpnEdit(HttpServletRequest req, HttpServletResponse res, CltCpnDto pvo) {
		CltCpnDto rvo = cpnService.selectCpnOne(pvo);
		req.setAttribute("pvo", rvo);
		
		return "cltsh/adm/coupon/adm_cpn_edit";
	}
	// 쿠폰 수정 액션
	@RequestMapping("/cltsh/adm/cpn/admCpnEditAct.do")
	public String admCpnEditAct(HttpServletRequest req, HttpServletResponse res, CltCpnDto pvo) {
		int result = cpnService.updateCpn(pvo);
		req.setAttribute("pvo", pvo);
		
		return "redirect:/cltsh/adm/cpn/admCpnList.do";
	}
	// 쿠폰 삭제 액션
	@RequestMapping("/cltsh/adm/cpn/admCpnRemoveAct.do")
	public String admCpnRemoveAct(HttpServletRequest req, HttpServletResponse res, CltCpnDto pvo) {
		int result = cpnService.deleteCpn(pvo);
		
		return "redirect:/cltsh/adm/cpn/admCpnList.do";
	}
}
