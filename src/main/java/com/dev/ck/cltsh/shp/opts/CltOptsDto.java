package com.dev.ck.cltsh.shp.opts;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CltOptsDto {
	private int goodsOptsSeq;	/* 상품 옵션 시퀀스 */
	private String optsCd;		/* 옵션 코드 */
	private String optsNm;		/* 옵션이름 */
	private String optsVal;	/* 옵션값 */
	private String useYn;		/* 사용여부 */
	private String rgstId;		/* 등록아이디 */
	private String rgstDate;	/* 등록일 */
	private String updtId;		/* 수정아이디 */
	private String updtDate;	/* 수정일 */
	private int goodsCd;		/* 상품코드 */
	
	private String optsType;
	private int addTextCnt;
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
}