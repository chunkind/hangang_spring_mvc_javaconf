package com.dev.ck.cltsh.shp.cate;


import com.dev.ck.cltsh.cmm.PagingVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CltCateDto extends PagingVO{
	public CltCateDto(String catgryCd, int goodsCd
		, String catgryNm, String noteCont, String classLvlCd
		, String uprClassCd, String rgstId
		, String updtId, String useYn) {
		this.catgryCd = catgryCd;
		this.goodsCd = goodsCd;
		this.catgryNm = catgryNm;
		this.noteCont = noteCont;
		this.classLvlCd = classLvlCd;
		this.uprClassCd = uprClassCd;
		this.rgstId = rgstId;
		this.updtId = updtId;
		this.useYn = useYn;
	}
//	new CateVO("CT01", 0, "가방", "가방", "1", "CT01", "system", "system", "Y")
	
	private long goodsCataSeq;
	private String catgryCd;
	private String catgryCd2;
	private int goodsCd;
	private String catgryNm;
	private String noteCont;
	private String classLvlCd;
	private String uprClassCd;
	private String rgstId;
	private String rgstDate;
	private String updtId;
	private String updtDate;
	private String useYn;
	private String cateType;
	
	private String[] upCateType;
	private String[] unCateType;
	private String[] upCatgryCdArr;
	private String[] unCatgryCdArr;
	private String[] upCatgryNmArr;
	private String[] unCatgryNmArr;
	private String[] upNoteContArr;
	private String[] unNoteContArr;
	private String[] upUseYnArr;
	private String[] unUseYnArr;
	private String[] upClassLvlCdArr;
	private String[] unClassLvlCdArr;
	private long[] upGoodsCataSeq;
	private long[] unGoodsCataSeq;
}
