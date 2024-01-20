package com.dev.ck.cltsh.shp.qna;

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
import com.dev.ck.cltsh.shp.qna.service.CltQnaService;
import com.dev.ck.cltsh.shp.user.CltUserDto;

@Controller
public class CltQnaController{
	@Autowired private CltQnaService qnaService;
	@Autowired private CltCateService cateService;
	@Autowired private CltGoodsService goodsService;
	
	/* QNA */
	@RequestMapping("/cltsh/qna/qnaList.do")
	public String qnaList(HttpServletRequest req, HttpServletResponse res) {
		CltQnaDto pvo = new CltQnaDto();
		List<CltQnaDto> list = qnaService.selectQnaList(pvo);
		req.setAttribute("list", list);

		return "cltsh/shp/qna/qna";
	}
	
	/* 상세페이지 */
	@RequestMapping("/cltsh/qna/qnaDetail.do")
	public String qnaDetail(HttpServletRequest req, HttpServletResponse res) {
		commonCode(req);
		
		CltQnaDto pvo = new CltQnaDto();
		pvo.setQnaBoardSeq(Long.parseLong(req.getParameter("qnaBoardSeq")));
		
		CltQnaDto rvo = qnaService.selectQnaOne(pvo);
		
		req.setAttribute("pvo", rvo);
		
		return "cltsh/shp/qna/qna_detail";
	}
	
	/* 입력 화면 호출 */
	@RequestMapping("/cltsh/qna/qnaInsert.do")
	public String qnaInsert(HttpServletRequest req, HttpServletResponse res) {
		commonCode(req);
		
		return "cltsh/shp/qna/qna_insert";
	}
	
	/* 입력 화면 호출 */
	@RequestMapping("/cltsh/qna/goodsDtlQnaInsert.do")
	public String goodsDtlQnaInsert(HttpServletRequest req, HttpServletResponse res) {
		commonCode(req);
		
		CltGoodsDto gvo = new CltGoodsDto();
		gvo.setGoodsCd(Integer.parseInt(req.getParameter("goodsCd")));
		CltGoodsDto rvo = goodsService.selectMypgGoodsOne(gvo);
		
		req.setAttribute("rvo", rvo);
		
		return "cltsh/shp/qna/goods_dtl_qna_insert";
	}
	
	/* 입력 액션 */
	@RequestMapping("/cltsh/qna/qnaInsertAct.do")
	public String qnaInsertAct(HttpServletRequest req, CltQnaDto pvo) {
		HttpSession session = req.getSession();
		CltUserDto loginVo = (CltUserDto) session.getAttribute("loginInfo");
		pvo.setRgstId(loginVo.getUsrId());
		pvo.setUseYn("Y");
		pvo.setAnswer("미답변");
		
		if(pvo.getPassYn() == "N") {
			pvo.setPassWd("N");
		}
		
		int result = qnaService.insertQna(pvo);
		req.setAttribute("pvo", pvo);
		
		return "redirect:/cltsh/main/mainQnaList.do";
	}
	
	/* 수정 화면 호출 */
	@RequestMapping("/cltsh/qna/qnaEdit.do")
	public String qnaEdit(HttpServletRequest req, CltQnaDto pvo) {
		commonCode(req);
		
		CltQnaDto rvo = qnaService.selectQnaOne(pvo);
		
		req.setAttribute("pvo", rvo);
		
		return "cltsh/shp/qna/qna_edit";
	}
	
	/* 수정 액션 */
	@RequestMapping("/cltsh/qna/qnaEditAct.do")
	public String qnaEditAct(HttpServletRequest req, HttpServletResponse res, CltQnaDto pvo) {
		commonCode(req);
		
		HttpSession session = req.getSession();
		CltUserDto loginVo = (CltUserDto) session.getAttribute("loginInfo");
		
		pvo.setUpdtId(loginVo.getUsrId());
		int result = qnaService.updateQna(pvo);
		
		req.setAttribute("pvo", pvo);
		
		return "redirect:/cltsh/main/mainQnaList.do";
	}
	
	/* 입력 화면 호출 */
	@RequestMapping("/cltsh/qna/qnaRemoveAct.do")
	public String qnaRemoveAct(HttpServletRequest req, HttpServletResponse res, CltQnaDto pvo) {
		commonCode(req);
		int result = qnaService.deleteQna(pvo);
		req.setAttribute("pvo", pvo);
		return "redirect:/cltsh/main/mainQnaList.do";
	}
	
	//카테고리 oneDepth
	public void commonCode(HttpServletRequest req) {
		//공통 코드 가져오기
		CltCateDto cateVO = new CltCateDto();
		List<CltCateDto> oneDepthCateList = cateService.selectCateList(cateVO);

		req.setAttribute("oneDepthCateList", oneDepthCateList);
	}
}
