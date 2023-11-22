package com.dev.ck.cltsh.shp.event;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.dev.ck.cltsh.shp.event.service.CltEventService;

@Controller
public class CltEventController{
	@Autowired private CltEventService eventService;
	
	private String command = "";

	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		//파라미터 셋팅
		CltEventDto pvo = parameterSetting(req);
	
		/*if(command.equals(HandlerMapping.CPN_LIST)) {
			List<CpnVO> goodsList = cpnService.selectCpnList(pvo);
			req.setAttribute("cpnList", cpnList);
			modelAndView.setPath("/WEB-INF/jsp/shp/cpn/cpn_list.jsp");
			modelAndView.setRedirect(false);
		}*/

		return modelAndView;
	}

	private CltEventDto parameterSetting(HttpServletRequest req) {
		CltEventDto pvo = new CltEventDto();
		return pvo;
	}

}
