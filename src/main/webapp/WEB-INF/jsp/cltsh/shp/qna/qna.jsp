<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/nomalMenu.jsp" %>
<style>
	.item_list_area {
		padding: 10px;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	.item_list_area table{
		width: 80%;
	}
	.item_list_area table th{
		text-align: center;
		padding-bottom: 10px;
	}
	.item_list_area table td{
		text-align: center;
		padding-top: 10px;
		padding-bottom: 10px;
	}
	.btn_area{
		width: 80%;
	}
	.fa{
		
	}
</style>
<section class="title_area">
	<h3 class="title">1:1 문의</h3>
</section>
<section class="item_list_area">
	<table>
		<thead>
			<tr><th>번호</th><th>구분</th><th>제목</th><th>등록일</th><th>작성자</th><th>상태</th></tr>
		</thead>
		<tbody>
		<c:if test="${empty list }">
			<tr><td class="nodata" colspan="6">데이터가 없습니다.</td></tr>
		</c:if>
		<c:forEach items="${list }" var="obj">
			<tr>
				<td>${obj.qnaBoardSeq}</td>
				<td>${obj.qnaTp}</td>
				<td><a href="/qna/qnaDetail.do?qnaBoardSeq=${obj.qnaBoardSeq}">${obj.titNm}</a></td>
				<td>${obj.rgstDate}</td>
				<td>${obj.rgstId}</td> <!-- <td>처리일</td> -->
				<td>${obj.ansrStat}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	    ${paging}
	<%-- <div class="pageNav">
		<a href='<c:url value="/main/mainQnaList.do?page=1"/>'><i class="fa">◀</i></a> <!-- 맨 앞 페이지로 -->
		
		<c:choose>
			<c:when test="${page eq 1 && isNext eq 'true'}">
				<a href='<c:url value="/main/mainQnaList.do?page=1"/>'><i class="fa">◀</i></a>
			</c:when>
			<c:when test="${isNext eq 'true' }">
				<a href='<c:url value="/main/mainQnaList.do?page=${minPage - 10}"/>'><i class="fa">◀</i></a>
			</c:when>
		</c:choose>
		
		<c:forEach begin="${minPage }" end="${maxPage }" var="pageNum">
			<a <c:if test="${page eq pageNum}">class="active"</c:if> href='<c:url value="/main/mainQnaList.do?page=${pageNum }"/>'><i class="fa">${pageNum }</i></a>
		</c:forEach>
		
		<c:if test="${isNext eq 'true' }">
			<a href='<c:url value="/main/mainQnaList.do?page=${maxPage + 1}"/>'><i class="fa">▶</i></a>
		</c:if>
		
		<a href='<c:url value="/main/mainQnaList.do?page=${qnaCnt }"/>'><i class="fa">▶</i></a> <!-- 맨 뒤 페이지로 -->
	</div> --%>
		
	<div class="btn_area">
		<input type="button" class="w70" value="작성하기" onclick="location.href='/cltsh/qna/qnaInsert.do'" />
	</div>
</section>

<%@ include file="/WEB-INF/jsp/cltsh/cmm/auth.jsp" %>