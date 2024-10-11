<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container mt-4">
	<h2 class="text-center mb-5">주문 관리</h2>
	<form name="frm" action="/cltsh/adm/order/admOrderCancelConfirmAct.do" method="post" enctype="multipart/form-data" onsubmit="return fn_order_cancel()">
		<input type="hidden" name="ordNo" value="${ordHistVo.ordNo}">
		<input type="hidden" name="ordClmNo" value="${ordHistVo.ordClmNo}">
		<input type="hidden" name="ordClmDtlSn" value="${ordHistVo.ordClmDtlSn}">
		
		<div class="row mb-3">
			<div class="col-md-4">
				<label for="ordNo" class="form-label">주문 번호</label>
				<input type="text" id="ordNo" class="form-control" value="${ordVo.ordNo}" readonly>
			</div>
			<div class="col-md-4">
				<label for="goodsNm" class="form-label">주문 상품</label>
				<input type="text" id="goodsNm" name="goodsNm" class="form-control" value="${ordVo.goodsNm}" readonly>
			</div>
			<div class="col-md-4">
				<label for="ordDate" class="form-label">주문일</label>
				<input type="text" id="ordDate" name="ordDate" class="form-control" value="${ordVo.ordDate}" readonly>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-md-4">
				<label for="payMny" class="form-label">결제 금액</label>
				<input type="text" id="payMny" name="payMny" class="form-control" value="${ordVo.payMny}" readonly>
			</div>
			<div class="col-md-4">
				<label for="goodsQty" class="form-label">수량</label>
				<input type="text" id="goodsQty" name="goodsQty" class="form-control" value="${ordVo.goodsQty}" readonly>
			</div>
			<div class="col-md-4">
				<label for="payWay" class="form-label">결제 수단</label>
				<input type="text" id="payWay" name="payWay" class="form-control" value="${ordVo.payWay}" readonly>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-md-4">
				<label for="ordrNm" class="form-label">주문자</label>
				<input type="text" id="ordrNm" name="ordrNm" class="form-control" value="${ordVo.ordrNm}" readonly>
			</div>
			<div class="col-md-4">
				<label for="ordrId" class="form-label">주문자 아이디</label>
				<input type="text" id="ordrId" name="ordrId" class="form-control" value="${ordVo.ordrId}" readonly>
			</div>
			<div class="col-md-4">
				<label for="ordrPhon" class="form-label">주문자 연락처</label>
				<input type="text" id="ordrPhon" name="ordrPhon" class="form-control" value="${ordVo.ordrPhon}" readonly>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-md-4">
				<label for="ordrEmail" class="form-label">주문자 이메일</label>
				<input type="email" id="ordrEmail" name="ordrEmail" class="form-control" value="${ordVo.ordrEmail}" readonly>
			</div>
			<div class="col-md-4">
				<label for="acqrNm" class="form-label">수취자</label>
				<input type="text" id="acqrNm" name="acqrNm" class="form-control" value="${ordVo.acqrNm}" readonly>
			</div>
			<div class="col-md-4">
				<label for="acqrPhon" class="form-label">수취자 연락처</label>
				<input type="text" id="acqrPhon" name="acqrPhon" class="form-control" value="${ordVo.acqrPhon}" readonly>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-md-4">
				<label for="acqrAddr" class="form-label">주소</label>
				<input type="text" id="acqrAddr" name="acqrAddr" class="form-control" value="${ordVo.acqrAddr}" readonly>
			</div>
			<div class="col-md-4">
				<label for="acqrAddrDtl" class="form-label">상세 주소</label>
				<input type="text" id="acqrAddrDtl" name="acqrAddrDtl" class="form-control" value="${ordVo.acqrAddrDtl}" readonly>
			</div>
			<div class="col-md-4">
				<label for="reqMemo" class="form-label">요청 사항</label>
				<input type="text" id="reqMemo" name="reqMemo" class="form-control" value="${ordVo.reqMemo}" readonly>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-md-4">
				<label for="clmRasn" class="form-label">취소 사유</label>
				<input type="text" id="clmRasn" name="clmRasn" class="form-control" value="${ordHistVo.clmRasn}" readonly>
			</div>
			<div class="col-md-4">
				<label for="histMemo" class="form-label">추가 상세 내용</label>
				<input type="text" id="histMemo" name="histMemo" class="form-control" value="${ordHistVo.histMemo}" readonly>
			</div>
		</div>

		<div class="text-center mt-4">
			<button type="button" class="btn btn-secondary me-2" onclick="location.href='/cltsh/adm/order/admOrderList.do'">목록</button>
			<button type="submit" class="btn btn-primary">취소 승인</button>
		</div>
	</form>
</div>

<script>
	// 취소 승인
	function fn_order_cancel() {
		return confirm('취소을 승인 하시겠습니까?');
	}
</script>