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
				<h4>옵션 관리</h4>
				<figure>
					<figcaption class="blockquote-footer">
					<cite title="Source Title">최초 상품 등록 시 아이템 설정이 가능하며 상품 등록 후 아이템 추가는 불가합니다.</cite>
					</figcaption>
				</figure>
				
				<div id="itemButton" class="col-md-2">
					<!-- button id="addItem" type="button" class="btn btn-primary btn-sm">아이템추가</button-->
				</div>
			</div>
				<div id="itemTagArea">
					 <!-- 옵션 그룹 추가 -->
				    <div id="optionGroups" class="mb-3">
				        <h5>옵션 그룹</h5>
				        <button class="btn btn-primary btn-sm mb-2" onclick="addOptionGroup();return false;">옵션 그룹 추가</button>
				    </div>
				
				    <!-- 옵션 조합 생성 버튼 -->
				    <button class="btn btn-success" onclick="generateCombinations(); return false;">옵션 조합 생성</button>
				
				    <!-- 옵션 조합 리스트 -->
				    <h5 class="mt-4">옵션 조합</h5>
				    <table class="table">
				        <thead>
				            <tr>
				                <th>옵션 조합</th>
				                <th>재고</th>
				                <th>사용 여부</th>
				            </tr>
				        </thead>
				        <tbody id="optionGrid">
				            <!-- 옵션 조합이 여기에 동적으로 추가됨 -->
				        </tbody>
				    </table>
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


<script>
function addOptionGroup() {
    let optionGroupId = $(".option-group").length + 1;
    let groupHtml = `
        <div class="option-group mb-3">
            <label>옵션 그룹명</label>
            <input type="text" class="form-control option-group-name" placeholder="예: 사이즈, 색상, 소재">
            <label class="mt-2">옵션 값</label>
            <input type="text" class="form-control option-values" placeholder="쉼표(,)로 구분 (예: S, M, L)">
            <button class="btn btn-danger btn-sm mt-2" onclick="removeOptionGroup(this)">옵션 그룹 삭제</button>
        </div>
    `;
    $("#optionGroups").append(groupHtml);
}

function removeOptionGroup(button) {
    $(button).closest(".option-group").remove();
}

function generateCombinations() {
    let optionGrid = $("#optionGrid");
    optionGrid.empty(); // 기존 조합 초기화

    let optionGroups = [];
    $(".option-group").each(function () {
        let groupName = $(this).find(".option-group-name").val().trim();
        let values = $(this).find(".option-values").val().split(",").map(v => v.trim()).filter(Boolean);

        if (groupName && values.length > 0) {
            optionGroups.push({ groupName, values });
        }
    });

    if (optionGroups.length === 0) {
        alert("옵션 그룹을 추가하고 값을 입력해주세요.");
        return;
    }

    let combinations = getCombinations(optionGroups.map(g => g.values));

    combinations.forEach(combination => {
        if (!Array.isArray(combination)) {
            console.error("잘못된 데이터 형식:", combination);
            return;
        }

        let rowHtml = '';
        	rowHtml += '<tr>';
       		rowHtml += '<td>'+combination.join(" > ")+'</td>';
       		rowHtml += '<td><input type="number" class="form-control" value="10"></td>';
       		rowHtml += '<td>';
    		rowHtml += '<select class="form-select">';
    		rowHtml += '<option value="Y" selected>사용</option>';
    		rowHtml += '<option value="N">사용 안함</option>';
    		rowHtml += '</select>';
    		rowHtml += '</td>';
    		rowHtml += '</tr>';
        optionGrid.append(rowHtml);
    });
}

function getCombinations(arrays) {
    if (!arrays || arrays.length === 0) return [];

    let result = [[]];
    for (let i = 0; i < arrays.length; i++) {
        let temp = [];
        for (let res of result) {
            for (let val of arrays[i]) {
                temp.push([...res, val]);
            }
        }
        result = temp;
    }

    return result;
}
</script>