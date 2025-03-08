package com.dev.ck.cltsh.shp.dress;

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
import com.dev.ck.cltsh.shp.cate.CltCateDto;
import com.dev.ck.cltsh.shp.cate.service.CltCateService;
import com.dev.ck.cltsh.shp.dress.service.CltDressService;
import com.dev.ck.cltsh.shp.main.CltGoodsDetailDto;
import com.dev.ck.cltsh.shp.main.service.CltMainService;
import com.dev.ck.cltsh.shp.user.CltUserDto;

@Controller
@SuppressWarnings("unchecked")
public class CltDressController {
	@Autowired private CltDressService dressService;
	@Autowired private CltCateService cateService;
	@Autowired private CltMainService mainService;

	@RequestMapping("/cltsh/dress/dressRegister.do")
	public String dressRegister(HttpServletRequest req, HttpServletResponse res, CltDressDto pvo) {
		CltUserDto loginVo = commonCode(req);
		
		if(loginVo == null) {
			return "redirect:/cltsh/user/userLogin.do";
		}

		pvo.setUsrId(loginVo.getUsrId());
		List<CltDressDto> writeList = dressService.selectWriteSaleRvw(pvo);
		req.setAttribute("writeList", writeList);
		
		return "cltsh/shp/dress/dress_register";
	}
	
	@RequestMapping("/cltsh/dress/dressRegisterAct.do")
	public String dressRegisterAct(HttpServletRequest req, HttpServletResponse res, CltDressDto pvo) {
		CltUserDto loginVo = commonCode(req);
		
		//파일 업로드
		FileUtil.uploadFile(req, pvo.getFile1());
		

		String[] strArr = null;

		if(null != pvo.getSelectedSaleRvwItem()){
			System.out.print("pvo.getSelectedSaleRvwItem() : " + pvo.getSelectedSaleRvwItem());
			strArr = pvo.getSelectedSaleRvwItem().split("@");
			
		}

		System.out.print("strArr : " + strArr);
		pvo.setOrdNo(strArr[0]);
		pvo.setSaleBoardSeq(Integer.parseInt(strArr[1]));
		pvo.setGoodsCd(Integer.parseInt(strArr[2]));
		pvo.setEntrNo(Integer.parseInt(strArr[3]));
		pvo.setOrdClmDtlSn(Integer.parseInt(strArr[4]));
		pvo.setRgstId(loginVo.getUsrId());
		pvo.setUpdtId(loginVo.getUsrId());
		pvo.setImgPath((String) req.getAttribute("imgPath"));
		pvo.setImgNm((String)req.getAttribute("imgNm"));
		
		int result = dressService.insertDress(pvo);
		
		req.setAttribute("pvo", pvo);
		
		return "redirect:/cltsh/main/mainDrssList.do";
	}
	
	@RequestMapping("/cltsh/dress/dressEdit.do")
	public String dressEdit(HttpServletRequest req, HttpServletResponse res, CltDressDto pvo) {
		CltDressDto rvo = dressService.selectDressOne(pvo);
		req.setAttribute("pvo", rvo);
		
		return "cltsh/shp/dress/dress_edit";
	}
	
	@RequestMapping("/cltsh/dress/dressEditAct.do")
	public String dressEditAct(HttpServletRequest req, HttpServletResponse res, CltDressDto pvo) {
		CltUserDto loginVo = commonCode(req);
		
		//파일 업로드
		FileUtil.uploadFile(req, pvo.getFile1());
		
		pvo.setImgPath((String) req.getAttribute("imgPath"));
		pvo.setImgNm((String)req.getAttribute("imgNm"));
		pvo.setUpdtId(loginVo.getUsrId());
		pvo.setUseYn("Y");
		int result = dressService.updateDress(pvo);
		
		req.setAttribute("pvo", pvo);
		
		return "redirect:/cltsh/main/mainDrssList.do";
	}
	
	@RequestMapping("/cltsh/dress/dressDetail.do")
	public String dressDetail(HttpServletRequest req, HttpServletResponse res, CltDressDto pvo) {
		//공통 코드 가져오기
		CltCateDto cateVO = new CltCateDto();
		List<CltCateDto> oneDepthCateList = cateService.selectCateList(cateVO);
		req.setAttribute("oneDepthCateList", oneDepthCateList);
		
		CltDressDto rvo = dressService.selectDressOne(pvo);
		
		req.setAttribute("pvo", rvo);
		
		return "cltsh/shp/dress/dress_detail";
	}
	
	@RequestMapping("/cltsh/dress/dressRemoveAct.do")
	public String dressRemoveAct(HttpServletRequest req, HttpServletResponse res, CltDressDto pvo) {
		int result = dressService.deleteDress(pvo);
		
		return "redirect:/cltsh/main/mainDrssList.do";
	}
	
	@RequestMapping("/cltsh/dress/DressCateAjax.do")
	@ResponseBody
	public JSONObject DressCateAjax(HttpServletRequest req, HttpServletResponse res) {
		JSONObject data = new JSONObject();
		JSONArray jArry = new JSONArray();
		
		String oneDepthCate = req.getParameter("oneDepthCateList");
		CltCateDto cateVO = new CltCateDto();
		cateVO.setUprClassCd(oneDepthCate);
		
		List<CltCateDto> twoDepthCateList = cateService.selectCateUnList(cateVO);
		
		for(int i=0; i<twoDepthCateList.size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("catgryCd", twoDepthCateList.get(i).getCatgryCd());
			obj.put("catgryNm", twoDepthCateList.get(i).getCatgryNm());
			jArry.add(obj);
		}
		
		data.put("result", "success");
		data.put("dataList", jArry);
		
		return data;
	}
	
	@RequestMapping("/cltsh/dress/DressCateAjax2.do")
	@ResponseBody
	public JSONObject DressCateAjax2(HttpServletRequest req, HttpServletResponse res) {
		JSONObject data = new JSONObject();
		JSONArray jArry = new JSONArray();
		
		String oneDepthCate = req.getParameter("oneDepthCateList");
		String twoDepthCateList = req.getParameter("twoDepthCateList");
		CltGoodsDetailDto mainVO = new CltGoodsDetailDto();
		mainVO.setSearchCatgryCd(oneDepthCate);
		mainVO.setSearchCatgryCd2(twoDepthCateList);
		
		List<CltGoodsDetailDto> searchGoodsList = mainService.selectListMainCate(mainVO);
		
		for(int i=0; i<searchGoodsList.size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("goodsNm", searchGoodsList.get(i).getGoodsNm());
			obj.put("goodsCd", searchGoodsList.get(i).getGoodsCd());
			jArry.add(obj);
		}
		
		data.put("result", "success");
		data.put("dataList", jArry);
		
		return data;
	}
	
	@RequestMapping("/cltsh/dress/DressCateAjax3.do")
	@ResponseBody
	public JSONObject DressCateAjax3(HttpServletRequest req, HttpServletResponse res) {
		JSONObject data = new JSONObject();
		JSONArray jArry = new JSONArray();
		
		String searchGoodsCd = req.getParameter("searchGoodsList");
		
		CltGoodsDetailDto mainVO = new CltGoodsDetailDto();
		mainVO.setSearchGoodsCd(searchGoodsCd);
			
		List<CltGoodsDetailDto> searchGoods = mainService.selectListMainCate(mainVO);
		
		for(int i=0; i<searchGoods.size(); i++) {
			JSONObject obj = new JSONObject();
			obj.put("imgPath", searchGoods.get(i).getImgPath());
			obj.put("imgNm", searchGoods.get(i).getImgNm());
			jArry.add(obj);
		}
		
		data.put("result", "success");
		data.put("dataList", jArry);
		
		return data;
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
