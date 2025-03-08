<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.inicis.std.util.SignatureUtil"%>
<%@page import="java.util.*"%>

<%
	String signKey = "SU5JTElURV9UUklQTEVERVNfS0VZU1RS";
	String mKey = SignatureUtil.hash(signKey, "SHA-256");	
%>

<!--테스트 JS-->
<script language="javascript" type="text/javascript" src="https://stgstdpay.inicis.com/stdjs/INIStdPay.js" charset="UTF-8"></script>

<div class="container">
	<div class="item_list_area my-4">
		<h3 class="title text-center">주문 내역 입니다.</h3>

		<form name="SendPayForm_id" id="SendPayForm_id" action="/cltsh/order/payPcReq.do" method="post">
		<!-- <form name="frm" action="/cltsh/order/orderCartRegisterAct.do" method="post"> -->
			<input type="hidden" name="checkedList" value="${key}">
			<input type="hidden" name="clmSctCd" value="01">
			<input type="hidden" name="clmStatCd" value="01">
			
			<input type="hidden" name="version" value="1.0">
			<input type="hidden" name="gopaymethod" value="Card:Directbank:vbank">
			<input type="hidden" name="mid" value="${payVo.mid }">
			<input type="hidden" name="oid" value="${payVo.ordNo }">
			<input type="hidden" name="price" value="${payVo.goodsPrc }">
			<input type="hidden" name="timestamp" value="${payVo.timestamp }">
			<input type="hidden" name="useChkfake" value="${payVo.useChkfake }">
			<input type="hidden" name="signature" value="${payVo.signature }">
			<input type="hidden" name="verification" value="${payVo.verification }">
			<input type="hidden" name="mKey" value="<%=mKey%>">
			<input type="hidden" name="currency" value="WON"> 
			<input type="hidden" name="goodname" value="${goodsNm}">
			<input type="hidden" name="buyername" value="${sessionScope.loginInfo.usrNm}">
			<input type="hidden" name="buyertel" value="${sessionScope.loginInfo.cellNo}">
			<input type="hidden" name="buyeremail" value="${sessionScope.loginInfo.emailAddr}">
			<input type="hidden" name="returnUrl" value="http://localhost:9999/cltsh/order/payPcReturn.do">
			<input type="hidden" name="closeUrl" value="http://localhost:9999/cltsh/order/payPcClose.do">
			<input type="hidden" name="acceptmethod" value="HPP(1):below1000:centerCd(Y)">
			
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
				
				<c:forEach items="${detail}" var="obj">
					<input type="hidden" name="entrNo" value="${obj.entrNo}">
					<input type="hidden" name="goodsNm" value="${obj.goodsNm}">
					<input type="hidden" name="goodsCd" value="${obj.goodsCd}">
					<input type="hidden" name="payMny" value="${totalPayment}">
					<input type="hidden" name="saleBoardSeqs" value="${obj.saleBoardSeq}">
					<tr>
						<th>상품 명</th>
						<td>${obj.goodsNm}</td>
						<th>옵션 정보</th>
						<td>${optionInfo[0]}, ${optionInfo[1]}</td>
					</tr>
					<tr>
						<th>수량</th>
						<td><input type="number" class="form-control" name="goodsQty" value="1"></td>
						<th>상품 가격</th>
						<td>${String.format("%,d", obj.goodsPrc - obj.goodsSalePrc)} 원</td>
					</tr>
				</c:forEach>
				<tr>
					<th>배송비</th>
					<td>${String.format("%,d", totalDlvPrc)} 원</td>
					<th>총 결제 금액</th>
					<td>${String.format("%,d", totalPayment)} 원</td>
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
				<input type="button" class="btn btn-primary" onclick="sendPaymentData();" value="주문하기">
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">
	function openPaymentPopup() {
		// payPcReq에서 응답을 받은 후 결제 창을 열기 위해 호출
		INIStdPay.pay('SendPayForm_id');
	}
	
	function sendPaymentData() {
		const formData = new FormData(document.getElementById('SendPayForm_id'));
		
		fetch('/cltsh/order/payOrder.do', {
			method: 'POST',
			body: formData
		})
		.then(response => response.json())
		.then(data => {
			if (data.result === 'success') {
				INIStdPay.pay('SendPayForm_id');
			} else {
				alert('저장 실패: ' + data.message);
			}
		})
		.catch(error => console.error('Error:', error));
	}
</script>
