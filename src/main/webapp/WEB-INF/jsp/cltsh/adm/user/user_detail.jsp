<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cltsh/cmm/admHeader.jsp" %>
<h2>회원 관리</h2>
<div class="data_list">
	<table>
		<colgroup>
			<col width="20%" />
			<col width="30%" />
			<col width="20%" />
			<col width="30%" />
		</colgroup>
		<tr>
			<th><div>회원 번호</div></th>
			<td>${pvo.usrBaseSeq}</td>
			<th><div>아이디</div></th>
			<td>${pvo.usrId}</td>
		</tr>
		<tr>
			<th><div>이름</div></th>
			<td>${pvo.usrNm}</td>
			<th><div>생년월일</div></th>
			<td>${pvo.usrBirth}</td>
		</tr>
		<tr>
			<th><div>이메일</div></th>
			<td>${pvo.emailAddr}</td>
			<th><div>핸드폰 번호</div></th>
			<td>${pvo.cellNo}</td>
		</tr>
		<tr>
			<th><div>도로명 주소</div></th>
			<td>${pvo.loadAddrBase}</td>
			<th><div>상세주소</div></th>
			<td>${pvo.loadAddrDtl}</td>
		</tr>
		<tr>
			<th><div>우편번호</div></th>
			<td>${pvo.loadPostNo}</td>
			<th><div>회원가입일</div></th>
			<td>${pvo.rgstDate}</td>
		</tr>
		<tr>
			<th><div>정지 여부</div></th>
			<td>${pvo.lockYn}</td>
			<th><div>사용 여부</div></th>
			<td>${pvo.useYn}</td>
		</tr>
	</table>
</div>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>