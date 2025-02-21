
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
import com.dev.ck.cltsh.shp.opts.CltOptsDto;
import com.dev.ck.cltsh.shp.opts.service.CltOptsService;
import com.dev.ck.cltsh.shp.user.CltUserDto;

@Controller
@SuppressWarnings("unchecked")
public class CltAdmGoodsController{
	@Autowired private CltGoodsService goodsService;
	@Autowired private CltEntrService entrService;
	@Autowired private CltCateService cateService;
	@Autowired private CltCodeService codeService;
	@Autowired private CltOptsService optsService;

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
			}else {
				pvo.setEntrNo(Long.parseLong(searchEntrNo));
			}
			searchEntrNo = String.valueOf(pvo.getEntrNo());
			goodsList = goodsService.selectGoodsPagingList(pvo);
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
	
	// TO-BE) 상품 등록 화면
	@RequestMapping("/cltsh/adm/goods/admGoodsRegisterNew.do")
	public String admGoodsRegisterNew(HttpServletRequest req, HttpServletResponse res, CltGoodsDto pvo) {
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
		
		//상품 옵션 리스트
		CltOptsDto optsVo = new CltOptsDto();
		List<CltOptsDto> optsList = optsService.selectOptsList(optsVo);
		
		req.setAttribute("optsList", optsList);
		req.setAttribute("codeList", codeList);
		req.setAttribute("entrList", entrList);
		req.setAttribute("upperCodeList", upperCodeList);
		req.setAttribute("underCodeList", underCodeList);
		
		return "cltsh/adm/goods/goods_register_new";
	}
	
	//상품 등록 액션
	@RequestMapping("/cltsh/adm/goods/admGoodsRegisterAct.do")
	public String admGoodsRegisterAct(HttpServletRequest req, HttpServletResponse res, CltGoodsDto pvo) {
		//세션
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
		
		// 세션 체크 (로그인 정보가 없을 경우 예외 발생)
	    if (loginInfo == null) {
	    	return "redirect:/cltsh/adm/main.do";
	    }
		
		//파일 업로드
		FileUtil.uploadFile(req, pvo.getFile1());
		
		pvo.setImgPath((String) req.getAttribute("imgPath"));
		pvo.setImgNm((String)req.getAttribute("imgNm"));
		pvo.setRgstId(loginInfo.getUsrId());
		
		int resultGoodsCd = goodsService.insertGoods(pvo);
		
		String[] optsNmArray = req.getParameterValues("optsNmArray[]");
		String[] optsValArray = req.getParameterValues("optsValArray[]");
		String[] useYnArray = req.getParameterValues("useYnArray[]");
		String[] optsOrdrArray = req.getParameterValues("optsOrdrArray[]");
		String[] isMainProductArray = req.getParameterValues("isMainProductArray[]");
		String[] optInyQtyArray = req.getParameterValues("optInyQtyArray[]");
		
		// 배열 값 출력
		if (optsNmArray != null && optsValArray != null && useYnArray != null) {
			int code = 1;
			String tmpOptNm = null;
			// 데이터 반복 삽입
            for (int i = 0; i < optsNmArray.length; i++) {
            	if(null!= tmpOptNm && !tmpOptNm.equals(optsNmArray[i])) {
            		code++;
            	}
            	
            	String optsCd = String.format("%04d", code);
            	
            	int optOrdr = Integer.parseInt(optsOrdrArray[i]);
            	int optInyQty = Integer.parseInt(optInyQtyArray[i]);
            	
            	CltOptsDto opt = new CltOptsDto();
            	opt.setOptsCd(optsCd);
            	opt.setOptsNm(optsNmArray[i]);
            	opt.setOptsVal(optsValArray[i]);
            	opt.setOptsUseYn(useYnArray[i]);
            	opt.setOptsOrdr(optOrdr);
            	opt.setIsMainProduct(isMainProductArray[i]);
            	opt.setOptValInyQty(optInyQty);
            	
            	opt.setGoodsCd(resultGoodsCd);
            	opt.setRgstId(loginInfo.getUsrId());
            	opt.setUpdtId(loginInfo.getUsrId());
            	
            	tmpOptNm = optsNmArray[i];
            	optsService.insertOpts(opt);
            }
		}
		
		req.setAttribute("pvo", pvo);
		
		return "redirect:/cltsh/adm/goods/admGoodsList.do";
	}
	
	// 상품 수정 화면
	@RequestMapping("/cltsh/adm/goods/admGoodsEditNew.do")
	public String admGoodsEditNew(HttpServletRequest req, HttpServletResponse res, CltGoodsDto pvo) {
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
		codeVo.setGrpCd("STD001");
		List<CltCodeDto> codeList = codeService.selectSaleStatCdList(codeVo);
		
		//옵션리스트
		CltOptsDto optVo = new CltOptsDto();
		optVo.setGoodsCd(rvo.getGoodsCd());
		List<CltOptsDto> optList = optsService.selectAdmOptsList(optVo);
		
		req.setAttribute("pvo", rvo);
		req.setAttribute("optList", optList);
		req.setAttribute("codeList", codeList);
		req.setAttribute("entrList", entrList);
		req.setAttribute("upperCodeList", upperCodeList);
		req.setAttribute("underCodeList", underCodeList);
		
		return "cltsh/adm/goods/goods_edit_new";
	}
	
	// 상품 수정 액션
	/*
	 * [개선해야 할 내용]
	 * 1. 로직 분리 필요 => SRP(단일 책임 원칙) 적용.
	 *    - 파일업로드 로직 서비스 분리
	 *    - 상품수정 로직 서비스 분리
	 *    - 옵션수정 로직 서비스 분리
	 *    
	 * 2. 옵션변수 객체 사용으로 데이터 변환 처리
	 *    - HttpServletRequest 에서 직접 데이터를 추출하는 대신 DTO/VO 객체를 사용하여 데이터 변환 처리. 
	 *      => 객체를 활용하여 데이터 바인딩을 단순화하고, 유효성 검사 추가
	 *      
	 * 3. 예외처리 통
	 *    => 컨트롤러에서 try-catch를 직접 사용하지 않고, AOP 기반의 예외 처리 핸들러로 관리.
	 * */
	@RequestMapping("/cltsh/adm/goods/admGoodsEditAct.do")
	public String admGoodsEditAct(HttpServletRequest req, HttpServletResponse res, CltGoodsDto pvo) {
		//세션
		HttpSession session = req.getSession();
		CltUserDto loginInfo = (CltUserDto) session.getAttribute("loginInfo");
		
		// 세션 체크 (로그인 정보가 없을 경우 예외 발생)
	    if (loginInfo == null) {
	    	return "redirect:/cltsh/adm/main.do";
	    }
		
		//파일 업로드
		FileUtil.uploadFile(req, pvo.getFile1());
		
		if(req.getAttribute("imgPath") != null && req.getAttribute("imgNm") != null) {
			pvo.setImgPath((String) req.getAttribute("imgPath"));
			pvo.setImgNm((String)req.getAttribute("imgNm"));
		}
		pvo.setUpdtId(loginInfo.getUsrId());
		
		int resultGoodsCd = goodsService.updateGoods(pvo);
		
		String[] optsSeqArray = req.getParameterValues("optsSeqArray[]");
		String[] optsOrdrArray = req.getParameterValues("optsOrdrArray[]");
		String[] isMainProductArray = req.getParameterValues("isMainProductArray[]");
		String[] useYnArray = req.getParameterValues("useYnArray[]");
		String[] optInyQtyArray = req.getParameterValues("optInyQtyArray[]");
		
		// 배열 값 출력
		if (optsSeqArray != null && optsOrdrArray != null && useYnArray != null
			&& isMainProductArray != null && optInyQtyArray != null ) {

			// 데이터 반복 삽입
            for (int i = 0; i < optsSeqArray.length; i++) {
            	
            	int optSeq = Integer.parseInt(optsSeqArray[i]);
            	int optOrdr = Integer.parseInt(optsOrdrArray[i]);
            	int optInyQty = Integer.parseInt(optInyQtyArray[i]);

            	CltOptsDto opt = new CltOptsDto();
            	opt.setGoodsOptsSeq(optSeq);
            	opt.setOptsOrdr(optOrdr);
            	opt.setIsMainProduct(isMainProductArray[i]);
            	opt.setOptsUseYn(useYnArray[i]);
            	opt.setOptValInyQty(optInyQty);
            	opt.setUpdtId(loginInfo.getUsrId());
            	
            	optsService.updatePartOpts(opt);
            }
		}
		
		req.setAttribute("pvo", pvo);
		
		return "redirect:/cltsh/adm/goods/admGoodsEditNew.do?goodsInfoSeq="+pvo.getGoodsInfoSeq();
	}
	
	// 상품 삭제 액션
	@RequestMapping("/cltsh/adm/goods/admGoodsRemoveAct.do")
	public String admGoodsRemoveAct(HttpServletRequest req, HttpServletResponse res, CltGoodsDto pvo) {
		int result = goodsService.deleteGoodsOne(pvo);
		
		return "redirect:/cltsh/adm/goods/admGoodsList.do";
	}
	
	// 상품 문의 화면
	@RequestMapping("/cltsh/adm/goods/admGoodsQna.do")
	public String admGoodsQna(HttpServletRequest req, HttpServletResponse res, CltGoodsDto pvo) {
		return "cltsh/adm/goods/goods_qna";
	}
}
