package com.dev.ck.cltsh.shp.goods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.ck.cltsh.cmm.util.PagingUtil;
import com.dev.ck.cltsh.shp.cate.CltCateDto;
import com.dev.ck.cltsh.shp.cate.service.CltCateService;
import com.dev.ck.cltsh.shp.dress.CltDressDto;
import com.dev.ck.cltsh.shp.dress.service.CltDressService;
import com.dev.ck.cltsh.shp.goods.service.CltGoodsService;
import com.dev.ck.cltsh.shp.opts.CltOptsDto;
import com.dev.ck.cltsh.shp.opts.service.CltOptsService;
import com.dev.ck.cltsh.shp.qna.CltQnaDto;
import com.dev.ck.cltsh.shp.qna.service.CltQnaService;

@Controller
public class CltGoodsController{
	@Autowired private CltGoodsService goodsService;
	@Autowired private CltDressService dressService;
	@Autowired private CltCateService cateService;
	@Autowired private CltQnaService qnaService;
	@Autowired private CltOptsService optsService;
	
	@RequestMapping("/cltsh/goods/goodsList.do")
	public String goodsList(HttpServletRequest req, HttpServletResponse res) {
		CltGoodsDto pvo = new CltGoodsDto();
		List<CltGoodsDto> goodsList = goodsService.selectGoodsList(pvo);
		
		req.setAttribute("goodsList", goodsList);
		
		return "cltsh/shp/goods/goods_list";
	}
	
	@RequestMapping("/cltsh/goods/goodsCategory.do")
	public String goodsCategory(HttpServletRequest req, HttpServletResponse res) {
		CltGoodsDto pvo = new CltGoodsDto();
		List<CltGoodsDto> goodsList = goodsService.selectGoodsList(pvo);
		
		req.setAttribute("goodsList", goodsList);
		
		return "cltsh/shp/goods/goods_category";
	}

	@RequestMapping("/cltsh/goods/goodsCartAddAjax.do")
	public String goodsCartAddAjax(HttpServletRequest req, HttpServletResponse res) {
		return "cltsh/shp/goods/goods_category";
	}
	
	@RequestMapping("/cltsh/goods/goodsDetail.do")
	public String goodsDetail(HttpServletRequest req, HttpServletResponse res, CltQnaDto qvo) throws IOException {
		String referer = req.getHeader("Referer"); // 이전 페이지의 URL
	    
		//공통 코드 가져오기
		CltCateDto cateVO = new CltCateDto();
		List<CltCateDto> oneDepthCateList = cateService.selectCateList(cateVO);

		// 상품정보
		CltGoodsDto detail = goodsService.selectGoodsDetail(req.getParameter("searchSaleBoardSeq"));

		if(detail !=null && !"".equals(detail.getGoodsCd())) {
			// 상품정보: 옵션
			CltOptsDto ovo = new CltOptsDto();
			ovo.setGoodsCd((int) detail.getGoodsCd());
			Map<String, List<Map<String, Object>>> groupedOptions = optsService.selectoptsMap(ovo);
			
			// 리뷰
			CltDressDto dvo = new CltDressDto();
			dvo.setGoodsCd((int) detail.getGoodsCd());
			List<CltDressDto> rvo = dressService.goodsDtlDressList(dvo);
			
			////////////////////////////////////////////////////////////////////////////////
			String requestURI = (String) req.getAttribute("requestURI"); //페이징
			String page = req.getParameter("page");
			int totalCnt = qnaService.qnaCnt();
			qvo.setPath(requestURI);
			qvo.setParamPage(page);
			qvo.setTotalCnt(totalCnt);
			PagingUtil.getPagingKeys(qvo);
			////////////////////////////////////////////////////////////////////////////////
			
			qvo.setGoodsCd(detail.getGoodsCd());
			// 문의
			List<CltQnaDto> rqvo = qnaService.searchGoodsCdQna(qvo);
			
			req.setAttribute("oneDepthCateList", oneDepthCateList); //카테고리
			req.setAttribute("detail", detail); // 상품상세
			req.setAttribute("optList", groupedOptions); // 상품상세:옵션
			
			req.setAttribute("rvo", rvo);	// 리뷰 (드레스룸)
			req.setAttribute("rqvo", rqvo);	// 문의
			req.setAttribute("paging", qvo.getHtml()); //페이징
			
			return "cltsh/shp/goods/goods_detail";
		}else {
			// Referer가 있을 경우 이전 페이지로 이동
	        if (referer != null) {
	            res.sendRedirect(referer);
	        } else {
	            res.sendRedirect("/"); // 기본 페이지로 이동
	        }
	        return null;
		}
		
	}
}
