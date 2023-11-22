<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/nomalMenu.jsp" %>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">

<section class="title_area">
	<h3 class="title">드레스룸 상세</h3>
</section>

<section class="item_list_area">
<form name="frm" action="/cltsh/dress/dressEdit.do" method="post">
	<input type="hidden" name="saleBoardRpySeq" value="${pvo.saleBoardRpySeq }" />
	<input type="hidden" name="saleBoardSeq" value="${pvo.saleBoardSeq }" />
	<input type="hidden" name="rvwTag" value="${pvo.rvwTag}">
	<input type="hidden" name="imgPath" value="${pvo.imgPath }" />
	<input type="hidden" name="imgNm" value="${pvo.imgNm }" />
	<input type="hidden" name="bulTitNm" value="${pvo.bulTitNm }" />
	<%-- <input type="hidden" name="bulCont" value="${pvo.bulCont }" /> --%>
	<table>
		<colgroup>
			<col width="10%" />
			<col width="40%" />
			<col width="10%" />
			<col width="40%" />
		</colgroup>
		<tr>
			<th>제목</th>
			<td>
				<div>${pvo.bulTitNm}</div>
			</td>
			<th>태그</th>
			<td>
				<div>${pvo.rvwTag}</div>
			</td>
		</tr>
		<tr>
			<th>대표이미지</th>
			<td><div id="imgPreView"><img alt="" width="300px" src="${pvo.imgPath}${pvo.imgNm}"></div></td>
			<th>작성자</th>
			<td>${pvo.rgstId}</td>
		</tr>
		<tr>
			<th colspan="4">내용</th>
		</tr>
		<tr>
			<td colspan="4"><pre style="text-align: left">${pvo.bulCont}</pre></td>
		</tr>
	</table>
	<div class="btn_area">
		<c:if test="${sessionScope.loginInfo.usrId eq pvo.rgstId}">
			<input type="submit" value="수정" />
		</c:if>
		<input type="button" value="목록" onclick="location.href='/cltsh/main/mainDrssList.do'"/>
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