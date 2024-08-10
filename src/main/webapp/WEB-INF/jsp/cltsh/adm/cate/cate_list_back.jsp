<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>카테고리 관리</h2>
<form method="post" action="/cltsh/adm/cate/admCateRegisterAct.do" onsubmit="return fn_submitCheck()">
<input type="hidden" id="upperTxtCnt" name="upperTxtCnt" value="0">
<input type="hidden" id="underTxtCnt" name="underTxtCnt" value="0">
<div class="data_list">
    <div class="upper_lvl">
    	<div class="items_header">
    		<span>분류 코드</span>
    		<span>분류 명</span>
    		<span>비고 내용</span>
    		<span>사용 여부</span>
    		<span>삭제</span>
    	</div>
    	<div class="items">
			<c:forEach items="${list }" var="obj" varStatus="countObj">
				<c:if test="${obj.classLvlCd eq '1'}">
					<div onclick="fn_a('${obj.catgryCd}')">
						<ul>
							<li><input type="text" name="upCatgryCd${countObj.index }" value="${obj.catgryCd}" /></li>
							<li><input type="text" name="upCatgryNm${countObj.index }" value="${obj.catgryNm}" /></li>
							<li><input type="text" name="upNoteCont${countObj.index }" value="${obj.noteCont}" /></li>
							<input type="hidden" name="upCateType${countObj.index }" value="'cateUpdate'"/>
							<input type="hidden" name="upGoodsCataSeq${countObj.index }" value="${obj.goodsCataSeq}"/>
							<li><select name="upUseYn${countObj.index }">
									<option value="Y" <c:if test="${obj.useYn eq 'Y'}" >selected</c:if>>사용</option>
									<option value="N" <c:if test="${obj.useYn eq 'N'}" >selected</c:if>>사용안함</option>
							</select></li>
							<li><input type="button" class="btn_del" value="취소" onclick="fnDel(this , '${obj.goodsCataSeq}' , '${obj.classLvlCd}');" /></li>
						</ul>
					</div>
			    </c:if>
			</c:forEach>
    	</div>
    	<div class="items">
    		<span class="plus" id="upper_btn_add">+</span>
    	</div>
    </div>
    <div class="under_lvl">
    	<div class="items_header">
    		<span>분류 코드</span>
    		<span>분류 명</span>
    		<span>비고 내용</span>
    		<span>사용 여부</span>
    		<span>삭제</span>
    	</div>
    	<div class="items">
			<c:forEach items="${underList }" var="obj" varStatus="countObj">
				<c:if test="${obj.classLvlCd eq '2'}">
					<div>
						<ul>
							<li><input type="text" name="unCatgryCd${countObj.index }" value="${obj.catgryCd}" /></li>
							<li><input type="text" name="unCatgryNm${countObj.index }" value="${obj.catgryNm}" /></li>
							<li><input type="text" name="unNoteCont${countObj.index }" value="${obj.noteCont}" /></li>
							<input type="hidden" name="unCateType${countObj.index }" value="'cateUpdate'"/>
							<input type="hidden" name="unGoodsCataSeq${countObj.index }" value="${obj.goodsCataSeq}"/>
							<li><select name="unUseYn${countObj.index }">
									<option value="Y" <c:if test="${obj.useYn eq 'Y'}" >selected</c:if>>사용</option>
									<option value="N" <c:if test="${obj.useYn eq 'N'}" >selected</c:if>>사용안함</option>
							</select></li>
							<li><input type="button" class="btn_del" value="취소" onclick="fnDel(this , '${obj.goodsCataSeq}', '${obj.classLvlCd}');" /></li>
						</ul>
					</div>
			    </c:if>
			</c:forEach>
    	</div>
    	<div class="items">
    		<span class="plus" id="under_btn_add">+</span>
    	</div>
    </div>
</div>
<div>
	<input type="submit" value="저장"/>
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
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>