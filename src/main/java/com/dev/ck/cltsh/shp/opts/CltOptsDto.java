package com.dev.ck.cltsh.shp.opts;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CltOptsDto {
	private int entrNo;				/* 거래처번호 */
	private int goodsCd;			/* 상품코드 */
	private int goodsOptsSeq;		/* 상품 옵션 시퀀스 */
	private String optsCd;			/* 옵션 코드 */
	private String optsNm;			/* 옵션이름 */
	private String optsUseYn;		/* 사용여부 */
	private int optsOrdr;			/* 노출순서 */
	private String isMainProduct;	/* 대표상품여부 */

	private int goodsOptsValSeq;	/* 상품 옵션값 시퀀스 */
	private String optsVal;			/* 옵션값 */
	private String optsValUseYn;	/* 옵션값사용여부 */
	private int optValInyQty;		/* 옵션 재고수량 */
	
	private String rgstId;			/* 등록아이디 */
	private String rgstDate;		/* 등록일 */
	private String updtId;			/* 수정아이디 */
	private String updtDate;		/* 수정일 */
	
	private String optsType;
	private int addTextCnt;
	private int optsCnt; /* 기존 데이터 갯수 */
	private int [] goodsOptsSeqArr;	
	private String [] optsTypeArr;	
	private String[] optsCdArr;
	private String[] optsNmArr;
	private String[] optsValArr;
	private int[] goodsCdArr;
	private String[] useYnArr;
	
	private String [] addOptsTypeArr;
	private String[] addOptsCdArr;
	private String[] addOptsNmArr;
	private String[] addOptsValArr;
	private int[] addGoodsCdArr;
	private String[] addUseYnArr;
	
	public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("optsSeq", this.goodsOptsSeq);
        map.put("optsCd", this.optsCd);
        map.put("optsNm", this.optsNm);
        map.put("optsVal", this.optsVal);
        map.put("goodsCd", this.goodsCd);
        map.put("optInyQty", this.optValInyQty);
        map.put("isMainProduct", this.isMainProduct);
        return map;
    }
}