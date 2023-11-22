package com.dev.ck.cltsh.adm.cate;

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

import com.dev.ck.cltsh.shp.cate.CltCateDto;
import com.dev.ck.cltsh.shp.cate.service.CltCateService;
import com.dev.ck.cltsh.shp.user.CltUserDto;

@Controller
@SuppressWarnings("unchecked")
public class CltAdmCateController{
	@Autowired private CltCateService cateService;
	
	// 카테고리 리스트 Ajax
	@RequestMapping("/cltsh/adm/cate/admCateListAjax.do")
	@ResponseBody
	public JSONObject admCateListAjax(HttpServletRequest req, HttpServletResponse res, CltCateDto pvo) {
		JSONObject data = new JSONObject();
		JSONArray jArry = new JSONArray();
		
		List<CltCateDto> underList = cateService.selectCateUnList(pvo);
		
		for(int i=0; i<underList.size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("catgryCd", underList.get(i).getCatgryCd());
			obj.put("catgryNm", underList.get(i).getCatgryNm());
			jArry.add(obj);
		}
		
		data.put("result", "success");
		data.put("dataList", jArry);
		
		return data;
	}
	
	// 카테고리 리스트
	@RequestMapping("/cltsh/adm/cate/admCateList.do")
	public String admCateList(HttpServletRequest req, HttpServletResponse res, CltCateDto pvo) {
		List<CltCateDto> list = cateService.selectCateList(pvo);
		req.setAttribute("list", list);
		
		pvo.setUprClassCd(req.getParameter("catgryCd"));
		List<CltCateDto> underList = cateService.selectCateUnList(pvo);
		
		if(req.getParameter("catgryCd") != null) {
			req.setAttribute("underList", underList);			
		}
		
		req.setAttribute("upperListSize", list.size());
		req.setAttribute("underListSize", underList.size());
		
		return "cltsh/adm/cate/cate_list";
	}
	
	// 카테고리 생성 액션
	@RequestMapping("/cltsh/adm/cate/admCateRegisterAct.do")
	public String admCateRegisterAct(HttpServletRequest req, HttpServletResponse res) {
		//세션
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
				
		CltCateDto pvo = cateService.parameterSetting(req);
		pvo.setUpdtId(loginInfo.getUsrId());
		pvo.setRgstId(loginInfo.getUsrId());
		
		int result = cateService.saveCate(pvo);
		req.setAttribute("pvo", pvo);
		
		return "redirect:/cltsh/adm/cate/admCateList.do";
	}
	
	// 카테고리 삭제 액션
	@RequestMapping("/cltsh/adm/cate/admCateRemoveAct.do")
	public String admCateRemoveAct(HttpServletRequest req, HttpServletResponse res, CltCateDto pvo) {
		int result = cateService.deleteCate(pvo);
		
		return "redirect:/cltsh/adm/cate/admCateList.do";
	}
}
