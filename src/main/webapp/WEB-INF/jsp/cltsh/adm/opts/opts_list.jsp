<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>

<style>
.admin_body select, 
.admin_body input {
    width: 40%;
}

.data_list {
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    width: 100%;
}

.items_header {
	background-color: #e6e3fc;
	padding: 20px;
	font-weight: bold;
	border-bottom: 1px solid black;
	display: flex;
	justify-content: space-around;
}

.items div {
	border-bottom: 1px solid black;
	display: flex;
	justify-content: space-around;
}

.plus {
	width: 100%;
	display: flex;
	justify-content: center;
	font-size: 28px;
	cursor: pointer;
}

.btn_del {
	width: 60px !important;
	height: 25px !important;
	padding: 0 !important;
}

.items div ul li {
	display: inline-block;
	width: 20%;
	text-align: center;
	padding: 10px 0px 0px 6px;
}

.items div ul li input,
.items div ul li select {
	width: 100%;
}

.items ul.optslist {
	display: flex;
	flex-direction: row;
	justify-content: space-around;
	list-style: none;
	border-bottom: 1px solid black;
}
.items ul.optslist li {
	width: 20%; /* 각 항목이 동일한 너비를 가지도록 설정 */
	text-align: center;
	padding: 10px 0px 0px 6px;
}
.items ul.optslist li input,
.items ul.optslist li select {
	width: 100%;
}
</style>


<h2>상품 옵션 관리</h2>
<form method="post" action="/cltsh/adm/opts/admOptsRegisterAct.do" onsubmit="return fn_submitCheck()">
<div class="items_header">
	<span>옵션 번호</span>
	<span>옵션 명</span>
	<span>옵션 값</span>
	<span>사용 여부</span>
	<span>삭제</span>
</div>

<div class="items">
	<c:forEach items="${optsList }" var="obj" varStatus="countObj">
		<ul class="optslist">
			<li><input type="text" name="optsCd${countObj.index }" value="${obj.optsCd}" /></li>
			<li><input type="text" name="optsNm${countObj.index }" value="${obj.optsNm}" /></li>
			<li><input type="text" name="optsVal${countObj.index }" value="${obj.optsVal}" /></li>
			<%-- <li>
				<select name="upUseYn${countObj.index}">
					<option value="Y" <c:if test="${obj.useYn eq 'Y'}">selected</c:if>>사용</option>
					<option value="N" <c:if test="${obj.useYn eq 'N'}">selected</c:if>>사용안함</option>
				</select>
			</li> --%>
			<input type="hidden" name="goodsOptsSeq" value="${obj.goodsOptsSeq}"/></li>
			<input type="hidden" name="goodsCd" value="${obj.goodsCd}"/></li>
			<li><input type="button" class="btn_del" value="취소" onclick="fnDel(this , '${obj.goodsOptsSeq}');" /></li>
		</ul>
	</c:forEach>
</div>
<div class="items">
	<span class="plus" id="opts_btn_add">+</span>
</div>

<div>
	<input type="submit" value="저장"/>
</div>
</form>

<script>
let upperTextCnt = 0;
let btnCnt = 0;

document.addEventListener("DOMContentLoaded", () => {
	let opts_btn_add = document.querySelector('#opts_btn_add');
	let htmlInput = fn_getHtmlInput();
	let items_area = document.querySelector('.items');
	
	opts_btn_add.addEventListener('click', ()=>{
		btnCnt = upperTextCnt;
		items_area.innerHTML += fn_getHtmlInput();
		upperTextCnt++;
	});
});

function fn_getHtmlInput(){
	let html = ''
	+'<div><ul>'
	+	'<li><input type="text" name="optsCd'+ btnCnt +'" placeholder="옵션코드"/></li>'
	+	'<li><input type="text" name="optsNm'+ btnCnt +'" placeholder="옵션이름"/></li>'
	+	'<li><input type="text" name="optsVal'+ btnCnt +'" placeholder="분류코드"/></li>'
	+	'<li>'
	+		'<select name="useYn'+ btnCnt +'">'
	+			'<option value="Y">사용</option>'
	+			'<option value="N">사용안함</option>'
	+		'</select>'
	+	'</li>'
	+	'<input type="hidden" name="goodsOptsSeq'+ btnCnt +'"/></li>'
	+	'<input type="hidden" name="goodsCd'+ btnCnt +'"/></li>'
	+	'<li><input type="button" class="btn_del" value="취소" onclick="fnDel(this);" /></li>'
	+'</ul></div>'
	;
	return html;
}

function fn_submitCheck(){
	/* debugger; */
	let upperTextCnt_add = document.querySelector('#upperTxtCnt');
	let underTextCnt_add = document.querySelector('#underTxtCnt');
	
	upperTextCnt_add.value = upperTextCnt;
	underTextCnt_add.value = underTextCnt;
	
	return true;
}
function fnDel(_this, goodsOptsSeq){
	if(goodsOptsSeq == null){
		_this.parentNode.parentNode.parentNode.remove();
	}else {
		if(confirm('옵션을 정말 삭제 하시겠습니까?')){
			_this.parentNode.parentNode.parentNode.remove();
			location.href = '/cltsh/adm/opts/admOptsRemoveAct.do?goodsOptsSeq='+goodsOptsSeq;
		}
	}
}
</script>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>