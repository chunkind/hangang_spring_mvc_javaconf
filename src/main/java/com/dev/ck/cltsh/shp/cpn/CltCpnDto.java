package com.dev.ck.cltsh.shp.cpn;

import com.dev.ck.cltsh.cmm.PagingVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CltCpnDto extends PagingVO{
	private long couInfoSeq;/*쿠폰 시퀀스*/
	private long couNum;/*쿠폰 코드*/
	private String couName;/*쿠폰 이름*/
	private int couDiscount;/*쿠폰 할인율*/
	private String couRegistDate;/*쿠폰 등록 날짜*/
	private String couEndDate;/*쿠폰 만료 날짜*/
	private int couCount;/*쿠폰 개수*/
}