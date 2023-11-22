package com.dev.ck.cltsh.shp.code;

import com.dev.ck.cltsh.cmm.PagingVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CltCodeDto extends PagingVO{
	private long stdCdBaseSeq; /*시퀀스*/
	private String codeNm; /*코드 이름*/
	private String codeVal; /*코드 값*/
	private String codeDesc; /*설명*/
	private String grpCd; /*코드 그룹*/
	private int grpOrdr; /*그룹 순번*/
	private String useYn; /*사용 여부*/
	private String rgstId; /*등록 아이디*/
	private String rgstDate; /*등록일*/
	private String updtId; /*수정 아이디*/
	private String updtDate; /*수정일*/
	
	private String searchGrpCd;
	
	public CltCodeDto(String codeNm, String codeVal, String codeDesc, String grpCd, int grpOrdr, String useYn, String rgstId, String updtId) {
		this.codeNm = codeNm;
		this.codeVal = codeVal;
		this.codeDesc = codeDesc;
		this.grpCd = grpCd;
		this.grpOrdr = grpOrdr;
		this.useYn = useYn;
		this.rgstId = rgstId;
		this.updtId = updtId;
	}

	public CltCodeDto(long stdCdBaseSeq, String codeNm, String codeVal, String codeDesc, String grpCd, int grpOrdr,
				  String useYn, String rgstId, String rgstDate, String updtId, String updtDate) {
		super();
		this.stdCdBaseSeq = stdCdBaseSeq;
		this.codeNm = codeNm;
		this.codeVal = codeVal;
		this.codeDesc = codeDesc;
		this.grpCd = grpCd;
		this.grpOrdr = grpOrdr;
		this.useYn = useYn;
		this.rgstId = rgstId;
		this.rgstDate = rgstDate;
		this.updtId = updtId;
		this.updtDate = updtDate;
	}
}
