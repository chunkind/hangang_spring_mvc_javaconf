<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/nomalMenu.jsp" %>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">

<section class="title_area">
	<h3 class="title">드레스룸 수정</h3>
</section>

<section class="item_list_area">
	<form action="/cltsh/dress/dressEditAct.do" method="post" enctype="multipart/form-data" onsubmit="return fn_dress_edit()">
		<input type="hidden" name="saleBoardRpySeq" value="${pvo.saleBoardRpySeq }" />
		<table>
			<colgroup>
				<col width="10%" />
				<col width="40%" />
				<col width="10%" />
				<col width="40%" />
			</colgroup>
			<tr>
				<th>제목</th>
				<td><input type="text" name="bulTitNm" value="${pvo.bulTitNm}"></td>
				<th>태그</th>
				<td>
					<div><input type="text" name="rvwTag" value="${pvo.rvwTag}"/></div>
				</td>
			</tr>
			<tr>
				<th>대표 리뷰 이미지</th>
				<td>
					<input type="file" name="file1" onchange="previewImg(event);">
					<input type="hidden" name="imgPath" id="imgPath" />
					<input type="hidden" name="imgNm" id="imgNm" />
				</td>
				<th>미리보기</th>
				<td><div id="imgPreView"><img alt="" width="300px" src="${pvo.imgPath}${pvo.imgNm}"></div></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">
					<textarea name="bulCont" id="summernote" value="">${pvo.bulCont}</textarea>
				</td>
			</tr>
		</table>
		<div class="btn_area">
			<input type="button" value="목록" onclick="location.href='/cltsh/main/mainDrssList.do'"/>
			<input type="button" value="삭제" onclick="fn_dress_remove('${pvo.saleBoardRpySeq}')"/>
			<input type="submit" value="수정"/>
		</div>
	</form>
</section>
<script>
$(document).ready(function() {
	$('#summernote').summernote({
		height: 300,                 // set editor height
		minHeight: null,             // set minimum height of editor
		maxHeight: null,             // set maximum height of editor
		focus: true                  // set focus to editable area after initializing summernote
	});
	$('#summernote').summernote();
});
function fn_dress_edit(){
	if(confirm('드레스룸을 정말 수정 하시겠습니까?')){
		return true;
	}else{
		return false;
	}
}

function fn_dress_remove(saleBoardRpySeq){
	if(confirm('드레스룸을 정말 삭제 하시겠습니까?')){
		location.href='/cltsh/dress/dressRemoveAct.do?saleBoardRpySeq=' + saleBoardRpySeq;
	}
}

function previewImg(e){
	let reader = new FileReader();
	reader.onload = function(event) {
		let img = document.querySelector("#imgPreView img");
		if(null!=img){
			document.querySelector("#imgPreView img").remove();
		}
		img = document.createElement("img");
		img.setAttribute("src", event.target.result);
		img.setAttribute("width", "300px");
		document.querySelector("#imgPreView").appendChild(img);
	};
	reader.readAsDataURL(event.target.files[0]);
}
</script>