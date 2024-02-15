package com.dev.ck.cltsh.adm.opts;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.ck.cltsh.shp.opts.CltOptsDto;
import com.dev.ck.cltsh.shp.opts.service.CltOptsService;

@Controller
public class CltAdmOptsController {
	@Autowired private CltOptsService optsService;
	
	//옵션 관리
	@RequestMapping("/cltsh/adm/opts/admOptsList.do")
	public String admOptsList(HttpServletRequest req, HttpServletResponse res, CltOptsDto pvo) {
		List<CltOptsDto> optsList = optsService.selectOptsList(pvo);
		req.setAttribute("optsList", optsList);
		return "cltsh/adm/opts/opts_list";
	}

}
