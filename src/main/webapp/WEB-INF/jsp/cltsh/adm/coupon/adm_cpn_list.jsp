<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2>쿠폰 목록</h2>
	<div class="table-responsive">
		<table class="table table-striped table-hover" style="border-top: 1px solid black;">
			<thead>
				<tr>
					<th>선택</th>
					<th>쿠폰 코드</th>
					<th>쿠폰 이름</th>
					<th>쿠폰 할인율</th>
					<th>쿠폰 등록 날짜</th>
					<th>쿠폰 만료 날짜</th>
					<th>쿠폰 개수</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty list }">
					<tr><td colspan="7">데이터가 없습니다.</td></tr>
				</c:if>
				<c:forEach items="${list }" var="obj" varStatus="cnt">
					<tr>
						<td><input type="checkbox" id="cb"></td>
						<td>${obj.couNum}</td>
						<td><a href="/cltsh/adm/cpn/admCpnEdit.do?couInfoSeq=${obj.couInfoSeq}">${obj.couName}</a></td>
						<td>${obj.couDiscount}%</td>
						<td>${obj.couRegistDate}</td>
						<td>${obj.couEndDate}</td>
						<td>${obj.couCount}개</td> 
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="d-flex justify-content-between align-items-center mt-4">
		<div>${paging}</div>
		<div>
			<a href="/cltsh/adm/cpn/admCpnRegister.do" class="btn btn-primary">추가</a>
		</div>
	</div>
</div>
