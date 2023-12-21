package com.dev.ck.cltsh.shp.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dev.ck.cltsh.shp.user.service.CltUserService;
import com.dev.ck.cltsh.shp.user.service.kakaoLoginService;

@Controller
public class CltUserController {
	@Autowired private CltUserService userService;
	@Autowired private kakaoLoginService kakaoService;
	
	// 회원 정보 수정 화면
	@RequestMapping("/cltsh/user/userEdit.do")
	public String userEdit(HttpServletRequest req, HttpServletResponse res, CltUserDto pvo) {
		pvo.setUsrBaseSeq(Integer.parseInt(req.getParameter("usrBaseSeq")));
		pvo = userService.selectUserOne(pvo);
		
		req.setAttribute("pvo", pvo);
		
		return "cltsh/shp/user/user_edit";
	}
	
	// 회원 정보 수정
	@RequestMapping("/cltsh/user/userEditAct.do")
	public String userEditAct(HttpServletRequest req, HttpServletResponse res, CltUserDto pvo) {
		pvo.setLoadPostNo(pvo.getLandPostNo());
		pvo.setLockYn("N");
		pvo.setUpdtId(pvo.getUsrId());
		pvo.setUseYn("Y");
		int result = userService.updateUser(pvo);
		
		req.setAttribute("pvo", pvo);
		
		return "redirect:/cltsh/main.do";
	}

	// 회원가입 시 회원 아이디 중복 체크
	@RequestMapping("/cltsh/user/userIdCheck")
	public void userIdCheck(HttpServletRequest req, HttpServletResponse res) {
		String json = "";
		CltUserDto pvo = new CltUserDto();
		CltUserDto sessionVO = userService.userLogin(pvo);

		try {
			if (null == sessionVO) {
				json = "{\"result\":\"success\"}";
			} else {
				json = "{\"result\":\"fail\"}";
			}
		} catch (Exception e) {
			json = "{\"result\":\"fail\"}";
			e.printStackTrace();
		}

		req.setAttribute("json", json);
	}
	
	// 로그인 화면 호출
	@RequestMapping("/cltsh/user/userLogin.do")
	public String userLogin() {
		return "cltsh/shp/user/login";
	}

	// 카카오 로그인 화면 호출 //1번 카카오톡에 사용자 코드 받기(jsp의 a태그 href에 경로 있음)
	@GetMapping("/cltsh/user/kakaoLogin.do") //	@RequestMapping(value = "/cltsh/user/kakaoLogin.do", method = RequestMethod.GET)
	public String kakaoLogin(@RequestParam(value = "code", required = false) String code, HttpServletRequest req) throws Throwable {
		HttpSession session = req.getSession();
		String returnPage = "";
		
		// 1번
		System.out.println("code:" + code);
		
		// 2번
		String access_Token = kakaoService.getAccessToken(code);
		System.out.println("###access_Token#### : " + access_Token);
		// 위의 access_Token 받는 걸 확인한 후에 밑에 진행
		
		// 3번
		HashMap<String, Object> userInfo = kakaoService.getUserInfo(access_Token);
//		System.out.println("###nickname#### : " + userInfo.get("nickname"));
		String email = (String) userInfo.get("email");
		
		if (email == null || email.equals("")) {
			returnPage = "/cltsh/user/userLogin.do";
		} else {
			CltUserDto pvo = userService.kakaoLogin(email);
			CltUserDto sessionVO = userService.userLogin(pvo);
			
			if (null == sessionVO) {
				returnPage = "redirect:/cltsh/user/userLogin.do";
			} else if (pvo.getUsrId().equals(sessionVO.getUsrId()) && pvo.getPassWd().equals(sessionVO.getPassWd())) {
				session.setAttribute("loginInfo", sessionVO);
				returnPage = "redirect:/cltsh/main.do";
			}
		}
		
		return returnPage; // return에 페이지를 해도 되고, 여기서는 코드가 넘어오는지만 확인할거기 때문에 따로 return 값을 두지는 않았음
	}
	
	// 로그인 - 아이디, 비밀번호 입력 시 호출
	@RequestMapping("/cltsh/user/userLoginAct.do")
	public String userLoginAct(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String returnPage = "";
		CltUserDto pvo = new CltUserDto();

		pvo.setUsrId(req.getParameter("usrId"));
		pvo.setPassWd(req.getParameter("passWd"));

		CltUserDto sessionVO = userService.userLogin(pvo);

		if (null == sessionVO) {
			session.setAttribute("message", "아이디/비밀번호를 입력해 주세요.");
			returnPage = "redirect:/cltsh/user/userLogin.do";
		} else if (pvo.getUsrId().equals(sessionVO.getUsrId()) && pvo.getPassWd().equals(sessionVO.getPassWd())) {
			session.setAttribute("loginInfo", sessionVO);
			returnPage = "redirect:/cltsh/main.do";
		} else {
			session.setAttribute("message", "아이디/비밀번호를 확인해 주세요.");
			returnPage = "redirect:/cltsh/user/userLogin.do";
		}

		return returnPage;
	}

	// 회원 가입 화면 호출
	@RequestMapping("/cltsh/user/userJoin.do")
	public String userJoin(HttpServletRequest req, HttpServletResponse res) {
		List<String> birthYyList = new ArrayList<String>();
		List<String> birthMmList = new ArrayList<String>();
		List<String> birthDdList = new ArrayList<String>();

		for (int i = 1950; i <= 2022; i++) {
			birthYyList.add(String.valueOf(i));
		}
		for (int i = 1; i <= 12; i++) {
			birthMmList.add(String.valueOf(i));
		}
		for (int i = 1; i <= 31; i++) {
			birthDdList.add(String.valueOf(i));
		}

		// 셋팅값 request에 넣기
		req.setAttribute("birthYyList", birthYyList);
		req.setAttribute("birthMmList", birthMmList);
		req.setAttribute("birthDdList", birthDdList);

		return "cltsh/shp/user/join";
	}
	
	// 회원 가입 백단 로직 실행
	@RequestMapping("/cltsh/user/userJoinInsert.do")
	public String userJoinInsert(HttpServletRequest req, HttpServletResponse res, CltUserDto pvo) {
		pvo.setLoadPostNo(pvo.getLandPostNo());
		pvo.setRgstId(pvo.getUsrId());
		userService.insertUser(pvo);

		req.setAttribute("message", "회원가입을 환영합니다!");

		return "cltsh/shp/user/login";
	}

	// 로그아웃
	@RequestMapping("/cltsh/user/userLogout.do")
	public String userLogout(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		session.invalidate();
		
		return "redirect:/cltsh/main.do";
	}
}