<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container mt-5">
	<h2 class="text-center mb-4">주문 취소 신청</h2>

	<form action="/cltsh/order/order_cancelAct.do" method="post" onsubmit="return confirmCancel();">
		<input type="hidden" name="ordClmNo" value="${ordDtlVo.ordClmNo}">
		<input type="hidden" name="usrId" value="${ordDtlVo.ordrId}">
		<input type="hidden" name="ordClmDtlSn" value="${ordDtlVo.ordClmDtlSn}">
		<input type="hidden" name="goodsCd" value="${ordDtlVo.goodsCd}">
		<input type="hidden" name="goodsQty" value="${ordDtlVo.goodsQty}">
		
		<div class="row mb-3">
			<div class="col-md-4">
				<label for="ordNo" class="form-label">주문 번호</label>
				<input type="text" id="ordNo" name="ordNo" class="form-control" value="${ordDtlVo.ordNo}" readonly>
			</div>
			<div class="col-md-4">
				<label for="goodsNm" class="form-label">주문 상품</label>
				<input type="text" id="goodsNm" name="goodsNm" class="form-control" value="${ordDtlVo.bulTitNm}" readonly>
			</div>
			<div class="col-md-4">
				<label for="payMny" class="form-label">결제 금액</label>
				<input type="text" id="payMny" class="form-control" value=" ${String.format("%,d", ordDtlVo.payMny)}원" readonly>
			</div>
		</div>

		<div class="mb-3">
			<label for="clmRasn" class="form-label">취소 사유</label>
			<select id=clmRasn name="clmRasn" class="form-select" required>
				<option value="">취소 사유를 선택하세요</option>
				<option value="배송 지연">배송 지연</option>
				<option value="단순 변심">단순 변심</option>
				<option value="상품 불량">상품 불량</option>
				<option value="기타">기타</option>
			</select>
		</div>

		<div class="mb-3">
			<label for="histMemo" class="form-label">추가 상세 내용</label>
			<textarea id="histMemo" name="histMemo" class="form-control" rows="4" placeholder="추가 내용을 입력하세요 (선택 사항)"></textarea>
		</div>

		<div class="text-center">
			<button type="submit" class="btn btn-danger">주문 취소</button>
			<button type="button" class="btn btn-secondary" onclick="history.back();">취소</button>
		</div>
	</form>
</div>

<script>
	function confirmCancel() {
		var selectElement = document.getElementById("clmRasn");
		var selectElementMemo = document.getElementById("histMemo");
		if (selectElement.value === "기타" && selectElementMemo.value === "") {
			alert("추가 상세 내용을 입력해 주세요.");
			return false;
		}
		if (selectElement.value === "") {
			alert("취소 사유를 선택하세요.");
			return false;
		}
		return confirm("주문을 취소하시겠습니까?");
	}
</script>