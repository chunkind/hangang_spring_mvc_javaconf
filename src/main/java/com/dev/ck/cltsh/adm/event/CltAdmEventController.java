package com.dev.ck.cltsh.adm.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dev.ck.ackwd.utils.FileUtil;
import com.dev.ck.cltsh.cmm.util.PagingUtil;
import com.dev.ck.cltsh.shp.event.CltEventDto;
import com.dev.ck.cltsh.shp.event.service.CltEventService;

@Controller
@SuppressWarnings("unchecked")
public class CltAdmEventController{
	@Autowired private CltEventService eventService;
	
	//이벤트 관리 리스트
	@RequestMapping("/cltsh/adm/event/selectEventPagingList.do")
	public String selectEventPagingList(HttpServletRequest req, HttpServletResponse res, CltEventDto pvo) {
		String requestURI = (String) req.getAttribute("requestURI"); //페이징
		String page = req.getParameter("page");
		int totalCnt = eventService.eventCnt();
		
		pvo.setPath(requestURI);
		pvo.setParamPage(page);
		pvo.setTotalCnt(totalCnt);
		PagingUtil.getPagingKeys(pvo);
		
		List<CltEventDto> list = eventService.selectEventPagingList(pvo);
		
		req.setAttribute("list", list);
		req.setAttribute("paging", pvo.getHtml());
		
		return "cltsh/adm/event/adm_event_list";
	}
	
	//이벤트 관리 리스트
	@RequestMapping("/cltsh/adm/event/admEventList.do")
	public String admEventList(HttpServletRequest req, HttpServletResponse res, CltEventDto pvo) {
		List<CltEventDto> list = eventService.selectEventList(pvo);
		req.setAttribute("list", list);
		
		return "cltsh/adm/event/adm_event_list";
	}
	
	//이벤트 등록 화면
	@RequestMapping("/cltsh/adm/event/admEventRegister.do")
	public String admEventRegister(HttpServletRequest req, HttpServletResponse res, CltEventDto pvo) {
		return "cltsh/adm/event/adm_event_register";
	}
	
	//이벤트 등록
	@RequestMapping("/cltsh/adm/event/admEventRegisterAct.do")
	public String admEventRegisterAct(HttpServletRequest req, HttpServletResponse res, CltEventDto pvo) {
		//파일 업로드
		FileUtil.uploadFile(req, pvo.getFile1());
		
		if(req.getAttribute("imgPath") != null && req.getAttribute("imgNm") != null) {
			pvo.setImgPath((String) req.getAttribute("imgPath"));
			pvo.setImgNm((String)req.getAttribute("imgNm"));
		}
		
		int result = eventService.insertEvent(pvo);
		
		req.setAttribute("pvo", pvo);
		
		return "redirect:/cltsh/adm/event/admEventList.do";
	}
	
	//이벤트 수정 화면
	@RequestMapping("/cltsh/adm/event/admEventEdit.do")
	public String admEventEdit(HttpServletRequest req, HttpServletResponse res, CltEventDto pvo) {
		CltEventDto rvo = eventService.selectEventOne(pvo);
		
		req.setAttribute("pvo", rvo);
		
		return "cltsh/adm/event/adm_event_edit";
	}
	
	//이벤트 수정 액션
	@RequestMapping("/cltsh/adm/event/admEventEditAct.do")
	public String admEventEditAct(HttpServletRequest req, HttpServletResponse res, CltEventDto pvo) {
		//파일 업로드
		FileUtil.uploadFile(req, pvo.getFile1());
		
		if(req.getAttribute("imgPath") != null && req.getAttribute("imgNm") != null) {
			pvo.setImgPath((String) req.getAttribute("imgPath"));
			pvo.setImgNm((String)req.getAttribute("imgNm"));
		}
		
		int result = eventService.updateEvent(pvo);
		
		req.setAttribute("pvo", pvo);
		
		return "redirect:/cltsh/adm/event/admEventList.do";
	}
	
	//이벤트 삭제
	@RequestMapping("/cltsh/adm/event/admEventRemoveAct.do")
	public String admEventRemoveAct(HttpServletRequest req, HttpServletResponse res, CltEventDto pvo) {
		int result = eventService.deleteEvent(pvo);
		
		return "redirect:/cltsh/adm/event/admEventList.do";
	}
	
	@RequestMapping(value = "/cltsh/adm/event/admEventListAjax.do")
	@ResponseBody
	public JSONObject admEventListAjax(HttpServletRequest req, HttpServletResponse res, CltEventDto pvo) {
		JSONObject data = new JSONObject();
		JSONArray jArry = new JSONArray();
		
		List<CltEventDto> list = eventService.selectEventList(pvo);
		
		for(int i=0; i<list.size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("imgNm", list.get(i).getImgNm());
			obj.put("imgPath", list.get(i).getImgPath());
			jArry.add(obj);
		}
		
		data.put("result", "success");
		data.put("data", jArry);
		
		return data;
	}
}
