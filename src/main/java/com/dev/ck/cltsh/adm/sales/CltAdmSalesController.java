package com.dev.ck.cltsh.adm.sales;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.ck.cltsh.shp.code.CltCodeDto;
import com.dev.ck.cltsh.shp.code.service.CltCodeService;
import com.dev.ck.cltsh.shp.entr.CltEntrDto;
import com.dev.ck.cltsh.shp.entr.service.CltEntrService;
import com.dev.ck.cltsh.shp.goods.CltGoodsDto;
import com.dev.ck.cltsh.shp.goods.service.CltGoodsService;
import com.dev.ck.cltsh.shp.sales.CltSalesDto;
import com.dev.ck.cltsh.shp.sales.service.CltSalesService;
import com.dev.ck.cltsh.shp.user.CltUserDto;

@Controller
public class CltAdmSalesController{
	@Autowired private CltSalesService salesService;
	@Autowired private CltGoodsService goodsService;
	@Autowired private CltEntrService entrService;
	@Autowired private CltCodeService codeService;
	
	//어드민 판매게시판 리스트
	@RequestMapping("/cltsh/adm/sales/admSalesList.do")
	public String admSalesList(HttpServletRequest req, HttpServletResponse res, CltSalesDto pvo) {
		commonCode(req);
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
		
		CltEntrDto entrPvo = new CltEntrDto();
		entrPvo.setUsrId(loginInfo.getUsrId());
		List<CltEntrDto> entrList = entrService.selectIdEntrList(entrPvo);
		
		long searchEntrNo = 0L;
		if(null != pvo.getSearchEntrNo() && !"".equals(pvo.getSearchEntrNo())){
			searchEntrNo = Long.parseLong(pvo.getSearchEntrNo());
		}else{
			searchEntrNo = entrList.get(0).getEntrNo();
		}
	
		pvo.setEntrNo(searchEntrNo);
		
		List<CltSalesDto> salesList = salesService.entrSalesList(pvo);

		req.setAttribute("salesList", salesList);
		req.setAttribute("searchEntrNo", searchEntrNo);
		req.setAttribute("entrList", entrList);

		return "cltsh/adm/sales/sales_list";
	}
	
	//어드민 판매게시판 등록 화면
	@RequestMapping("/cltsh/adm/sales/admSalesRegister.do")
	public String admSalesRegister(HttpServletRequest req, HttpServletResponse res, CltSalesDto pvo) {
		//판매상태 공통코드
		CltCodeDto codeVO = new CltCodeDto();
		List<CltCodeDto> saleCodeList = codeService.selectSaleStatCdList(codeVO);
				
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
		
		CltEntrDto evo = new CltEntrDto();
		evo.setUsrId(loginInfo.getUsrId());
		List<CltEntrDto> entrList = entrService.selectIdEntrList(evo);
		String searchEntrNo = String.valueOf(entrList.get(0).getEntrNo());
		
		//등록가능한 상품 표시
		CltGoodsDto goodsVO = new CltGoodsDto();
		goodsVO.setSearchEntrNo(searchEntrNo);
		List<CltGoodsDto> goodsList = goodsService.selectGoodsList(goodsVO);

		req.setAttribute("entrList", entrList);
		req.setAttribute("saleCodeList", saleCodeList);
		req.setAttribute("goodsList", goodsList);
		req.setAttribute("searchEntrNo", searchEntrNo);

		return "cltsh/adm/sales/sales_register";
	}
	
	//어드민 판매게시판 등록 액션
	@RequestMapping("/cltsh/adm/sales/admSalesRegisterAct.do")
	public String admSalesRegisterAct(HttpServletRequest req, HttpServletResponse res, CltSalesDto pvo) {
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
		
		pvo.setQryCnt(0);
		pvo.setLkeCnt(0);
		pvo.setRgstId(loginInfo.getUsrId());
		pvo.setUpdtId(loginInfo.getUsrId());
		pvo.setDescription("설명 없음.");
		
		int result = salesService.insertSales(pvo);

		return "redirect:/cltsh/adm/sales/admSalesList.do";
	}
	
	//어드민 판매게시판 수정 화면
	@RequestMapping("/cltsh/adm/sales/admSalesUpdate.do")
	public String admSalesUpdate(HttpServletRequest req, HttpServletResponse res, CltSalesDto pvo) {
		commonCode(req);
		CltSalesDto detail = salesService.selectSalesOne(pvo);

		//등록가능한 상품 표시
		CltGoodsDto goodsVO = new CltGoodsDto();
		goodsVO.setSearchEntrNo(String.valueOf(detail.getEntrNo()));
		List<CltGoodsDto> goodsList = goodsService.selectGoodsList(goodsVO);

		req.setAttribute("detail", detail);
		req.setAttribute("goodsList", goodsList);

		return "cltsh/adm/sales/sales_edit";
	}
	
	//어드민 판매게시판 수정 액션
	@RequestMapping("/cltsh/adm/sales/admSalesUpdateAct.do")
	public String admSalesUpdateAct(HttpServletRequest req, HttpServletResponse res, CltSalesDto pvo) {
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
		
		pvo.setQryCnt(0);
		pvo.setLkeCnt(0);
		pvo.setUpdtId(loginInfo.getUsrId());
		pvo.setUseYn("Y");
		pvo.setDescription("설명 없음.");

		int result = salesService.updateSales(pvo);

		return "redirect:/cltsh/adm/sales/admSalesList.do";
	}
	
	//어드민 판매게시판 삭제 액션
	@RequestMapping("/cltsh/adm/sales/admSalesRemoveAct.do")
	public String admSalesRemoveAct(HttpServletRequest req, HttpServletResponse res, CltSalesDto pvo) {
		int result = salesService.deleteSales(pvo);

		return "redirect:/cltsh/adm/sales/admSalesList.do";
	}
	
	public void commonCode(HttpServletRequest req) {
		//세션값 빼기
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
		
//		if(null == loginInfo) {
//			modelAndView.setPath("/DispatcherServlet?command=user_login");
//			modelAndView.setRedirect(true);
//			return modelAndView;
//		}
		
		//업체 리스트
		CltEntrDto entrVO = new CltEntrDto();
		List<CltEntrDto> entrList = entrService.selectEntrList(entrVO);
		req.setAttribute("entrList", entrList);
		
		//판매상태 공통코드
		CltCodeDto codeVO = new CltCodeDto();
		codeVO.setSearchGrpCd("STD001");
		List<CltCodeDto> saleCodeList = codeService.selectCodeList(codeVO);
		req.setAttribute("saleCodeList", saleCodeList);
	}
}
