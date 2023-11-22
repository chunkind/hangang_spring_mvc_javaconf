<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<h2>드레스룸 관리</h2>
<h4>드레스룸 목록</h4>
<div class="data_list">
    <table>
        <thead>
           <tr>
              <th>번호</th>
              <th>제목</th>
              <th>태그</th>
              <th>작성자</th>
              <th>작성일자</th>
              <th>좋아요</th>
          </tr>
        </thead>
        <tbody>
           <c:if test="${empty list }">
	   	      <tr><td colspan="6">데이터가 없습니다.</td></tr>
	       </c:if>
	       <c:forEach items="${list }" var="obj">
		      <tr class="dressroom_manager_table_body">
		       <td>${obj.dressroomId}</td>
		       <td><a href="/cltsh/DispatcherServlet?command=adm_dressroom_manager_edit&dressroomInfoSEQ=${obj.dressroomInfoSEQ}">${obj.dressroomName}</a></td>
		       <td>${obj.tagId}</td>
		       <td>${obj.userId}</td>
		       <td>${obj.dressroomDate}</td>
		       <td>${obj.dressroomLike}</td>
		      </tr>
	    	 </c:forEach>
        </tbody>
    </table>
</div>
 <%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>