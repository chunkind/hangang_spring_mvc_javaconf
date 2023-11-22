package com.dev.ck.cltsh.adm.code;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dev.ck.cltsh.cmm.util.PagingUtil;
import com.dev.ck.cltsh.shp.code.CltCodeDto;
import com.dev.ck.cltsh.shp.code.service.CltCodeService;
import com.dev.ck.cltsh.shp.user.CltUserDto;


@Controller
@SuppressWarnings("unchecked")
public class CltAdmCodeController {
	@Autowired private CltCodeService codeService;
	
	//공통코드 리스트
	@RequestMapping("/cltsh/adm/code/admCodeList.do")
	public String admCodeList(HttpServletRequest req, HttpServletResponse res, CltCodeDto pvo) {
		// 인터셉터에서 저장한 QueryString 가져오기
		String requestURI = (String) req.getAttribute("requestURI"); //페이징
		String page = req.getParameter("page");
		int totalCnt = codeService.codeCnt();
		
		pvo.setPath(requestURI);
		pvo.setParamPage(page);
		pvo.setTotalCnt(totalCnt);
		PagingUtil.getPagingKeys(pvo);
		List<CltCodeDto> list = codeService.selectCodeList(pvo);
		
		req.setAttribute("list", list);
		req.setAttribute("paging", pvo.getHtml());
		
		return "cltsh/adm/code/code_list";
	}
		
	//공통코드 리스트 Ajax
	@RequestMapping("/cltsh/adm/code/admCodeListAjax.do")
	@ResponseBody
	public JSONObject admCodeListAjax(HttpServletRequest req, HttpServletResponse res, CltCodeDto pvo) {
		JSONObject data = new JSONObject();
		JSONArray jArry = new JSONArray();

		List<CltCodeDto> list = null;
		
		if(req.getParameter("searchGradeUpperType").equals("user")) {
			list = codeService.selectUsrCdList(pvo);
		}else if(req.getParameter("searchGradeUpperType").equals("admin")) {
			list = codeService.selectAdmCdList(pvo);
		}
		
		for(int i=0; i<list.size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("codeNm", list.get(i).getCodeNm());
			obj.put("codeVal", list.get(i).getCodeVal());
			jArry.add(obj);
		}
		
		data.put("result", "success");
		data.put("dataList", jArry);
		
		return data;
	}
	
	//공통코드 등록 화면
	@RequestMapping("/cltsh/adm/code/admCodeRegister.do")
	public String admCodeRegister(HttpServletRequest req, HttpServletResponse res, CltCodeDto pvo) {
		return "cltsh/adm/code/code_register";
	}
	
	//공통코드 등록
	@RequestMapping("/cltsh/adm/code/admCodeRegisterAct.do")
	public String admCodeRegisterAct(HttpServletRequest req, HttpServletResponse res, CltCodeDto pvo) {
		//세션
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
		pvo.setRgstId(loginInfo.getUsrId());
		
		int result = codeService.insertCode(pvo);
		req.setAttribute("pvo", pvo);
		
		return "redirect:/cltsh/adm/code/admCodeList.do";
	}
	
	//공통코드 수정 화면
	@RequestMapping("/cltsh/adm/code/admCodeEdit.do")
	public String admCodeEdit(HttpServletRequest req, HttpServletResponse res, CltCodeDto pvo) {
		CltCodeDto rvo = codeService.selectCodeOne(pvo);
		req.setAttribute("pvo", rvo);
		
		return "cltsh/adm/code/code_edit";
	}
	
	//공통코드 수정
	@RequestMapping("/cltsh/adm/code/admCodeEditAct.do")
	public String admCodeEditAct(HttpServletRequest req, HttpServletResponse res, CltCodeDto pvo) {
		//세션
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
		pvo.setUpdtId(loginInfo.getUsrId());
		
		int result = codeService.updateCode(pvo);
		req.setAttribute("pvo", pvo);
		
		return "redirect:/cltsh/adm/code/admCodeList.do";
	}
	
	//공통코드 삭제
	@RequestMapping("/cltsh/adm/code/admCodeRemoveAct.do")
	public String admCodeRemoveAct(HttpServletRequest req, HttpServletResponse res, CltCodeDto pvo) {
		int result = codeService.deleteCodeOne(pvo);
		
		return "redirect:/cltsh/adm/code/admCodeList.do";
	}
}
