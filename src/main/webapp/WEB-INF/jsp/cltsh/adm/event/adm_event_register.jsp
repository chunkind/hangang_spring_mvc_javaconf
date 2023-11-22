<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<h2>이벤트 배너 목록 > 이벤트 배너 추가</h2>
<form action="/cltsh/adm/event/admEventRegisterAct.do" method="post" enctype="multipart/form-data">
<div class="data_list">
    <table>
    	<colgroup>
    		<col width="20%" />
    		<col width="30%" />
    		<col width="20%" />
    		<col width="30%" />
    	</colgroup>
    	<tr>
    		<th><div>이벤트 이름</div></th>
            <td><input type="text" name="eventName"></td>
            <th><div>이벤트 만료 날짜</div></th>
            <td><input type="Date" name="eventEndDate"></td>
            <th><div>이미지</div></th>
            <td>
            	<input type="file" name="file1" onchange="previewImg(event);">
            	<input type="hidden" name="imgPath" id="imgPath" />
            	<input type="hidden" name="imgNm" id="imgNm" />
            </td>
        </tr>
        <tr>
    		<th><div>이미지 미리보기</div></th>
            <td colspan="5">
            	<div id="imgPreView"></div>
            </td>
        </tr>
    </table>
</div>
<div class="btn_area">
    <input type="button" value="목록" onclick="location.href='/cltsh/adm/event/admEventList.do'"/>
    <input type="submit" value="추가" />
</div>
</form>
<script>
function previewImg(e){
	let reader = new FileReader();
	reader.onload = function(event) {
		let img = document.querySelector("#imgPreView img");
		if(null!=img){
			document.querySelector("#imgPreView img").remove();
		}
		img = document.createElement("img");
		img.setAttribute("src", event.target.result);
		document.querySelector("#imgPreView").appendChild(img);
	};
	reader.readAsDataURL(event.target.files[0]);
}
</script>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>