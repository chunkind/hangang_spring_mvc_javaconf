package com.dev.ck.cltsh.adm.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CltAdmMainController {
	
	@RequestMapping("/cltsh/adm/main.do")
	public String admMainHome(HttpServletRequest req, HttpServletResponse res) {
		
		return "cltsh/adm/main/admMainHome";
	}

}
