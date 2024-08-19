<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2>상품 판매 게시글 관리</h2>
	<div class="src_area">
		<div>
			<select name="searchEntrNo" id="searchEntrNo">
				<c:forEach items="${entrList}" var="obj">
					<option value="${obj.entrNo}" <c:if test="${searchEntrNo eq obj.entrNo}">selected</c:if>>${obj.entrNm}(${obj.entrNo})</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="table-responsive">
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th class="text-center">게시번호</th>
					<th class="text-center">상품코드</th>
					<th class="text-center">제목</th>
					<th class="text-center">게시여부</th>
					<th class="text-center">게시시작일</th>
					<th class="text-center">게시종료일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty salesList}">
					<tr><td colspan="6" class="text-center">표시할 데이터가 없습니다.</td></tr>
				</c:if>
				<c:forEach items="${salesList}" var="obj">
					<tr onclick="fn_showDetail('${obj.saleBoardSeq}')">
						<td>${obj.saleBoardSeq}</td>
						<td>${obj.goodsCd}</td>
						<td>${obj.bulTitNm}</td>
						<td>${obj.bulYn}</td>
						<td>${obj.bulStrtDt}</td>
						<td>${obj.bulEndDt}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="d-flex justify-content-between align-items-center mt-4">
		<a href="/cltsh/adm/sales/admSalesRegister.do" class="btn btn-primary">등록</a>
	</div>
</div>

<script>
document.addEventListener("DOMContentLoaded", ()=>{
	let sel_entrCd = document.querySelector("#searchEntrNo");
	sel_entrCd.addEventListener('change', (e)=>{
		location.href = '/adm/sales/admSalesList.do?searchEntrNo='+sel_entrCd.value;
	});
});
function fn_showDetail(saleBoardSeq){
	location.href="/cltsh/adm/sales/admSalesUpdate.do?saleBoardSeq="+saleBoardSeq;
}
</script>
