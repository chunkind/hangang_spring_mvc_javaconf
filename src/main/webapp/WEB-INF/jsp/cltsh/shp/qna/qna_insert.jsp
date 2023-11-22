<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/nomalMenu.jsp" %>
<style>
	.item_list_area{
		text-align: left;
	}
</style>
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
			<th>문의유형</th>
			<td>
				<select name="qnaTp" id="qnaTp">
					<option value="일반문의">일반문의</option>
					<option value="상품문의">상품문의</option>
				</select>
			</td>
			<th>답변 상태</th>
			<td>
				<div>답변미완료</div>
				<input type="hidden" name="ansrStat" value="답변미완료">
			</td>
		</tr>
		<tr class="cate">
			<th>상위 카테고리</th>
			<td>
				<select name="oneDepthCateList" id="oneDepthCateList">
					<option value="">선택</option>
					<c:forEach items="${oneDepthCateList }" var="obj">
						<option value="${obj.catgryCd}">${obj.catgryNm}</option>
					</c:forEach>
				</select>
			</td>
			<th>하위 카테고리</th>
			<td>
				<select name="twoDepthCateList" id="twoDepthCateList">
					<option value="">선택</option>
				</select>
			</td>
		</tr>
		<tr class="cate">
			<th>상품</th>
			<td>
				<select name="goodsCd" id="searchGoodsList">
					<option value="0">선택</option>
				</select>
			</td>
			<th>이미지</th>
			<td>
				<img id="goodsImg"/>
			</td>
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
	let sel_passYn = document.querySelector('#passYn');
	sel_passYn.addEventListener('change', (e)=>{
		let selectedVal = e.target.value;
		
		if(selectedVal == 'N'){
			document.getElementById("passWd").style.display = "none";
		}else{
			document.getElementById("passWd").style.display = "table-row";
		}
		
	});
	document.getElementById("passWd").style.display = "none";
	
	let sel_qnaTp = document.querySelector('#qnaTp');
	sel_qnaTp.addEventListener('change', (e)=>{
		let selectedVal = e.target.value;
		
		if(selectedVal == '일반문의'){
			/* document.getElementsByClassName("cate").style.display = "none"; */
			document.getElementsByClassName("cate")[0].style.display = "none";
			document.getElementsByClassName("cate")[1].style.display = "none";
		}else{
		document.getElementsByClassName("cate")[0].style.display = "table-row";
		document.getElementsByClassName("cate")[1].style.display = "table-row";
		}
		
	});
	document.getElementsByClassName("cate")[0].style.display = "none";
	document.getElementsByClassName("cate")[1].style.display = "none";
});

document.getElementById("oneDepthCateList").addEventListener('change', ()=>{
	let oneDepthCateList = document.querySelector('#oneDepthCateList').value;
	fn_ajax({
		url: '/dress/DressCateAjax.do?oneDepthCateList='+encodeURIComponent(oneDepthCateList),
		method: 'get',
		success: function(data){
			console.log(data);
			var rtnJson = data;
			if(rtnJson.result == 'success'){
				let sel_twoDepthCateList = document.querySelector('#twoDepthCateList');
				let sel_twoDepthCateList_options = document.querySelectorAll('#twoDepthCateList option');
				for(let i=0; i<sel_twoDepthCateList_options.length; i++){
					sel_twoDepthCateList_options[i].remove();
				}
				//추가
				let option = document.createElement('option');
				option.value = '';
				option.innerHTML = '선택';
				sel_twoDepthCateList.append(option);
					
				for(let i=0; i<rtnJson.dataList.length; i++){
					let objValue = rtnJson.dataList[i];
					let option = document.createElement('option');
					let catgryCd = objValue['catgryCd'];
					let catgryNm = objValue['catgryNm'];
					option.value = catgryCd;
					option.innerHTML = catgryNm;
					sel_twoDepthCateList.append(option);
				}
			}else{
				alert("에러 발생.");
			}
		}
	});
});

document.getElementById("twoDepthCateList").addEventListener('change', ()=>{
	let oneDepthCateList = document.querySelector('#oneDepthCateList').value;
	let twoDepthCateList = document.querySelector('#twoDepthCateList').value;
	fn_ajax({
		url: '/dress/DressCateAjax2.do?oneDepthCateList='+encodeURIComponent(oneDepthCateList)+'&twoDepthCateList='+encodeURIComponent(twoDepthCateList),
		method: 'get',
		success: function(data){
			console.log(data);
			var rtnJson = data;
			if(rtnJson.result == 'success'){
				let sel_searchGoodsList = document.querySelector('#searchGoodsList');
				let sel_searchGoodsList_options = document.querySelectorAll('#searchGoodsList option');
				for(let i=0; i<sel_searchGoodsList_options.length; i++){
					sel_searchGoodsList_options[i].remove();
				}
				//추가
				let option = document.createElement('option');
				option.value = '';
				option.innerHTML = '선택';
				sel_searchGoodsList.append(option);
				
				for(let i=0; i<rtnJson.dataList.length; i++){
					let objValue = rtnJson.dataList[i];
					let option = document.createElement('option');
					let goodsCd = objValue['goodsCd'];
					let goodsNm = objValue['goodsNm'];
					option.value = goodsCd;
					option.innerHTML = goodsNm;
					sel_searchGoodsList.append(option);
				}
			}else{
				alert("에러 발생.");
			}
		}
	});
});

document.getElementById("searchGoodsList").addEventListener('change', ()=>{
	let searchGoodsList = document.querySelector('#searchGoodsList').value;
	fn_ajax({
		url: '/dress/DressCateAjax3.do?searchGoodsList='+encodeURIComponent(searchGoodsList),
		method: 'get',
		success: function(data){
			console.log(data);
			var rtnJson = data;
			if(rtnJson.result == 'success'){
				let objValue = rtnJson.dataList[0];
				let imgPath = objValue['imgPath'];
				let imgNm = objValue['imgNm'];
				document.getElementById("goodsImg").src = imgPath + imgNm;
				document.getElementById("goodsImg").width = 120;
				document.getElementById("goodsImg").height = 120;
			}else{
				alert("에러 발생.");
			}
		}
	});
});
</script>