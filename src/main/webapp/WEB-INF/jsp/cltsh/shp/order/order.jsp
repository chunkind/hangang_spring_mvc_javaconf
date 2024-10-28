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

		<!-- <form name="frm" action="/cltsh/order/orderRegister.do" method="post"> -->
		<form name="SendPayForm_id" id="SendPayForm_id" action="/cltsh/order/payPcReq.do" method="post">
			<input type="hidden" name="saleBoardSeq" value="${detail.saleBoardSeq}">
			<input type="hidden" name="entrNo" value="${detail.entrNo}">
			<input type="hidden" name="goodsNm" value="${detail.goodsNm}">
			<input type="hidden" name="goodsCd" value="${detail.goodsCd}">
			<input type="hidden" name="payMny" value="${detail.goodsPrc - detail.goodsSalePrc + detail.dlvPrc}">
			<input type="hidden" name="clmSctCd" value="01">
			<input type="hidden" name="clmStatCd" value="01"> 
			
			<input type="hidden" name="version" value="1.0">
			<input type="hidden" name="gopaymethod" value="Card:Directbank:vbank">
			<input type="hidden" name="mid" value="${payVo.mid }">
			<input type="hidden" name="oid" value="${payVo.oid }">
			<input type="hidden" name="price" value="${payVo.price }">
			<input type="hidden" name="timestamp" value="${payVo.timestamp }">
			<input type="hidden" name="useChkfake" value="${payVo.useChkfake }">
			<input type="hidden" name="signature" value="${payVo.signature }">
			<input type="hidden" name="verification" value="${payVo.verification }">
			<input type="hidden" name="mKey" value="<%=mKey%>">
			<input type="hidden" name="currency" value="WON"> 
			<input type="hidden" name="goodname" value="${detail.goodsNm}">
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
				<!-- <input type="button" class="btn btn-primary" onclick="orderPay();" value="주문하기"> -->
				<input type="button" class="btn btn-primary" onclick="openPaymentPopup();" value="주문하기">
				
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">
	function openPaymentPopup() {
		// 결제 창을 여는 코드 (INIStdPay 사용)
		INIStdPay.pay('SendPayForm_id'); // ID를 결제 폼의 ID로 설정하세요.
	}
</script>

<!-- <script type="text/javascript">
	function openPaymentPopup() {
		var form = document.frm; // 폼 객체
		var popUrl = form.action; // form에서 action 속성을 가져와 팝업으로 사용할 URL
		var popOption = "width=800, height=600, resizable=no, scrollbars=no, status=no"; // 팝업창 옵션

		// 새로운 창에 form 데이터를 post 방식으로 전송하기 위한 방법
		var newWindow = window.open('', 'orderPay', popOption); // 새로운 창을 팝업으로 엶
		form.target = 'orderPay'; // 폼의 타겟을 팝업창으로 설정
		form.submit(); // 폼 제출
	}
</script> -->

<!-- <script>
function orderPay(){
	window.open('/cltsh/order/payPcReq.do', 'orderPay', 'width=800,height=600');
}

</script> -->

