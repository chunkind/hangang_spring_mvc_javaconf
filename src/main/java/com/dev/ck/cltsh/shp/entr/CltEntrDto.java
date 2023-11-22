package com.dev.ck.cltsh.shp.entr;

import java.sql.Date;

import com.dev.ck.cltsh.cmm.PagingVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CltEntrDto extends PagingVO{
	public CltEntrDto(String usrId, String entrNm, String bmanRegNo
			, String presNm, String presTell, String presEmail
			, String aempNm, String aempTell, String aempEmail
			, int score, String landAddrBase, String landAddrDtl
			, String landPostNo, String loadAddrBase, String loadPostNo
			, Date opnDate, Date closeDate, String opnYn
			, String useYn, String rgstId, String updtId) {
		this.usrId = usrId;
		this.entrNm = entrNm;
		this.bmanRegNo = bmanRegNo;
		this.presNm = presNm;
		this.presTell = presTell;
		this.presEmail = presEmail;
		this.aempNm = aempNm;
		this.aempTell = aempTell;
		this.aempEmail = aempEmail;
		this.score = score;
		this.landAddrBase = landAddrBase;
		this.landAddrDtl = landAddrDtl;
		this.landPostNo = landPostNo;
		this.loadAddrBase = loadAddrBase;
		this.loadPostNo = loadPostNo;
		this.opnDate = opnDate;
		this.closeDate = closeDate;
		this.opnYn = opnYn;
		this.useYn = useYn;
		this.rgstId = rgstId;
		this.updtId = updtId;
	}
	//new EntrVO("chunkind", "JShop", "123-45-67890", "김땡땡", "01012341234", "jshop@go.ir", "김담당", "01043214321", "jjdd@naver.com", 0, "경기 성남시 분당구", "삼평동 681", "13494", "경기 성남시 분당구 판교역로 235 (에어치스퀘어 엔동)", "13494", DateUtils.stringToSqlDate("2010-10-01"), null, "Y", "Y", "system", "system")
	private long entrNo;
	private String usrId;
	private String entrNm;
	private String bmanRegNo;
	private String presNm;
	private String presTell;
	private String presEmail;
	private String aempNm;
	private String aempTell;
	private String aempEmail;
	private int score;
	private String landAddrBase;
	private String landAddrDtl;
	private String landPostNo;
	private String loadAddrBase;
	private String loadPostNo;
	private Date opnDate;
	private Date closeDate;
	private String opnYn;
	private String useYn;
	private String rgstId;
	private Date rgstDate;
	private String updtId;
	private Date updtDate;
}