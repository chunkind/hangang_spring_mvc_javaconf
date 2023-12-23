<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
  body {
    margin: 0;
    padding: 0;
    background-color: #f5f6f7;
  }

  .wrap {
    width: 490px;
    margin: auto;
    padding: 40px 20px 20px 20px;
    background-color: #ffffff;
    border-radius: 30px;
    box-sizing: border-box;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    position: absolute;
    top: 50%;
    transform: translateY(50%);
    left: 50%;
    transform: translate(-50%, -50%);
  }

  .title {
    width: 240px;
    height: 44px;
    text-align: center;
    font-size: 25px;
    margin: 0 auto;
    background-repeat: no-repeat;
    background-position: 0 0;
    background-size: 240px auto;
    margin-bottom: 20px;
  }

  .kakao {
    margin-top: 15px;
    height: 40px;
    border: solid 1px #FEE500;
    background: #FEE500;
    color: #3c1d1e;
    font-size: 18px;
    box-sizing: border-box;
    border-radius: 5px;
    cursor: pointer;
    width: 330px;
    display: flex;
    margin: 0 auto;
  }

  .kakao_i {
    background: url(resources/icons/kakao.png) no-repeat;
    width: 40px;
    height: 100%;
    background-size: 90%;
    background-position: 50%;
    margin: 0 20px;
  }

  .kakao_txt {
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 16px;
    padding-right: 60px;
  }

  a {
    text-decoration: none;
  }

  header {
    text-align: center;
    padding: 20px 0;
  }

  header img {
    max-width: 100%;
    height: auto;
  }

  #section {
    text-align: center;
    margin-top: 30px;
  }

  .input_area {
    display: inline-block;
    text-align: left;
  }

  h1 {
    font-size: 24px;
    margin-bottom: 20px;
  }

  form {
    margin-bottom: 20px;
  }

  input {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    box-sizing: border-box;
  }

  .top_log {
    display: flex;
    justify-content: space-between;
    margin-top: 10px;
  }
</style>

<c:if test="${not empty sessionScope.message}">
  <script type="text/javascript">
    alert("${sessionScope.message}");
  </script>
  <c:remove var="message" scope="session" />
</c:if>
<c:if test="${not empty requestScope.message}">
  <script type="text/javascript">
    alert("${requestScope.message}");
  </script>
  <c:remove var="message" scope="session" />
</c:if>

<header id="header">
  <div class="logo">
    <a href="/cltsh/main.do"><img src="/img/cltsh/logo_01.png" /></a>
  </div>
</header>

<section id="section" class="section">
  <div class="wrap">
    <div class="input_area">
      <h1>로그인</h1>
      <div class="top">
        <form id="frm" action="/cltsh/user/userLoginAct.do" method="post">
          <input type="text" name="usrId" placeholder="아이디 입력 "><br />
          <input type="password" name="passWd" placeholder="비밀번호 입력 "><br />
          <input type="submit" value="로그인" />
        </form>
      </div>
      <div class="top_log">
        <pre> 아이디 찾기 |</pre>
        <pre> 비밀번호 찾기 |</pre>
        <pre><a href="/cltsh/user/userJoin.do"> 회원가입</a></pre>
      </div>
      <a class="kakao"
        href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=dcf3a1fafb07e171bfe0d06c72d2a2d3&redirect_uri=http://localhost:9999/cltsh/user/kakaoLogin.do">
        <div class="kakao_i"></div>
        <div class="kakao_txt">카카오톡으로 간편로그인</div>
      </a>
    </div>
  </div>
</section>
