<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/nomalMenu.jsp" %>
<section class="title_area">
	<h3 class="title">1:1문의 > 작성하기</h3>
</section>
<section class="item_list_area">
	<form name="frm" action="/cltsh/qna/qnaInsertAct.do" method="post">
	<table>
		<colgroup>
			<col width="10%" />
			<col width="40%" />
			<col width="10%" />
			<col width="40%" />
		</colgroup>
		<tr>
			<th>제목</th>
			<td><input type="text" name="titNm"></td>
		</tr>
		<tr>
			<th>비밀글</th>
			<td>
				<select name="passYn" id="passYn">
					<option value="Y">사용</option>
					<option value="N" selected="selected">미사용</option>
				</select>
			</td>
			<th>비밀글 비밀번호</th>
			<td><input type="password" name="passWd" id="passWd"></td>
		</tr>
		<tr>
			<th>카테고리</th>
			<td>
				<input type="text" name="qnaTp" id="qnaTp" value="상품문의">
			</td>
			<th>답변 상태</th>
			<td>
				<div>답변미완료</div>
				<input type="hidden" name="ansrStat" value="답변미완료">
			</td>
		</tr>
		<tr>
			<th>상품 : </th>
			<td>
				${rvo.bulTitNm }
				<input type="hidden" name="goodsCd" value="${rvo.goodsCd }">
			</td>
		</tr>
		<tr>
			<img id="goodsImg" src="${rvo.imgPath }${rvo.imgNm }" width="300" height="300"/>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
				<textarea rows="20" cols="100" name="cont"></textarea>
			</td>
		</tr>
	</table>
	<div class="btn_area">
		<input type="submit" value="작성하기" />
	</div>
	</form>
</section>
<script>
document.addEventListener("DOMContentLoaded", () => {
	document.getElementById("qnaTp").readOnly = true;
	
	let sel_passYn = document.querySelector('#passYn');
	sel_passYn.addEventListener('change', (e)=>{
		let selectedVal = e.target.value;
		
		if(selectedVal == 'N'){
			document.getElementById("passWd").style.display = "none";
		}else{
		document.getElementById("passWd").style.display = "block";
		}
		
	});
	document.getElementById("passWd").style.display = "none";
});
</script>