package com.dev.ck.cltsh.adm.opts;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.ck.cltsh.shp.cate.CltCateDto;
import com.dev.ck.cltsh.shp.code.CltCodeDto;
import com.dev.ck.cltsh.shp.opts.CltOptsDto;
import com.dev.ck.cltsh.shp.opts.service.CltOptsService;
import com.dev.ck.cltsh.shp.user.CltUserDto;

@Controller
public class CltAdmOptsController {
	@Autowired private CltOptsService optsService;
	
	//옵션 관리
	@RequestMapping("/cltsh/adm/opts/admOptsList.do")
	public String admOptsList(HttpServletRequest req, HttpServletResponse res, CltOptsDto pvo) {
		List<CltOptsDto> optsList = optsService.selectOptsList(pvo);
		req.setAttribute("optsListSize", optsList.size());
		req.setAttribute("optsList", optsList);
		return "cltsh/adm/opts/opts_list";
	}
	
	//옵션 등록
	@RequestMapping("/cltsh/adm/opts/admOptsRegisterAct.do")
	public String admOptsRegisterAct(HttpServletRequest req, HttpServletResponse res, CltOptsDto pvo) {
		//세션
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
		pvo.setRgstId(loginInfo.getUsrId());
		
//		int result = codeService.insertCode(pvo);
		req.setAttribute("pvo", pvo);
		
		return "redirect:/cltsh/adm/code/admCodeList.do";
	}

	// 카테고리 삭제 액션
	@RequestMapping("/cltsh/adm/opts/admOptsRemoveAct.do")
	public String admOptsRemoveAct(HttpServletRequest req, HttpServletResponse res, CltOptsDto pvo) {
		int result = optsService.deleteOptsOne(pvo);
		
		return "redirect:/cltsh/adm/opts/admOptsList.do";
	}
}
