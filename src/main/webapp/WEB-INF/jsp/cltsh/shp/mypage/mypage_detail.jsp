<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/nomalMenu.jsp"%>
<link href="/css/cltsh/mypage_detail.css" rel="stylesheet">

<section class="title_area">
	<h3 class="title">주문상세조회</h3>
</section>

<section class="item_list_area">
	<h2>주문정보</h2>
	<div class="order_member">
		<div>
			<span>주문번호</span> <span>${ordList.ordNo}</span>
		</div>
		<div>
			<span>주문일자</span> <span>${ordList.ordDate}</span>
		</div>
		<div>
			<span>주문자</span> <span>${ordList.ordrNm}</span>
		</div>
		<div>
			<span>결제금액</span> <span>${String.format("%,d", ordList.payMny)}원</span>
		</div>
		<div>
			<span>적립포인트</span> <span>50원</span>
		</div>
		<div class="end">
			<span>운송장 번호</span> <span>${ordList.billNum}</span>
		</div>
	</div>
	<h2>주문상품</h2>
	<div class="order_item">
		<div>상품 이미지</div>
		<div class="price">주문금액</div>
		<div>진행상황</div>
	</div>
	
	<c:forEach items="${ordDtlList }" var="obj">
		<div class="order_item2">
			<div>
				<img src="${obj.imgPath}${obj.imgNm}">
			</div>
			<div>
				<div>${obj.bulTitNm}</div>
			</div>
			<div>${String.format("%,d", obj.goodsPrc - obj.goodsSalePrc)}원</div>
			<div>${obj.codeNm}</div>
			<c:if test="${obj.saleBoardRpySeq eq 0}">
				<input type="button" onclick="location.href='/cltsh/dress/dressRegister.do?ordDtlNo=${obj.ordDtlNo}'" value="드레스룸 등록" />
			</c:if>
		</div>
	</c:forEach>
	<h2>주문정보</h2>
	<div class="order_item3">
		<div class="a">
			<div>결제수단</div>
			<div>${ordList.payWay}</div>
		</div>
		<div class="a">
			<div>상품 금액</div>
			<div>${String.format("%,d", searchSalesGoods.goodsPrc - searchSalesGoods.goodsSalePrc)}원</div>
		</div>
		<div class="a">
			<div>쿠폰 할인 금액</div>
			<div>0 원</div>
		</div>
		<div class="a">
			<div>사용 포인트</div>
			<div>0 원</div>
		</div>
		<div class="a">
			<div>배송비</div>
			<div>${String.format("%,d", searchGoods.dlvPrc)}원</div>
		</div>
		<div class="a">
			<div>총 주문금액</div>
			<div>${String.format("%,d", ordList.payMny)}원</div>
		</div>
	</div>
	<h2>배송지 정보</h2>
	<div class="order_item3">
		<div class="a">
			<div>수령인</div>
			<div>${ordList.acqrNm}</div>
		</div>
		<div class="a">
			<div>휴대폰</div>
			<div>${ordList.acqrPhon}</div>
		</div>
		<div class="a">
			<div>우편번호</div>
			<div>10000</div>
		</div>
		<div class="a">
			<div>배송주소</div>
			<div>${ordList.acqrAddr}</div>
		</div>
		<div class="a">
			<div>나머지 주소</div>
			<div>${ordList.acqrAddrDtl}</div>
		</div>
		<div class="a">
			<div>배송메모</div>
			<div>${ordList.reqMemo}</div>
		</div>
	</div>
	<div class="btn_area">
		<button class="delivery_btn"
			onclick="location.href='/cltsh/mypage/mypage.do'">주문/배송조회로이동</button>
	</div>
</section>