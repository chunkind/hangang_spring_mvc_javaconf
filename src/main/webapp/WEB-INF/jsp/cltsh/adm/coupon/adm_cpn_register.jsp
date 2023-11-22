<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admHeader.jsp" %>
<h2>쿠폰 목록 > 쿠폰 추가</h2>
<form action="/cltsh/adm/cpn/admCpnRegisterAct.do" method="post" enctype="multipart/form-data">
<div class="data_list">
    <table>
    	<colgroup>
    		<col width="20%" />
    		<col width="30%" />
    		<col width="20%" />
    		<col width="30%" />
    	</colgroup>
    	<tr>
    		<th><div>쿠폰 이름</div></th>
            <td><input type="text" name="couName"></td>
            <th><div>쿠폰 할인율</div></th>
            <td><input type="number" name="couDiscount"></td>
        </tr>
        <tr>
    		<th><div>쿠폰 만료 날짜</div></th>
            <td><input type="Date" name="couEndDate"></td>
            <th><div>쿠폰 개수</div></th>
            <td><input type="number" name="couCount"></td>
        </tr>
    </table>
</div>
<div class="btn_area">
    <input type="button" value="목록" onclick="location.href='/cltsh/adm/cpn/admCpnList.do'"/>
    <input type="submit" value="추가" />
</div>
</form>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admFooter.jsp" %>