<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h2 class="my-4 text-center">카테고리 관리</h2>
<form method="post" action="/cltsh/adm/cate/admCateRegisterAct.do" onsubmit="return fn_submitCheck()">
	<input type="hidden" id="upperTxtCnt" name="upperTxtCnt" value="0">
	<input type="hidden" id="underTxtCnt" name="underTxtCnt" value="0">
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
						<tbody>
							<c:forEach items="${list}" var="obj" varStatus="countObj">
								<c:if test="${obj.classLvlCd eq '1'}">
									<tr>
										<td><input type="text" class="form-control form-control-sm" name="upCatgryCd${countObj.index}" value="${obj.catgryCd}" /></td>
										<td><input type="text" class="form-control form-control-sm" name="upCatgryNm${countObj.index}" value="${obj.catgryNm}" /></td>
										<td><input type="text" class="form-control form-control-sm" name="upNoteCont${countObj.index}" value="${obj.noteCont}" /></td>
										<td>
											<select class="form-select form-select-sm" name="upUseYn${countObj.index}">
												<option value="Y" <c:if test="${obj.useYn eq 'Y'}" >selected</c:if>>사용</option>
												<option value="N" <c:if test="${obj.useYn eq 'N'}" >selected</c:if>>사용안함</option>
											</select>
										</td>
										<td><button type="button" class="btn btn-info btn-sm" onclick="fnDel(this, '${obj.goodsCataSeq}', '${obj.classLvlCd}');">삭제</button></td>
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
						<tbody>
							<c:forEach items="${underList}" var="obj" varStatus="countObj">
								<c:if test="${obj.classLvlCd eq '2'}">
									<tr>
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
		<div class="row">
			<div class="col text-center">
				<button type="submit" class="btn btn-success">저장</button>
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

document.addEventListener("DOMContentLoaded", () => {
	let upper_btn_add = document.querySelector('#upper_btn_add');
	let under_btn_add = document.querySelector('#under_btn_add');
	let upper_items_area = document.querySelector('.upper_lvl .items');
	let under_items_area = document.querySelector('.under_lvl .items');
	let htmlInput = fn_getHtmlInput();
	
	upper_btn_add.addEventListener('click', ()=>{
		btnCnt = upperTextCnt;
		nmAdd = 'up';
		classCd = '1';
		upper_items_area.innerHTML += fn_getHtmlInput();
		upperTextCnt++;
	});
	
	under_btn_add.addEventListener('click', ()=>{
		btnCnt = underTextCnt;
		nmAdd = 'un';
		classCd = '2';
		under_items_area.innerHTML += fn_getHtmlInput();
		underTextCnt++;
	});
});
function fn_getHtmlInput(){
	let html = ''
	+'<div><ul>'
	+	'<li><input type="text" id="'+nmAdd+'CatgryCd'+btnCnt+'" name="'+nmAdd+'CatgryCd'+btnCnt+'" placeholder="분류코드"/></li>'
	+	'<li><input type="text" name="'+nmAdd+'CatgryNm'+btnCnt+'" placeholder="분류명"/></li>'
	+	'<li><input type="text" name="'+nmAdd+'NoteCont'+btnCnt+'" placeholder="비고내용"/></li>'
	+	'<input type="hidden" name="'+nmAdd+'ClassLvlCd'+btnCnt+'" value="'+classCd+'"/>'
	+	'<input type="hidden" name="'+nmAdd+'CateType'+btnCnt+'" value="cateInsert"/>'
	+	'<li>'
	+		'<select name="'+nmAdd+'UseYn'+btnCnt+'">'
	+			'<option value="Y">사용</option>'
	+			'<option value="N">사용안함</option>'
	+		'</select>'
	+	'</li>'
	+	'<li><input type="button" class="btn_del" value="취소" onclick="fnDel(this);" /></li>'
	+'</ul></div>'
	;
	return html;
}
function fn_a(catgryCd){
	location.href = '/cltsh/adm/cate/admCateList.do?catgryCd='+catgryCd;
}
function fnDel(_this, goodsCataSeq , classLvlCd){
	if(goodsCataSeq == null){
		_this.parentNode.parentNode.parentNode.remove();
	}else {
		if(classLvlCd == "1" && 0 < underTextCnt){
			alert("하위 카테고리가 있습니다.");
		}else if(confirm('상품을 정말 삭제 하시겠습니까?')){
			_this.parentNode.parentNode.parentNode.remove();
			location.href = '/cltsh/adm/cate/admCateRemoveAct.do?goodsCataSeq='+goodsCataSeq;
		}
	}
}
function fn_submitCheck(){
	/* debugger; */
	let upperTextCnt_add = document.querySelector('#upperTxtCnt');
	let underTextCnt_add = document.querySelector('#underTxtCnt');
	
	upperTextCnt_add.value = upperTextCnt;
	underTextCnt_add.value = underTextCnt;
	
	return true;
}
</script>