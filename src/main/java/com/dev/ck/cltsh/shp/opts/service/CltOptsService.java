package com.dev.ck.cltsh.shp.opts.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.cltsh.shp.opts.CltOptsDto;

@Service
public class CltOptsService {
	@Autowired private CltOptsMapper optsDao;
	
	public CltOptsDto parameterSetting(HttpServletRequest req) {
		int goodsOptsSeq = Integer.parseInt(req.getParameter("goodsOptsSeq"));
		String optsCd = req.getParameter("optsCd");
		String optsNm = req.getParameter("optsNm");
		String optsVal = req.getParameter("optsVal");
		String useYn = req.getParameter("useYn");
		String rgstId = req.getParameter("rgstId");
		String rgstDate = req.getParameter("rgstDate");
		String updtId = req.getParameter("updtId");
		String updtDate = req.getParameter("updtDate");
		int goodsCd = Integer.parseInt(req.getParameter("goodsCd"));

		CltOptsDto pvo = new CltOptsDto();
		pvo.setGoodsOptsSeq(goodsOptsSeq);
		pvo.setRgstDate(rgstDate);
		pvo.setOptsCd(optsCd);
		pvo.setOptsNm(optsNm);
		pvo.setOptsVal(optsVal);
		pvo.setUseYn(useYn);
		pvo.setRgstId(rgstId);
		pvo.setRgstDate(rgstDate);
		pvo.setUpdtId(updtId);
		pvo.setUpdtDate(updtDate);
		pvo.setGoodsCd(goodsCd);
		return pvo;
	}
	
	public CltOptsDto selectOptsOne(CltOptsDto pvo) {
		return optsDao.selectOptsOne(pvo);
	};
	
	public List<CltOptsDto> selectOptsList(CltOptsDto pvo){
		return optsDao.selectOptsList(pvo);
	};
	
	public int insertOpts() {
		return optsDao.insertOpts();
	};
	
	public int updateOpts(CltOptsDto pvo) {
		return optsDao.updateOpts(pvo);
	};
	
	public int deleteOptsOne(CltOptsDto pvo) {
		return optsDao.deleteOptsOne(pvo);
	};
	
	public int deleteOptsAll() {
		return optsDao.deleteOptsAll();
	};
}
