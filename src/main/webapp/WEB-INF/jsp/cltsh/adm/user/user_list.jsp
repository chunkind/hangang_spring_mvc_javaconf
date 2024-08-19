<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2>회원 관리</h2>
	<form name="frm" action="/cltsh/adm/user/admUserSearch.do" method="post">
	<div class="table-responsive">
		<h4>회원 검색</h4>
		<div>
			<table class="table table-striped table-hover">
				<colgroup>
					<col width="25%"/>
					<col width="25%"/>
					<col width="25%"/>
					<col width="25%"/>
				</colgroup>
				<tr>
					<th class="col">검색</th>
					<td colspan="3">
						<select name="searchType">
							<option value="">선택</option>
							<option value="idType">아이디</option>
							<option value="nameType">이름</option>
						</select>
						<input class="search" type="text" name="searchText" />
					</td>
				</tr>
				<tr>
					<th>회원등급</th>
					<td>
						<select name="searchGradeUpperType" id="searchGradeUpperType">
							<option value="grade">등급</option>
							<option value="user">회원</option>
							<option value="admin">관리자</option>
						</select>
					</td>
					<th>회원구분</th>
					<td>
						<select name="searchGradeUnderType" id="searchGradeUnderType">
						</select>
					</td>
				</tr>
				<tr>
					<th class="col">회원가입일</th>
					<td colspan="3"><input class="membership_date1" name="searchStartRgstDate" type="date"/><input class="membership_date2" type="date" name="searchEndRgstDate"/></td>
				</tr>
			</table>
		</div>
		<div>
			<div>전체 1명 / 검색 1명</div>
			<select id="user_sequence" name="user_sequence">
				<option value="">전체</option>
				<option value="num">번호 순</option>
				<option value="rgst">회원 가입 순</option>
			</select>
		</div>
	</div>
	<input type="submit" class="member_search_btn" value="검색">
	</form>
	
	<div class="table-responsive">
		<table class="table table-striped table-hover">
			<colgroup>
				<col width="3%"/>
				<col width="10%"/>
				<col width="17%"/>
				<col width="10%"/>
				<col width="10%"/>
				<col width="10%"/>
			</colgroup>
			<thead>
				<tr>
					<th class="text-center">선택</th>
					<th class="text-center">번호</th>
					<th class="text-center">아이디/닉네임</th>
					<th class="text-center">이름</th>
					<th class="text-center">등급</th>
					<th class="text-center">회원가입일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty list }">
					<tr><td colspan="10" class="text-center">데이터가 없습니다.</td></tr>
				</c:if>
				<c:forEach items="${list }" var="obj">
				<tr>
					<td class="text-center"><input type="checkbox"></td>
					<td class="text-center">${obj.usrBaseSeq}</td>
					<td class="text-center">${obj.usrId}</td>
					<td class="text-center"><a href="/cltsh/adm/user/admUserDetail.do?usrBaseSeq=${obj.usrBaseSeq}">${obj.usrNm}</a></td>
					<td class="text-center">관리자</td>
					<td class="text-center">${obj.rgstDate}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		${paging }
</div>
<script>
(function(){
	document.getElementById("searchGradeUpperType").addEventListener('change', makeRequest);
	function makeRequest() {
		httpRequest = new XMLHttpRequest();
		if(!httpRequest) {
			alert('XMLHTTP 인스턴스를 만들 수가 없어요 ㅠㅠ');
			return false;
		}
		let searchGradeUpperType = document.querySelector('#searchGradeUpperType').value;
		httpRequest.onreadystatechange = alertContents;
		httpRequest.open('POST', "/adm/code/admCodeListAjax.do");
		httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		httpRequest.send('searchGradeUpperType='+encodeURIComponent(searchGradeUpperType));
	}
	
	function alertContents() {
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if (httpRequest.status === 200) {
				var res = httpRequest.responseText;
				console.log('res:' + res);
				var rtnJson = JSON.parse(res);
				if(rtnJson.result == 'success'){
					let sel_searchGradeUnderType = document.querySelector('#searchGradeUnderType');
					let sel_searchGradeUnderType_options = document.querySelectorAll('#searchGradeUnderType option');
					for(let i=0; i<sel_searchGradeUnderType_options.length; i++){
						sel_searchGradeUnderType_options[i].remove();
					}
					//추가
					for(let i=0; i<rtnJson.dataList.length; i++){
						let objValue = rtnJson.dataList[i];
						let option = document.createElement('option');
						let codeNm = objValue['codeNm'];
						let codeVal = objValue['codeVal'];
						option.value = codeVal;
						option.innerHTML = codeNm;
						sel_searchGradeUnderType.append(option);
					}
				}else if(rtnJson.result == 'fail'){
					let sel_searchGradeUnderType = document.querySelector('#searchGradeUnderType');
					let sel_searchGradeUnderType_options = document.querySelectorAll('#searchGradeUnderType option');
					for(let i=0; i<sel_searchGradeUnderType_options.length; i++){
						sel_searchGradeUnderType_options[i].remove();
					}
					let option = document.createElement('option');
					option.value = '';
					option.innerHTML = '전체';
					sel_searchGradeUnderType.append(option);
				}else{
					alert("에러 발생.");
				}
			} else {
				alert('request에 뭔가 문제가 있어요.');
			}
		}
	}
})();

document.addEventListener("DOMContentLoaded", ()=>{
	let sel_user_sequence = document.querySelector("#user_sequence");
	sel_user_sequence.addEventListener('change', (e)=>{
		location.href = '/adm/user/admUserList.do?userSequence='+sel_user_sequence.value;
	});
});
</script>