package com.dev.ck.cltsh.adm.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dev.ck.ackwd.utils.FileUtil;
import com.dev.ck.cltsh.cmm.util.PagingUtil;
import com.dev.ck.cltsh.shp.cate.CltCateDto;
import com.dev.ck.cltsh.shp.cate.service.CltCateService;
import com.dev.ck.cltsh.shp.code.CltCodeDto;
import com.dev.ck.cltsh.shp.code.service.CltCodeService;
import com.dev.ck.cltsh.shp.entr.CltEntrDto;
import com.dev.ck.cltsh.shp.entr.service.CltEntrService;
import com.dev.ck.cltsh.shp.goods.CltGoodsDto;
import com.dev.ck.cltsh.shp.goods.service.CltGoodsService;
import com.dev.ck.cltsh.shp.user.CltUserDto;

@Controller
@SuppressWarnings("unchecked")
public class CltAdmGoodsController{
	@Autowired private CltGoodsService goodsService;
	@Autowired private CltEntrService entrService;
	@Autowired private CltCateService cateService;
	@Autowired private CltCodeService codeService;

	// 상품 리스트 화면
	@RequestMapping("/cltsh/adm/goods/admGoodsList.do")
	public String admGoodsList(HttpServletRequest req, HttpServletResponse res, CltGoodsDto pvo) {
		String requestURI = (String) req.getAttribute("requestURI"); //페이징
		String page = req.getParameter("page");
		int totalCnt = goodsService.goodsCnt();
		
		pvo.setPath(requestURI);
		pvo.setParamPage(page);
		pvo.setTotalCnt(totalCnt);
		PagingUtil.getPagingKeys(pvo);
		
		//세션
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
		
		//검색 조건
		String searchEntrNo = pvo.getSearchEntrNo();
		
		//업체 리스트
		CltEntrDto entrVO = new CltEntrDto();
		entrVO.setUsrId(loginInfo.getUsrId());
		List<CltEntrDto> entrList = entrService.selectIdEntrList(entrVO);
		
		//판매 상태 공통코드
		CltCodeDto codeVo = new CltCodeDto();
		codeVo.setRgstId(loginInfo.getUsrId());
		List<CltCodeDto> codeList = codeService.selectSaleStatCdList(codeVo);
		
		//상품 리스트
		List<CltGoodsDto> goodsList = null;
		if(entrList.size() > 0) {
			if(null == searchEntrNo || "".equals(searchEntrNo) || "null".equals(searchEntrNo)) {
				pvo.setEntrNo(entrList.get(0).getEntrNo());
				searchEntrNo = "";
			}else {
				pvo.setEntrNo(Long.parseLong(searchEntrNo));
				goodsList = goodsService.selectGoodsPagingList(pvo);
			}
		}
		
		req.setAttribute("paging", pvo.getHtml());
		req.setAttribute("codeList", codeList);
		req.setAttribute("entrList", entrList);
		req.setAttribute("goodsList", goodsList);
		req.setAttribute("searchEntrNo", searchEntrNo);
		
		return "cltsh/adm/goods/goods_list";
	}
	
	// 상품 리스트 Ajax
	@RequestMapping("/cltsh/adm/goods/admGoodsListAjax.do")
	@ResponseBody
	public JSONObject admGoodsListAjax(HttpServletRequest req, HttpServletResponse res, CltGoodsDto pvo) {
		JSONObject data = new JSONObject();
		JSONArray jArry = new JSONArray();
		
		String searchEntrNo = pvo.getSearchEntrNo();
		pvo.setEntrNo(Long.parseLong(searchEntrNo));
		List<CltGoodsDto> goodsList = goodsService.selectGoodsList(pvo);
		
		for(int i=0; i<goodsList.size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("goodsCd", goodsList.get(i).getGoodsCd());
			obj.put("goodsNm", goodsList.get(i).getGoodsNm());
			jArry.add(obj);
		}
		
		data.put("result", "success");
		data.put("dataList", jArry);
		
		return data;
	}
	
	//상품 등록 화면
	@RequestMapping("/cltsh/adm/goods/admGoodsRegister.do")
	public String admGoodsRegister(HttpServletRequest req, HttpServletResponse res, CltGoodsDto pvo) {
		//세션
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
		
		//업체 리스트
		CltEntrDto entrVO = new CltEntrDto();
		entrVO.setUsrId(loginInfo.getUsrId());
		List<CltEntrDto> entrList = entrService.selectIdEntrList(entrVO);
		
		//카테고리 리스트
		CltCateDto cateVO = new CltCateDto();
		List<CltCateDto> upperCodeList = cateService.selectCateList(cateVO);
		cateVO.setUprClassCd(upperCodeList.get(0).getCatgryCd());
		List<CltCateDto> underCodeList = cateService.selectCateUnList(cateVO);
		
		//공통 코드 - 판매 상태 리스트
		CltCodeDto codeVo = new CltCodeDto();
		codeVo.setRgstId(loginInfo.getUsrId());
		List<CltCodeDto> codeList = codeService.selectSaleStatCdList(codeVo);
		
		req.setAttribute("codeList", codeList);
		req.setAttribute("entrList", entrList);
		req.setAttribute("upperCodeList", upperCodeList);
		req.setAttribute("underCodeList", underCodeList);
		
		return "cltsh/adm/goods/goods_register";
	}
	
	//상품 등록 액션
	@RequestMapping("/cltsh/adm/goods/admGoodsRegisterAct.do")
	public String admGoodsRegisterAct(HttpServletRequest req, HttpServletResponse res, CltGoodsDto pvo) {
		//세션
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
				
		//파일 업로드
		FileUtil.uploadFile(req, pvo.getFile1());
		
		pvo.setImgPath((String) req.getAttribute("imgPath"));
		pvo.setImgNm((String)req.getAttribute("imgNm"));
		pvo.setRgstId(loginInfo.getUsrId());
		
		int result = goodsService.insertGoods(pvo);
		req.setAttribute("pvo", pvo);
		
		return "redirect:/cltsh/adm/goods/admGoodsList.do";
	}
	
	// 상품 수정 화면
	@RequestMapping("/cltsh/adm/goods/admGoodsEdit.do")
	public String admGoodsEdit(HttpServletRequest req, HttpServletResponse res, CltGoodsDto pvo) {
		CltGoodsDto rvo = goodsService.selectGoodsOne(pvo);
		
		//세션
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
		
		//업체 리스트
		CltEntrDto entrVO = new CltEntrDto();
		entrVO.setUsrId(loginInfo.getUsrId());
		List<CltEntrDto> entrList = entrService.selectIdEntrList(entrVO);
		
		//카테고리 리스트
		CltCateDto cateVO = new CltCateDto();
		List<CltCateDto> upperCodeList = cateService.selectCateList(cateVO);
		cateVO.setUprClassCd(rvo.getCatgryCd());
		List<CltCateDto> underCodeList = cateService.selectCateUnList(cateVO);
		
		//공통 코드 - 판매 상태 리스트
		CltCodeDto codeVo = new CltCodeDto();
		codeVo.setRgstId(loginInfo.getUsrId());
		List<CltCodeDto> codeList = codeService.selectCodeList(codeVo);
		
		req.setAttribute("pvo", rvo);
		req.setAttribute("codeList", codeList);
		req.setAttribute("entrList", entrList);
		req.setAttribute("upperCodeList", upperCodeList);
		req.setAttribute("underCodeList", underCodeList);
		
		return "cltsh/adm/goods/goods_edit";
	}
	
	// 상품 수정 액션
	@RequestMapping("/cltsh/adm/goods/admGoodsEditAct.do")
	public String admGoodsEditAct(HttpServletRequest req, HttpServletResponse res, CltGoodsDto pvo) {
		//세션
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
		
		//파일 업로드
		FileUtil.uploadFile(req, pvo.getFile1());
		
		if(req.getAttribute("imgPath") != null && req.getAttribute("imgNm") != null) {
			pvo.setImgPath((String) req.getAttribute("imgPath"));
			pvo.setImgNm((String)req.getAttribute("imgNm"));
		}
		pvo.setUpdtId(loginInfo.getUsrId());
		
		int result = goodsService.updateGoods(pvo);
		req.setAttribute("pvo", pvo);
		
		return "redirect:/cltsh/adm/goods/admGoodsList.do";
	}
	
	// 상품 삭제 액션
	@RequestMapping("/cltsh/adm/goods/admGoodsRemoveAct.do")
	public String admGoodsRemoveAct(HttpServletRequest req, HttpServletResponse res, CltGoodsDto pvo) {
		int result = goodsService.deleteGoods(pvo);
		
		return "redirect:/cltsh/adm/goods/admGoodsList.do";
	}
	
	// 상품 문의 화면
	@RequestMapping("/cltsh/adm/goods/admGoodsQna.do")
	public String admGoodsQna(HttpServletRequest req, HttpServletResponse res, CltGoodsDto pvo) {
		return "cltsh/adm/goods/goods_qna";
	}
}
