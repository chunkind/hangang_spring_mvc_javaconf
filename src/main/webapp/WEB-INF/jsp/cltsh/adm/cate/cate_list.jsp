<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
  <h1 class="h2">카테고리 관리</h1>
  <div class="btn-toolbar mb-2 mb-md-0">
    <div class="btn-group me-2">
      <button type="button" id="btn_save" class="btn btn-sm btn-outline-secondary">저장</button>
      <!-- <button type="button" class="btn btn-sm btn-outline-secondary">Export</button> -->
    </div>
    <!-- <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle d-flex align-items-center gap-1">
      <svg class="bi"><use xlink:href="#calendar3"/></svg>
      This week
    </button> -->
  </div>
</div>

<form id="frm" method="post" action="/cltsh/adm/cate/admCateRegisterAct.do" onsubmit="return fn_submitCheck()">
	<input type="hidden" id="upperTxtCnt1" name="upperTxtCnt" value="0">
	<input type="hidden" id="underTxtCnt1" name="underTxtCnt" value="0">
	<div class="container">
		<div class="row">
			<!-- 상위 카테고리 -->
			<div class="col-12 col-md-6 mb-4">
				<h4 class="text-center">상위 카테고리</h4>
				<div class="table-responsive">
					<table class="table table-striped table-sm">
						<thead>
							<tr>
								<th class="text-center col-2">분류 코드</th>
								<th class="text-center col-2">분류 명</th>
								<th class="text-center col-2">비고 내용</th>
								<th class="text-center col-2">사용 여부</th>
								<th class="text-center col-1">삭제</th>
							</tr>
						</thead>
						<tbody id="upper_items_area">
							<c:forEach items="${list}" var="obj" varStatus="countObj">
								<c:if test="${obj.classLvlCd eq '1'}">
									<tr>
										<input type="hidden" name="upGoodsCataSeq${countObj.index}" value="${obj.goodsCataSeq}" />
										<td onclick="fn_a('${obj.catgryCd}')"><input type="text" class="form-control form-control-sm" name="upCatgryCd${countObj.index}" value="${obj.catgryCd}" /></td>
										<td><input type="text" class="form-control form-control-sm" name="upCatgryNm${countObj.index}" value="${obj.catgryNm}" /></td>
										<td><input type="text" class="form-control form-control-sm" name="upNoteCont${countObj.index}" value="${obj.noteCont}" /></td>
										<td>
											<select class="form-select form-select-sm" name="upUseYn${countObj.index}">
												<option value="Y" <c:if test="${obj.useYn eq 'Y'}" >selected</c:if>>사용</option>
												<option value="N" <c:if test="${obj.useYn eq 'N'}" >selected</c:if>>사용안함</option>
											</select>
										</td>
										<td><button type="button" class="btn btn-danger btn-sm" onclick="fnDel(this, '${obj.goodsCataSeq}', '${obj.classLvlCd}');">삭제</button></td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<button type="button" class="btn btn-primary btn-sm w-100" id="upper_btn_add">상위 카테고리 추가</button>
			</div>

			<!-- 하위 카테고리 -->
			<div class="col-12 col-md-6 mb-4">
				<h4 class="text-center">하위 카테고리</h4>
				<div class="table-responsive">
					<table class="table table-striped table-sm">
						<thead>
							<tr>
								<th class="text-center col-2">분류 코드</th>
								<th class="text-center col-2">분류 명</th>
								<th class="text-center col-2">비고 내용</th>
								<th class="text-center col-2">사용 여부</th>
								<th class="text-center col-1">삭제</th>
							</tr>
						</thead>
						<tbody id="under_items_area">
							<c:forEach items="${underList}" var="obj" varStatus="countObj">
								<c:if test="${obj.classLvlCd eq '2'}">
									<tr>
										<input type="hidden" name="unGoodsCataSeq${countObj.index}" value="${obj.goodsCataSeq}" />
										<td><input type="text" class="form-control form-control-sm" name="unCatgryCd${countObj.index}" value="${obj.catgryCd}" /></td>
										<td><input type="text" class="form-control form-control-sm" name="unCatgryNm${countObj.index}" value="${obj.catgryNm}" /></td>
										<td><input type="text" class="form-control form-control-sm" name="unNoteCont${countObj.index}" value="${obj.noteCont}" /></td>
										<td>
											<select class="form-select form-select-sm" name="unUseYn${countObj.index}">
												<option value="Y" <c:if test="${obj.useYn eq 'Y'}" >selected</c:if>>사용</option>
												<option value="N" <c:if test="${obj.useYn eq 'N'}" >selected</c:if>>사용안함</option>
											</select>
										</td>
										<td><button type="button" class="btn btn-danger btn-sm" onclick="fnDel(this, '${obj.goodsCataSeq}', '${obj.classLvlCd}');">삭제</button></td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<button type="button" class="btn btn-primary btn-sm w-100" id="under_btn_add">하위 카테고리 추가</button>
			</div>
		</div>
	</div>
</form>



<script>
let upperTextCnt = 0 + Number('${upperListSize}');
let underTextCnt = 0 + Number('${underListSize}');
let btnCnt = 0;
let nmAdd = '';
let classCd = '';
let underCnt = 0;




document.querySelector('#btn_save').addEventListener("click", () => {
    // fn_submitCheck() 호출
    if (fn_submitCheck()) {
        document.querySelector('#frm').submit(); // 조건이 만족될 경우 폼 제출
    }
});

document.addEventListener("DOMContentLoaded", () => {
	let upper_btn_add = document.querySelector('#upper_btn_add');
	let under_btn_add = document.querySelector('#under_btn_add');
	let upper_items_area = document.querySelector('#upper_items_area');
	let under_items_area = document.querySelector('#under_items_area');

		upper_btn_add.addEventListener('click', () => {
		classCd = '1';
		upper_items_area.insertAdjacentHTML('beforeend', fn_getHtmlInput('up', upperTextCnt, classCd));
		upperTextCnt++;
	});
	
	under_btn_add.addEventListener('click', () => {
		classCd = '2';
		under_items_area.insertAdjacentHTML('beforeend', fn_getHtmlInput('un', underTextCnt, classCd));
		underTextCnt++;
	});
});

function fn_getHtmlInput(type, index, classCd) {
	let html = `
	<tr>
		<input type="hidden" name="` + type + `ClassLvlCd` + index + `" value="` + classCd + `"/>
		<input type="hidden" name="` + type + `CateType` + index + `" value="cateInsert"/>
		<td><input type="text" class="form-control form-control-sm" name="` + type + `CatgryCd` + index + `" placeholder="분류코드"/></td>
		<td><input type="text" class="form-control form-control-sm" name="` + type + `CatgryNm` + index + `" placeholder="분류명"/></td>
		<td><input type="text" class="form-control form-control-sm" name="` + type + `NoteCont` + index + `" placeholder="비고내용"/></td>
		<td>
			<select class="form-select form-select-sm" name="` + type + `UseYn` + index + `">
				<option value="Y">사용</option>
				<option value="N">사용안함</option>
			</select>
		</td>
		<td><button type="button" class="btn btn-danger btn-sm" onclick="fnDel(this);">취소</button></td>
	</tr>`;
	return html;
}

function fnDel(_this, goodsCataSeq , classLvlCd){
	if(goodsCataSeq == null){
		//_this.parentNode.parentNode.parentNode.remove();
		_this.parentNode.parentNode.remove();
	}else {
		if(classLvlCd == "1" && 0 < underTextCnt){
			alert("하위 카테고리가 있습니다.");
		}else if(confirm('상품을 정말 삭제 하시겠습니까?')){
			_this.parentNode.parentNode.remove();
			location.href = '/cltsh/adm/cate/admCateRemoveAct.do?goodsCataSeq='+goodsCataSeq;
		}
	}
}

function fn_a(catgryCd){
	location.href = '/cltsh/adm/cate/admCateList.do?catgryCd='+catgryCd;
}

function fn_submitCheck() {
    let upperTextCnt_add = document.querySelector('#upperTxtCnt1');
    let underTextCnt_add = document.querySelector('#underTxtCnt1');

    console.log("Before Update - Upper Count:", upperTextCnt_add.value);
    console.log("Before Update - Under Count:", underTextCnt_add.value);
    
    upperTextCnt_add.value = upperTextCnt;
    underTextCnt_add.value = underTextCnt;

    console.log("After Update - Upper Count:", upperTextCnt_add.value);
    console.log("After Update - Under Count:", underTextCnt_add.value);

    // 최종 값 확인 후 반환
    console.log("Submitting form with values: ", {
        upperTextCnt: upperTextCnt_add.value,
        underTextCnt: underTextCnt_add.value
    });

    return true; 
}
</script>