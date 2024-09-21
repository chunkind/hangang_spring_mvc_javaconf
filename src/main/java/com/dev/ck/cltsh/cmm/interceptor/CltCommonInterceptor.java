package com.dev.ck.cltsh.cmm.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dev.ck.ackwd.utils.StringUtil;
import com.dev.ck.cltsh.cmm.util.StringUtils;
import com.dev.ck.cltsh.shp.user.CltUserDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CltCommonInterceptor extends HandlerInterceptorAdapter {
	public static final String[] EXCEPT_URI = {
		"Ajax.do", ".js", ".css", ".html",
		"Detail.do", "List.do",
		"/cltsh/main.do",
		"/cltsh/user/userLogin.do",
		"/cltsh/user/userLoginAct.do",
	};
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// String requestURI = request.getRequestURI();

		System.out.println("=interceptor start ========================================================================================");
		
		// 세션 체크
		HttpSession session = request.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
		
		// 예외처리 url
		/*if(isCheckUrl(request.getRequestURI()) && null == loginInfo) {
			session.setAttribute("message", "로그인 해주세요...");
			//response.sendRedirect("/cltsh/main.do");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cltsh/main.do");
	        dispatcher.forward(request, response);
		}*/
		
		// 필수로 체크해야하는 url
		
		
		
//		String queryStr = request.getQueryString();
//		
//	    if (queryStr != null) {
//	        System.out.println(queryStr);
//	    } else {
//	        // 쿼리 문자열이 없는 경우 요청 URI 출력
//	        String requestURI = request.getRequestURI();
//	        System.out.println("Request URI: " + requestURI);
//	    }
		
		String requestURI = request.getRequestURI();
        System.out.println("Request URI: " + requestURI);
	    
	    // requestURI를 HttpServletRequest에 저장
        request.setAttribute("requestURI", requestURI);
		
		System.out.println("=interceptor end ==========================================================================================");
		
		return true; // false 진행X
	}

	private boolean isCheckUrl(String requestURI) {
		// true면 url 체크 대상이 된다..
		boolean result = true;
		if(StringUtil.isEmpty(requestURI))
			return false;
		
		for(String str : EXCEPT_URI) {
			if(requestURI.contains(str)) {
				result = false;
				break;
			}
		}
		
		return result;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//		log.info("postHandle [{}]", modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//		String requestURI = request.getRequestURI();
//		String logId = (String) request.getAttribute(LOG_ID);
//		log.info("RESPONSE [{}][{}]", logId, requestURI);
//		if (ex != null) {
//			log.error("afterCompletion error!!", ex);
//		}
	}
}

//@Component 
//public class CommonInterceptor extends HandlerInterceptorAdapter{
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		boolean result = true;
//		System.out.println("=interceptor start ========================================================================================");
//		String queryStr = request.getQueryString();
//		System.out.println(queryStr);
//		
//		// QueryString을 HttpServletRequest에 저장
//        request.setAttribute("pageInfo", queryStr);
//
//        System.out.println("=interceptor end ==========================================================================================");
//		return result;
//	}
//
//
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		super.afterCompletion(request, response, handler, ex);
//	}
//}
