package com.dev.ck.cltsh.shp.main;

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
import com.dev.ck.cltsh.shp.main.service.CltMainService;
import com.dev.ck.cltsh.shp.qna.CltQnaDto;
import com.dev.ck.cltsh.shp.qna.service.CltQnaService;

@Controller
public class CltMainController{
	@Autowired private CltMainService mainService;
	@Autowired private CltCateService cateService;
	@Autowired private CltQnaService qnaService;
	@Autowired private CltDressService dressService;
	
	@RequestMapping("/cltsh/main.do")
	public String mainHomeList(HttpServletRequest req, HttpServletResponse res) {
		commonCode(req);
		
		CltGoodsDetailDto mainVO = new CltGoodsDetailDto();
		List<CltGoodsDetailDto> mainHomeList = mainService.selectListMainHome(mainVO);
		
		req.setAttribute("mainHomeList", mainHomeList);
		
		return "cltsh/shp/main/main_home";
	}
	
	@RequestMapping("/cltsh/main/mainCataList.do")
	public String mainCataList(HttpServletRequest req, HttpServletResponse res, CltGoodsDetailDto pvo) {
		List<CltCateDto> oneDepthCateList = commonCode(req);
 		CltCateDto cateVO = new CltCateDto();
		
		//2depth 카테고리
		String searchType = req.getParameter("searchType");
		String searchCatgryCd = req.getParameter("searchCatgryCd");
		String searchCatgryCd2 = req.getParameter("searchCatgryCd2");
		String queryStr = "";
		String queryStrArry[] = {"",""};

//		GoodsDetailVO mainVO = new GoodsDetailVO();
		if(null == searchCatgryCd || "".equals(searchCatgryCd)){
			searchCatgryCd = oneDepthCateList.get(0).getCatgryCd();
		}else {
			queryStrArry[0] += "searchCatgryCd=" + searchCatgryCd;
		}
		cateVO.setUprClassCd(searchCatgryCd);

		List<CltCateDto> twoDepthCateList = cateService.selectCateUnList(cateVO);

		if(null == searchCatgryCd2 || "".equals(searchCatgryCd2)){
			searchCatgryCd2 = twoDepthCateList.get(0).getCatgryCd();
		}else {
			queryStrArry[1] += "searchCatgryCd2=" + searchCatgryCd2;
		}
		cateVO.setCatgryCd2(searchCatgryCd2);

		if(!"all".equals(searchType)){
			pvo.setCatgryCd(searchCatgryCd);
			pvo.setCatgryCd2(searchCatgryCd2);
		}
		
		////////////////////////////////////////////////////////////////////////////////////////////
		String requestURI = (String) req.getAttribute("requestURI"); //페이징
		String page = req.getParameter("page");
		int totalCnt = mainService.searchGoodsCnt(pvo);
		
		pvo.setPath(requestURI);
		pvo.setParamPage(page);
		pvo.setTotalCnt(totalCnt);
		
		if(null == searchType || "".equals(searchType)){
			queryStr += "searchCatgryCd=" + queryStrArry[0] + "&" + "searchCatgryCd2=" + queryStrArry[1] + "&";
			pvo.setQueryStr(queryStr);
			PagingUtil.getPagingKeys(pvo);
		}
		else {
			queryStr += "searchType=" + searchType;
			pvo.setQueryStr(queryStr);
			PagingUtil.getPagingKeys(pvo);
			
		}
		////////////////////////////////////////////////////////////////////////////////////////////

		List<CltGoodsDetailDto> mainCateList = mainService.selectListMainCate(pvo);

		req.setAttribute("searchType", searchType);
		req.setAttribute("mainCateList", mainCateList);
		req.setAttribute("twoDepthCateList", twoDepthCateList);
		req.setAttribute("selectedOneDepthCate", searchCatgryCd);
		req.setAttribute("selectedTwoDepthCate", searchCatgryCd2);
		req.setAttribute("paging", pvo.getHtml());
		
		return "cltsh/shp/main/main_category";
	}
	
	@RequestMapping("/cltsh/main/mainQnaList.do")
	public String mainQnaList(HttpServletRequest req, HttpServletResponse res, CltQnaDto pvo) {
		String requestURI = (String) req.getAttribute("requestURI"); //페이징
		String page = req.getParameter("page");
		int totalCnt = qnaService.qnaCnt();
		
		pvo.setPath(requestURI);
		pvo.setParamPage(page);
		pvo.setTotalCnt(totalCnt);
		
		PagingUtil.getPagingKeys(pvo);
		
		commonCode(req);
		List<CltQnaDto> list = qnaService.qnaPageing(pvo);
		req.setAttribute("paging", pvo.getHtml());
		req.setAttribute("list", list);
		return "cltsh/shp/qna/qna";
	}

	
	@RequestMapping("/cltsh/main/mainDrssList.do")
	public String mainDrssList(HttpServletRequest req, HttpServletResponse res) {
		commonCode(req);
		
		CltDressDto dressVO = new CltDressDto();
		List<CltDressDto> list = dressService.selectDressList(dressVO);
		req.setAttribute("list", list);
		req.setAttribute("listSize", list.size());
		
		return "cltsh/shp/dress/dress_main";
	}
	
	public List<CltCateDto> commonCode(HttpServletRequest req) {
		//공통 코드 가져오기
		CltCateDto cateVO = new CltCateDto();
		List<CltCateDto> oneDepthCateList = cateService.selectCateList(cateVO);

		req.setAttribute("oneDepthCateList", oneDepthCateList);
		return oneDepthCateList;
	}	


}
