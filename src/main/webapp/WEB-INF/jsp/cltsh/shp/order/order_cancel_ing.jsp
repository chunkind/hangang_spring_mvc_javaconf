<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container mt-5">
	<h2 class="text-center mb-4">주문 취소 신청</h2>
		
		<div class="row mb-3">
			<div class="col-md-4">
				<label for="ordNo" class="form-label">주문 번호</label>
				<input type="text" id="ordNo" class="form-control" value="${ordDtlVo.ordNo}" readonly>
			</div>
			<div class="col-md-4">
				<label for="goodsNm" class="form-label">주문 상품</label>
				<input type="text" id="goodsNm" class="form-control" value="${ordDtlVo.goodsNm}" readonly>
			</div>
			<div class="col-md-4">
				<label for="payMny" class="form-label">결제 금액</label>
				<input type="text" id="payMny" class="form-control" value="${ordDtlVo.payMny}" readonly>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-md-4">
				<label for="clmRasn" class="form-label">취소 사유</label>
				<input type="text" id="clmRasn" class="form-control" value="${ordHistVo.clmRasn}" readonly>
			</div>
			<div class="col-md-4">
				<label for="histMemo" class="form-label">추가 상세 내용</label>
				<c:choose>
					<c:when test="${empty ordHistVo.histMemo}">
						<input type="text" id="histMemo" class="form-control" value="없음" readonly>
					</c:when>
					<c:otherwise>
						<input type="text" id="histMemo" class="form-control" value="${ordHistVo.histMemo}" readonly>
					</c:otherwise>
				</c:choose>
			</div>
		</div>


		<div class="text-center">
			<button type="button" class="btn btn-secondary" onclick="history.back();">목록</button>
		</div>
</div>