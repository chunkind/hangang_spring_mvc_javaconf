<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container mt-4">
	<h2 class="text-center mb-5">주문 관리</h2>
	<form name="frm" action="/cltsh/adm/order/admOrdStateChange.do" method="post" enctype="multipart/form-data" onsubmit="return fn_order_edit()">

		<div class="row mb-3">
			<div class="col-md-4">
				<label for="ordNo" class="form-label">주문 번호</label>
				<input type="text" id="ordNo" name="ordNo" class="form-control" maxlength="20" value="${ordVo.ordNo}" readonly>
			</div>
			<div class="col-md-4">
				<label for="billNum" class="form-label">운송장 번호</label>
				<input type="text" id="billNum" name="billNum" class="form-control" maxlength="14" placeholder="운송장 번호를 입력해주세요."
					value="${ordVo.billNum == 0 ? '' : ordVo.billNum}">
			</div>
			<div class="col-md-4">
				<label for="ordDate" class="form-label">주문일</label>
				<input type="text" id="ordDate" name="ordDate" class="form-control" maxlength="20" value="${ordVo.ordDate}" readonly>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-md-4">
				<label for="ordStat" class="form-label">주문 상태</label>
				<select name="ordStat" id="ordStat" class="form-select">
					<c:forEach items="${ordStatList}" var="obj">
						<option value="${obj.codeVal}" ${obj.codeVal eq ordVo.ordStat ? 'selected' : ''}>${obj.codeNm}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-4">
				<label for="payWay" class="form-label">결제 수단</label>
				<input type="text" id="payWay" name="payWay" class="form-control" maxlength="20" value="${ordVo.payWay}" readonly>
			</div>
			<div class="col-md-4">
				<label for="payMny" class="form-label">결제 금액</label>
				<input type="text" id="payMny" name="payMny" class="form-control" maxlength="20" value="${ordVo.payMny}" readonly>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-md-4">
				<label for="goodsNm" class="form-label">주문 상품</label>
				<input type="text" id="goodsNm" name="goodsNm" class="form-control" maxlength="20" value="${ordVo.goodsNm}" readonly>
			</div>
			<div class="col-md-4">
				<label for="goodsQty" class="form-label">수량</label>
				<input type="text" id="goodsQty" name="goodsQty" class="form-control" maxlength="20" value="${ordVo.goodsQty}" readonly>
			</div>
			<div class="col-md-4">
				<label for="ordrNm" class="form-label">주문자</label>
				<input type="text" id="ordrNm" name="ordrNm" class="form-control" maxlength="20" value="${ordVo.ordrNm}" readonly>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-md-4">
				<label for="ordrId" class="form-label">주문자 아이디</label>
				<input type="text" id="ordrId" name="ordrId" class="form-control" maxlength="20" value="${ordVo.ordrId}" readonly>
			</div>
			<div class="col-md-4">
				<label for="ordrPhon" class="form-label">주문자 연락처</label>
				<input type="text" id="ordrPhon" name="ordrPhon" class="form-control" maxlength="20" value="${ordVo.ordrPhon}" readonly>
			</div>
			<div class="col-md-4">
				<label for="ordrEmail" class="form-label">주문자 이메일</label>
				<input type="email" id="ordrEmail" name="ordrEmail" class="form-control" maxlength="30" value="${ordVo.ordrEmail}" readonly>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-md-4">
				<label for="acqrNm" class="form-label">수취자</label>
				<input type="text" id="acqrNm" name="acqrNm" class="form-control" maxlength="20" value="${ordVo.acqrNm}" readonly>
			</div>
			<div class="col-md-4">
				<label for="acqrPhon" class="form-label">수취자 연락처</label>
				<input type="text" id="acqrPhon" name="acqrPhon" class="form-control" maxlength="20" value="${ordVo.acqrPhon}" readonly>
			</div>
			<div class="col-md-4">
				<label for="acqrAddr" class="form-label">주소</label>
				<input type="text" id="acqrAddr" name="acqrAddr" class="form-control" maxlength="100" value="${ordVo.acqrAddr}" readonly>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-md-4">
				<label for="acqrAddrDtl" class="form-label">상세 주소</label>
				<input type="text" id="acqrAddrDtl" name="acqrAddrDtl" class="form-control" maxlength="100" value="${ordVo.acqrAddrDtl}" readonly>
			</div>
			<div class="col-md-4">
				<label for="reqMemo" class="form-label">요청 사항</label>
				<input type="text" id="reqMemo" name="reqMemo" class="form-control" maxlength="100" value="${ordVo.reqMemo}" readonly>
			</div>
		</div>

		<div class="text-center mt-4">
			<button type="button" class="btn btn-secondary me-2" onclick="location.href='/cltsh/adm/order/admOrderList.do'">목록</button>
			<button type="submit" class="btn btn-primary">저장</button>
		</div>
	</form>
</div>

<script>
	// 저장 기능 확인
	function fn_order_edit() {
		return confirm('주문을 저장하시겠습니까?');
	}
</script>