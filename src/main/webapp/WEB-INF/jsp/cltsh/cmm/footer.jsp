<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar fixed-bottom navbar-expand-sm navbar-dark bg-dark">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="/cltsh/main/mainDrssList.do">리뷰</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/cltsh/main/mainQnaList.do">1:1 문의</a>
        </li>
        <li class="nav-item dropup">
          <a class="nav-link dropdown-toggle" href="/cltsh/main/mainCataList.do" data-bs-toggle="dropdown" aria-expanded="false">카테고리</a>
          <ul class="dropdown-menu">
          	<li><a class="dropdown-item" href="/cltsh/main/mainCataList.do?searchType=all">전체</a></li>
			<c:forEach items="${oneDepthCateList}" var="obj">
				<li><a class="dropdown-item" href="/cltsh/main/mainCataList.do?searchCatgryCd=${obj.catgryCd}">${obj.catgryNm}</a></li>
			</c:forEach>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
<!-- FOOTER -->
<footer class="container">
  <p class="float-end"><a href="#">Back to top</a></p>
  <p>&copy; 2017–2023 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
</footer>