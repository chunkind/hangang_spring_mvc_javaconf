package com.dev.ck.cltsh.shp.sales;

import java.sql.Date;

import com.dev.ck.cltsh.cmm.PagingVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CltSalesDto extends PagingVO{
	public CltSalesDto(int goodsCd, long entrNo, String ntcSctCd
			, String bulYn, Date bulStrtDt, Date bulEndDt
			, String bulTitNm, String bulCont, int qryCnt
			, int lkeCnt, int goodsPrc, int goodsSalePrc
			, String prclWay, int saleCnt, String rgstId
			, String updtId, String saleStatCd, String description) {
		this.goodsCd = goodsCd;
		this.entrNo = entrNo;
		this.ntcSctCd = ntcSctCd;
		this.bulYn = bulYn;
		this.bulStrtDt = bulStrtDt;
		this.bulEndDt = bulEndDt;
		this.bulTitNm = bulTitNm;
		this.bulCont = bulCont;
		this.qryCnt = qryCnt;
		this.lkeCnt = lkeCnt;
		this.goodsPrc = goodsPrc;
		this.goodsSalePrc = goodsSalePrc;
		this.prclWay = prclWay;
		this.saleCnt = saleCnt;
		this.rgstId = rgstId;
		this.updtId = updtId;
		this.saleStatCd = saleStatCd;
		this.description = description;
	}

	private long saleBoardSeq;
	private int goodsCd;
	private long entrNo;
	private String ntcSctCd;
	private String bulYn;
	private Date bulStrtDt;
	private Date bulEndDt;
	private String bulTitNm;
	private String bulCont;
	private int qryCnt;
	private int lkeCnt;
	private int goodsPrc;
	private int goodsSalePrc;
	private String prclWay;
	private int saleCnt;
	private String rgstId;
	private Date rgstDate;
	private String updtId;
	private Date updtDate;
	private String saleStatCd;
	private String useYn;
	private String description;
	
	private String searchEntrNo;
}
