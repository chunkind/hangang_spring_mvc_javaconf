<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/nomalMenu.jsp" %>
<link href="/css/cltsh/mypage.css" rel="stylesheet">
<section class="title_area">
	<h3 class="title">마이 페이지</h3>
</section>
<section class="item_list_area">
<div class="header_data">
    <div class="icon">
		<span>
			<i class="fa-solid fa-truck"></i>
			<a href="/cltsh/mypage/mypage.do" class="a">주문/배송조회</a>
		</span>
		<span>
			<i class="fa-solid fa-p"></i>
			<a href="/cltsh/mypage/mypagePoint.do" class="b">포인트</a>
		</span>
		<span>
			<i class="fa-solid fa-money-check-dollar"></i>
			<a href="/cltsh/mypage/mypageCoupon.do" class="c">쿠폰</a>
		</span>
		<span>
			<i class="fa-solid fa-comments"></i>
			<a href="/cltsh/mypage/mypageQna.do" class="d">Q&A</a>
		</span>
    </div>
</div>
<div class="data_list">
	<table>
		<colgroup>
			<col width="10%" />
			<col width="20%" />
			<col width="20%" />
			<col width="20%" />
			<col width="20%" />
			<col width="10%" />
		</colgroup>
		<tr>
			<th>주문번호</th>
			<th>썸네일</th>
			<th>상품명</th>
			<th>주문금액</th>
			<th>주문상태</th>
			<th></th>
		</tr>
		<c:if test="${empty mypgList }">
			<tr>
				<td colspan="6"><div class="nodata">주문내역이 없습니다.</div></td>
			</tr>
		</c:if>
		<c:forEach items="${mypgList }" var="obj">
			<tr>
				<td>${obj.ordNo}</td>
				<td><img src="${obj.imgPath}${obj.imgNm}"></td>
				<td><a href="/cltsh/mypage/mypageDetail.do?ordNo=${obj.ordNo}">${obj.bulTitNm}</a></td>
				<td>${obj.payMny}원</td>
				<td>${obj.codeNm}</td>
				<td>
					<c:if test="${obj.saleBoardRpySeq eq 0}">
						<input type="button" onclick="location.href='/cltsh/dress/dressRegister.do?ordNo=${obj.ordNo}'" value="드레스룸 등록" />
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%-- <div class="pageNav">
		<a href='<c:url value="/mypage/mypage.do?page=1"/>'><i class="fa">◀</i></a> <!-- 맨 앞 페이지로 -->
		<c:choose>
			<c:when test="${page eq 1 && isNext eq 'true'}">
				<a href='<c:url value="/mypage/mypage.do?page=1"/>'><i class="fa">◀</i></a>
			</c:when>
			<c:when test="${isNext eq 'true' }">
				<a href='<c:url value="/mypage/mypage.do?page=${minPage - 10}"/>'><i class="fa">◀</i></a>
			</c:when>
		</c:choose>
		<c:forEach begin="${minPage }" end="${maxPage }" var="pageNum">
			<a <c:if test="${page eq pageNum}">class="active"</c:if> href='<c:url value="/mypage/mypage.do?page=${pageNum }"/>'><i class="fa">${pageNum }</i></a>
		</c:forEach>
		<c:if test="${isNext eq 'true' }">
			<a href='<c:url value="/mypage/mypage.do?page=${maxPage + 1}"/>'><i class="fa">▶</i></a>
		</c:if>
		<a href='<c:url value="/mypage/mypage.do?page=${ordCnt }"/>'><i class="fa">▶</i></a> <!-- 맨 뒤 페이지로 -->
	</div> --%>
</div>
</section>