package com.dev.ck.cltsh.adm.entr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.ck.cltsh.cmm.util.PagingUtil;
import com.dev.ck.cltsh.shp.entr.CltEntrDto;
import com.dev.ck.cltsh.shp.entr.service.CltEntrService;
import com.dev.ck.cltsh.shp.user.CltUserDto;
import com.dev.ck.cltsh.shp.user.service.CltUserService;

@Controller
public class CltAdmEntrController{
	@Autowired private CltEntrService entrService;
	@Autowired private CltUserService userService;
	
	// 업체 리스트
	@RequestMapping("/cltsh/adm/entr/admEntrList.do")
	public String admEntrList(HttpServletRequest req, HttpServletResponse res, CltEntrDto pvo) {
		String requestURI = (String) req.getAttribute("requestURI"); //페이징
		String page = req.getParameter("page");
		int totalCnt = entrService.entrCnt();
		
		pvo.setPath(requestURI);
		pvo.setParamPage(page);
		pvo.setTotalCnt(totalCnt);
		PagingUtil.getPagingKeys(pvo);
		List<CltEntrDto> entrList = entrService.selectEntrList(pvo);
		
		req.setAttribute("paging", pvo.getHtml());
		req.setAttribute("entrList", entrList);
		
		return "cltsh/adm/entr/entr_list";
	}
	
	// 업체 등록 화면
	@RequestMapping("/cltsh/adm/entr/admEntrRegister.do")
	public String admEntrRegister(HttpServletRequest req, HttpServletResponse res, CltEntrDto pvo) {
		CltUserDto userVO = new CltUserDto();
		
		List<CltUserDto> userList = userService.selectUserList(userVO);
		
		req.setAttribute("userList", userList);
		
		
		return "cltsh/adm/entr/entr_register";
	}
	
	// 업체 등록 액션
	@RequestMapping("/cltsh/adm/entr/admEntrRegisterAct.do")
	public String admEntrRegisterAct(HttpServletRequest req, HttpServletResponse res, CltEntrDto pvo) {
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
		pvo.setScore(0);
		pvo.setRgstId(loginInfo.getUsrId());
		pvo.setUpdtId(loginInfo.getUsrId());
		
		int result = entrService.insertEntr(pvo);
		req.setAttribute("pvo", pvo);
		
		return "redirect:/cltsh/adm/entr/admEntrList.do";
	}
	
	// 업체 수정 화면
	@RequestMapping("/cltsh/adm/entr/admEntrEdit.do")
	public String admEntrEdit(HttpServletRequest req, HttpServletResponse res, CltEntrDto pvo) {
		CltUserDto userVO = new CltUserDto();
		
		CltEntrDto rvo = entrService.selectEntrOne(pvo);
		req.setAttribute("evo", rvo);
		
		List<CltUserDto> userList = userService.selectUserList(userVO);
		
		req.setAttribute("userList", userList);
		
		return "cltsh/adm/entr/entr_edit";
	}
	
	// 업체 수정 액션
	@RequestMapping("/cltsh/adm/entr/admEntrEditAct.do")
	public String admEntrEditAct(HttpServletRequest req, HttpServletResponse res, CltEntrDto pvo) {		
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
		pvo.setScore(0);
		pvo.setUpdtId(loginInfo.getUsrId());
		
		int result = entrService.updateEntr(pvo);
		req.setAttribute("evo", pvo);
		
		return "redirect:/cltsh/adm/entr/admEntrList.do";
	}
	
	// 업체 삭제 액션
	@RequestMapping("/cltsh/adm/entr/admEntrRemoveAct.do")
	public String admEntrRemoveAct(HttpServletRequest req, HttpServletResponse res, CltEntrDto pvo) {
		int result = entrService.deleteEntr(pvo);
		
		return "redirect:/cltsh/adm/entr/admEntrList.do";
	}
}
