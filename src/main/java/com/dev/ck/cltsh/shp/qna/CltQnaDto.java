package com.dev.ck.cltsh.shp.qna;

import com.dev.ck.cltsh.cmm.PagingVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CltQnaDto extends PagingVO{
	private long qnaBoardSeq;
	private String titNm;
	private String cont;
	private String rgstId;
	private String rgstDate;
	private String updtId;
	private String updtDate;
	private String qnaTp;
	private String ansrStat;
	private String useYn;
	private String passYn;
	private String passWd;
	private long goodsCd;
	private String answer;
	
	private int page;
	private int pagePerRow;
}
