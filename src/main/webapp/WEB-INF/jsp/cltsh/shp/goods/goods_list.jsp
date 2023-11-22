<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/bannerMenu.jsp"%>
<footer id="product_ranking">
	<h2>Today 랭킹</h2>
	<div class="product_group">
		<pre>전체</pre>
		<pre>상의</pre>
		<pre>아우터</pre>
		<pre>바지</pre>
	</div>
	<c:choose>
		<c:when test="${not empty goodsList }">
		<div class="img_area">
			<c:forEach var="obj" items="${goodsList}" varStatus="status">
			<c:if test="${status.count mod 4 eq 1 }">
				<div class="img_a">
			</c:if>
				<div class="item" onclick="pageMove('product')">
					<img src="${obj.imgPath}${obj.imgNm}">
					<div class="txt_area">
						<div class="item_name">[${status.count}]${obj.goodsNm}</div>
						<div class="item_price">
							<span class="color_red">50%</span> <span>${obj.goodsPrc}원</span>
						</div>
					</div>
					<div class="dim"></div>
				</div>
			<c:if test="${status.count mod 4 eq 0 }">
				</div>
			</c:if>
			</c:forEach>
		</div>
		</c:when>
		<c:otherwise>
			<div class="img_area">
				<div class="img_a">데이터가 없습니다.</div>
			</div>
		</c:otherwise>
	</c:choose>
</footer>