<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container mt-4">
	<h2>주문 관리</h2>
	<div class="table-responsive mb-4">
		<h3>주문내역 검색</h3>
		<div>
			<table class="table table-striped table-hover">
				<colgroup>
					<col width="10%"></col>
					<col width="90%"></col>
				</colgroup>
				<tr>
					<th>검색조건</th>
					<td>
						<div>
							<select>
								<option>주문번호</option>
								<option>주문상품정보</option>
								<option>주문자정보</option>
								<option>결제정보</option>
								<option>배송완료일</option>
								<option>배송정보</option>
								<option>주문상태</option>
							</select> <input type="text">
						</div>
					</td>
				</tr>
				<tr>
					<th>기간</th>
					<td>
						<div>
							<select>
								<option>주문일</option>
							</select> <a href="">전체</a> <a href="">오늘</a> <a href="">3일</a> <a href="">7일</a>
							<a href="">1개월</a> <a href="">3개월</a> <a href="">1년</a> <input
								type="text"> 부터 <input type="text"> 까지
						</div>
					</td>
				</tr>
				<tr>
					<th>결제수단</th>
					<td>
						<div>
							<input type="checkbox">무통장입금 <input type="checkbox">신용카드
							<input type="checkbox">실시간 계좌이체 <input type="checkbox">가상계좌
							<input type="checkbox">휴대폰
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div>
			<select name="" id="">
				<option value="">주문번호순</option>
				<option value="">주문일순</option>
			</select>
		</div>
	</div>
	<div class="table-responsive">
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th class="text-center">선택</th>
					<th class="text-center">주문번호</th>
					<th class="text-center">주문일</th>
					<th class="text-center">주문상품정보</th>
					<th class="text-center">주문자정보</th>
					<th class="text-center">결제정보</th>
					<th class="text-center">운송장 번호</th>
					<th class="text-center">주문상태</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orderList}" var="obj">
					<tr>
						<td class="text-center align-middle"><input type="checkbox"></td>
						<td class="text-center align-middle"><a href="/cltsh/adm/order/admOrderDetail.do?ordClmNo=${obj.ordClmNo}">${obj.ordNo}</td>
						<td class="text-center align-middle">${obj.ordDate}</td>
						<td class="text-center align-middle">${obj.goodsNm}</td>
						<td class="text-center align-middle">${obj.usrId}<br>${obj.ordrNm}</td>
						<td class="text-center align-middle">${obj.payMny}원<br>${obj.payWay}</td>
						<c:choose>
							<c:when test="${obj.billNum == 0}">
								<td class="text-center align-middle">배송 준비 중</td>
							</c:when>
							<c:otherwise>
								<td class="text-center align-middle">${obj.billNum }</td>
							</c:otherwise>
						</c:choose>
						<td class="text-center align-middle"">
							<c:choose>
								<c:when test="${obj.clmSctCd == '01' and obj.clmStatCd == '01'}">
									<a style="color: blue;">주문 대기</a>
								</c:when>
								<c:when test="${obj.clmSctCd == '01' and obj.clmStatCd == '02'}">
									<a style="color: green;">주문 완료</a>
								</c:when>
								<c:when test="${obj.clmSctCd == '01' and obj.clmStatCd == '03'}">
									<a style="color: red;">주문 취소</a>
								</c:when>

								<c:when test="${obj.clmSctCd == '02' and obj.clmStatCd == '01'}">
									<a href="/cltsh/adm/order/admOrderCancelConfirm.do?ordNo=${obj.ordNo}&ordClmNo=${obj.ordClmNo}" style="color: orange; text-decoration: none;">취소 대기</a>
								</c:when>
								<c:when test="${obj.clmSctCd == '02' and obj.clmStatCd == '02'}">
									<%-- <a href="/cltsh/adm/order/admOrderCancelConfirm.do?ordNo=${obj.ordNo}&ordClmNo=${obj.ordClmNo}" style="color: green; text-decoration: none;">취소 완료</a> --%>
									<a style="color: green; text-decoration: none;">취소 완료</a>
								</c:when>
								<c:when test="${obj.clmSctCd == '02' and obj.clmStatCd == '03'}">
									<%-- <a href="/cltsh/adm/order/admOrderCancelConfirm.do?ordNo=${obj.ordNo}&ordClmNo=${obj.ordClmNo}" style="color: red; text-decoration: none;">취소 취소</a> --%>
									<a style="color: red; text-decoration: none;">취소 취소</a>
								</c:when>
								
								<c:otherwise>
									거래중
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		${paging }
	</div>
</div>
