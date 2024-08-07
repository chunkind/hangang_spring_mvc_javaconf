<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container my-5">
	<div class="text-center mb-4">
		<h3 class="display-6">드레스룸 상세</h3>
	</div>
	<form name="frm" action="/cltsh/dress/dressEdit.do" method="post">
		<input type="hidden" name="saleBoardRpySeq" value="${pvo.saleBoardRpySeq }" />
		<input type="hidden" name="saleBoardSeq" value="${pvo.saleBoardSeq }" />
		<input type="hidden" name="rvwTag" value="${pvo.rvwTag}">
		<input type="hidden" name="imgPath" value="${pvo.imgPath }" />
		<input type="hidden" name="imgNm" value="${pvo.imgNm }" />
		<input type="hidden" name="bulTitNm" value="${pvo.bulTitNm }" />
		<div class="table-responsive">
			<table class="table table-bordered">
				<colgroup>
					<col width="10%" />
					<col width="40%" />
					<col width="10%" />
					<col width="40%" />
				</colgroup>
				<tr>
					<th>제목</th>
					<td>${pvo.bulTitNm}</td>
					<th>태그</th>
					<td>${pvo.rvwTag}</td>
				</tr>
				<tr>
					<th>대표이미지</th>
					<td>
						<div id="imgPreView">
							<img alt="" width="300px" src="${pvo.imgPath}${pvo.imgNm}" class="img-fluid">
						</div>
					</td>
					<th>작성자</th>
					<td>${pvo.rgstId}</td>
				</tr>
				<tr>
					<th colspan="4" class="text-center">내용</th>
				</tr>
				<tr>
					<td colspan="4"><pre class="text-left">${pvo.bulCont}</pre></td>
				</tr>
			</table>
		</div>
		<div class="text-center mt-4">
			<c:if test="${sessionScope.loginInfo.usrId eq pvo.rgstId}">
				<button type="submit" class="btn btn-primary">수정</button>
			</c:if>
			<button type="button" class="btn btn-secondary" onclick="location.href='/cltsh/main/mainDrssList.do'">목록</button>
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
            img.setAttribute("width", "300px");
            document.querySelector("#imgPreView").appendChild(img);
        };
        reader.readAsDataURL(e.target.files[0]);
    }

    $(document).ready(function() {
        $('#summernote').summernote({
            height: 300,
            minHeight: null,
            maxHeight: null,
            focus: true
        });
        $('#summernote').summernote();
    });
</script>
