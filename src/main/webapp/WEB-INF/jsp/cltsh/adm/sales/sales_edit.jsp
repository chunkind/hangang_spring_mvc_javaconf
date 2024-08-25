<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2 class="text-center mb-5">상품 판매 게시글 관리 > 상품 판매 게시글 관리 상세</h2>
	<form action="/cltsh/adm/sales/admSalesUpdateAct.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="saleBoardSeq" value="${detail.saleBoardSeq}">
		
		<div class="row mb-3">
			<div class="col-md-4">
				<div class="form-group">
					<label for="entrNo" class="form-label">판매처</label>
					<select id="entrNo" name="entrNo" class="form-select">
						<c:forEach items="${entrList}" var="obj">
							<option value="${obj.entrNo}"
							<c:if test="${obj.entrNo eq detail.entrNo}">selected</c:if>>${obj.entrNm}(${obj.entrNo})</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label for="goodsCd" class="form-label">판매상품</label>
					<select id="goodsCd" name="goodsCd" class="form-select">
						<c:forEach items="${goodsList}" var="obj">
							<option value="${obj.goodsCd}" <c:if test="${obj.goodsCd eq detail.goodsCd}">selected</c:if>>${obj.goodsNm}(${obj.goodsCd})</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label for="saleStatCd" class="form-label">판매상태</label>
					<select id="saleStatCd" name="saleStatCd" class="form-select">
						<c:forEach items="${saleCodeList}" var="obj">
							<option value="${obj.codeVal}" <c:if test="${obj.codeVal eq detail.saleStatCd}">selected</c:if>>${obj.codeNm}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
			
		<div class="row mb-3">
			<div class="col-md-4">
				<div class="form-group">
					<label for="bulTitNm" class="form-label">게시글제목</label>
					<input type="text" id="bulTitNm" name="bulTitNm" class="form-control" value="${detail.bulTitNm}" maxlength="20">
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label for="bulStrtDt" class="form-label">게시시작일자</label>
					<input type="date" id="bulStrtDt" name="bulStrtDt" class="form-control" value="${detail.bulStrtDt}" maxlength="20">
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label for="bulEndDt" class="form-label">게시종료일자</label>
					<input type="date" id="bulEndDt" name="bulEndDt" class="form-control" value="${detail.bulEndDt}" maxlength="20">
				</div>
			</div>
		</div>
		
		<div class="row mb-3">
			<div class="col-md-4">
				<div class="form-group">
					<label for="bulYn" class="form-label">게시여부</label>
					<label>Y <input type="radio" id="bulYn" name="bulYn" value="Y" <c:if test="${'Y' eq detail.bulYn}">checked</c:if>></label>
					<label>N <input type="radio" id="bulYn" name="bulYn" value="N" <c:if test="${'N' eq detail.bulYn}">checked</c:if>></label>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label for="ntcSctCd" class="form-label">공지구분코드</label>
					<select name="ntcSctCd" class="form-select">
						<option value="01">일반</option>
					</select>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label for="goodsPrc" class="form-label">상품가격</label>
					<input type="number" id="goodsPrc" name="goodsPrc" class="form-control" value="${detail.goodsPrc}" maxlength="20">
				</div>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-md-4">
				<div class="form-group">
					<label for="goodsSalePrc" class="form-label">할인가격</label>
					<input type="number" id="goodsSalePrc" name="goodsSalePrc" class="form-control" value="${detail.goodsSalePrc}" maxlength="20">
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label for="prclWay" class="form-label">배송방법</label>
					<select id="prclWay" name="prclWay" class="form-select">
						<option value="01">일반</option>
					</select>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label for="saleCnt" class="form-label">판매수량</label>
					<input type="number" id="saleCnt"name="saleCnt" class="form-control" value="${detail.saleCnt}" maxlength="20">
				</div>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-md-4">
				<div class="form-group">
					<label for="bulCont" class="form-label">내용</label>
					<textarea id="bulCont" name="bulCont" rows="30" cols="80">${detail.bulCont}</textarea>
				</div>
			</div>
		</div>
		
		<div class="text-center mt-4">
			<button type="button" class="btn btn-light me-2" onclick="location.href='/cltsh/adm/sales/admSalesList.do'">목록</button>
			<button type="submit" class="btn btn-light me-2">수정</button>
			<button type="button" class="btn btn-danger" onclick="location.href='/cltsh/adm/sales/admSalesRemoveAct.do?saleBoardSeq='+'${detail.saleBoardSeq}'">삭제</button>
		</div>
	</form>
</div>


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
		httpRequest.open('POST', "DispatcherServlet?command=adm_goods_list_ajax");
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