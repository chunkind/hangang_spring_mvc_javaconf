package com.dev.ck.cltsh.shp.dress;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.dev.ck.cltsh.cmm.PagingVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CltDressDto extends PagingVO{
	private int saleBoardRpySeq;
	private int saleBoardSeq;
	private int goodsCd;
	private int entrNo;
	private String bulTitNm; //제목
	private String bulCont; //내용
	private int rpyLvl; //답글 레벨
	private int parSaleBoardRpySn; //부모답글 번호
	private int qryCnt; //조회수
	private int lkeCnt; //추천수
	private String rgstId;
	private String rgstDate;
	private String updtId;
	private String updtDate;
	private String useYn;
	private String imgPath;
	private String imgNm;
	private String noticeDoc;
	private String ordNo;
	private String usrId;
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
	private long payMny;
	private String reqMemo;
	private Date ordDate;
	private int billNum;

	private String rvwTag;

	private String selectedSaleRvwItem;
	
	private MultipartFile file1;
}
