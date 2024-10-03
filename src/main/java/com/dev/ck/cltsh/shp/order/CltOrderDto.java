package com.dev.ck.cltsh.shp.order;

import com.dev.ck.cltsh.cmm.PagingVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CltOrderDto extends PagingVO {
	//주문 기본
	private String ordNo;
	private String ordClmNo;
	private String clmSctCd;
	private String clmStatCd;
	private String ordStat;
	private String ordrId;
	private String ordrNm;
	private String ordrPhon;
	private String ordrEmail;
	private String acqrPhon;
	private String acqrNm;
	private String acqrAddr;
	private String acqrAddrDtl;
	private String acqrEmail;
	private String prclWay;
	private String packWay;
	private String payWay;
	private Long payMny;
	private String reqMemo;
	private String ordDate;
	private String updtDate;
	private String updtId;
	private String rgstDate;
	private String rgstId;
	private Long billNum;
	
	private String usrId;
	private Long entrNo;
	private String ordStatNm; //주문 상태 -> "02"일 경우 "결제완료" 저장

	//주문 상세
	private String ordClmDtlSn;
	private String goodsNm;
	private int goodsCd;
	private int goodsQty;
	private String codeNm;
	
	//주문 이력
	private String ordHistSeq;
	private String histMemo;
	
	//장바구니
	private Long ordBasketSeq;
	private String useYn;
	private Long saleBoardSeq;
	private String imgPath;
	private String imgNm;
	private String bulTitNm;
	private int goodsPrc;/*상품가격*/
	private int goodsSalePrc;
	private int saleCnt;
	private String saleStatCd;
	private String description;
	private String checkedList;
	private String key;
	private int dlvPrc;
	private String rvwTag;
	
	//상세페이지 상품 옵션
	private String colorOption;
	private String sizeOption;
	
	String[] goodsNmArry;
	Long[] goodsCdArry;
	int[] goodsQtyArry;
	private String[] saleBoardSeqs;
	private int index;
	private long saleBoardRpySeq;

	//파라미터
	private String searchSaleBoardSeq;
}