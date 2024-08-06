<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container mt-4">
	<div class="card">
		<div class="card-header bg-primary text-white">
			<h5 class="mb-0">1:1 문의 > 작성하기</h5>
		</div>
		<div class="card-body">
			<form name="frm" action="/cltsh/qna/qnaInsertAct.do" method="post">
				<div class="form-group row">
					<label for="titNm" class="col-sm-2 col-form-label">제목</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="titNm" name="titNm">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">비밀글</label>
					<div class="col-sm-10">
						<div class="form-check">
							<input class="form-check-input" type="radio" name="passYn"
								value="Y" id="passYnY"> <label class="form-check-label"
								for="passYnY"> 사용 </label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="passYn"
								value="N" id="passYnN" checked> <label
								class="form-check-label" for="passYnN"> 미사용 </label>
						</div>
					</div>
				</div>
				<div class="form-group row">
					<label for="qnaTp" class="col-sm-2 col-form-label">문의유형</label>
					<div class="col-sm-10">
						<select class="form-control" id="qnaTp" name="qnaTp">
							<option value="일반문의">일반문의</option>
							<option value="상품문의">상품문의</option>
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">답변 상태</label>
					<div class="col-sm-10">
						<div>답변미완료</div>
						<input type="hidden" name="ansrStat" value="답변미완료">
					</div>
				</div>
				<div class="form-group row cate" style="display: none;">
					<label for="oneDepthCateList" class="col-sm-2 col-form-label">상위
						카테고리</label>
					<div class="col-sm-10">
						<select class="form-control" id="oneDepthCateList"
							name="oneDepthCateList">
							<option value="">선택</option>
							<c:forEach items="${oneDepthCateList }" var="obj">
								<option value="${obj.catgryCd}">${obj.catgryNm}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group row cate" style="display: none;">
					<label for="twoDepthCateList" class="col-sm-2 col-form-label">하위
						카테고리</label>
					<div class="col-sm-10">
						<select class="form-control" id="twoDepthCateList"
							name="twoDepthCateList">
							<option value="">선택</option>
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label for="searchGoodsList" class="col-sm-2 col-form-label">상품</label>
					<div class="col-sm-8">
						<select class="form-control" id="searchGoodsList" name="goodsCd">
							<option value="0">선택</option>
						</select>
					</div>
					<div class="col-sm-2">
						<img id="goodsImg" class="img-fluid" />
					</div>
				</div>
				<div class="form-group row">
					<label for="cont" class="col-sm-2 col-form-label">내용</label>
					<div class="col-sm-10">
						<textarea class="form-control" id="cont" rows="10" name="cont"></textarea>
					</div>
				</div>
				<div class="text-right">
					<button type="submit" class="btn btn-primary">작성하기</button>
				</div>
			</form>
		</div>
	</div>
</div>

<script>
// 문의유형 변경 시 카테고리 표시 제어
document.addEventListener("DOMContentLoaded", () => {
    let sel_qnaTp = document.querySelector('#qnaTp');
    sel_qnaTp.addEventListener('change', (e) => {
        let selectedVal = e.target.value;
        let cateRows = document.querySelectorAll('.cate');
        
        if (selectedVal == '일반문의') {
            cateRows.forEach(row => row.style.display = 'none');
        } else {
            cateRows.forEach(row => row.style.display = 'table-row');
        }
    });
    // 초기 상태 설정
    let initial_qnaTp = document.querySelector('#qnaTp').value;
    if (initial_qnaTp == '일반문의') {
        document.querySelectorAll('.cate').forEach(row => row.style.display = 'none');
    } else {
        document.querySelectorAll('.cate').forEach(row => row.style.display = 'table-row');
    }
});

// 카테고리 및 상품 데이터 로딩
document.getElementById("oneDepthCateList").addEventListener('change', () => {
    let oneDepthCateList = document.querySelector('#oneDepthCateList').value;
    fn_ajax({
        url: '/dress/DressCateAjax.do?oneDepthCateList=' + encodeURIComponent(oneDepthCateList),
        method: 'get',
        success: function (data) {
            var rtnJson = data;
            if (rtnJson.result == 'success') {
                let sel_twoDepthCateList = document.querySelector('#twoDepthCateList');
                sel_twoDepthCateList.innerHTML = '<option value="">선택</option>'; // 초기화
                rtnJson.dataList.forEach(objValue => {
                    let option = document.createElement('option');
                    option.value = objValue['catgryCd'];
                    option.innerHTML = objValue['catgryNm'];
                    sel_twoDepthCateList.append(option);
                });
            } else {
                alert("에러 발생.");
            }
        }
    });
});

document.getElementById("twoDepthCateList").addEventListener('change', () => {
    let oneDepthCateList = document.querySelector('#oneDepthCateList').value;
    let twoDepthCateList = document.querySelector('#twoDepthCateList').value;
    fn_ajax({
        url: '/dress/DressCateAjax2.do?oneDepthCateList=' + encodeURIComponent(oneDepthCateList) + '&twoDepthCateList=' + encodeURIComponent(twoDepthCateList),
        method: 'get',
        success: function (data) {
            var rtnJson = data;
            if (rtnJson.result == 'success') {
                let sel_searchGoodsList = document.querySelector('#searchGoodsList');
                sel_searchGoodsList.innerHTML = '<option value="0">선택</option>'; // 초기화
                rtnJson.dataList.forEach(objValue => {
                    let option = document.createElement('option');
                    option.value = objValue['goodsCd'];
                    option.innerHTML = objValue['goodsNm'];
                    sel_searchGoodsList.append(option);
                });
            } else {
                alert("에러 발생.");
            }
        }
    });
});

document.getElementById("searchGoodsList").addEventListener('change', () => {
    let searchGoodsList = document.querySelector('#searchGoodsList').value;
    fn_ajax({
        url: '/dress/DressCateAjax3.do?searchGoodsList=' + encodeURIComponent(searchGoodsList),
        method: 'get',
        success: function (data) {
            var rtnJson = data;
            if (rtnJson.result == 'success') {
                let objValue = rtnJson.dataList[0];
                let imgPath = objValue['imgPath'];
                let imgNm = objValue['imgNm'];
                document.getElementById("goodsImg").src = imgPath + imgNm;
                document.getElementById("goodsImg").style.width = '120px';
                document.getElementById("goodsImg").style.height = '120px';
            } else {
                alert("에러 발생.");
            }
        }
    });
});
</script>
