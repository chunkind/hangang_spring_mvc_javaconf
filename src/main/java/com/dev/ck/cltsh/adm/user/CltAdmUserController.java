package com.dev.ck.cltsh.adm.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.ck.cltsh.cmm.util.PagingUtil;
import com.dev.ck.cltsh.shp.code.CltCodeDto;
import com.dev.ck.cltsh.shp.code.service.CltCodeService;
import com.dev.ck.cltsh.shp.user.CltUserDto;
import com.dev.ck.cltsh.shp.user.service.CltUserService;

@Controller
public class CltAdmUserController{
	@Autowired private CltUserService userService;
	@Autowired private CltCodeService codeService;
	
	// 회원 정보 List
	@RequestMapping("/cltsh/adm/user/admUserList.do")
	public String admUserList(HttpServletRequest req, HttpServletResponse res, CltUserDto pvo) {
		String requestURI = (String) req.getAttribute("requestURI"); //페이징
		String page = req.getParameter("page");
		int totalCnt = userService.userCnt();
		pvo.setPath(requestURI);
		pvo.setParamPage(page);
		pvo.setTotalCnt(totalCnt);
		PagingUtil.getPagingKeys(pvo);
		
		List<CltUserDto> list = userService.selectUserPagingList(pvo);
		
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
		
		//판매 상태 공통코드
		CltCodeDto codeVo = new CltCodeDto();
		codeVo.setRgstId(loginInfo.getUsrId());
		List<CltCodeDto> codeList = codeService.selectCodeList(codeVo);
		
		req.setAttribute("list", list);
		req.setAttribute("codeList", codeList);
		req.setAttribute("paging", pvo.getHtml());
		
		return "cltsh/adm/user/user_list";
	}
	
	// 회원 정보 상세페이지
	@RequestMapping("/cltsh/adm/user/admUserDetail.do")
	public String admUserDetail(HttpServletRequest req, HttpServletResponse res, CltUserDto pvo) {
		CltUserDto rvo = userService.selectUserOne(pvo);
		req.setAttribute("pvo", rvo);
		
		return "cltsh/adm/user/user_detail";
	}
	
	// 회원 검색
	@RequestMapping("/cltsh/adm/user/admUserSearch.do")
	public String admUserSearch(HttpServletRequest req, HttpServletResponse res, CltUserDto pvo) {		
		List<CltUserDto> list = userService.admUserSearch(pvo);
		req.setAttribute("list", list);
		
		return "cltsh/adm/user/user_list";
	}

}
