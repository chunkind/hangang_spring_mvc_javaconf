package com.dev.ck.cltsh.adm.point;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CltAdmPointController{
	private String command = "";
	
	@RequestMapping("/cltsh/adm/dress/adm_point_list.do")
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//레프트 메뉴 네비게이션
		req.setAttribute("leftMenuNav", "adm_point_list");
		return "cltsh/adm/point/point_list";
	}

}
