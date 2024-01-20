package com.dev.ck.cltsh.shp.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.ck.cltsh.shp.cate.CltCateDto;
import com.dev.ck.cltsh.shp.cate.service.CltCateService;
import com.dev.ck.cltsh.shp.goods.CltGoodsDto;
import com.dev.ck.cltsh.shp.goods.service.CltGoodsService;
import com.dev.ck.cltsh.shp.mypage.service.CltMypgService;
import com.dev.ck.cltsh.shp.order.CltOrderDto;
import com.dev.ck.cltsh.shp.order.service.CltOrderService;
import com.dev.ck.cltsh.shp.qna.CltQnaDto;
import com.dev.ck.cltsh.shp.qna.service.CltQnaService;
import com.dev.ck.cltsh.shp.sales.CltSalesDto;
import com.dev.ck.cltsh.shp.sales.service.CltSalesService;
import com.dev.ck.cltsh.shp.user.CltUserDto;

@Controller
public class CltMypgController{
	@Autowired private CltOrderService orderService;
	@Autowired private CltGoodsService goodsService;
	@Autowired private CltQnaService qnaService;
	@Autowired private CltMypgService mypgService;
	@Autowired private CltCateService cateService;
	@Autowired private CltSalesService salesService;
	
	@RequestMapping("/cltsh/mypage/mypage.do")
	public String mypage(HttpServletRequest req, HttpServletResponse res, CltMypgDto mypgVO) {
	////////////////////////////////////////////////////////////////////////////////////////////
//		int pagePerRows = Config.PAGE_PER_ROWS;
//	
//		int page = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
//		int x = 0;
//	
//		if (page > pagePerRows) {
//			x = (int) (page / pagePerRows);
//			if (page % 10 == 0 && page > 10) { // page가 10보다 크고 10의 배수일 경우 -1
//				x--;
//			}
//		}
//	
//		mypgVO.setPage(page);
//		mypgVO.setPagePerRow(pagePerRows);
//	
//		int ordCnt = mypgService.ordCnt(); // 문의 갯수
//		int maxPage = ordCnt / pagePerRows; // 페이지 갯수
//		ordCnt = maxPage;
//		int minPage = 1;
//		boolean isNext = false;
//	
//		if (maxPage > pagePerRows) {
//			maxPage = pagePerRows + (pagePerRows * x);
//			minPage = (pagePerRows * x) + 1;
//			isNext = true;
//		} else if (maxPage == pagePerRows) {
//			maxPage = pagePerRows;
//		}
//		
//		req.setAttribute("isNext", isNext);
//		req.setAttribute("maxPage", maxPage);
//		req.setAttribute("minPage", minPage);
//		req.setAttribute("page", page);
//		req.setAttribute("ordCnt", ordCnt);
	////////////////////////////////////////////////////////////////////////////////////////////
		CltUserDto loginVo = commonCode(req);
		
		mypgVO.setUsrId(loginVo.getUsrId());
		List<CltMypgDto> mypgList = mypgService.selectMypgList(mypgVO);

		req.setAttribute("mypgList", mypgList);

		return "cltsh/shp/mypage/mypage";
	}
	
	@RequestMapping("/cltsh/mypage/mypageCoupon.do")
	public String mypageCoupon(HttpServletRequest req, HttpServletResponse res) {
		commonCode(req);
		return "cltsh/shp/mypage/mypage_coupon";
	}
	
	@RequestMapping("/cltsh/mypage/mypageDetail.do")
	public String mypageDetail(HttpServletRequest req, HttpServletResponse res, CltOrderDto ordVo) {
//		HttpSession session = req.getSession();
//		UserVO loginVo = (UserVO) session.getAttribute("loginInfo");
		CltUserDto loginVo = commonCode(req);
		
		CltOrderDto ordList = orderService.searchOrdNoList(ordVo);
		ordVo.setUsrId(loginVo.getUsrId());
		
		CltGoodsDto goodsVo = new CltGoodsDto();
		goodsVo.setGoodsCd(ordList.getGoodsCd());
		CltGoodsDto searchGoods = goodsService.selectMypgGoodsOne(goodsVo);//selectMypgSalesOne
		
		CltSalesDto salesVo = new CltSalesDto();
		salesVo.setGoodsCd(ordList.getGoodsCd());
		CltSalesDto searchSalesGoods = salesService.selectMypgSalesOne(salesVo);
		
		req.setAttribute("ordList", ordList);
		req.setAttribute("searchGoods", searchGoods);
		req.setAttribute("searchSalesGoods", searchSalesGoods);

		return "cltsh/shp/mypage/mypage_detail";
	}
	
	@RequestMapping("/cltsh/mypage/mypagePoint.do")
	public String mypagePoint(HttpServletRequest req, HttpServletResponse res) {
		commonCode(req);
		return "cltsh/shp/mypage/mypage_point";
	}
	
	@RequestMapping("/cltsh/mypage/mypageQna.do")
	public String mypageQna(HttpServletRequest req, HttpServletResponse res) {
//		HttpSession session = req.getSession();
//		UserVO loginVo = (UserVO) session.getAttribute("loginInfo");
		CltUserDto loginVo = commonCode(req);
		
		CltQnaDto qnaVO = new CltQnaDto();
		qnaVO.setRgstId(loginVo.getUsrId());
		List<CltQnaDto> qnaList = qnaService.searchIdQnaList(qnaVO);
		
		req.setAttribute("qnaList", qnaList);
		
		return "cltsh/shp/mypage/mypage_qna";
	}
	
	//카테고리 oneDepth, 로그인 정보
	public CltUserDto commonCode(HttpServletRequest req) {
		//공통 코드 가져오기
		CltCateDto cateVO = new CltCateDto();
		List<CltCateDto> oneDepthCateList = cateService.selectCateList(cateVO);
		req.setAttribute("oneDepthCateList", oneDepthCateList);
		
		//로그인 정보 가져오기
		HttpSession session = req.getSession();
		CltUserDto loginVo = (CltUserDto) session.getAttribute("loginInfo");
		
		if(loginVo == null) {
			session.setAttribute("message", "로그인을 해주세요.");
			return null;
		}
		
		return loginVo;
	}
}
