package com.dev.ck.cltsh.cmm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CltCommonInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// String requestURI = request.getRequestURI();

		System.out.println("=interceptor start ========================================================================================");
		
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
