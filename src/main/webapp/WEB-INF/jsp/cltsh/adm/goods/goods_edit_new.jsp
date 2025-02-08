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

#admPrdReg ul {margin: 0 !important; padding: 0 !important;}
</style>

<div id="admPrdReg" class="container mt-4">
	<h2 class="mb-5">상품 관리 > 상품 목록 > 상품 수정(NEW)</h2>
	<form action="/cltsh/adm/goods/admGoodsEditAct.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="entrNo" value="${pvo.entrNo}"/>
	<input type="hidden" name="goodsInfoSeq" value="${pvo.goodsInfoSeq }" />
	<input type="hidden" name="goodsCd" value="${pvo.goodsCd }" />
	<input type="hidden" name="imgPath" id="imgPath" value="${pvo.imgPath }"/>
	<input type="hidden" name="imgNm" id="imgNm" value="${pvo.imgNm }" />
	
		<div class="row mb-3">
		<h4>상품정보</h4>
		
			<div class="row mb-3">
				<label for="goodsNm" class="col-sm-2 col-form-label">상품명</label>
				<div class="col-sm-10">
					<input type="text" id="goodsNm" name="goodsNm" value="${pvo.goodsNm}" class="form-control" maxlength="20">
				</div>
			</div>
			
			<div class="row mb-3">
				<label for="entrNo" class="col-sm-2 col-form-label pm-3">판매처</label>
				<div class="col-md-4 col-sm-10 pm-3">
					<select id="entrNo" class="form-select" disabled>
						<c:forEach items="${entrList}" var="obj">
							<option value="${obj.entrNo}" <c:if test="${pvo.entrNo eq obj.entrNo}" >selected</c:if>>${obj.entrNm}(${obj.entrNo})</option>
						</c:forEach>
					</select>
				</div>
				
				<label for="useYn" class="col-sm-2 col-form-label pm-3">사용여부</label>
				<div class="col-md-4 col-sm-10 pm-3">
					<select id="useYn" name="useYn" class="form-select">
						<option value="Y" <c:if test="${pvo.useYn eq 'Y'}" >selected</c:if>>사용</option>
						<option value="N" <c:if test="${pvo.useYn eq 'N'}" >selected</c:if>>미사용</option>
					</select>
				</div>
			</div>
			
			<div class="row mb-3">
				<label for="saleStatCd" class="col-sm-2 col-form-label pm-3">판매상태</label>
				<div class="col-md-4 col-sm-10 pm-3">
					<select id="saleStatCd" name="saleStatCd" class="form-select">
						<c:forEach items="${codeList}" var="obj">
							<option value="${obj.codeNm}" <c:if test="${pvo.saleStatCd eq obj.codeNm}" >selected</c:if> >${obj.codeNm}</option>
						</c:forEach>
					</select>
				</div>
				
				<label for="goodsPrc" class="col-sm-2 col-form-label pm-3">상품가격</label>
				<div class="col-md-4 col-sm-10 pm-3">
					<input type="number" id="goodsPrc" name="goodsPrc" value="${pvo.goodsPrc}" class="form-control" maxlength="20">
				</div>
			</div>
			
			<div class="row mb-3">
				<label for="catgryCd" class="col-sm-2 col-form-label pm-3">대분류</label>
				<div class="col-md-4 col-sm-10 pm-3">
					<select id="catgryCd" name="catgryCd" class="form-select">
						<option value="">선택</option>
						<c:forEach items="${upperCodeList}" var="obj">
							<option value="${obj.catgryCd}" <c:if test="${pvo.catgryCd eq obj.catgryCd}" >selected</c:if>>${obj.catgryNm}</option>
						</c:forEach>
					</select>
				</div>
				
				<label for="catgryCd2" class="col-sm-2 col-form-label pm-3">소분류</label>
				<div class="col-md-4 col-sm-10 pm-3">
					<select id="catgryCd2" name="catgryCd2" class="form-select">
						<option value="">선택</option>
						<c:forEach items="${underCodeList}" var="obj">
							<option value="${obj.catgryCd}" <c:if test="${pvo.catgryCd2 eq obj.catgryCd}" >selected</c:if>>${obj.catgryNm}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<div class="row mb-3">
				<label for="inyQty" class="col-sm-2 col-form-label pm-3">상품수량</label>
				<div class="col-md-4 col-sm-10 pm-3">
					<input type="number" id="inyQty" name="inyQty" value="${pvo.inyQty}" class="form-control" maxlength="20">
				</div>
			</div>
			
			<div class="row mb-3">
				<label for="goodsIntr" class="col-sm-2 col-form-label">상품상세설명</label>
				<div class="col-md-10 col-sm-12">
					<textarea rows="4" id="goodsIntr" name="goodsIntr" class="form-control">${pvo.goodsIntr}</textarea>
				</div>
			</div>
		</div>
		
		<div class="row mb-3">
			<div id="itemTitle" class="row">	
				<h4>아이템정보</h4>
				<figure>
					<figcaption class="blockquote-footer">
					<cite title="Source Title">상품 최초 등록 시 아이템 설정이 가능하며 상품 등록 후 아이템 추가는 불가합니다.</cite>
					</figcaption>
				</figure>
			</div>
				<div id="itemTagArea">
					<ul id="itemList">
						<c:forEach items="${optList}" var="opt">
							<li class="row col-md-12 pm-3">
								<input type="hidden" name="optsSeqArray[]" value="${opt.goodsOptsSeq}" />
								
								<label for="optsNmArray" class="col-sm-2 col-form-label">옵션명</label>
								<div class="col-md-4 col-sm-10">
									<select id="optsNmArray" class="form-control" disabled>
										<option>${opt.optsNm}</option>
									</select>
								</div>
								
								<label for="optsValArray" class="col-sm-2 col-form-label">옵션값</label>
								<div class="col-md-4 col-sm-10">
									<select id="optsValArray" class="form-control" disabled>
										<option>${opt.optsVal}</option>
									</select>
								</div>
								
								<label for="optsOrdrArray" class="col-sm-2 col-form-label">노출순서</label>
								<div class="col-md-4 col-sm-10">
									<input type="number" id="optsOrdrArray" name="optsOrdrArray[]" value="${opt.optsOrdr}" class="form-control" maxlength="20">
								</div>
								
								<label for="useYnArray" class="col-sm-2 col-form-label">사용여부</label>
								<div class="col-md-4 col-sm-10">
								<select id="useYnArray" name="useYnArray[]" class="form-select">
									<option value="Y" <c:if test="${opt.useYn eq 'Y'}" >selected</c:if>>사용</option>
									<option value="N" <c:if test="${opt.useYn eq 'N'}" >selected</c:if>>사용안함</option>
								</select>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
		</div>
	
		<div class="row mb-3">
		<h4>배송정보</h4>
			<div class="row mb-3">
				<label for="dlvPrc" class="col-sm-2 col-form-label pm-3">배송비</label>
				<div class="col-md-4 col-sm-10 pm-3">
					<input type="number" id="dlvPrc" name="dlvPrc" value="${pvo.dlvPrc}" class="form-control" maxlength="20">
				</div>
			</div>
		</div>
		
		<div class="row mb-3">
		<h4>썸네일</h4>
			<div class="row mb-3">
				<label for="file1" class="col-sm-2 col-form-label">대표이미지</label>
				<div class="col-md-4 col-sm-10">
					<input type="file" name="file1" class="form-control" onchange="previewImg(event);">
				</div>
			</div>
			
			<div class="row mb-3">
				<label for="imgPreView" class="col-sm-2 col-form-label"></label>
				<div class="col-md-4 col-sm-10">
					<img alt="" width="300px" src="${pvo.imgPath}${pvo.imgNm}">
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="text-center mt-4">
				<button type="button" class="btn btn-light me-2" onclick="location.href='/cltsh/adm/goods/admGoodsList.do'">목록</button>
				<button type="submit" class="btn btn-light me-2">수정</button>
				<button type="button" class="btn btn-danger" onclick="fn_goods_remove('${pvo.goodsInfoSeq}')">삭제</button>
			</div>
		</div>
		
	</form>
</div>


<script>
(function(){
	document.getElementById("catgryCd").addEventListener('change', makeRequest);
	function makeRequest() {
		httpRequest = new XMLHttpRequest();
		if(!httpRequest) {
			alert('XMLHTTP 인스턴스를 만들 수가 없어요 ㅠㅠ');
			return false;
		}
		let catgryCd = document.querySelector('#catgryCd').value;
		httpRequest.onreadystatechange = alertContents;
		httpRequest.open('POST', "DispatcherServlet?command=adm_cate_list_ajax");
		httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		/* httpRequest.setRequestHeader('Content-Type', 'application/json'); */
		httpRequest.send('catgryCd='+encodeURIComponent(catgryCd));
	}
	
	function alertContents() {
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if (httpRequest.status === 200) {
				var res = httpRequest.responseText;
				console.log('res:' + res);
				var rtnJson = JSON.parse(res);
				if(rtnJson.result == 'success'){
					let sel_catgryCd2 = document.querySelector('#catgryCd2');
					let sel_catgryCd2_options = document.querySelectorAll('#catgryCd2 option');
					for(let i=0; i<sel_catgryCd2_options.length; i++){
						sel_catgryCd2_options[i].remove();
					}
					//추가
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
			} else {
				alert('request에 뭔가 문제가 있어요.');
			}
		}
	}
})();

//상품수정
function fn_goods_edit(){
	if(confirm('상품을 정말 수정 하시겠습니까?')){
		return true;
	}else{
		return false;
	}
}

//상품삭제
function fn_goods_remove(goodsInfoSeq){
	if(confirm('상품을 정말 삭제 하시겠습니까?')){
		location.href='/cltsh/adm/goods/admGoodsRemoveAct.do?goodsInfoSeq=' + goodsInfoSeq;
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
		img.setAttribute("width", "300px");
		//img.setAttribute("height", "");
		document.querySelector("#imgPreView").appendChild(img);
	};
	reader.readAsDataURL(event.target.files[0]);
}
</script>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>
