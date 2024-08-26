<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-4">
	<h2 class="text-center mb-5">쿠폰 목록 > 쿠폰 추가</h2>
	<form action="/cltsh/adm/cpn/admCpnRegisterAct.do" method="post" enctype="multipart/form-data">
		<div class="row mb-3">
			<div class="col-md-3">
				<label for="couName" class="form-label">쿠폰 이름</label>
				<input type="text" id="couName" name="couName" class="form-control" maxlength="20">
			</div>
			<div class="col-md-3">
				<label for="couDiscount" class="form-label">쿠폰 할인율</label>
				<input type="number" id="couDiscount" name="couDiscount" class="form-control" maxlength="20">
			</div>
			<div class="col-md-3">
				<label for="couEndDate" class="form-label">쿠폰 만료 날짜</label>
				<input type="Date" id="couEndDate" name="couEndDate" class="form-control" maxlength="20">
			</div>
			<div class="col-md-3">
				<label for="couCount" class="form-label">쿠폰 개수</label>
				<input type="number" id="couCount" name="couCount" class="form-control" maxlength="20">
			</div>
		</div>
		
		<div class="text-center mt-4">
			<button type="button" class="btn btn-light me-2" onclick="location.href='/cltsh/adm/cpn/admCpnList.do'">목록</button>
			<button type="submit" class="btn btn-light">추가</button>
		</div>
	</form>
</div>