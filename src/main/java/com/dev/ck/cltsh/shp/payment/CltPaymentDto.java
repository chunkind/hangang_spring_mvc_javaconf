package com.dev.ck.cltsh.shp.payment;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CltPaymentDto {
	private String version;		// 결제 방식
	private String gopaymethod;	// 결제 방식
	private String mid;			// 상점 아이디 (이니시스에서 발급한 상점 아이디)
	private String oid;			// 주문 번호
	private String price;		// 결제 금액
	private String timestamp;	// 타임스탬프 - 요청 시간
	private String useChkfake;	// pc결제 보안강화 사용 [Y 고정]
	private String signature;	// 결제 요청 시 서명 (이니시스에서 제공하는 방식에 따라 생성)
	private String verification;	// 검증 서명
	private String mKey;		// 보안 키
	private String currency;	// 통화구분 ["WON":한화,"USD":달러]
	private String goodname;	// 상품명
	private String buyername;	// 구매자 이름
	private String buyertel;	// 구매자 전화번호
	private String buyeremail;	// 구매자 이메일
	private String returnUrl;	// 결제 후 리다이렉트 URL
	private String closeUrl;	// 결제 창 닫기 URL
	private String acceptmethod;	// 허용된 결제 방식 -  "centerCd(Y)" IDC센터코드 수신 사용옵션 세팅 필수 ex) acceptmethod = centerCd(Y)
}
