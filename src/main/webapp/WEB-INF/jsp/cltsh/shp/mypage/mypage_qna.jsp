<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/nomalMenu.jsp" %>
<link href="/css/cltsh/mypage.css" rel="stylesheet">
<section class="title_area">
	<h3 class="title">마이 페이지 > Q&A</h3>
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
		<thead>
			<tr><th>번호</th><th>구분</th><th>제목</th><th>등록일</th><th>작성자</th><th>상태</th></tr>
		</thead>
		<tbody>
		<c:if test="${empty qnaList }">
			<tr><td class="nodata" colspan="6">데이터가 없습니다.</td></tr>
		</c:if>
		<c:forEach items="${qnaList }" var="obj">
			<tr>
				<td>${obj.qnaBoardSeq}</td>
				<td>${obj.qnaTp}</td>
				<td><a href="/cltsh/qna/qnaDetail.do?qnaBoardSeq=${obj.qnaBoardSeq}">${obj.titNm}</a></td>
				<td>${obj.rgstDate}</td>
				<td>${obj.rgstId}</td> <!-- <td>처리일</td> -->
				<td>${obj.ansrStat}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</section>