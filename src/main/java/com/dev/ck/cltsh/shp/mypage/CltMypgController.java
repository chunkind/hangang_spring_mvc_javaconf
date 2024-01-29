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
		CltUserDto loginVo = commonCode(req);
		
		mypgVO.setUsrId(loginVo.getUsrId());
		List<CltMypgDto> mypgList = mypgService.selectMypgList(mypgVO);
		
		for (CltMypgDto mypg : mypgList) {
			String bulTitNms = mypg.getBulTitNm();
			
			if (bulTitNms != null && !bulTitNms.isEmpty()) {
				String[] titles = bulTitNms.split(",");
				// titles 배열을 활용하여 원하는 처리 수행
				// 예: 첫 번째 값은 대표 이름, 나머지는 ,로 구분된 추가 항목들
				if(titles.length != 1) {
					String processedBulTitNms = titles[0].trim() + " 외 " + (titles.length - 1) + "건";
					mypg.setBulTitNms(processedBulTitNms);
				}else {
					String processedBulTitNms = titles[0].trim();
					mypg.setBulTitNms(processedBulTitNms);
				}
			}
		}
		
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
		CltUserDto loginVo = commonCode(req);
		
		CltOrderDto ordList = orderService.selectOrdOne(ordVo);
		
		List<CltOrderDto> ordDtlList = orderService.searchOrdNoList(ordVo);
//		ordVo.setUsrId(loginVo.getUsrId());
		
		CltGoodsDto goodsVo = new CltGoodsDto();
		goodsVo.setGoodsCd(ordList.getGoodsCd());
		CltGoodsDto searchGoods = goodsService.selectMypgGoodsOne(goodsVo);//selectMypgSalesOne
		
		CltSalesDto salesVo = new CltSalesDto();
		salesVo.setGoodsCd(ordList.getGoodsCd());
		CltSalesDto searchSalesGoods = salesService.selectMypgSalesOne(salesVo);
		
		req.setAttribute("ordList", ordList);
		req.setAttribute("ordDtlList", ordDtlList);
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
