<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<h2>상품 관리 > 상품 문의 관리</h2>
<div class="src_area">
    <h3>상품검색</h3>
	<div>
		<table>
			<colgroup>
				<col width="10%"></col>
				<col width="90%"></col>
			</colgroup>
			<tr>
				<th>검색조건</th>
				<td>
					<div>
						<select>
					        <option>전체</option>
					        <option>상품명</option>
					        <option>제목</option>
					        <option>작성자</option>
					    </select>
					    <input type="text" placeholder="search">
					</div>
				</td>
			</tr>
		</table>
	</div>
	<div>
	    <select>
	        <option>등록일순</option>
	        <option>이름순</option>
	    </select>
	</div>
</div>
<div class="data_list">
    <table>
        <thead>
            <tr>
                <th>전체선택</th><th>상품명</th><th>제목</th><th>작성자</th><th>등록일</th><th>답변상태</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><input type="checkbox" id="cb"></td><td>상품1</td><td>테스트1</td><td>1</td><td>2021-12-28</td>
                <td><button><a href="/cltsh/html/admin/product_postscript/product_postscript_answer.html">답변</a></button></td>
            </tr>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>