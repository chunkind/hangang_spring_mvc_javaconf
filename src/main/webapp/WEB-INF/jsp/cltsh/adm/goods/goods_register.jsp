<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2 class="text-center mb-5">상품 관리 > 상품 목록 > 상품 등록</h2>
	<form action="/cltsh/adm/goods/admGoodsRegisterAct.do" method="post" enctype="multipart/form-data">

		<div class="row mb-3">
			<div class="col-md-4">
				<div class="form-group">
					<label for="entrNo" class="form-label">판매처</label>
					<select id="entrNo" name="entrNo" class="form-select">
						<c:forEach items="${entrList}" var="obj">
							<option value="${obj.entrNo}">${obj.entrNm}(${obj.entrNo})</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label for="saleStatCd" class="form-label">판매상태</label>
					<select id="saleStatCd" name="saleStatCd" class="form-select">
						<c:forEach items="${codeList}" var="obj">
							<option value="${obj.codeNm}">${obj.codeNm}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label for="goodsNm" class="form-label">상품명</label>
					<input type="text" id="goodsNm" name="goodsNm" class="form-control" maxlength="20">
				</div>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-md-4">
				<div class="form-group">
					<label for="goodsPrc" class="form-label">상품가격</label>
					<input type="number" id="goodsPrc" name="goodsPrc" class="form-control" maxlength="20">
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label for="catgryCd" class="form-label">대분류</label>
					<select id="catgryCd" name="catgryCd" class="form-select">
						<option value="">선택</option>
						<c:forEach items="${upperCodeList}" var="obj">
							<option value="${obj.catgryCd}">${obj.catgryNm}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label for="catgryCd2" class="form-label">소분류</label>
					<select id="catgryCd2" name="catgryCd2" class="form-select">
						<option value="">선택</option>
					</select>
				</div>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-md-4">
				<div class="form-group">
					<label for="inyQty" class="form-label">상품수량</label>
					<input type="number" id="inyQty" name="inyQty" value="1" class="form-control" maxlength="20">
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label for="dlvPrc" class="form-label">배송비</label>
					<input type="number" id="dlvPrc" name="dlvPrc" value="2000" class="form-control" maxlength="20">
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label for="goodsSize" class="form-label">사이즈</label>
					<select id="goodsSize" name="goodsSize" class="form-select">
						<option value="XS">XS</option>
						<option value="S">S</option>
						<option value="M">M</option>
						<option value="L">L</option>
						<option value="XL">XL</option>
						<option value="XXL">XXL</option>
						<option value="XXXL">XXXL</option>
						<option value="FREE">FREE</option>
					</select>
				</div>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-md-4">
				<div class="form-group">
					<label for="goodsClr" class="form-label">컬러</label>
					<select id="goodsClr" name="goodsClr" class="form-select">
						<option value="black">블랙</option>
						<option value="white">화이트</option>
						<option value="naivy">네이비</option>
						<option value="ivory">아이보리</option>
					</select>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label for="useYn" class="form-label">사용여부</label>
					<select id="useYn" name="useYn" class="form-select">
						<option value="Y">사용</option>
						<option value="N">미사용</option>
					</select>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label for="file1" class="form-label">이미지</label>
					<input type="file" id="file1" name="file1" class="form-control" onchange="previewImg(event);">
					<input type="hidden" id="imgPath" name="imgPath" />
					<input type="hidden" id="imgNm" name="imgNm" />
				</div>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-md-4">
				<div class="form-group">
					<label for="goodsIntr" class="form-label">상품소개</label>
					<textarea rows="4" id="goodsIntr" name="goodsIntr" class="form-control"></textarea>
				</div>
			</div>
			<div class="col-md-4">
				<div id="imgPreView" class="mt-2"></div>
			</div>
			<div class="col-md-4 d-flex align-items-center">
				<button type="button" class="btn btn-secondary me-2 w-100" onclick="location.href='/cltsh/adm/opts/admOptsList.do'">상품 옵션 추가</button>
			</div>
		</div>

		<div class="text-center mt-4">
			<button type="button" class="btn btn-secondary me-2" onclick="location.href='/cltsh/adm/goods/admGoodsList.do'">목록</button>
			<button type="submit" class="btn btn-primary">등록</button>
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