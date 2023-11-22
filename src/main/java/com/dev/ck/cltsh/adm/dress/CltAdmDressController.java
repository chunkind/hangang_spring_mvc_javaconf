package com.dev.ck.cltsh.adm.dress;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.ck.cltsh.shp.dress.CltDressDto;
import com.dev.ck.cltsh.shp.dress.service.CltDressService;

@Controller
public class CltAdmDressController{
	@Autowired private CltDressService dressService;
	
	private String command = "";

	@RequestMapping("/cltsh/adm/dress/admDressroomManager.do")
	public String admDressroomManager(HttpServletRequest req, HttpServletResponse res, CltDressDto pvo) {
		List<CltDressDto> list = dressService.selectDressList(pvo);
		req.setAttribute("list", list);
		//레프트 메뉴 네비게이션
		req.setAttribute("leftMenuNav", "admDressroomManager");
		return "cltsh/adm/dress/dressroom_manager";
	}
	
	@RequestMapping("/cltsh/adm/dress/admDressroomManagerEdit.do")
	public String admDressroomManagerEdit(HttpServletRequest req, HttpServletResponse res, CltDressDto pvo) {
		CltDressDto rvo = dressService.selectDressOne(pvo);
		req.setAttribute("pvo", rvo);
		//레프트 메뉴 네비게이션
		req.setAttribute("leftMenuNav", "admDressroomManager");
		return "cltsh/adm/dress/dressroom_manager_edit";
	}
	
	@RequestMapping("/cltsh/adm/dress/admDressroomManagerEditAct.do")
	public String admDressroomManagerEditAct(HttpServletRequest req, HttpServletResponse res, CltDressDto pvo) {
		int result = dressService.updateDress(pvo);
		req.setAttribute("pvo", pvo);
		return "redirect:/cltsh/adm/dress/admDressroomManager.do";
	}
	
	@RequestMapping("/cltsh/adm/dress/admDressroomManagerRemoveAct.do")
	public String admDressroomManagerRemoveAct(HttpServletRequest req, HttpServletResponse res, CltDressDto pvo) {
		int result = dressService.deleteDress(pvo);
		return "redirect:/cltsh/adm/dress/admDressroomManager.do";
	}
}
