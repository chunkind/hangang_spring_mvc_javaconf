package com.dev.ck.cltsh.shp.opts.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.ck.cltsh.shp.cate.CltCateDto;
import com.dev.ck.cltsh.shp.opts.CltOptsDto;

@Service
public class CltOptsService {
	@Autowired private CltOptsMapper optsDao;
	
	public CltOptsDto parameterSetting(HttpServletRequest req) {
		int addTxtCnt = req.getParameter("addTextCnt") == null? 0 : Integer.parseInt(req.getParameter("addTextCnt"));
		int optsCnt = req.getParameter("optsCnt") == null? 0 : Integer.parseInt(req.getParameter("optsCnt"));
		int goodsOptsSeq = req.getParameter("goodsOptsSeq") == null? 0 :Integer.parseInt(req.getParameter("goodsOptsSeq"));
		String optsCd = req.getParameter("optsCd");
		String optsNm = req.getParameter("optsNm");
		String optsVal = req.getParameter("optsVal");
		String useYn = req.getParameter("useYn");
		String rgstId = req.getParameter("rgstId");
		String rgstDate = req.getParameter("rgstDate");
		String updtId = req.getParameter("updtId");
		String updtDate = req.getParameter("updtDate");
		int goodsCd = Integer.parseInt(req.getParameter("goodsCd"));
		String optsType = req.getParameter("optsType");
		
		/* 기존 옵션 */
		int[] goodsOptsSeqArr = new int[optsCnt + 1];
		String[] optsNmArr = new String[optsCnt + 1];
		String[] optsValArr = new String[optsCnt + 1];
		String[] optsCdArr = new String[optsCnt + 1];
		int[] goodsCdArr = new int[optsCnt + 1];
		String[] useYnArr = new String[optsCnt + 1];
		String[] optsTypeArr = new String[optsCnt + 1];
		
		/* 추가 할 옵션 */
		String [] addOptsTypeArr = new String[addTxtCnt + 1];
		String[] addOptsCdArr = new String[addTxtCnt + 1];
		String[] addOptsNmArr = new String[addTxtCnt + 1];
		String[] addOptsValArr = new String[addTxtCnt + 1];
		int[] addGoodsCdArr = new int[addTxtCnt + 1];
		String[] addUseYnArr = new String[addTxtCnt + 1];
		
		/* 기존 옵션 */
		for(int i = 0; i <= optsCnt; i++) {
//			goodsOptsSeqArr[i] = Integer.parseInt(req.getParameter("goodsOptsSeq"+i));
			optsTypeArr[i] = req.getParameter("optsType"+i);
			optsCdArr[i] = req.getParameter("optsCd"+i);
			optsNmArr[i] = req.getParameter("optsNm"+i);
			optsValArr[i] = req.getParameter("optsVal"+i);
			goodsCdArr[i] = Integer.parseInt(req.getParameter("goodsCd"));
			useYnArr[i] = req.getParameter("useYn"+i);
		}
		
		/* 추가 할 옵션 */
		for(int i = 0; i <= addTxtCnt; i++) {
			addOptsTypeArr[i] = req.getParameter("addOptsType"+i);
			addOptsCdArr[i] = req.getParameter("addOptsCd"+i);
			addOptsNmArr[i] = req.getParameter("addOptsNm"+i);
			addOptsValArr[i] = req.getParameter("addOptsVal"+i);
			addGoodsCdArr[i] = Integer.parseInt(req.getParameter("goodsCd"));
			addUseYnArr[i] = req.getParameter("addUseYn"+i);
		}
		
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
		pvo.setOptsType(optsType);
		pvo.setGoodsOptsSeqArr(goodsOptsSeqArr);
		pvo.setOptsTypeArr(optsTypeArr);
		pvo.setAddOptsTypeArr(addOptsTypeArr);
		pvo.setOptsCdArr(optsCdArr);
		pvo.setAddOptsCdArr(addOptsCdArr);
		pvo.setOptsNmArr(optsNmArr);
		pvo.setAddOptsNmArr(addOptsNmArr);
		pvo.setOptsValArr(optsValArr);
		pvo.setAddOptsValArr(addOptsValArr);
		pvo.setGoodsCdArr(goodsCdArr);
		pvo.setAddGoodsCdArr(addGoodsCdArr);
		pvo.setUseYnArr(useYnArr);
		pvo.setAddUseYnArr(addUseYnArr);
		return pvo;
	}
	
	public int saveOpts(CltOptsDto pvo) {
		int result = 1;
		
		/* 기존 옵션 */
		int[] goodsOptsSeqArr = pvo.getGoodsOptsSeqArr();
		String[] optsTypeArr = pvo.getOptsTypeArr();
		String[] optsNmArr = pvo.getOptsNmArr();
		String[] optsValArr = pvo.getOptsValArr();
		String[] optsCdArr = pvo.getOptsCdArr();
		int[] goodsCdArr = pvo.getGoodsCdArr();
		String[] useYnArr = pvo.getUseYnArr();
		
		/* 추가 할 옵션 */
		String[] addOptsTypeArr = pvo.getAddOptsTypeArr();
		String[] addOptsNmArr = pvo.getAddOptsNmArr();
		String[] addOptsValArr = pvo.getAddOptsValArr();
		String[] addOptsCdArr = pvo.getAddOptsCdArr();
		int[] addGoodsCdArr = pvo.getAddGoodsCdArr();
		String[] addUseYnArr = pvo.getAddUseYnArr();
		
		try {
			for (int i = 0; i <= pvo.getOptsNmArr().length-1; i++) {
				pvo.setGoodsOptsSeq(goodsOptsSeqArr[i]);
				pvo.setOptsType(optsTypeArr[i]);
				pvo.setOptsNm(optsNmArr[i]);
				pvo.setOptsVal(optsValArr[i]);
				pvo.setOptsCd(optsCdArr[i]);
				pvo.setGoodsCd(goodsCdArr[i]);
				pvo.setUseYn(useYnArr[i]);
				optsDao.updateOpts(pvo);
			}
			
			for (int i = 0; i <= pvo.getAddOptsNmArr().length-1; i++) {
				pvo.setOptsType(addOptsTypeArr[i]);
				pvo.setOptsNm(addOptsNmArr[i]);
				pvo.setOptsVal(addOptsValArr[i]);
				pvo.setOptsCd(addOptsCdArr[i]);
				pvo.setGoodsCd(addGoodsCdArr[i]);
				pvo.setUseYn(addUseYnArr[i]);
				optsDao.insertOpts(pvo);
			}
		} catch (Exception e) {
			result = 0;
		}
		
		return result;
	}
	
	public CltOptsDto selectOptsOne(CltOptsDto pvo) {
		return optsDao.selectOptsOne(pvo);
	};
	
	public List<CltOptsDto> selectOptsList(CltOptsDto pvo){
		return optsDao.selectOptsList(pvo);
	};

	public List<CltOptsDto> selectAdmOptsList(CltOptsDto pvo){
		return optsDao.selectAdmOptsList(pvo);
	};
	
	public int insertOpts(CltOptsDto pvo) {
		return optsDao.insertOpts(pvo);
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
