<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <c:if test="${sessionScope.message ne ''}"> 아래와 같다--%>
<c:if test="${not empty sessionScope.message}">
	<script type="text/javascript">alert("${sessionScope.message}");</script>
	<%-- <c:out scope="session" var="message" value="메세지가 들어갑니다."/> jsp에서 메세지 추가하고 싶을 떄 사용 --%>
	<c:remove var="message" scope="session"/>
</c:if>
<c:if test="${not empty requestScope.message}">
	<script type="text/javascript">alert("${requestScope.message}");</script>
	<c:remove var="message" scope="session"/>
</c:if>

<header id="header">
	<div class="logo"><a href="/cltsh/main.do"><img src="/img/cltsh/logo_01.png" /></a></div>
</header>
<section id="section" class="section">
   <div class="input_area">
      <h1>로그인</h1>
      <div class="top">
      	 <form id="frm" action="/cltsh/user/userLoginAct.do" method="post">
         	<input type="text" name="usrId" placeholder="아이디 입력 "><br/>
         	<input type="password" name="passWd" placeholder="비밀번호 입력 "><br/>
         	<input type="submit" value="로그인"/>
         </form>
      </div>
      <div class="top_log">
         <pre> 아이디 찾기 |</pre>
         <pre> 비밀번호 찾기 |</pre>
         <pre><a href="/cltsh/user/userJoin.do"> 회원가입</a></pre>
      </div>
   </div>
</section>
