<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<h2>이벤트 배너 관리</h2>
<div class="src_area">
	<!-- <h4>이벤트 검색</h4>
	<div>
		<table>
			<colgroup>
				<col width="20%"/>
				<col width="80%"/>
			</colgroup>
			<tr>
				<th>
					
				</th>
				<td></td>
			</tr>
		</table>
	</div> -->
</div>

<div>
    선택한 항목을 <button>X삭제</button>
</div>
<button id="go" class="btn_prod">등록</button>

<div class="data_list">
	<table>
		<colgroup>
			<col width="">
			<col width="">
			<col width="">
			<col width="">
			<col width="">
			<col width="">
		</colgroup>
		<thead>
			<tr>
				<th><input type="checkbox"></th>
				<th>번호</th>
				<th>제목</th>
				<th>상태</th>
				<th>기간</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
			<tr>
	            <td colspan="6">배너 내역이 없습니다.</td>
	        </tr>
		</tbody>
	</table>
</div>

<div id="popup" style="display: none;">
    <h3>이벤트 배너 등록</h3>
    <div id="popup-text">
        <table>
            <tr>
                <th>제목</th>
                <td><input type="text"></td>
            </tr>
            <tr>
                <th>기간 설정</th>
                <td><input type="date"> ~ <input type="date"></td>
            </tr>
            <tr>
                <th>진행 여부</th>
                <td><input type="radio">대기<input type="radio">진행<input type="radio">종료</td>
            </tr>
        </table>
    </div>
    <div id="popup-text">
        <table>
            <tr>
                <th>이미지 설정</th>
                <th>순서</th>
                <th>편집</th>
                <th>이미지 등록</th>
                <th>URL</th>
            </tr>
            <tr>
                <td></td>
                <td>1</td>
                <td>↑ ↓</td>
                <td><input type="file"></td>
                <td><input type="url"></td>
            </tr>
        </table>
    </div>
    <button id="exit" class="join_btn">등록</button>
</div>
<script>
    const go = document.querySelector("#go");
    const bg = document.querySelector("#bg");
    const popup = document.querySelector("#popup");
    const exit = document.querySelector("#exit");

    go.addEventListener("click",function(){
        bg.classList.remove("hidden");
        popup.classList.remove("hidden");
    });
    exit.addEventListener("click",function(){
        bg.classList.add("hidden");
        popup.classList.add("hidden");
    });
</script>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>