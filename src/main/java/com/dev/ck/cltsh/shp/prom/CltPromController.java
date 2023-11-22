package com.dev.ck.cltsh.shp.prom;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.ck.cltsh.shp.prom.service.CltPromService;

@Controller
public class CltPromController {
	@Autowired private CltPromService promService;
	
	@RequestMapping("/cltsh/prom/promList.do")
	public String cpnList(HttpServletRequest req, HttpServletResponse res) {
		CltPromDto pvo = new CltPromDto();
		List<CltPromDto> promList = promService.selectPromList(pvo);
		req.setAttribute("promList", promList);
		
		return "cltsh/adm/prom/adm_prom_list";
	}
}
