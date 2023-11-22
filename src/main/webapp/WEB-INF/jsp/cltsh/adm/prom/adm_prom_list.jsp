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
	    	<c:if test="${empty list}">
	    		<tr><td colspan="7">데이터가 없습니다.</td></tr>
	    	</c:if>
	    	<c:forEach items="${list}" var="obj" varStatus="cnt">
		        <tr>
		            <td>
		            	<input type="checkbox" id="cb">
		            </td>
		            <td>${obj.promNum}</td>
		            <td><a href="/cltsh/adm/prom/admPromEdit.do?promSeq=${obj.promSeq}">${obj.promName}</a></td>
		            <td>${obj.promDiscount}%</td>
		            <td>${obj.rgstDate}</td>
		            <td>${obj.promEndDate}</td>
		        </tr>
	    	</c:forEach>
	    </tbody>
	</table>
</div>

${paging}

<div class="btn_area">
	<input type="button" value="추가" onclick="location.href='/cltsh/adm/cpn/admCpnRegister.do'" />
</div>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>