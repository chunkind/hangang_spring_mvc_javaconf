package com.dev.ck.cltsh.shp.event.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.cltsh.shp.event.CltEventDto;

@Service
public class CltEventService {
	@Autowired private CltEventMapper dao;

	public CltEventDto parameterSetting(HttpServletRequest req) {
		long eventInfoSeq = req.getParameter("eventInfoSeq") == null? 0L : Long.parseLong(req.getParameter("eventInfoSeq"));
		long eventNum = req.getParameter("eventNum") == null? 0L : Long.parseLong(req.getParameter("eventNum"));
		String eventName = req.getParameter("eventName");
		String eventEndDate = req.getParameter("eventEndDate");

		CltEventDto pvo = new CltEventDto();
		pvo.setEventInfoSeq(eventInfoSeq);
		pvo.setEventNum(eventNum);
		pvo.setEventName(eventName);
		pvo.setEventEndDate(eventEndDate);
		
		//첨부파일 있으면 셋팅
		String imgPath = (String) req.getAttribute("imgPath");
		if(null == imgPath || "".equals(imgPath)) {
			imgPath = req.getParameter("imgPath");
		}
		String imgNm = (String) req.getAttribute("imgNm");
		if(null == imgNm || "".equals(imgNm)) {
			imgNm = req.getParameter("imgNm");
		}
			
		if(null != imgPath && !"".equals(imgPath)) {
			pvo.setImgPath(imgPath);
		}
		if(null != imgNm && !"".equals(imgNm)) {
			pvo.setImgNm(imgNm);
		}
		
		return pvo;
	}
	
	public int eventCnt() {
		return dao.eventCnt();
	};
	public List<CltEventDto> selectEventPagingList(CltEventDto pvo){
		return dao.selectEventPagingList(pvo);
	};
	public int insertEvent(CltEventDto pvo) {
		return dao.insertEvent(pvo);
	};
	public CltEventDto selectEventOne(CltEventDto pvo) {
		return dao.selectEventOne(pvo);
	};
	public List<CltEventDto> selectEventList(CltEventDto pvo){
		return dao.selectEventList(pvo);
	};
	public int updateEvent(CltEventDto pvo) {
		return dao.updateEvent(pvo);
	};
	public int deleteEvent(CltEventDto pvo) {
		return dao.deleteEvent(pvo);
	};
	public int dropSeq() {
		return dao.dropSeq();
	};
	public int createSeq() {
		return dao.createSeq();
	};
	public int deleteEventAll() {
		return dao.deleteEventAll();
	};	
}
