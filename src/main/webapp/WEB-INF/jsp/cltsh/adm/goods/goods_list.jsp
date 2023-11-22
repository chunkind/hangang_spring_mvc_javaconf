<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
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
<div class="data_list">
	<table>
	    <thead>
	        <tr>
	            <th>전체선택</th>
	            <th>순번</th>
	            <th>상품코드</th>
	            <th>상품이미지</th>
	            <th>상품명</th>
	            <th>판매가</th>
	            <th>상태</th>
	            <th>재고수량</th>
	            <th>배송비</th>
	            <th>컬러</th>
	            <th>사이즈</th>
	            <th>등록일</th>
	        </tr>
	    </thead>
	    <tbody>
	    	<c:if test="${empty goodsList}">
	    		<tr><td colspan="12">표시할 데이터가 없습니다.</td></tr>
	    	</c:if>
	    	<c:forEach items="${goodsList }" var="obj" varStatus="cnt">
		        <tr>
		            <td>
		            	<input type="checkbox" id="cb">
		            </td>
		            <td>${cnt.count}</td>
		            <td>${obj.goodsCd}</td>
		            <td><img src="${obj.imgPath}${obj.imgNm }" height="200px" width="200px" /></td>
		            <td><a href="/cltsh/adm/goods/admGoodsEdit.do?goodsInfoSeq=${obj.goodsInfoSeq}">${obj.goodsNm}</a></td>
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
	${paging }
<div class="btn_area">
	<input type="button" value="등록" onclick="location.href='/cltsh/adm/goods/admGoodsRegister.do'" />
</div>
<script type="text/javascript">
document.addEventListener("DOMContentLoaded", ()=>{
	let sel_entrCd = document.querySelector("#searchEntrNo");
	sel_entrCd.addEventListener('change', (e)=>{
		location.href = '/adm/goods/admGoodsList.do?searchEntrNo='+sel_entrCd.value;
	});
});
</script>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>