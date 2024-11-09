<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.inicis.std.util.ParseUtil"%>
<%@ page import="com.inicis.std.util.SignatureUtil"%>
<%@ page import="com.inicis.std.util.HttpUtil"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <title>KG이니시스 결제샘플</title>

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  
  
  <script language="javascript" type="text/javascript" src="https://stdpay.inicis.com/stdjs/INIStdPay.js" charset="UTF-8"></script>
  <script type="text/javascript">
    function paybtn() {
      INIStdPay.pay('SendPayForm_id');
    }
  </script>
</head>

<body class="wrap">
  <div class="container mt-5">
    <!-- 페이지 타이틀 -->
    <section class="mb-4">
      <div class="text-center">
        <h2>일반결제</h2>
        <p class="lead">KG이니시스 결제창을 호출하여 다양한 지불수단으로 안전한 결제를 제공하는 서비스</p>
      </div>
    </section>

    <!-- 결제 정보 -->
    <section class="card shadow-sm mb-4">
      <div class="card-header">
        <h3 class="card-title">PC 일반결제</h3>
      </div>

      <div class="card-body">
        <!-- 유의사항 -->
        <div class="alert alert-warning">
          <h4>※ 유의사항</h4>
          <ul>
            <li>테스트MID 결제시 실 승인되며, 당일 자정(24:00) 이전에 자동으로 취소처리 됩니다.</li>
            <li>가상계좌 채번 후 입금할 경우 자동환불되지 않사오니, 가맹점관리자 내 "입금통보테스트" 메뉴를 이용부탁드립니다.</li>
            <li>국민카드 정책상 테스트 결제가 불가하여 오류가 발생될 수 있습니다. 국민, 카카오뱅크 외 다른 카드로 테스트결제 부탁드립니다.</li>
          </ul>
        </div>

        <!-- 결제 결과 표시 -->
        <form name="" id="result" method="post">
          <div class="row g-3">
            <div class="col-12">
              <p><strong>결과 코드:</strong> ${resultMap.resultCode}</p>
              <p><strong>결과 메시지:</strong> ${resultMap.resultMsg}</p>
              <p><strong>거래 ID(TID):</strong> ${resultMap.tid}</p>
              <p><strong>주문 ID(MOID):</strong> ${resultMap.MOID}</p>
              <p><strong>총 결제 금액:</strong> ${resultMap.TotPrice}</p>
              <p><strong>상품명:</strong> ${resultMap.goodName}</p>
              <p><strong>승인 일자:</strong> ${resultMap.applDate}</p>
              <p><strong>승인 시간:</strong> ${resultMap.applTime}</p>
            </div>
          </div>
        </form>

        <!-- 돌아가기 버튼 -->
        <div class="text-center mt-4">
          <a href="/cltsh/main.do" class="btn btn-primary btn-lg">돌아가기</a>
        </div>
      </div>
    </section>
  </div>

  <!-- Bootstrap JS 및 의존성 JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pzjw8f+ua7Kw1TIq0hJQyofN04jrDGRg0IO2z2zm2XTRkQf0FE8vbO9gZd4bgZ9A" crossorigin="anonymous"></script>
</body>

</html>
