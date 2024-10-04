<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container mt-4">
	<h2 class="text-center mb-5">교환 / 반품 신청</h2>

	<form name="frmExchangeReturn" action="/cltsh/adm/order/applyExchangeReturn.do" method="post" enctype="multipart/form-data" onsubmit="return confirmSubmission()">

		<!-- 주문 정보 -->
		<div class="card mb-3">
			<div class="card-body">
				<h5 class="card-title">주문 정보</h5>
				<div class="row">
					<div class="col-md-4">
						<label for="ordNo" class="form-label">주문 번호</label>
						<input type="text" id="ordNo" name="ordNo" class="form-control" maxlength="20" value="${ordDtlVo.ordNo}" readonly>
					</div>
					<div class="col-md-4">
						<label for="payMny" class="form-label">결제 금액</label>
						<input type="text" id="payMny" name="payMny" class="form-control" value="${ordDtlVo.payMny}" readonly>
					</div>
					<div class="col-md-4">
						<label for="ordDate" class="form-label">주문일</label>
						<input type="text" id="ordDate" name="ordDate" class="form-control" value="${ordDtlVo.ordDate}" readonly>
					</div>
				</div>
			</div>
		</div>

		<!-- 교환/반품 신청 -->
		<div class="card mb-3">
			<div class="card-body">
				<h5 class="card-title">교환/반품 신청 정보</h5>

				<!-- 상품 정보 -->
				<div class="row mb-3">
					<div class="col-md-6">
						<label for="goodsNm" class="form-label">상품명</label>
						<input type="text" id="goodsNm" name="goodsNm" class="form-control" value="${ordDtlVo.goodsNm}" readonly>
					</div>
					<div class="col-md-2">
						<label for="goodsQty" class="form-label">수량</label>
						<input type="text" id="goodsQty" name="goodsQty" class="form-control" value="${ordDtlVo.goodsQty}" readonly>
					</div>
					<div class="col-md-4">
						<label for="ordrNm" class="form-label">주문자</label>
						<input type="text" id="ordrNm" name="ordrNm" class="form-control" value="${ordDtlVo.ordrNm}" readonly>
					</div>
				</div>

				<!-- 교환/반품 옵션 선택 -->
				<div class="row mb-3">
					<div class="col-md-6">
						<label for="exchangeReturnType" class="form-label">교환/반품 선택</label>
						<select id="exchangeReturnType" name="exchangeReturnType" class="form-select" required>
							<option value="">선택해주세요</option>
							<option value="exchange">교환 신청</option>
							<option value="return">반품 신청</option>
						</select>
					</div>
					<div class="col-md-6">
						<label for="reason" class="form-label">사유 선택</label>
						<select id="reason" name="reason" class="form-select" required>
							<option value="">사유를 선택해주세요</option>
							<option value="wrong_item">잘못된 상품이 배송됨</option>
							<option value="damaged_item">상품이 손상됨</option>
							<option value="not_satisfied">상품이 만족스럽지 않음</option>
							<option value="other">기타</option>
						</select>
					</div>
				</div>

				<!-- 기타 사유 입력 -->
				<div class="row mb-3" id="otherReasonRow" style="display: none;">
					<div class="col-md-12">
						<label for="otherReason" class="form-label">기타 사유</label>
						<textarea id="otherReason" name="otherReason" class="form-control" rows="3" placeholder="기타 사유를 입력해주세요."></textarea>
					</div>
				</div>

				<!-- 운송장 번호 입력 -->
				<div class="row mb-3">
					<div class="col-md-6">
						<label for="billNum" class="form-label">운송장 번호</label>
						<input type="text" id="billNum" name="billNum" class="form-control" placeholder="운송장 번호를 입력해주세요." value="${ordVo.billNum == 0 ? '' : ordVo.billNum}">
					</div>
					<div class="col-md-6">
						<label for="reqMemo" class="form-label">요청 사항</label>
						<input type="text" id="reqMemo" name="reqMemo" class="form-control" placeholder="요청 사항을 입력해주세요." value="${ordVo.reqMemo}">
					</div>
				</div>
			</div>
		</div>

		<!-- 정책 안내 -->
		<div class="card mb-3">
			<div class="card-body">
				<h5 class="card-title">교환/반품 정책 안내</h5>
				<p>교환/반품 신청은 상품 수령 후 7일 이내에 가능합니다. 상품이 손상되었거나 배송 오류가 발생한 경우
					교환/반품이 가능합니다. 단, 사용한 제품은 교환/반품이 불가합니다.</p>
			</div>
		</div>

		<!-- 제출 버튼 -->
		<div class="text-center mt-4">
			<button type="button" class="btn btn-secondary me-2" onclick="location.href='/cltsh/adm/order/admOrderList.do'">취소</button>
			<button type="submit" class="btn btn-primary">교환/반품 신청</button>
		</div>
	</form>
</div>

<script>
	// 기타 사유 선택 시 표시
	document.getElementById('reason').addEventListener('change', function() {
		if (this.value === 'other') {
			document.getElementById('otherReasonRow').style.display = 'block';
		} else {
			document.getElementById('otherReasonRow').style.display = 'none';
		}
	});

	// 폼 제출 확인
	function confirmSubmission() {
		return confirm('교환/반품 신청을 제출하시겠습니까?');
	}
</script>