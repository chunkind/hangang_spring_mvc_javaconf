<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2 class="text-center mb-5">이벤트 배너 목록 > 이벤트 배너 수정</h2>
	<form action="/cltsh/adm/event/admEventEditAct.do" method="post" enctype="multipart/form-data" onsubmit="return fn_event_edit()">
		<input type="hidden" name="eventInfoSeq" value="${pvo.eventInfoSeq }" />
		
		<div class="row mb-3">
			<div class="col-md-4">
				<label for="eventName" class="form-label">이벤트 이름</label>
				<input type="text" id="eventName" name="eventName" class="form-control" maxlength="20" value="${pvo.eventName }">
			</div>
			<div class="col-md-4">
				<label for="eventEndDate" class="form-label">이벤트 만료 날짜</label>
				<input type="Date" id="eventEndDate" name="eventEndDate" class="form-control" maxlength="20" value="${pvo.eventEndDate }">
			</div>
			<div class="col-md-4">
				<label for="useYn" class="form-label">이미지</label>
				<input type="file" name="file1" onchange="previewImg(event);">
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-md-4">
				<label for="eventName" class="form-label">이미지 미리보기</label>
				<img alt="" src="${pvo.imgPath}${pvo.imgNm}">
				<input type="hidden" name="imgPath" value="${pvo.imgPath}" />
				<input type="hidden" name="imgNm" value="${pvo.imgNm}" />
			</div>
		</div>
		<div class="text-center mt-4">
			<button type="button" class="btn btn-light me-2" onclick="location.href='/cltsh/adm/event/admEventList.do'">목록</button>
			<button type="submit" class="btn btn-light me-2">수정</button>
			<button type="button" class="btn btn-danger" onclick="fn_event_remove('${pvo.eventInfoSeq}')">삭제</button>
		</div>
	</form>
</div>

<script>
//상품수정
function fn_event_edit(){
	if(confirm('이벤트 배너를 정말 수정 하시겠습니까?')){
		return true;
	}else{
		return false;
	}
}

//상품삭제
function fn_event_remove(eventInfoSeq){
	if(confirm('이벤트 배너를 정말 삭제 하시겠습니까?')){
		location.href='/cltsh/adm/event/admEventRemoveAct.do?eventInfoSeq=' + eventInfoSeq;
	}
}

//첨부파일 이미지 미리보기
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