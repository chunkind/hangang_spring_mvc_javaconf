package com.dev.ck.cltsh.shp.payment;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CltPaymentDto {
	private int paySn;
	private String ordClmNo;
	private int ordClmDtlSn;
	private int payState;
	
	private String gopaymethod;	// Card:Directbank:vbank
	private String tid;			// 거래 고유 식별자 (transaction_id)
	private String mid;			// 상점 아이디 (이니시스에서 발급한 상점 아이디 merchant_order_id)
	private String ordNo;			// oid - 주문 번호
	private String goodsPrc;		// 결제 금액
	private String timestamp;	// 타임스탬프 - 요청 시간
	private String useChkfake;	// pc결제 보안강화 사용 [Y 고정]
	private String signature;	// 결제 요청 시 서명 (이니시스에서 제공하는 방식에 따라 생성)
	private String verification;	// 검증 서명
	private String mKey;		// 보안 키
	private String currency;	// 통화구분 ["WON":한화,"USD":달러]
	private String goodsNm;	// 상품명
	private String buyerNm;	// 구매자 이름
	private String buyerTel;	// 구매자 전화번호
	private String buyerEmail;	// 구매자 이메일
	private String returnUrl;	// 결제 후 리다이렉트 URL
	private String closeUrl;	// 결제 창 닫기 URL
	private String acceptMethod;	// 허용된 결제 방식 -  "centerCd(Y)" IDC센터코드 수신 사용옵션 세팅 필수 ex) acceptmethod = centerCd(Y)
	private String paymentStatus;  //결제가 성공했는지, 실패했는지 기록하는 필드
	private String rgstDate;		//생성일
	private String updtDate;	//수정일
}
