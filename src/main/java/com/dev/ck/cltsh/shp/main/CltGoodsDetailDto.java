package com.dev.ck.cltsh.shp.main;

import java.sql.Date;

import com.dev.ck.cltsh.cmm.PagingVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CltGoodsDetailDto extends PagingVO{
	private String ntcSctCd;
	private String bulYn;
	private Date bulStrtDt;
	private Date bulEndDt;
	private String bulCont;
	private int qryCnt;
	private long lkeCnt;
	
	private long goodsInfoSeq;/*상품 시퀀스*/
	private long goodsCd;/*상품 코드*/
	private long entrNo;/*거래처 번호*/
	private String goodsNm;/*상품이름*/
	private int goodsPrc;/*상품가격*/
	private String catgryCd;/*대분류*/
	private String catgryCd2;/*소분류*/
	private int inyQty;/*재고수량*/
	private int dlvPrc;/*배송비*/
	private String goodsSize;/*상품싸이즈*/
	private String goodsClr;/*상품컬러*/
	private String imgPath;/*이미지경로*/
	private String imgNm;/*이미지이름*/
	private String goodsIntr;/*상품소개*/
	private String saleStatCd;/*판매상태*/
	private String useYn;/*사용여부*/
	private String rgstId;/*등록자*/
	private Date rgstDate;/*등록일*/
	private String updtId;/*수정자*/
	private Date updtDate;/*수정일*/
	
	private String searchEntrNo;
	
	//주문 기본
	private String ordNo;
	private String usrId;
	private String ordDtlStatCd;
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
	private Long billNum;
	
	//주문 상세
	private Long ordDtlNo;
	private int goodsQty;
	private String codeNm;
	

	//장바구니
	private Long ordBasketSeq;
	private Long saleBoardSeq;
	private String bulTitNm;
	private int goodsSalePrc;
	private int saleCnt;
	private String description;
	private String checkedList;
	private String key;
	
	private String rvwTag;
	
	//상세페이지 상품 옵션
	private String colorOption;
	private String sizeOption;
	
	private String[] goodsNmArry;
	private Long[] goodsCdArry;
	private int[] goodsQtyArry;
	private String[] saleBoardSeqs;

	//파라미터
	private String searchSaleBoardSeq;

	private String searchCatgryCd;
	private String searchCatgryCd2;
	private String searchGoodsCd;
}
