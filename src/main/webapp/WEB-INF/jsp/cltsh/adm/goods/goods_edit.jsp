<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<h2>상품 관리 > 상품 목록 > 상품 등록</h2>
<form action="/cltsh/adm/goods/admGoodsEditAct.do" method="post" enctype="multipart/form-data" onsubmit="return fn_goods_edit()">
<input type="hidden" name="goodsInfoSeq" value="${pvo.goodsInfoSeq }" />
<input type="hidden" name="goodsCd" value="${pvo.goodsCd }" />
<input type="hidden" name="imgPath" id="imgPath" value="${pvo.imgPath }"/>
<input type="hidden" name="imgNm" id="imgNm" value="${pvo.imgNm }" />
<div class="data_list">
    <table>
    	<colgroup>
    		<col width="20%" />
    		<col width="30%" />
    		<col width="20%" />
    		<col width="30%" />
    	</colgroup>
    	<tr>
    		<th><div>판매처</div></th>
    		<td>
    			<select name="entrNo">
					<c:forEach items="${entrList}" var="obj">
						<option value="${obj.entrNo}" <c:if test="${pvo.entrNo eq obj.entrNo}" >selected</c:if>>${obj.entrNm}(${obj.entrNo})</option>
					</c:forEach>
				</select>
    		</td>
    		<th><div>판매상태</div></th>
    		<td>
    			<select name="saleStatCd">
    				<option value="01" <c:if test="${pvo.saleStatCd eq '01'}" >selected</c:if>>판매중</option>
    				<option value="02" <c:if test="${pvo.saleStatCd eq '02'}" >selected</c:if>>판매중지</option>
    				<option value="03" <c:if test="${pvo.saleStatCd eq '03'}" >selected</c:if>>품절</option>
    				<option value="04" <c:if test="${pvo.saleStatCd eq '04'}" >selected</c:if>>재고부족</option>
    			</select>
    		</td>
    	</tr>
        <tr>
    		<th><div>상품명</div></th>
            <td><input type="text" name="goodsNm" value="${pvo.goodsNm}"></td>
            <th><div>상품가격</div></th>
            <td><input type="number" name="goodsPrc" value="${pvo.goodsPrc}"></td>
        </tr>
        <tr>
			<th><div>대분류</div></th>
            <td>
            	<select name="catgryCd" id="catgryCd">
                    <option value="">선택</option>
                    <c:forEach items="${upperCodeList}" var="obj">
                    	<option value="${obj.catgryCd}" <c:if test="${pvo.catgryCd eq obj.catgryCd}" >selected</c:if>>${obj.catgryNm}</option>
                    </c:forEach>
                </select>
            </td>
            <th><div>소분류</div></th>
            <td>
            	<select name="catgryCd2" id="catgryCd2">
                    <option value="">선택</option>
                    <c:forEach items="${underCodeList}" var="obj">
                    	<option value="${obj.catgryCd}" <c:if test="${pvo.catgryCd2 eq obj.catgryCd}" >selected</c:if>>${obj.catgryNm}</option>
                    </c:forEach>
                </select>
            </td>            
        </tr>
        <tr>
            <th><div>상품수량</div></th>
            <td><input type="number" name="inyQty" value="${pvo.inyQty}"></td>
            <th><div>배송비</div></th>
            <td><input type="number" name="dlvPrc" value="${pvo.dlvPrc}"></td>
        </tr>
        <tr>
        	<th><div>사이즈</div></th>
            <td>
                <select name="goodsSize">
                    <option value="XS" <c:if test="${pvo.goodsSize eq 'XS'}" >selected</c:if>>S</option>
                    <option value="S" <c:if test="${pvo.goodsSize eq 'S'}" >selected</c:if>>S</option>
                    <option value="M" <c:if test="${pvo.goodsSize eq 'M'}" >selected</c:if>>M</option>
                    <option value="L" <c:if test="${pvo.goodsSize eq 'L'}" >selected</c:if>>L</option>
                    <option value="XL" <c:if test="${pvo.goodsSize eq 'XL'}" >selected</c:if>>XL</option>
                    <option value="XXL" <c:if test="${pvo.goodsSize eq 'XXL'}" >selected</c:if>>XXL</option>
                    <option value="XXXL" <c:if test="${pvo.goodsSize eq 'XXXL'}" >selected</c:if>>XXXL</option>
                    <option value="FREE" <c:if test="${pvo.goodsSize eq 'FREE'}" >selected</c:if>>FREE</option>
                </select>
            </td>
            <th><div>컬러</div></th>
            <td>
                <select name="goodsClr">
                    <option value="black" <c:if test="${pvo.goodsClr eq 'black'}" >selected</c:if>>블랙</option>
                    <option value="white" <c:if test="${pvo.goodsClr eq 'white'}" >selected</c:if>>화이트</option>
                    <option value="naivy" <c:if test="${pvo.goodsClr eq 'naivy'}" >selected</c:if>>네이비</option>
                    <option value="ivory" <c:if test="${pvo.goodsClr eq 'ivory'}" >selected</c:if>>아이보리</option>
                </select>
            </td>
        </tr>
        <tr>
            <th><div>사용여부</div></th>            
            <td>
            	<select name="useYn">
            		<option value="Y" <c:if test="${pvo.useYn eq 'Y'}" >selected</c:if>>사용</option>
            		<option value="N" <c:if test="${pvo.useYn eq 'N'}" >selected</c:if>>미사용</option>
            	</select>
            </td>
			<th><div>이미지</div></th>
            <td>
            	<input type="file" name="file1" onchange="previewImg(event);">
            </td>
        </tr>
        <tr>
            <th><div>상품소개</div></th>
            <td colspan="2">
            	<textarea rows="20" cols="70" name="goodsIntr">${pvo.goodsIntr}</textarea>
            </td>
            <td>
            	<div id="imgPreView">
            		<img alt="" width="300px" src="${pvo.imgPath}${pvo.imgNm}">
            	</div>
            </td>
        </tr>
    </table>
</div>
<div class="btn_area">
    <input type="button" value="목록" onclick="location.href='/cltsh/adm/goods/admGoodsList.do'"/>
    <input type="button" value="삭제" onclick="fn_goods_remove('${pvo.goodsInfoSeq}')"/>
    <input type="submit" value="수정"/>
</div>
</form>
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