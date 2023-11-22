<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<h2>1:1 문의 관리</h2>
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
            <th>답변상태</th>
        </tr>
        <c:forEach items="${rvo}" var="obj">
	        <tr>
	            <td><input type="checkbox" id="cb"></td>
	            <td>${obj.qnaBoardSeq}</td>
	            <td>${obj.titNm}</td>
	            <td>${obj.rgstId }</td>
	            <td>${obj.rgstDate}</td>
	            <td><button class="one_btn"><a href="/cltsh/adm/qna/admQnaAnswer.do?qnaBoardSeq=${obj.qnaBoardSeq}">답변하기</a></button></td>
	        </tr>
		</c:forEach>
    </table>
    
    ${paging }
    
    <%-- <div class="pageNav">
		<a href='<c:url value="/adm/qna/admQnaList.do?page=1"/>'><i class="fa">◀</i></a> <!-- 맨 앞 페이지로 -->
		<c:choose>
			<c:when test="${minPage eq 1}">
				<a href='<c:url value="/adm/qna/admQnaList.do?page=1"/>'><i class="fa">◀</i></a>
			</c:when>
			<c:when test="${isNext eq 'true' }">
				<a href='<c:url value="/adm/qna/admQnaList.do?page=${minPage - 10}"/>'><i class="fa">◀</i></a>
			</c:when>
		</c:choose>
		<c:forEach begin="${minPage }" end="${maxPage }" var="pageNum">
			<a <c:if test="${page eq pageNum}">class="active"</c:if> href='<c:url value="/adm/qna/admQnaList.do?page=${pageNum }"/>'><i class="fa">${pageNum }</i></a>
		</c:forEach>
		<c:if test="${isNext eq 'true' }">
			<a href='<c:url value="/adm/qna/admQnaList.do?page=${maxPage + 1}"/>'><i class="fa">▶</i></a>
		</c:if>
		<a href='<c:url value="/adm/qna/admQnaList.do?page=${qnaCnt }"/>'><i class="fa">▶</i></a> <!-- 맨 뒤 페이지로 -->
	</div> --%>
</div>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>