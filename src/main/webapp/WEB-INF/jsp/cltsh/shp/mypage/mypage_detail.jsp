<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="container my-5">
	<h2 class="mb-4">주문 정보</h2>
	<div class="card p-4 mb-4">
		<div class="row mb-2">
			<div class="col-sm-3 fw-bold">주문번호</div>
			<div class="col-sm-9">${ordList.ordNo}</div>
		</div>
		<div class="row mb-2">
			<div class="col-sm-3 fw-bold">주문일자</div>
			<div class="col-sm-9">${ordList.ordDate}</div>
		</div>
		<div class="row mb-2">
			<div class="col-sm-3 fw-bold">주문자</div>
			<div class="col-sm-9">${ordList.ordrNm}</div>
		</div>
		<div class="row mb-2">
			<div class="col-sm-3 fw-bold">결제금액</div>
			<div class="col-sm-9">${String.format("%,d", ordList.payMny)}원</div>
		</div>
		<div class="row mb-2">
			<div class="col-sm-3 fw-bold">적립포인트</div>
			<div class="col-sm-9">50원</div>
		</div>
		<div class="row">
			<div class="col-sm-3 fw-bold">운송장 번호</div>
			<div class="col-sm-9">${ordList.billNum}</div>
		</div>
	</div>

	<h2 class="mb-4">주문 상품</h2>
	<div class="card p-4 mb-4">
		<div class="row fw-bold mb-2">
			<div class="col-sm-3">상품 이미지</div>
			<div class="col-sm-3">상품명</div>
			<div class="col-sm-3">주문금액</div>
			<div class="col-sm-3">진행상황</div>
		</div>
		<c:forEach var="obj" items="${ordDtlList}">
			<div class="row mb-2 align-items-center">
				<div class="col-sm-3">
					<img src="${obj.imgPath}${obj.imgNm}" class="img-fluid" alt="상품 이미지">
				</div>
				<div class="col-sm-3">
					<div>${obj.bulTitNm}</div>
				</div>
				<div class="col-sm-3">${String.format("%,d", obj.goodsPrc - obj.goodsSalePrc)}원
				</div>
				<div class="col-sm-3">
					${obj.codeNm}
					<c:if test="${obj.saleBoardRpySeq eq 0}">
						<button class="btn btn-link p-0" onclick="location.href='/cltsh/dress/dressRegister.do?ordNo=${obj.ordNo }&ordClmDtlSn=${obj.ordClmDtlSn}'"> 드레스룸 등록</button>
					</c:if>
				</div>
			</div>
		</c:forEach>
	</div>

	<h2 class="mb-4">결제 정보</h2>
	<div class="card p-4 mb-4">
		<div class="row mb-2">
			<div class="col-sm-3 fw-bold">결제수단</div>
			<div class="col-sm-9">${ordList.payWay}</div>
		</div>
		<div class="row mb-2">
			<div class="col-sm-3 fw-bold">상품 금액</div>
			<div class="col-sm-9">
				<c:forEach var="obj" items="${ordDtlList}">
					${String.format("%,d", obj.goodsPrc - obj.goodsSalePrc)}원<br>
				</c:forEach>
			</div>
		</div>
		<div class="row mb-2">
			<div class="col-sm-3 fw-bold">쿠폰 할인 금액</div>
			<div class="col-sm-9">0 원</div>
		</div>
		<div class="row mb-2">
			<div class="col-sm-3 fw-bold">사용 포인트</div>
			<div class="col-sm-9">0 원</div>
		</div>
		<div class="row mb-2">
			<div class="col-sm-3 fw-bold">배송비</div>
			<div class="col-sm-9">${String.format("%,d", ordDtlList[0].dlvPrc)}원</div>
		</div>
		<div class="row mb-2">
			<div class="col-sm-3 fw-bold">총 주문금액</div>
			<div class="col-sm-9">${String.format("%,d", ordList.payMny)}원</div>
		</div>
	</div>

	<h2 class="mb-4">배송지 정보</h2>
	<div class="card p-4 mb-4">
		<div class="row mb-2">
			<div class="col-sm-3 fw-bold">수령인</div>
			<div class="col-sm-9">${ordList.acqrNm}</div>
		</div>
		<div class="row mb-2">
			<div class="col-sm-3 fw-bold">휴대폰</div>
			<div class="col-sm-9">${ordList.acqrPhon}</div>
		</div>
		<div class="row mb-2">
			<div class="col-sm-3 fw-bold">우편번호</div>
			<div class="col-sm-9">10000</div>
		</div>
		<div class="row mb-2">
			<div class="col-sm-3 fw-bold">배송주소</div>
			<div class="col-sm-9">${ordList.acqrAddr}</div>
		</div>
		<div class="row mb-2">
			<div class="col-sm-3 fw-bold">나머지 주소</div>
			<div class="col-sm-9">${ordList.acqrAddrDtl}</div>
		</div>
		<div class="row">
			<div class="col-sm-3 fw-bold">배송메모</div>
			<div class="col-sm-9">${ordList.reqMemo}</div>
		</div>
	</div>

	<div class="text-center">
		<button class="btn btn-primary" onclick="location.href='/cltsh/mypage/mypageOrder.do'">주문/배송조회로 이동</button>
	</div>
</section>
