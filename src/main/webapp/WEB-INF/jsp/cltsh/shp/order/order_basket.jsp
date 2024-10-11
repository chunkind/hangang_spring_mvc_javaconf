<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container my-5">
	<div class="mb-4">
		<h3 class="text-center">주문 내역 입니다.</h3>
	</div>

	<form name="frm" action="/cltsh/order/orderCartRegisterAct.do" method="post">
		<input type="hidden" name="checkedList" value="${key}">
		<input type="hidden" name="clmSctCd" value="01">
		<input type="hidden" name="clmStatCd" value="01">

		<div class="mb-4">
			<h4>배송 정보</h4>
			<div class="row mb-3">
				<label class="col-sm-2 col-form-label">주문자 이름</label>
				<div class="col-sm-4">
					<input type="text" name="ordrNm" class="form-control" value="${sessionScope.loginInfo.usrNm}">
				</div>
				<label class="col-sm-2 col-form-label">주문자 전화번호</label>
				<div class="col-sm-4">
					<input type="text" name="ordrPhon" class="form-control" value="${sessionScope.loginInfo.cellNo}">
				</div>
			</div>
			<div class="row mb-3">
				<label class="col-sm-2 col-form-label">주문자 이메일</label>
				<div class="col-sm-4">
					<input type="text" name="ordrEmail" class="form-control" value="${sessionScope.loginInfo.emailAddr}">
				</div>
				<label class="col-sm-2 col-form-label">수취자 이름</label>
				<div class="col-sm-4">
					<input type="text" name="acqrNm" class="form-control" value="${sessionScope.loginInfo.usrNm}">
				</div>
			</div>
			<div class="row mb-3">
				<label class="col-sm-2 col-form-label">수취자 전화번호</label>
				<div class="col-sm-4">
					<input type="text" name="acqrPhon" class="form-control" value="${sessionScope.loginInfo.cellNo}">
				</div>
				<label class="col-sm-2 col-form-label">수취자 이메일</label>
				<div class="col-sm-4">
					<input type="text" name="acqrEmail" class="form-control" value="${sessionScope.loginInfo.emailAddr}">
				</div>
			</div>
			<div class="row mb-3">
				<label class="col-sm-2 col-form-label">수취자 주소</label>
				<div class="col-sm-4">
					<input type="text" name="acqrAddr" class="form-control" value="${sessionScope.loginInfo.loadAddrBase}">
				</div>
				<label class="col-sm-2 col-form-label">수취자 상세 주소</label>
				<div class="col-sm-4">
					<input type="text" name="acqrAddrDtl" class="form-control" value="${sessionScope.loginInfo.loadAddrDtl}">
				</div>
			</div>
			<div class="row mb-3">
				<label class="col-sm-2 col-form-label">요청 사항</label>
				<div class="col-sm-10">
					<textarea rows="4" class="form-control" name="reqMemo"></textarea>
				</div>
			</div>
		</div>

		<div class="mb-4">
			<h4>상품 정보</h4>
			<c:forEach items="${detail}" var="obj">
				<input type="hidden" name="entrNo" value="${obj.entrNo}">
				<input type="hidden" name="goodsNm" value="${obj.goodsNm}">
				<input type="hidden" name="goodsCd" value="${obj.goodsCd}">
				<input type="hidden" name="payMny" value="${totalPayment}">
				<input type="hidden" name="saleBoardSeqs" value="${obj.saleBoardSeq}">

				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">상품 명</label>
					<div class="col-sm-4">
						<p class="form-control-plaintext">${obj.goodsNm}</p>
					</div>
					<label class="col-sm-2 col-form-label">옵션 정보</label>
					<div class="col-sm-4">
						<p class="form-control-plaintext">옵션 정보 없음</p>
					</div>
				</div>
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">수량</label>
					<div class="col-sm-4">
						<input type="number" name="goodsQty" class="form-control" value="1">
					</div>
					<label class="col-sm-2 col-form-label">상품 가격</label>
					<div class="col-sm-4">
						<p class="form-control-plaintext">${String.format("%,d", obj.goodsPrc - obj.goodsSalePrc)} 원</p>
					</div>
				</div>
			</c:forEach>

			<div class="row mb-3">
				<label class="col-sm-2 col-form-label">총 결제 금액</label>
				<div class="col-sm-10">
					<p class="form-control-plaintext">${String.format("%,d", totalGoodsPrc)} 원 + 배송비 ${String.format("%,d", totalDlvPrc)} 원 = ${String.format("%,d", totalPayment)} 원</p>
				</div>
			</div>

			<div class="row mb-3">
				<label class="col-sm-2 col-form-label">결제 수단</label>
				<div class="col-sm-4">
					<select name="payWay" class="form-select">
						<option value="card">신용/체크카드</option>
						<option value="mobilePay">휴대폰결제</option>
						<option value="kakaoPay">카카오페이</option>
						<option value="naverPay">네이버페이</option>
						<option value="toss">토스</option>
					</select>
				</div>
			</div>
		</div>

		<div class="text-center">
			<button type="submit" class="btn btn-primary">주문하기</button>
		</div>
	</form>
</div>
