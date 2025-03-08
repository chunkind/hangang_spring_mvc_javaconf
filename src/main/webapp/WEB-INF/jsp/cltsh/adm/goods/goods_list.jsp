<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2>상품 관리 > 상품 목록</h2>
	<div class="src_area">
		<div>
			<select id="searchEntrNo" name="searchEntrNo">
				<option value="" <c:if test="${empty searchEntrNo}">selected</c:if>>업체를 선택해 주세요</option>
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
					<th class="text-center">전체선택</th>
					<th class="text-center">순번</th>
					<th class="text-center">상품코드</th>
					<th class="text-center">상품이미지</th>
					<th class="text-center">상품명</th>
					<th class="text-center">판매가</th>
					<th class="text-center">상태</th>
					<th class="text-center">재고수량</th>
					<th class="text-center">배송비</th>
					<th class="text-center">컬러</th>
					<th class="text-center">사이즈</th>
					<th class="text-center">등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty goodsList}">
					<tr><td colspan="12" class="text-center">표시할 데이터가 없습니다.</td></tr>
				</c:if>
				<c:forEach items="${goodsList }" var="obj" varStatus="cnt">
					<tr>
						<td>
							<input type="checkbox" id="cb">
						</td>
						<td>${cnt.count}</td>
						<td>${obj.goodsCd}</td>
						<td><img src="${obj.imgPath}${obj.imgNm }" height="200px" width="200px" /></td>
						<td><a href="/cltsh/adm/goods/admGoodsEditNew.do?goodsInfoSeq=${obj.goodsInfoSeq}">${obj.goodsNm}</a></td>
						<!-- <td><input type="button" value="상품 옵션 추가" onclick="location.href='/cltsh/adm/opts/admOptsList.do?goodsCd=${obj.goodsCd}'"/></td> -->
						<td>${obj.goodsPrc}</td>
						<td>${obj.saleStatCd}</td>
						<td>${obj.inyQty}</td>
						<td>${obj.dlvPrc}</td>
						<td>${obj.goodsClr}</td>
						<td>${obj.goodsSize}</td>
						<td>${obj.rgstDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="d-flex justify-content-between align-items-center mt-4">
		<div>${paging}</div>
		<div>
			<a href="/cltsh/adm/goods/admGoodsRegisterNew.do" class="btn btn-primary">등록</a>
		</div>
	</div>
</div>

<script type="text/javascript">
document.addEventListener("DOMContentLoaded", ()=>{
	let sel_entrCd = document.querySelector("#searchEntrNo");
	sel_entrCd.addEventListener('change', (e)=>{
		location.href = '/cltsh/adm/goods/admGoodsList.do?searchEntrNo='+sel_entrCd.value;
	});
});
</script>
