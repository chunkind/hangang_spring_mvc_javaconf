<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
<div class="container marketing" style="margin-top:50px;">
	<div class="row">
		<c:if test="${searchType eq 'all'}">
			<div class="btn-group" role="group" aria-label="Basic radio toggle button group">
			  <input type="radio" class="btn-check" name="btnradio" id="btnradio1" autocomplete="off" checked onclick="location.href='/cltsh/main/mainCataList.do?searchType=all';">
			  <label class="btn btn-outline-primary" for="btnradio1">전체</label>
			</div>
		</c:if>
		<c:if test="${searchType ne 'all'}">
			<div class="btn-group" role="group" aria-label="Basic radio toggle button group">
			<c:forEach items="${twoDepthCateList}" var="obj" varStatus="status">
				  <input type="radio" class="btn-check" name="btnradio" id="btnradio${status.count}" autocomplete="off" <c:if test="${obj.catgryCd eq selectedTwoDepthCate}">checked</c:if> onclick="location.href='/cltsh/main/mainCataList.do?searchCatgryCd=${selectedOneDepthCate}&searchCatgryCd2=${obj.catgryCd}';" >
				  <label class="btn btn-outline-primary" for="btnradio${status.count}">${obj.catgryNm}</label>
			</c:forEach>
			</div>
		</c:if>
	</div>
	<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5">
		<c:choose>
			<c:when test="${not empty mainCateList }">
			<c:forEach var="obj" items="${mainCateList}" varStatus="status">
				<div class="col" onclick="pageMove('product', '${obj.saleBoardSeq}')" style="margin-top: 12px; margin-bottom: 12px;">
					<div class="card shadow-sm">
						<img class="bd-placeholder-img card-img-top" width="100%" height="225" src="${obj.imgPath}${obj.imgNm}">
						<div class="card-body">
							<p class="card-text">${obj.bulTitNm}</p>
							<div class="d-flex justify-content-between align-items-center">
								<small class="text-body-secondary">${String.format("%,d", obj.goodsPrc - obj.goodsSalePrc)}원</small>
							</div>
						</div>
						<div class="card-body">
							<c:if test="${not empty sessionScope.loginInfo }">
								<button class="btn btn-primary" onclick="fn_add_basket('${obj.saleBoardSeq}')">장바구니</button>
							</c:if>
							<button class="btn btn-primary" onclick="pageMove('product', '${obj.saleBoardSeq}')">구매하기</button>
						</div>
					</div>
				</div>
			</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="noitem">데이터가 없습니다.</div>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="pagingAre">${paging}</div>
</div>
</main>