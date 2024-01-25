package com.dev.ck.cltsh.shp.mypage;

import com.dev.ck.cltsh.cmm.PagingVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CltMypgDto extends PagingVO {
	private String ordNo; /* 주문번호 */
	private String rgstDate; /* 주문일자 */
	private String ordrId; /* 주문자 아이디 */
	private String ordrNm; /* 주문자 이름 */
	private String ordrPhon; /* 주문자 폰번호 */
	private long payMny; /* 결제금액 */
	private String imgPath; /* 이미지 경로 */
	private String imgNm; /* 이미지 이름 */
	private String bulTitNm; /* 판매게시판 제목 */
	private int goodsQty; /* 수량 */
	private long goodsPrc; /* 상품금액 */
	private String ordStat; /* 주문상태코드 */
	private String codeNm; /* 주문상태코드이름 */
	private String payWay; /* 결제수단 */
	private long dlvPrc; /* 배송비 */
	private String acqrNm; /* 수령자 이름 */
	private String acqrPhon; /* 수령자 휴대폰 */
	private String acqrAddr; /* 수령지 주소 */
	private String acqrAddrDtl; /* 수령지 상세 주소 */
	private String reqMemo; /* 배송메모 */

	private String usrId;
	private long saleBoardRpySeq;
	private String bulTitNms; /* 여러 건 -  판매게시판 제목들  */
}
