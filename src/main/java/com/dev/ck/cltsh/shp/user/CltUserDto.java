package com.dev.ck.cltsh.shp.user;

import java.util.ArrayList;
import java.util.List;

import com.dev.ck.cltsh.cmm.PagingVO;
import com.dev.ck.cltsh.shp.entr.CltEntrDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CltUserDto extends PagingVO{
	public CltUserDto(String usrId, String usrNm, String passWd
			, String usrBirth, String emailAddr, String cellNo
			, String landAddrBase, String landAddrDtl
			, String landPostNo, String loadAddrBase
			, String loadAddrDtl, String loadPostNo
			, String rgstId) {
		this.usrId = usrId;
		this.usrNm = usrNm;
		this.passWd = passWd;
		this.usrBirth = usrBirth;
		this.emailAddr = emailAddr;
		this.cellNo = cellNo;
		this.landAddrBase = landAddrBase;
		this.landAddrDtl = landAddrDtl;
		this.landPostNo = landPostNo;
		this.loadAddrBase = loadAddrBase;
		this.loadAddrDtl = loadAddrDtl;
		this.loadPostNo = loadPostNo;
		this.rgstId = rgstId;
	}
//new UserVO("chunkind", "김땡땡", "1", "19880420", "chunkind@naver.com", "01012341244", "경기도 부천시 소사구", "괴안동 11", "12345", "경인로 122", "1동", "12345", "system")

	private long usrBaseSeq;
	private String usrId;
	private String usrNm;
	private String passWd;
	private String usrBirth;
	private String emailAddr;
	private String cellNo;
	private String landAddrBase;
	private String landAddrDtl;
	private String landPostNo;
	private String loadAddrBase;
	private String loadAddrDtl;
	private String loadPostNo;
	private String passWdChgDate; //Date -> String으로 받음
	private String lockYn;
	private String rgstId;
	private String rgstDate; //Date -> String으로 받음
	private String updtId;
	private String updtDate; //Date -> String으로 받음
	private String useYn;
	
	private String userSequence; // 리스트 순서
	
	private String searchType;
	private String searchText;
	private String searchGradeUpperType;
	private String searchGradeUnderType;
	private String searchStartRgstDate;
	private String searchEndRgstDate;
	
	
	private List<CltEntrDto> entrList = new ArrayList<CltEntrDto>();
}