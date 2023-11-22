<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<h2>공통코드 관리</h2>
<div class="src_area">
	<div>
		<select>
	        <option>등록일순</option>
	        <option>이름순</option>
	    </select>
	</div>
</div>
<div class="data_list">
    <table>
        <tr>
            <th>전체선택</th>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록일</th>
        </tr>
        <c:if test="${empty list }">
	    		<tr><td colspan="5">데이터가 없습니다.</td></tr>
	    </c:if>
		<c:forEach items="${list }" var="obj">
			<tr>
				<td><input type="checkbox" id="cb"></td>
				<td>${obj.stdCdBaseSeq}</td>
				<td><a href="/cltsh/adm/code/admCodeEdit.do?stdCdBaseSeq=${obj.stdCdBaseSeq}">${obj.codeNm}</a></td>
				<td>${obj.rgstId}</td>
				<td>${obj.rgstDate}</td>
			</tr>
		</c:forEach>
	</table>
	${paging}
    <input type="button" value="작성하기" onclick="location.href='/adm/code/admCodeRegister.do'" />
</div>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>