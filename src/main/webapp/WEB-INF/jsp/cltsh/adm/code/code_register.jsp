<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<style>
	.title_area, .item_list_area{
		text-align: left;
	}
</style>
<section class="title_area">
	<h3 class="title">공통코드 관리 > 등록</h3>
</section>
<section class="item_list_area">
<form name="frm" action="/cltsh/adm/code/admCodeRegisterAct.do" method="post">
	<table>
		<colgroup>
			<col width="10%" />
			<col width="40%" />
			<col width="10%" />
			<col width="40%" />
		</colgroup>
		<tr>
			<th>코드 이름</th>
			<td>
				<input type="text" name="codeNm"  value="">
			</td>
			<th>코드 값</th>
			<td>
				<input type="text" name="codeVal"  value="">
			</td>
		</tr>
		<tr>
			<th>코드 순번</th>
			<td><input type="number" name="grpOrdr" value=""></td>
			<th>코드 그룹</th>
			<td><input type="text" name="grpCd" value=""></td>
		</tr>
		<tr>
			<th>사용 여부</th>
			<td colspan="3">
				<select name="useYn">
					<option value="Y">사용</option>
					<option value="N">미사용</option>
				</select>
			</td>
		</tr>
		<tr>
			<th colspan="4">설명</th>
		</tr>
		<tr>
			<td colspan="4">
				<textarea rows="20" cols="50" name="codeDesc"></textarea>
			</td>
		</tr>
	</table>
	<div class="btn_area">
		<input type="submit" value="등록하기" />
	</div>
</form>
</section>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>