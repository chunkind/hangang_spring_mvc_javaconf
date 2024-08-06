<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container my-5">
	<div class="text-center mb-4">
		<h3 class="display-6">주문이 완료 되었습니다.</h3>
	</div>
	<div class="row justify-content-center">
		<div class="col-md-6">
			<table class="table table-bordered">
				<colgroup>
					<col width="50%">
					<col width="50%">
				</colgroup>
				<tr>
					<th>상품 명:</th>
					<c:choose>
						<c:when test="${not empty orderDtlList}">
							<c:forEach items="${orderDtlList}" var="obj">
								<td>${obj.goodsNm}</td>
							</c:forEach>
						</c:when>
						<c:when test="${not empty orderDtlOne}">
							<td>${orderDtlOne.goodsNm}</td>
						</c:when>
					</c:choose>
				</tr>
				<tr>
					<th>결제 금액:</th>
					<td>${String.format("%,d", orderOne.payMny)}원</td>
				</tr>
				<tr>
					<th>배송지:</th>
					<td>${orderOne.acqrAddr}(${orderOne.acqrAddrDtl})</td>
				</tr>
				<tr>
					<th>결제 수단:</th>
					<td>${orderOne.payWay}</td>
				</tr>
			</table>
			<div class="text-center mt-4">
				<button class="btn btn-primary" onclick="location.href='/cltsh/main.do'">확인</button>
			</div>
		</div>
	</div>
</div>
