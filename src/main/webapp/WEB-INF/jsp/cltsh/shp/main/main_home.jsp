<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/bannerMenu.jsp"%>
<section id="product_ranking" class="item_list_area">
	<h2>Today 랭킹</h2>
	<c:choose>
		<c:when test="${not empty mainHomeList }">
		<div class="img_area">
			<c:forEach var="obj" items="${mainHomeList}" varStatus="status">
			<c:if test="${status.count mod 5 eq 1 }">
				<div class="img_a">
			</c:if>
				<div class="item" onclick="pageMove('product', '${obj.saleBoardSeq}')">
					<img src="${obj.imgPath}${obj.imgNm}">
					<div class="txt_area">
						<div class="item_name">${obj.bulTitNm}</div>
						<div class="item_price">
							<span class="color_red">${(obj.goodsSalePrc/obj.goodsPrc * 100).intValue()}%</span>
							<span>${String.format("%,d", obj.goodsPrc - obj.goodsSalePrc)}원</span>
						</div>
					</div>
					<div class="dim"></div>
				</div>
			<c:if test="${status.count mod 5 eq 0 }">
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
</section>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/auth.jsp" %>