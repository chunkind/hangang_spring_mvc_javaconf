<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="item_list_area my-4">
		<h3 class="title text-center">주문 내역 입니다.</h3>

		<form name="frm" action="/cltsh/order/orderRegister.do" method="post">
			<input type="hidden" name="saleBoardSeq" value="${detail.saleBoardSeq}">
			<input type="hidden" name="entrNo" value="${detail.entrNo}">
			<input type="hidden" name="goodsNm" value="${detail.goodsNm}">
			<input type="hidden" name="goodsCd" value="${detail.goodsCd}">
			<input type="hidden" name="payMny" value="${detail.goodsPrc - detail.goodsSalePrc + detail.dlvPrc}">
			<input type="hidden" name="clmSctCd" value="01">
			<input type="hidden" name="clmStatCd" value="01">

			<h2 class="mt-4">배송 정보</h2>
			<table class="table table-bordered">
				<colgroup>
					<col width="20%">
					<col width="30%">
					<col width="20%">
					<col width="30%">
				</colgroup>
				<tr>
					<th>주문자 이름</th>
					<td><input type="text" class="form-control" name="ordrNm" value="${sessionScope.loginInfo.usrNm}"></td>
					<th>주문자 전화번호</th>
					<td><input type="text" class="form-control" name="ordrPhon" value="${sessionScope.loginInfo.cellNo}"></td>
				</tr>
				<tr>
					<th>주문자 이메일</th>
					<td><input type="text" class="form-control" name="ordrEmail" value="${sessionScope.loginInfo.emailAddr}"></td>
					<th>수취자 이름</th>
					<td><input type="text" class="form-control" name="acqrNm" value="${sessionScope.loginInfo.usrNm}"></td>
				</tr>
				<tr>
					<th>수취자 전화번호</th>
					<td><input type="text" class="form-control" name="acqrPhon" value="${sessionScope.loginInfo.cellNo}"></td>
					<th>수취자 이메일</th>
					<td><input type="text" class="form-control" name="acqrEmail" value="${sessionScope.loginInfo.emailAddr}"></td>
				</tr>
				<tr>
					<th>수취자 주소</th>
					<td><input type="text" class="form-control" name="acqrAddr" value="${sessionScope.loginInfo.loadAddrBase}"></td>
					<th>수취자 상세 주소</th>
					<td><input type="text" class="form-control" name="acqrAddrDtl" value="${sessionScope.loginInfo.loadAddrDtl}"></td>
				</tr>
				<tr>
					<th>요청 사항</th>
					<td colspan="3"><textarea rows="3" class="form-control" name="reqMemo"></textarea></td>
				</tr>
			</table>

			<h2 class="mt-4">상품 정보</h2>
			<table class="table table-bordered">
				<colgroup>
					<col width="20%">
					<col width="30%">
					<col width="20%">
					<col width="30%">
				</colgroup>
				<tr>
					<th>상품 명</th>
					<td>${detail.goodsNm}</td>
					<th>옵션 정보</th>
					<td>${optionInfo[0]}, ${optionInfo[1]}</td>
				</tr>
				<tr>
					<th>수량</th>
					<td><input type="number" class="form-control" name="goodsQty" value="1"></td>
					<th>상품 가격</th>
					<td>${String.format("%,d", detail.goodsPrc - detail.goodsSalePrc)} 원</td>
				</tr>
				<tr>
					<th>배송비</th>
					<td>${String.format("%,d", detail.dlvPrc)} 원</td>
					<th>총 결제 금액</th>
					<td>${String.format("%,d", detail.goodsPrc - detail.goodsSalePrc + detail.dlvPrc)} 원</td>
				</tr>
				<tr>
					<th>배송지</th>
					<td>${sessionScope.loginInfo.loadAddrBase}(${sessionScope.loginInfo.loadAddrDtl})</td>
					<th>결제 수단</th>
					<td>
						<select name="payWay" class="form-select">
							<option value="card">신용/체크카드</option>
							<option value="mobilePay">휴대폰결제</option>
							<option value="kakaoPay">카카오페이</option>
							<option value="naverPay">네이버페이</option>
							<option value="toss">토스</option>
						</select>
					</td>
				</tr>
			</table>

			<div class="text-center my-4">
				<input type="submit" class="btn btn-primary" value="주문하기">
			</div>
		</form>
	</div>
</div>
