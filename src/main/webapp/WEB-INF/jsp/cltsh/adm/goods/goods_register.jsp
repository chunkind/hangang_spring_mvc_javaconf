<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<h2>상품 관리 > 상품 목록 > 상품 등록</h2>
<form action="/cltsh/adm/goods/admGoodsRegisterAct.do" method="post" enctype="multipart/form-data">
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
						<option value="${obj.entrNo}">${obj.entrNm}(${obj.entrNo})</option>
					</c:forEach>
				</select>
    		</td>
    		<th><div>판매상태</div></th>
    		<td>
    			<select name="saleStatCd">
    				<c:forEach items="${codeList}" var="obj">
						<option value="${obj.codeNm}">${obj.codeNm}</option>
					</c:forEach>
    			</select>
    		</td>
    	</tr>
        <tr>
    		<th><div>상품명</div></th>
            <td><input type="text" name="goodsNm"></td>
            <th><div>상품가격</div></th>
            <td><input type="number" name="goodsPrc"></td>
        </tr>
        <tr>
			<th><div>대분류</div></th>
            <td>
                <select name="catgryCd" id="catgryCd">
                    <option value="">선택</option>
                    <c:forEach items="${upperCodeList}" var="obj">
                    	<option value="${obj.catgryCd}">${obj.catgryNm}</option>
                    </c:forEach>
                </select>
            </td>
            <th><div>소분류</div></th>
            <td>
				<select name="catgryCd2" id="catgryCd2">
					<option value="">선택</option>
				</select>
            </td>            
        </tr>
        <tr>
            <th><div>상품수량</div></th>
            <td><input type="number" name="inyQty" value="1"></td>
            <th><div>배송비</div></th>
            <td><input type="number" name="dlvPrc" value="2000"></td>
        </tr>
        <tr>
        	<th><div>사이즈</div></th>
            <td>
                <select name="goodsSize">
                    <option value="XS">S</option>
                    <option value="S">S</option>
                    <option value="M">M</option>
                    <option value="L">L</option>
                    <option value="XL">XL</option>
                    <option value="XXL">XXL</option>
                    <option value="XXXL">XXXL</option>
                    <option value="FREE">FREE</option>
                </select>
            </td>
            <th><div>컬러</div></th>
            <td>
                <select name="goodsClr">
                    <option value="black">블랙</option>
                    <option value="white">화이트</option>
                    <option value="naivy">네이비</option>
                    <option value="ivory">아이보리</option>
                </select>
            </td>
            <td><input type="button" value="상품 옵션 추가" onclick="location.href='/cltsh/adm/opts/admOptsList.do'"/></td>
        </tr>
        <tr>
            <th><div>사용여부</div></th>            
            <td>
            	<select name="useYn">
            		<option value="Y">사용</option>
            		<option value="N">미사용</option>
            	</select>
            </td>
			<th><div>이미지</div></th>
            <td>
            	<input type="file" name="file1" onchange="previewImg(event);">
            	<input type="hidden" name="imgPath" id="imgPath" />
            	<input type="hidden" name="imgNm" id="imgNm" />
            </td>
        </tr>
        <tr>
            <th><div>상품소개</div></th>
            <td colspan="2">
            	<textarea rows="20" cols="70" name="goodsIntr"></textarea>
            </td>
            <td>
            	<div id="imgPreView"></div>
            </td>
        </tr>
    </table>
</div>
<div class="btn_area">
    <input type="button" value="목록" onclick="location.href='/cltsh/adm/goods/admGoodsList.do'"/>
    <input type="submit" value="등록" />
</div>
</form>
<script>
document.getElementById("catgryCd").addEventListener('change', ()=>{
	let catgryCd = document.querySelector('#catgryCd').value;
	fn_ajax({
		url: '/adm/cate/admCateListAjax.do?uprClassCd='+encodeURIComponent(catgryCd),
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
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>