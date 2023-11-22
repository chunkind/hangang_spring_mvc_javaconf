<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<h2>쿠폰 목록</h2>
<div class="data_list">
	<table>
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
		            <td>
		            	<input type="checkbox" id="cb">
		            </td>
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

${paging }

<%-- <div class="pageNav">
	<a href='<c:url value="/cltsh/adm/cpn/admCpnList.do?page=1"/>'><i class="fa">◀</i></a> <!-- 맨 앞 페이지로 -->
	<c:choose>
		<c:when test="${page eq 1 && isNext eq 'true'}">
			<a href='<c:url value="/cltsh/adm/cpn/admCpnList.do?page=1"/>'><i class="fa">◀</i></a>
		</c:when>
		<c:when test="${isNext eq 'true' }">
			<a href='<c:url value="/cltsh/adm/cpn/admCpnList.do?page=${minPage - 10}"/>'><i class="fa">◀</i></a>
		</c:when>
	</c:choose>
	<c:forEach begin="${minPage }" end="${maxPage }" var="pageNum">
		<a <c:if test="${page eq pageNum}">class="active"</c:if> href='<c:url value="/cltsh/adm/cpn/admCpnList.do?page=${pageNum }"/>'><i class="fa">${pageNum }</i></a>
	</c:forEach>
	<c:if test="${isNext eq 'true' }">
		<a href='<c:url value="/cltsh/adm/cpn/admCpnList.do?page=${maxPage + 1}"/>'><i class="fa">▶</i></a>
	</c:if>
	<a href='<c:url value="/cltsh/adm/cpn/admCpnList.do?page=${cpnCnt }"/>'><i class="fa">▶</i></a> <!-- 맨 뒤 페이지로 -->
</div> --%>

<div class="btn_area">
	<input type="button" value="추가" onclick="location.href='/cltsh/adm/cpn/admCpnRegister.do'" />
</div>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>