<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<h2>상품 판매 게시글 관리 > 상품 판매 게시글 관리 리스트 > 상품 판매 게시글 등록</h2>
<form action="/cltsh/adm/sales/admSalesRegisterAct.do" method="post" enctype="multipart/form-data">
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
                <select id="entrNo" name="entrNo">
                    <c:forEach items="${entrList}" var="obj">
                        <option value="${obj.entrNo}" <c:if test="${searchEntrNo eq obj.entrNo}">selected</c:if> >${obj.entrNm}(${obj.entrNo})</option>
                    </c:forEach>
                </select>
    		</td>
    		<th><div>판매상품</div></th>
    		<td>
                <select id="goodsCd" name="goodsCd">
                    <c:forEach items="${goodsList}" var="obj">
                        <option value="${obj.goodsCd}">${obj.goodsNm}(${obj.goodsCd})</option>
                    </c:forEach>
                </select>
    		</td>
    	</tr>
        <tr>
    		<th><div>판매상태</div></th>
            <td>
                <select name="saleStatCd">
                	<c:forEach items="${saleCodeList}" var="obj">
                        <option value="${obj.codeVal}">${obj.codeNm}</option>
                    </c:forEach>
                </select>
            </td>
            <th><div>게시글제목</div></th>
            <td><input type="text" name="bulTitNm"></td>
        </tr>
        <tr>
            <th><div>게시시작일자</div></th>
            <td>
                <input type="date" name="bulStrtDt">
            </td>
            <th><div>게시종료일자</div></th>
            <td>
                <input type="date" name="bulEndDt">
            </td>
        </tr>
        <tr>
            <th><div>게시여부</div></th>
            <td>
            	<label>Y<input type="radio" name="bulYn" value="Y" checked="checked"></label>
            	<label>N<input type="radio" name="bulYn" value="N"></label>
            </td>
            <th><div>공지구분코드</div></th>
            <td>
                <select name="ntcSctCd">
                    <option value="01">일반</option>
                </select>
            </td>
        </tr>
        <tr>
            <th><div>상품가격</div></th>
            <td>
                <input type="number" name="goodsPrc">
            </td>
            <th><div>할인가격</div></th>
            <td>
                <input type="number" name="goodsSalePrc">
            </td>
        </tr>
        <tr>
            <th><div>배송방법</div></th>
            <td>
                <select name="prclWay">
                    <option value="01">일반</option>
                </select>
            </td>
            <th><div>판매수량</div></th>
            <td>
                <input type="number" name="saleCnt">
            </td>
        </tr>
        <tr>
            <th><div>내용</div></th>
            <td colspan="3">
                <textarea name="bulCont" rows="30" cols="80"></textarea>
            </td>
        </tr>
    </table>
</div>
<div class="btn_area">
    <input type="button" value="목록" onclick="location.href='/cltsh/adm/sales/admSalesList.do'"/>
    <input type="submit" value="등록" />
</div>
</form>
<script>
(function(){
	document.getElementById("entrNo").addEventListener('change', makeRequest);
	function makeRequest() {
		httpRequest = new XMLHttpRequest();
		if(!httpRequest) {
			alert('XMLHTTP 인스턴스를 만들 수가 없어요 ㅠㅠ');
			return false;
		}
		let entrNo = document.querySelector('#entrNo').value;
		httpRequest.onreadystatechange = alertContents;
		httpRequest.open('POST', "/cltsh/adm/goods/admGoodsListAjax.do");
		httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		/* httpRequest.setRequestHeader('Content-Type', 'application/json'); */
		httpRequest.send('searchEntrNo='+encodeURIComponent(entrNo));
	}
	
	function alertContents() {
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if (httpRequest.status === 200) {
				var res = httpRequest.responseText;
				console.log('res:' + res);
				var rtnJson = JSON.parse(res);
				if(rtnJson.result == 'success'){
					let sel_goodsCd = document.querySelector('#goodsCd');
					let sel_goodsCd_options = document.querySelectorAll('#goodsCd option');
					for(let i=0; i<sel_goodsCd_options.length; i++){
						sel_goodsCd_options[i].remove();
					}
					//추가
					for(let i=0; i<rtnJson.dataList.length; i++){
						let objValue = rtnJson.dataList[i];
						let option = document.createElement('option');
						let goodsCd = objValue['goodsCd'];
						let goodsNm = objValue['goodsNm'];
						option.value = goodsCd;
						option.innerHTML = goodsNm + '(' + goodsCd + ')';
						sel_goodsCd.append(option);
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
</script>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>