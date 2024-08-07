<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="item_list_area">
<input type="hidden" name="saleBoardSeq">
<form action="/cltsh/dress/dressRegisterAct.do" method="post" enctype="multipart/form-data">
	<table>
		<colgroup>
			<col width="10%" />
			<col width="40%" />
			<col width="10%" />
			<col width="40%" />
		</colgroup>
		<tr>
			<th>리스트</th>
			<td>
				<select name="selectedSaleRvwItem">
					<c:forEach items="${writeList}" var="obj">
						<option value="${obj.ordNo}@${obj.saleBoardSeq}@${obj.goodsCd}@${obj.entrNo}@${obj.ordDtlNo}">${obj.bulTitNm}</option>
					</c:forEach>
				</select>
			</td>
			<th>태그</th>
			<td>
				<div><input type="text" name="rvwTag" /></div>
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input type="text" name="bulTitNm"></td>
		</tr>
		<tr>
			<th>대표 리뷰 이미지</th>
			<td>
				<input type="file" name="file1" onchange="previewImg(event);">
				<input type="hidden" name="imgPath" id="imgPath" />
				<input type="hidden" name="imgNm" id="imgNm" />
			</td>
			<th>미리보기</th>
			<td><div id="imgPreView"></div></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
				<textarea name="bulCont" id="summernote" value=""></textarea>
			</td>
		</tr>
	</table>
    <div class="btn_area">
        <input type="submit" value="등록" />
    </div>
</form>
</section>
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
		img.setAttribute("width", "300px");
		document.querySelector("#imgPreView").appendChild(img);
	};
	reader.readAsDataURL(event.target.files[0]);
}

$(document).ready(function() {
	$('#summernote').summernote({
		height: 300,                 // set editor height
		minHeight: null,             // set minimum height of editor
		maxHeight: null,             // set maximum height of editor
		focus: true                  // set focus to editable area after initializing summernote
	});
	$('#summernote').summernote();
});
</script>