<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="item_list_area container py-4 mt-4">
	<input type="hidden" name="saleBoardSeq">
	<form action="/cltsh/dress/dressRegisterAct.do" method="post" enctype="multipart/form-data">
		<div class="mb-3 row">
			<label for="selectedSaleRvwItem" class="col-sm-2 col-form-label">리스트</label>
			<div class="col-sm-10">
				<select name="selectedSaleRvwItem" class="form-select" id="selectedSaleRvwItem">
					<c:forEach items="${writeList}" var="obj">
						<option value="${obj.ordNo}@${obj.saleBoardSeq}@${obj.goodsCd}@${obj.entrNo}@${obj.ordDtlNo}">
							${obj.bulTitNm}
						</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="mb-3 row">
			<label for="rvwTag" class="col-sm-2 col-form-label">태그</label>
			<div class="col-sm-10">
				<input type="text" name="rvwTag" class="form-control" id="rvwTag" placeholder="태그를 입력하세요">
			</div>
		</div>
		<div class="mb-3 row">
			<label for="bulTitNm" class="col-sm-2 col-form-label">제목</label>
			<div class="col-sm-10">
				<input type="text" name="bulTitNm" class="form-control" id="bulTitNm" placeholder="제목을 입력하세요">
			</div>
		</div>
		<div class="mb-3 row">
			<label for="file1" class="col-sm-2 col-form-label">대표 리뷰 이미지</label>
			<div class="col-sm-10">
				<input type="file" name="file1" class="form-control" id="file1" onchange="previewImg(event);">
				<input type="hidden" name="imgPath" id="imgPath" />
				<input type="hidden" name="imgNm" id="imgNm" />
			</div>
		</div>
		<div class="mb-3 row">
			<label class="col-sm-2 col-form-label">미리보기</label>
			<div class="col-sm-10">
				<div id="imgPreView" class="border rounded p-2" style="min-height: 150px;">
				</div>
			</div>
		</div>
		<div class="mb-3 row">
			<label for="summernote" class="col-sm-2 col-form-label">내용</label>
			<div class="col-sm-10">
				<textarea name="bulCont" id="summernote"></textarea>
			</div>
		</div>
		<div class="text-end">
			<button type="submit" class="btn btn-primary">등록</button>
		</div>
	</form>
</div>

<script>
function previewImg(e) {
	let reader = new FileReader();
	reader.onload = function(event) {
		let img = document.querySelector("#imgPreView img");
		if (img) {
			img.remove();
		}
		img = document.createElement("img");
		img.setAttribute("src", event.target.result);
		img.setAttribute("class", "img-fluid");
		document.querySelector("#imgPreView").appendChild(img);
	};
	reader.readAsDataURL(e.target.files[0]);
}
</script>

<script>
$(document).ready(function() {
	$('#summernote').summernote({
		height: 300,   // 에디터 높이 설정
		placeholder: '내용을 입력하세요',
		tabsize: 2
	});
});
</script>
