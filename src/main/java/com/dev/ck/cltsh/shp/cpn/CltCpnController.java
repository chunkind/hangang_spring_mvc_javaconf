package com.dev.ck.cltsh.shp.cpn;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.ck.cltsh.shp.cpn.service.CltCpnService;

@Controller
public class CltCpnController {
	@Autowired private CltCpnService cpnService;
	
	@RequestMapping("/cltsh/cpn/cpnList.do")
	public String cpnList(HttpServletRequest req, HttpServletResponse res) {
		CltCpnDto pvo = new CltCpnDto();
		List<CltCpnDto> cpnList = cpnService.selectCpnList(pvo);
		req.setAttribute("cpnList", cpnList);
		
		return "cltsh/shp/cpn/cpn_list";
	}
}
