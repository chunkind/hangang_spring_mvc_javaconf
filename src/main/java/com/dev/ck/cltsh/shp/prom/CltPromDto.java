package com.dev.ck.cltsh.shp.prom;

import com.dev.ck.cltsh.cmm.PagingVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CltPromDto extends PagingVO{
	private long promSeq; /*프로모션 시퀀스*/
	private long promNum; /*프로모션 번호*/
	private String promName; /*프로모션 명*/
	private String promTp; /*프로모션 유형*/
	private int promDiscount; /*프로모션 할인율*/
	private String promRegistDate; /*프로모션 시작일*/
	private String promEndDate; /*프로모션 종료일*/
	private String promCont; /*프로모션 내용*/
	private String imgPath; /*대표이미지 경로*/
	private String imgNm; /*대표이미지 명*/
	private String rgstId; /*등록자id*/
	private String rgstDate; /*등록일자*/
	private String updtId; /*수정자 id*/
	private String updtDate; /*수정일자*/
}
