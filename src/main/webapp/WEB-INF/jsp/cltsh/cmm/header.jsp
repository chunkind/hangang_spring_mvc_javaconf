<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header data-bs-theme="light">
	<nav class="navbar navbar-expand-md navbar-light fixed-top bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="/"><img src="/img/cltsh/logo_01.png"/></a>
			<div>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>
</header>

<script>
function fn_user_edit(usrBaseSeq){
	const form = document.createElement('form');
	form.method = 'post';
	form.action = '/cltsh/user/userEdit.do';

	const hiddenField = document.createElement('input');
	hiddenField.type = 'hidden';
	hiddenField.name = 'usrBaseSeq';
	hiddenField.value = usrBaseSeq;
	
	form.appendChild(hiddenField);
	
	document.body.appendChild(form);
	
	form.submit();
}
</script>