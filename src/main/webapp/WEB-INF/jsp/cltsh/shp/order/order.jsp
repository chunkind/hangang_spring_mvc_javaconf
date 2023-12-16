<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/nomalMenu.jsp" %>
<style>
.btn_area button{
	padding: 20px;
	font-size: 16px;
	font-weight: bold;
}
table{
	width: 100%;
}
.item_list_area{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
form{
	width: 60%;
}
input[type=text], input[type=number], select{
	width: 100%;
	height: 30px;
}
textarea {
	width: 100%;
}
</style>
<section class="title_area">
	<h3 class="title">주문 내역 입니다.</h3>
</section>
<section class="item_list_area">
<form name="frm" action="/cltsh/order/orderRegister.do" method="post">
<input type="hidden" name="saleBoardSeq" value="${detail.saleBoardSeq}">
<input type="hidden" name="entrNo" value="${detail.entrNo}">
<input type="hidden" name="goodsNm" value="${detail.goodsNm}"> <!-- 상품명 -->
<input type="hidden" name="goodsCd" value="${detail.goodsCd}"> <!-- 상품 코드 -->
<input type="hidden" name="payMny" value="${detail.goodsPrc - detail.goodsSalePrc + detail.dlvPrc}">
<h2>배송 정보</h2>
<table>
	<colgroup>
		<col width="20%" />
		<col width="30%" />
		<col width="20%" />
		<col width="30%" />
	</colgroup>
	<tr>
		<th>주문자 이름</th>
		<td><input type="text" name="ordrNm" value="${sessionScope.loginInfo.usrNm}"></td>
		<th>주문자 전화번호</th>
		<td><input type="text" name="ordrPhon" value="${sessionScope.loginInfo.cellNo}"></td>
	</tr>
	<tr>
		<th>주문자 이메일</th>
		<td><input type="text" name="ordrEmail" value="${sessionScope.loginInfo.emailAddr}"></td>
		<th>수취자 이름</th>
		<td><input type="text" name="acqrNm" value="${sessionScope.loginInfo.usrNm}"></td>
	</tr>
	<tr>
		<th>수취자 전화번호</th>
		<td><input type="text" name="acqrPhon" value="${sessionScope.loginInfo.cellNo}"></td>
		<th>수취자 이메일</th>
		<td><input type="text" name="acqrEmail" value="${sessionScope.loginInfo.emailAddr}"></td>
	</tr>
	<tr>
		<th>수취자 주소</th>
		<td><input type="text" name="acqrAddr" value="${sessionScope.loginInfo.loadAddrBase}"></td>
		<th>수취자 상세 주소</th>
		<td><input type="text" name="acqrAddrDtl" value="${sessionScope.loginInfo.loadAddrDtl}"></td>
	</tr>
	<tr>
		<th>요청 사항</th>
		<td colspan="3">
			<textarea rows="10" cols="50" name=reqMemo></textarea>
		</td>
	</tr>
</table>

<h2>상품 정보</h2>
<table>
	<colgroup>
		<col width="20%" />
		<col width="30%" />
		<col width="20%" />
		<col width="30%" />
	</colgroup>
	<tr>
		<th>상품 명</th>
		<td>${detail.goodsNm}</td>
		<th>옵션 정보</th>
		<td>${optionInfo[0] }, ${optionInfo[1] }</td>
	</tr>
	<tr>
		<th>수량</th>
		<td><input type="number" name="goodsQty" value="1"> <!-- 상품 코드 --></td>
		<th>상품 가격</th>
		<td>${String.format("%,d", detail.goodsPrc - detail.goodsSalePrc)} 원</td>
	</tr>
	<tr>
		<th>배송비</th>
		<td>${String.format("%,d", detail.dlvPrc)}원</td>
		<th>총 결제 금액</th>
		<td>${String.format("%,d", detail.goodsPrc - detail.goodsSalePrc + detail.dlvPrc)} 원</td>
	</tr>
	<tr>
		<th>배송지</th>
		<td>${sessionScope.loginInfo.loadAddrBase}(${sessionScope.loginInfo.loadAddrDtl})</td>
		<th>결제 수단</th>
		<td>
			<select name="payWay">
				<option value="card">신용/체크카드</option>
				<option value="mobilePay">휴대폰결제</option>
				<option value="kakaoPay">카카오페이</option>
				<option value="naverPay">네이버페이</option>
				<option value="toss">토스</option>
			</select>
		</td>
	</tr>
</table>
<div class="btn_area">
	<input type="submit" value="주문하기">
</div>
</form>
</section>