<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>

<form name="frm" action="/cltsh/DispatcherServlet?command=adm_dressroom_manager_edit_act" method="post" onsubmit="return fn_dress_edit()">
	<input type="hidden" name="dressroomInfoSEQ" value="${pvo.dressroomInfoSEQ }" />
	
	<div>제목</div>
	<input type="text" name="dressroomName" value="${pvo.dressroomName}"><br/>
	
	<label for="cont">내용</label><br/>
    <textarea rows="20" cols="70" name="dressroomDescription">${pvo.dressroomDescription}</textarea><br/>
	
	<div>태그</div>
	
	<input type="button" value="목록" onclick="location.href='/DispatcherServlet?command=adm_dressroom_manager'"/>
    <input type="button" value="삭제" onclick="fn_dress_remove('${pvo.dressroomInfoSEQ}')"/>
    <input type="submit" value="수정"/>
</form>
<script>
function fn_dress_edit(){
	if(confirm('드레스룸을 정말 수정 하시겠습니까?')){
		return true;
	}else{
		return false;
	}
}

function fn_dress_remove(dressroomInfoSEQ){
	if(confirm('드레스룸을 정말 삭제 하시겠습니까?')){
		location.href='/cltsh/DispatcherServlet?command=adm_dressroom_manager_remove_act&dressroomInfoSEQ=' + dressroomInfoSEQ;
	}
}
</script>

 <%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>