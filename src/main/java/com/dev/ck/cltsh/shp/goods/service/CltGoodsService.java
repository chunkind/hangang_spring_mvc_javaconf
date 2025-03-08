package com.dev.ck.cltsh.shp.goods.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.cltsh.shp.goods.CltGoodsDto;

@Service
public class CltGoodsService {
	@Autowired private CltGoodsMapper goodsDao;
	
	public CltGoodsDto parameterSetting(HttpServletRequest req) {
		long goodsInfoSeq = req.getParameter("goodsInfoSeq") == null? 0L : Long.parseLong(req.getParameter("goodsInfoSeq"));
		int goodsCd = req.getParameter("goodsCd") == null? 0 : Integer.parseInt(req.getParameter("goodsCd"));
		long entrNo = req.getParameter("entrNo") == null? 0L : Long.parseLong(req.getParameter("entrNo"));
		String saleStatCd = req.getParameter("saleStatCd");
		String goodsNm = req.getParameter("goodsNm");
		int goodsPrc = req.getParameter("goodsPrc") == null? 0 : Integer.parseInt(req.getParameter("goodsPrc"));
		String catgryCd = req.getParameter("catgryCd");
		String catgryCd2 = req.getParameter("catgryCd2");
		int inyQty = req.getParameter("inyQty") == null? 0 : Integer.parseInt(req.getParameter("inyQty"));
		int dlvPrc = req.getParameter("dlvPrc") == null? 0 : Integer.parseInt(req.getParameter("dlvPrc"));
		String goodsSize = req.getParameter("goodsSize");
		String goodsClr = req.getParameter("goodsClr");
		String useYn = req.getParameter("useYn");
		String goodsIntr = req.getParameter("goodsIntr");
		
		String searchEntrNo = req.getParameter("searchEntrNo");
		String searchSaleBoardSeq = req.getParameter("searchSaleBoardSeq");
		
		CltGoodsDto pvo = new CltGoodsDto();
		pvo.setGoodsInfoSeq(goodsInfoSeq);
		pvo.setGoodsCd(goodsCd);
		pvo.setEntrNo(entrNo);
		pvo.setSaleStatCd(saleStatCd);
		pvo.setGoodsNm(goodsNm);
		pvo.setGoodsPrc(goodsPrc);
		pvo.setCatgryCd(catgryCd);
		pvo.setCatgryCd2(catgryCd2);
		pvo.setInyQty(inyQty);
		pvo.setDlvPrc(dlvPrc);
		pvo.setGoodsSize(goodsSize);
		pvo.setGoodsClr(goodsClr);
		pvo.setUseYn(useYn);
		pvo.setGoodsIntr(goodsIntr);
		
		pvo.setSearchEntrNo(searchEntrNo);
		pvo.setSearchSaleBoardSeq(searchSaleBoardSeq);
		
		//첨부파일 있으면 셋팅
		String imgPath = (String) req.getAttribute("imgPath");
		if(null == imgPath || "".equals(imgPath)) {
			imgPath = req.getParameter("imgPath");
		}
		String imgNm = (String) req.getAttribute("imgNm");
		if(null == imgNm || "".equals(imgNm)) {
			imgNm = req.getParameter("imgNm");
		}
		
		if(null != imgPath && !"".equals(imgPath)) {
			pvo.setImgPath(imgPath);
		}
		if(null != imgNm && !"".equals(imgNm)) {
			pvo.setImgNm(imgNm);
		}
		
		return pvo;
	}
	
	public int goodsCnt() {
		return goodsDao.goodsCnt();
	}
	
	public List<CltGoodsDto> selectGoodsPagingList(CltGoodsDto pvo){
		return goodsDao.selectGoodsPagingList(pvo);
	}
	
	public int insertGoods(CltGoodsDto pvo) {
		
		int result = goodsDao.insertGoods(pvo);
		
		// insert 성공 시 방금 저장된 데이터의 시퀀스값 반환
		if(result > 0) {
			result = (int) pvo.getGoodsInfoSeq();
		}
		
		return result;
	}
	
	public CltGoodsDto selectGoodsOne(CltGoodsDto pvo) {
		return goodsDao.selectGoodsOne(pvo);
	}
	
	public List<CltGoodsDto> selectMypgGoodsList(CltGoodsDto pvo){
		return goodsDao.selectMypgGoodsList(pvo);
	}
	
	public CltGoodsDto selectMypgGoodsOne(CltGoodsDto pvo) {
		return goodsDao.selectMypgGoodsOne(pvo);
	}
	
	
	public CltGoodsDto selectGoodsDetail(String seq) {
		return goodsDao.selectGoodsDetail(seq);
	}
	
	public List<CltGoodsDto> selectGoodsList(CltGoodsDto pvo){
		return goodsDao.selectGoodsList(pvo);
	}
	
	public int updateGoods(CltGoodsDto pvo) {
		return goodsDao.updateGoods(pvo);
	}
	
	public int deleteGoodsOne(CltGoodsDto pvo) {
		return goodsDao.deleteGoodsOne(pvo);
	}
	
	public int deleteGoodsAll() {
		return goodsDao.deleteGoodsAll();
	}
	
	public int dropSeq() {
		return goodsDao.dropSeq();
	} 
	
	public int createSeq() {
		return goodsDao.createSeq();
	}

	//파라미터 셋팅
//	public GoodsVO parameterSetting(HttpServletRequest req) {
//		//첨부파일 있으면 셋팅
//		String imgPath = (String) req.getAttribute("imgPath");
//		if(null == imgPath || "".equals(imgPath)) {
//			imgPath = req.getParameter("imgPath");
//		}
//		String imgNm = (String) req.getAttribute("imgNm");
//		if(null == imgNm || "".equals(imgNm)) {
//			imgNm = req.getParameter("imgNm");
//		}
//		
//		if(null != imgPath && !"".equals(imgPath)) {
//			pvo.setImgPath(imgPath);
//		}
//		if(null != imgNm && !"".equals(imgNm)) {
//			pvo.setImgNm(imgNm);
//		}
//		return pvo;
//	}
}
