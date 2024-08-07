<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container my-5">
	<div class="text-center mb-4">
		<h3 class="display-6">드레스룸 수정</h3>
	</div>
	<form action="/cltsh/dress/dressEditAct.do" method="post" enctype="multipart/form-data" onsubmit="return fn_dress_edit()">
		<input type="hidden" name="saleBoardRpySeq" value="${pvo.saleBoardRpySeq }" />

		<div class="mb-3 row">
			<label for="bulTitNm" class="col-md-2 col-form-label">제목</label>
			<div class="col-md-10">
				<input type="text" class="form-control" id="bulTitNm" name="bulTitNm" value="${pvo.bulTitNm}" />
			</div>
		</div>

		<div class="mb-3 row">
			<label for="rvwTag" class="col-md-2 col-form-label">태그</label>
			<div class="col-md-10">
				<input type="text" class="form-control" id="rvwTag" name="rvwTag" value="${pvo.rvwTag}" />
			</div>
		</div>

		<div class="mb-3 row">
			<label class="col-md-2 col-form-label">대표 리뷰 이미지</label>
			<div class="col-md-10">
				<input type="file" class="form-control" name="file1" onchange="previewImg(event);" />
				<input type="hidden" name="imgPath" id="imgPath" />
				<input type="hidden" name="imgNm" id="imgNm" />
			</div>
		</div>

		<div class="mb-3 row">
			<label class="col-md-2 col-form-label">미리보기</label>
			<div class="col-md-10">
				<div id="imgPreView">
					<img alt="" width="300px" src="${pvo.imgPath}${pvo.imgNm}" class="img-fluid" />
				</div>
			</div>
		</div>

		<div class="mb-3 row">
			<label for="summernote" class="col-md-2 col-form-label">내용</label>
			<div class="col-md-10">
				<textarea class="form-control" id="summernote" name="bulCont">${pvo.bulCont}</textarea>
			</div>
		</div>

		<div class="text-center mt-4">
			<button type="button" class="btn btn-secondary" onclick="location.href='/cltsh/main/mainDrssList.do'">목록</button>
			<button type="button" class="btn btn-danger" onclick="fn_dress_remove('${pvo.saleBoardRpySeq}')">삭제</button>
			<button type="submit" class="btn btn-primary">수정</button>
		</div>
	</form>
</div>

<script>
$(document).ready(function() {
    $('#summernote').summernote({
        height: 300,                 // set editor height
        minHeight: null,             // set minimum height of editor
        maxHeight: null,             // set maximum height of editor
        focus: true                  // set focus to editable area after initializing summernote
    });
});

function fn_dress_edit() {
    return confirm('드레스룸을 정말 수정 하시겠습니까?');
}

function fn_dress_remove(saleBoardRpySeq) {
    if (confirm('드레스룸을 정말 삭제 하시겠습니까?')) {
        location.href = '/cltsh/dress/dressRemoveAct.do?saleBoardRpySeq=' + saleBoardRpySeq;
    }
}

function previewImg(e) {
    let reader = new FileReader();
    reader.onload = function(event) {
        let img = document.querySelector("#imgPreView img");
        if (img) {
            img.remove();
        }
        img = document.createElement("img");
        img.setAttribute("src", event.target.result);
        img.setAttribute("width", "300px");
        img.classList.add("img-fluid");
        document.querySelector("#imgPreView").appendChild(img);
    };
    reader.readAsDataURL(e.target.files[0]);
}
</script>
