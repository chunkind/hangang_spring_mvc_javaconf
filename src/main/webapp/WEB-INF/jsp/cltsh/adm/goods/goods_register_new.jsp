<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<style>
#admPrdReg h4 {
	font-size: 1.25rem;
	border-bottom: 2.5px solid #495057;
	padding-bottom: 0.59em;
	margin-bottom: 1em;
	padding-left: 2px;
}
#admPrdReg .pm-3 {padding-bottom:1rem!important;}
#admPrdReg .text-rihgt {text-align:right;}
#admPrdReg .text-center {text-align:center;}
#admPrdReg #itemTitle{ position: relative; width: 100%;}
#admPrdReg #itemTitle > #itemButton{position: absolute;right: 0px;text-align: right;}
#admPrdReg textArea#goodsIntr{widht:100%;}
.removeItem {height: 35px;}
</style>

<div id="admPrdReg" class="container mt-4">
	<h2 class="text-center mb-5">상품 관리 > 상품 목록 > 상품 등록(NEW)</h2>
	<form action="/cltsh/adm/goods/admGoodsRegisterAct.do" method="post" enctype="multipart/form-data">

		<div class="row mb-3">
		<h4>상품정보</h4>
		
			<div class="row mb-3">
				<label for="goodsNm" class="col-sm-2 col-form-label">상품명</label>
				<div class="col-sm-10">
					<input type="text" id="goodsNm" name="goodsNm" class="form-control" maxlength="20">
				</div>
			</div>
			
			<div class="row mb-3">
				<label for="entrNo" class="col-sm-2 col-form-label pm-3">판매처</label>
				<div class="col-md-4 col-sm-10 pm-3">
					<select id="entrNo" name="entrNo" class="form-select">
						<c:forEach items="${entrList}" var="obj">
							<option value="${obj.entrNo}">${obj.entrNm}(${obj.entrNo})</option>
						</c:forEach>
					</select>
				</div>
				
				<label for="useYn" class="col-sm-2 col-form-label pm-3">사용여부</label>
				<div class="col-md-4 col-sm-10 pm-3">
					<select id="useYn" name="useYn" class="form-select">
						<option value="Y">사용</option>
						<option value="N">미사용</option>
					</select>
				</div>
			</div>
			
			<div class="row mb-3">
				<label for="saleStatCd" class="col-sm-2 col-form-label pm-3">판매상태</label>
				<div class="col-md-4 col-sm-10 pm-3">
					<select id="saleStatCd" name="saleStatCd" class="form-select">
						<c:forEach items="${codeList}" var="obj">
							<option value="${obj.codeNm}">${obj.codeNm}</option>
						</c:forEach>
					</select>
				</div>
				
				<label for="goodsPrc" class="col-sm-2 col-form-label pm-3">상품가격</label>
				<div class="col-md-4 col-sm-10 pm-3">
					<input type="number" id="goodsPrc" name="goodsPrc" class="form-control" maxlength="20">
				</div>
			</div>
			
			<div class="row mb-3">
				<label for="catgryCd" class="col-sm-2 col-form-label pm-3">대분류</label>
				<div class="col-md-4 col-sm-10 pm-3">
					<select id="catgryCd" name="catgryCd" class="form-select">
						<option value="">선택</option>
						<c:forEach items="${upperCodeList}" var="obj">
							<option value="${obj.catgryCd}">${obj.catgryNm}</option>
						</c:forEach>
					</select>
				</div>
				
				<label for="catgryCd2" class="col-sm-2 col-form-label pm-3">소분류</label>
				<div class="col-md-4 col-sm-10 pm-3">
					<select id="catgryCd2" name="catgryCd2" class="form-select">
						<option value="">선택</option>
					</select>
				</div>
			</div>
			
			<div class="row mb-3">
				<label for="inyQty" class="col-sm-2 col-form-label pm-3">상품수량</label>
				<div class="col-md-4 col-sm-10 pm-3">
					<input type="number" id="inyQty" name="inyQty" value="1" class="form-control" maxlength="20">
				</div>
			</div>
			
			<div class="row mb-3">
				<label for="goodsIntr" class="col-sm-2 col-form-label">상품상세설명</label>
				<div class="col-md-10 col-sm-12">
					<textarea rows="4" id="goodsIntr" name="goodsIntr" class="form-control"></textarea>
				</div>
			</div>
		</div>
		
		<div class="row mb-3">
			<div id="itemTitle" class="row">	
				<h4>아이템정보</h4>
				<figure>
					<figcaption class="blockquote-footer">
					<cite title="Source Title">최초 상품 등록 시 아이템 설정이 가능하며 상품 등록 후 아이템 추가는 불가합니다.</cite>
					</figcaption>
				</figure>
				
				<div id="itemButton" class="col-md-2">
					<button id="addItem" type="button" class="btn btn-primary btn-sm">아이템추가</button>
				</div>
			</div>
				<div id="itemTagArea">
					<ul id="itemList">
						<li>등록된 아이템이 없습니다.</li>
					</ul>
				</div>
		</div>
	
		<div class="row mb-3">
		<h4>배송정보</h4>
			<div class="row mb-3">
				<label for="dlvPrc" class="col-sm-2 col-form-label pm-3">배송비</label>
				<div class="col-md-4 col-sm-10 pm-3">
					<input type="number" id="dlvPrc" name="dlvPrc" value="2000" class="form-control" maxlength="20">
				</div>
			</div>
		</div>
		
		<div class="row mb-3">
		<h4>썸네일</h4>
			<div class="row mb-3">
				<label for="file1" class="col-sm-2 col-form-label">대표이미지</label>
				<div class="col-md-4 col-sm-10">
					<input type="file" id="file1" name="file1" class="form-control" onchange="previewImg(event);">
					<input type="hidden" id="imgPath" name="imgPath" />
					<input type="hidden" id="imgNm" name="imgNm" />
				</div>
			</div>
			
			<div class="row mb-3">
				<label for="imgPreView" class="col-sm-2 col-form-label"></label>
				<div class="col-md-4 col-sm-10">
					<div id="imgPreView" class="mt-2"></div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="text-center mt-4">
				<button type="button" class="btn btn-secondary me-2" onclick="location.href='/cltsh/adm/goods/admGoodsList.do'">목록</button>
				<button type="submit" class="btn btn-primary">등록</button>
			</div>
		</div>
		
	</form>
</div>



<script>

document.getElementById("catgryCd").addEventListener('change', ()=>{
	let catgryCd = document.querySelector('#catgryCd').value;
	fn_ajax({
		url: '/cltsh/adm/cate/admCateListAjax.do?uprClassCd='+encodeURIComponent(catgryCd),
		method: 'get',
		success: function(data){
			console.log(data);
			var rtnJson = data;
			if(rtnJson.result == 'success'){
				let sel_catgryCd2 = document.querySelector('#catgryCd2');
				let sel_catgryCd2_options = document.querySelectorAll('#catgryCd2 option');
				for(let i=0; i<sel_catgryCd2_options.length; i++){
					sel_catgryCd2_options[i].remove();
				}
				//추가
				let option = document.createElement('option');
				option.value = '';
				option.innerHTML = '선택';
				sel_catgryCd2.append(option);
					
				for(let i=0; i<rtnJson.dataList.length; i++){
					let objValue = rtnJson.dataList[i];
					let option = document.createElement('option');
					let catgryCd = objValue['catgryCd'];
					let catgryNm = objValue['catgryNm'];
					option.value = catgryCd;
					option.innerHTML = catgryNm;
					sel_catgryCd2.append(option);
				}
			}else{
				alert("에러 발생.");
			}
		}
	});
});

$(document).ready(function(){
    let itemCount = 0; // 항목 갯수

	// 항목 추가
	$("#addItem").click(function(){
		
		// 항목 1개 이상: 문구삭제
		if(itemCount==0) $('#itemList li:eq(0)').remove();
		
		itemCount++;
		
		let itemTag = '';
		itemTag += '<li class="row col-md-12">';
		
			itemTag += '<label for="optsNmArray" class="col-sm-2 col-form-label">옵션명</label>';
			itemTag += '<div class="col-md-2 col-sm-10">';
				itemTag += '<input type="text" class="form-control" id="optsNmArray" name="optsNmArray[]">';
			itemTag += '</div>';
			
			itemTag += '<label for="optsValArray" class="col-sm-2 col-form-label">옵션값</label>';
			itemTag += '<div class="col-md-1 col-sm-10">';
				itemTag += '<input type="text" class="form-control" id="optsValArray" name="optsValArray[]">';
			itemTag += '</div>';
			
			itemTag += '<label for="useYnArray" class="col-sm-2 col-form-label">사용여부</label>';
			itemTag += '<div class="col-md-2 col-sm-10">';
			itemTag += '<select id="useYnArray" name="useYnArray[]" class="form-select">';
				itemTag += '<option value="Y">사용</option>';
				itemTag += '<option value="N">사용안함</option>';
			itemTag += '</select>';
			itemTag += '</div>';
			
			itemTag += '<button class="col-md-1 removeItem btn btn-sm btn-danger">삭제</button>';
		itemTag += '</li>';
		
		$("#itemList").append(itemTag);
	});

	// 항목 삭제 (이벤트 위임 방식으로 구현)
	$("#itemList").on("click", ".removeItem", function(){
		$(this).parent().remove();
		itemCount--;
		
		// 항목 0개: 문구추가
		if(itemCount == 0) $("#itemList").append('<li>등록된 아이템이 없습니다.</li>');
	});
});


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
		//img.setAttribute("height", "");
		document.querySelector("#imgPreView").appendChild(img);
	};
	reader.readAsDataURL(event.target.files[0]);
}
</script>
