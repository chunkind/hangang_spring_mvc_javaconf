<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp"%>
<h2>주문 관리</h2>
<div class="src_area">
	<h3>주문내역 검색</h3>
	<div>
		<table>
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
<div class="data_list">
	<table>
		<thead>
			<tr>
				<th>선택</th>
				<th>주문번호</th>
				<th>주문일</th>
				<th>주문상품정보</th>
				<th>주문자정보</th>
				<th>결제정보</th>
				<th>운송장 번호</th>
				<th>주문상태</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orderList}" var="obj">
				<tr>
					<td><input type="checkbox"></td>
					<td><a
						href="/cltsh/adm/order/admOrderDetail.do?ordNo=${obj.ordNo}">${obj.ordNo}</td>
					<td>${obj.ordDate}</td>
					<td>${obj.goodsNm}</td>
					<td>${obj.usrId}<br>${obj.ordrNm}
					</td>
					<td>${obj.payMny}원<br>${obj.payWay}
					</td>
					<c:choose>
						<c:when test="${obj.billNum == 0}">
							<td>배송 준비 중</td>
						</c:when>
						<c:otherwise>
							<td>${obj.billNum }</td>
						</c:otherwise>
					</c:choose>
					<td>${obj.codeNm }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pageNav">
		<a href='<c:url value="/cltsh/adm/order/admOrderList.do?page=1"/>'><i
			class="fa">◀</i></a>
		<!-- 맨 앞 페이지로 -->
		<c:choose>
			<c:when test="${page eq 1 && isNext eq 'true'}">
				<a href='<c:url value="/cltsh/adm/order/admOrderList.do?page=1"/>'><i
					class="fa">◀</i></a>
			</c:when>
			<c:when test="${isNext eq 'true' }">
				<a
					href='<c:url value="/cltsh/adm/order/admOrderList.do?page=${minPage - 10}"/>'><i
					class="fa">◀</i></a>
			</c:when>
		</c:choose>
		<c:forEach begin="${minPage }" end="${maxPage }" var="pageNum">
			<a <c:if test="${page eq pageNum}">class="active"</c:if>
				href='<c:url value="/cltsh/adm/order/admOrderList.do?page=${pageNum }"/>'><i
				class="fa">${pageNum }</i></a>
		</c:forEach>
		<c:if test="${isNext eq 'true' }">
			<a
				href='<c:url value="/cltsh/adm/order/admOrderList.do?page=${maxPage + 1}"/>'><i
				class="fa">▶</i></a>
		</c:if>
		<a
			href='<c:url value="/cltsh/adm/order/admOrderList.do?page=${ordCnt }"/>'><i
			class="fa">▶</i></a>
		<!-- 맨 뒤 페이지로 -->
	</div>
</div>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp"%>