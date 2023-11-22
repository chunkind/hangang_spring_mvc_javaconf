package com.dev.ck.cltsh.shp.goods;

import java.util.List;

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
import com.dev.ck.cltsh.shp.qna.CltQnaDto;
import com.dev.ck.cltsh.shp.qna.service.CltQnaService;

@Controller
public class CltGoodsController{
	@Autowired private CltGoodsService goodsService;
	@Autowired private CltDressService dressService;
	@Autowired private CltCateService cateService;
	@Autowired private CltQnaService qnaService;
	
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
	public String goodsDetail(HttpServletRequest req, HttpServletResponse res, CltQnaDto qvo) {
		//공통 코드 가져오기
		CltCateDto cateVO = new CltCateDto();
		List<CltCateDto> oneDepthCateList = cateService.selectCateList(cateVO);
		
		
		CltGoodsDto detail = goodsService.selectGoodsDetail(req.getParameter("searchSaleBoardSeq"));
		
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
		List<CltQnaDto> rqvo = qnaService.searchGoodsCdQna(qvo);
		
		req.setAttribute("oneDepthCateList", oneDepthCateList);
		req.setAttribute("detail", detail);
		req.setAttribute("rvo", rvo);
		req.setAttribute("rqvo", rqvo);
		req.setAttribute("paging", qvo.getHtml());
		
		return "cltsh/shp/goods/goods_detail";
	}
}
