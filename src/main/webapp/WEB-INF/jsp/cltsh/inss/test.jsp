

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Web manual</title>
    <link rel="stylesheet" type="text/css"
        href="https://ds-cdn.inicis.com/static/font/pretendard/pretendard-subset.css">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/fullpage.min.css">
    <script src="https://ds-cdn.inicis.com/static/js/jquery-2.2.4.min.js"></script>
    <script src="../../js/fullpage.min.js"></script>
	<script src="../../js/main.js"></script>
    <script>
        $(function(){ // layouts 불러오기
    		$("#footer").load("../../layouts/footer_demo.html")
		});
    </script>
	<script language="javascript" type="text/javascript" src="https://stdpay.inicis.com/stdjs/INIStdPay.js" charset="UTF-8"></script>
    <script type="text/javascript">
        function paybtn() {
            INIStdPay.pay('SendPayForm_id');
        }
    </script>
		
	<!-- 파비콘 220916-->
    <link rel="shortcut icon" href="../../img/favicon/favicon.ico">
    <link rel="apple-touch-icon" sizes="180x180" href="../../img/favicon/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192" href="../../img/favicon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="../../img/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="../../img/favicon/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="../../img/favicon/favicon-16x16.png">
    <!-- //파비콘 220916 -->
</head>

<!--PC(웹표준) 일반결제-->
<body>
    <div class="wrap">
        <div style="height:60px;"></div>
		
		<div id="add-option"></div>
		
		<!-- Top버튼, 플로팅 메뉴 -->
        <a href=" #top" class="btn_top">
            <span class="d-none">상단으로 이동</span>
        </a>
        <div class="card_float">
            <ul>
                <li><a href="../notice.html"><img src="../../img/ic_noti.png" alt=""><span>공지사항</span></a></li>
                <li><a href="https://github.com/kginicis-ts" target="_blank"><img src="../../img/ic_comm.png" alt=""><span>커뮤니티</span></a></li>
                <li><a href="../code.html"><img src="../../img/ic_code.png" alt=""><span>통합코드</span></a></li>
                <li><a href="../sample.html"><img src="../../img/ic_down.png" alt=""><span>샘플다운로드</span></a></li>
            </ul>
        </div>
        <!-- //Top버튼, 플로팅 메뉴 -->

        <!-- 반응형 PC버전 메뉴 -->

        <!-- GNB 220916 -->
        <div class="gnb wt pc">
            <header class="d-flex justify-content-center">
                <a href="../../">
                    <h1 class="h_logo"><img src="../../img/logo_inicis_c.png" alt="KG이니시스">
                    </h1>
                </a>
                <nav class="h_menu">
                    <ul>
                        <li><a href="../stdpay_pc.html">일반결제</a>
                            <!--ul class="gnb_sub" style="display: none;">
                                <li>
                                    <ol class="gnb_submenu">
                                        <li><a href="#">PC</a></li>
                                        <li><a href="#">모바일</a></li>
                                    </ol>
                                </li>
                            </ul-->
                        </li>
                        <li><a href="../bill_pc.html">빌링(정기과금)</a>
                            <ul class="gnb_sub" style="display: none">
                                <li>
                                    <ol class="gnb_submenu">
                                        <li><a href="../bill_pc.html">빌링키발급</a></li>
                                        <li><a href="../bill_pc.html#appl">빌링승인</a></li>
                                    </ol>
                                </li>
                            </ul>
                        </li>
                        <li><a href="../escrow_pc.html">에스크로</a>
                            <ul class="gnb_sub" style="display: none">
                                <li>
                                    <!--a href="escrow_pc">
                                        <h5>에스크로결제</h5>
                                    </a-->
                                    <ol class="gnb_submenu">
                                        <li><a href="../escrow_pc.html">에스크로결제</a></li>
                                        <li><a href="../escrow_pc.html#dlv">배송등록</a></li>
                                        <li><a href="../escrow_pc.html#conf">구매결정</a></li>
										<li><a href="../escrow_pc.html#dncf">구매거절확인</a></li>
										<li><a href="../etc-noti.html#es">상태변경노티</a></li>
                                    </ol>
                                </li>
                            </ul>
                        </li>
                        <li style="width: 92px;"><a href="../cancel.html">취소/환불</a>
                            <ul class="gnb_sub" style="display: none">
                                <li>
									<ol class="gnb_submenu">
                                        <li><a href="../cancel.html">일반취소</a></li>
                                        <li><a href="../cancel.html#vbank">가상계좌 환불</a></li>
                                        <li><a href="../cancel.html#hpp">휴대폰 익월환불</a></li>
                                    </ol>
                                </li>
                            </ul>
                        </li>
                        <li><a href="../etc-noti.html">기타서비스</a>
                            <ul class="gnb_sub" style="display: none">
                                <li>
                                    <ol class="gnb_submenu">
                                        <li><a href="../etc-noti.html">노티서비스</a></li>
                                        <li><a href="../etc-formpay.php">폼 페이</a></li>
                                        <li><a href="../etc-receipt.html">현금영수증</a></li>
                                        <li><a href="../etc-capture.html">수동매입</a></li>
                                        <li><a href="../etc-inquiry.html">거래조회</a></li>
                                        <li><a href="../etc-point.html">포인트</a></li>
                                    </ol>
                                </li>
                            </ul>
                        </li>
                        <li class="sel"><a href="../demo/">결제데모</a>
                            <ul class="gnb_sub" style="display: none">
                                <li>
                                    <ol class="gnb_submenu">
                                        <li><a href="../demo/pcDemo.php">일반결제</a></li>
                                        <li><a href="../demo/pcDemo_bill.php">빌링(정기과금)</a></li>
                                        <li><a href="../demo/pcDemo_escrow.php">에스크로결제</a></li>
                                        <li><a href="../demo/cancelDemo.php">취소/환불</a></li>
                                        <li><a href="../demo/hash.html">데이터암호화</a></li>
                                    </ol>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <div class="gnb_right">
                        <div class="btn_r me-4"><a href="../sitemap.html">사이트맵</a></div>
                        <div class="btn_solid"><a href="../qna.html">Q &#38; A</a></div>
                    </div>
                </nav>
            </header>
        </div>
        <!-- //GNB 220916 -->

        <!-- 반응형 모바일버전 메뉴 -->

        <!-- GNB -->
        <div class="gnb wt mobile">
            <header class="d-flex justify-content-center">
                <a href="../../">
                    <h1 class="h_logo"><img src="../../img/logo_inicis_c.png" alt="KG이니시스">
                        
                    </h1>
                </a>
                <!-- 모바일 메뉴 -->
                <button><img src="../../img/ic_menu.png" alt="메뉴버튼" class="h_btn_menu"></button>
                <!-- //모바일 메뉴 -->
				<div class="menu_drawer" style="display:none;">
                    <nav class="h_menu">
                        <ul>
                            <li><a href="../stdpay_pc.html">일반결제</a>
                                <div class="lnb_menu">
                                    <ul>
                                        <li class="menu_m"><a href="../stdpay_pc.html">PC</a></li>
                                        <li class="menu_m"><a href="../stdpay_m.html">모바일</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li><a href="../bill_pc.html">빌링(정기과금)</a>
                                <div class="lnb_menu">
                                    <ul>
                                        <li class="menu_m"><a href="../bill_pc.html">PC</a></li>
                                        <li class="menu_m"><a href="../bill_m.html">모바일</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li><a href="../escrow_pc.html">에스크로</a>
                                <div class="lnb_menu">
                                    <ul>
                                        <li class="menu_m"><a href="../escrow_pc.html">PC</a></li>
                                        <li class="menu_m"><a href="../escrow_m.html">모바일</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li><a href="../cancel.html">취소/환불</a>
							    <div class="lnb_menu">
                                    <ul>
                                        <li class="menu_m"><a href="../cancel.html">일반취소</a></li>
                                        <li class="menu_m"><a href="../cancel.html#vbank">가상계좌환불</a></li>
										<li class="menu_m"><a href="../cancel.html#hpp">휴대폰익월환불</a></li>
                                    </ul>
                                </div>
							</li>
                            <li><a href="../etc-noti.html">기타서비스</a>
							    <div class="lnb_menu">
                                    <ul>
                                        <li class="menu_m"><a href="../etc-noti.html">노티서비스</a></li>
                                        <li class="menu_m"><a href="../etc-formpay.php">폼 페이</a></li>
										<li class="menu_m"><a href="../etc-receipt.html">현금영수증</a></li>
										<li class="menu_m"><a href="../etc-capture.html">수동매입</a></li>
										<li class="menu_m"><a href="../etc-inquiry.html">거래조회</a></li>
										<li class="menu_m"><a href="../etc-point.html">포인트</a></li>
                                    </ul>
                                </div>
							</li>
							<li><a href="../demo/moDemo.php">결제데모</a>
							    <div class="lnb_menu">
                                    <ul>
                                        <li class="menu_m"><a href="../demo/moDemo.php">일반결제</a></li>
                                        <li class="menu_m"><a href="../demo/moDemo_bill.php">빌링(정기과금)</a></li>
										<li class="menu_m"><a href="../demo/moDemo_escrow.php">에스크로결제</a></li>
										<li class="menu_m"><a href="../demo/cancelDemo.php">취소/환불</a></li>
										<li class="menu_m"><a href="../demo/hash.html">데이터암호화</a></li>
                                    </ul>
                                </div>
							</li>
                            <li><a href="../qna.html">Q & A</a></li>
                        </ul>
                    </nav>
				</div>
            </header>
        </div>
        <!-- //GNB -->

        <!-- //반응형 모바일버전 메뉴 -->

        <!-- LNB -->
        <aside class="pc">
            <h2>결제데모</h2>
            <div class="tab">
                <div class="lnb_menu no_tab">
				    <h3 class="menu_tit"><a href="pcDemo.php" class="sel">일반결제</a></h3>
                    <ul>
                        <li class="menu"><a href="pcDemo.php" class="sel">PC</a></li>
                        <li class=""><a href="moDemo.php">Mobile</a></li>
                    </ul>
					<h3 class="menu_tit"><a href="pcDemo_bill.php">빌링(정기과금)</a></h3>
					<h3 class="menu_tit"><a href="pcDemo_escrow.php">에스크로결제</a></h3>
					<h3 class="menu_tit"><a href="cancelDemo.php">취소/환불</a></h3>
					<h3 class="menu_tit"><a href="hash.html">데이터암호화</a></h3>
                </div>
            </div>
        </aside>
        <!-- //LNB -->

        <!-- //반응형 PC버전 메뉴 -->


        <!-- 본문 -->
        <main class="col-8 cont" id="bill-01">
            <!-- 페이지타이틀 -->
            <section class="mb-5">
                <div class="tit">
                    <h2>일반결제</h2>
                    <p>KG이니시스 결제창을 호출하여 다양한 지불수단으로 안전한 결제를 제공하는 서비스</p>
                </div>
            </section>
            <!-- //페이지타이틀 -->


            <!-- 카드CONTENTS -->
            <section class="menu_cont mb-5">
                <div class="card">
                    <div class="card_tit">
                        <h3>PC 결제데모</h3>
                    </div>

                    <!-- 유의사항 -->
                    <div class="card_desc">
					    <h4>※ 유의사항</h4>
                        <ul>
                            <li>데모결제 시 실 승인되며, 당일 자정(24:00) 이전에 자동으로 취소처리 됩니다.</li>
							<li>가상계좌 채번 후 입금할 경우 자동환불되지 않사오니, 가맹점관리자 내 "입금통보테스트" 메뉴를 이용부탁드립니다.<br>(실 입금하신 경우 별도로 환불요청해주셔야 합니다.)</li>
							<li>국민카드 정책상 테스트 결제가 불가하여 오류가 발생될 수 있습니다. 국민, 카카오뱅크 외 다른 카드로 테스트결제 부탁드립니다.</li>
                        </ul>
                    </div>
                    <!-- //유의사항 -->


                <form name="" id="SendPayForm_id" method="post" class="mt-5">
                    <div class="row g-3 justify-content-between" style="--bs-gutter-x:0rem;">
					
                        <!--label class="col-10 col-sm-2 gap-2 input param" style="border:none;">version</label>
                        <label class="col-10 col-sm-9 input"-->
                            <input type="hidden" name="version" value="1.0">
                        <!--/label-->
						
                        <label class="col-10 col-sm-2 input param" style="border:none;">gopaymethod</label>
                        <label class="col-10 col-sm-9 input">
                            <select name="gopaymethod">
                                <option value="">-- 지불수단 --</option>
                                <option value="Card">신용카드</option>
                                <option value="DirectBank">계좌이체</option>
                                <option value="VBank">가상계좌</option>
                            </select>
                        </label>
						
						<label class="col-10 col-sm-2 input param" style="border:none;">mid <span class="text_g">(상점아이디)</span><span class="text_r">고정</span></label>
                        <label class="col-10 col-sm-9 input">
                            <input type="text" name="mid" value="INIpayTest" readonly>
                        </label>
						
                        <label class="col-10 col-sm-2 input param" style="border:none;">oid <span class="text_g">(주문번호)</span><span class="text_r">고정</span></label>
                        <label class="col-10 col-sm-9 input">
                            <input type="text" name="oid" value="DemoTest_1729305599829" readonly>
                        </label>
						
						<label class="col-10 col-sm-2 input param" style="border:none;">price <span class="text_g">(거래금액)</span><span class="text_r">고정</span></label>
                        <label class="col-10 col-sm-9 input">
                            <input type="text" name="price" value="1000" readonly>
                        </label>
						
						<label class="col-10 col-sm-2 input param" style="border:none;">timestamp<span class="text_r">고정</span></label>
                        <label class="col-10 col-sm-9 input">
                            <input type="text" name="timestamp" value="1729305599829" readonly>
                        </label>
						
						<!--label class="col-10 col-sm-2 input param" style="border:none;">signature</label>
                        <label class="col-10 col-sm-9 input"-->
                            <input type="hidden" name="signature" value="a5e0382bd156b0debd2bf18484e18344d4726819dd12c46ed0981c4d75a4af97">
							<input type="hidden" name="verification" value="0fdd412694c88d1f3a97028567ecdc3167fc4aef19261466f3b061f15f1192c2">
							<input type="hidden" name="use_chkfake" value="">
                        <!--/label-->
						
						<!--label class="col-10 col-sm-2 input param" style="border:none;">mKey</label>
                        <label class="col-10 col-sm-9 input"-->
                            <input type="hidden" name="mKey" value="3a9503069192f207491d4b19bd743fc249a761ed94246c8c42fed06c3cd15a33">
                        <!--/label-->
						
						<!--label class="col-10 col-sm-2 input param" style="border:none;">currency</label>
                        <label class="col-10 col-sm-9 input"-->
                            <input type="hidden" name="currency" value="WON">
                        <!--/label-->
						
						<label class="col-10 col-sm-2 input param" style="border:none;">goodname</label>
                        <label class="col-10 col-sm-9 input">
                            <input type="text" name="goodname" value="테스트상품">
                        </label>
						
						<label class="col-10 col-sm-2 input param" style="border:none;">buyername</label>
                        <label class="col-10 col-sm-9 input">
                            <input type="text" name="buyername" value="테스터">
                        </label>
						
						<label class="col-10 col-sm-2 input param" style="border:none;">buyertel</label>
                        <label class="col-10 col-sm-9 input">
                            <input type="text" name="buyertel" value="01012345678">
                        </label>
						
						<label class="col-10 col-sm-2 input param" style="border:none;">buyeremail</label>
                        <label class="col-10 col-sm-9 input">
                            <input type="text" name="buyeremail" value="test@test.com">
                        </label>
						
						<!--label class="col-10 col-sm-2 input param" style="border:none;">payViewType</label>
                        <label class="col-10 col-sm-9 input">
                            <input type="text" name="payViewType" value="overlay">
                        </label-->
						
						<!--label class="col-10 col-sm-2 input param" style="border:none;">returnUrl</label>
                        <label class="col-10 col-sm-9 input"-->
                            <input type="hidden" name="returnUrl" value="https://manual.inicis.com/pay/demo/pcDemo_Return.php">
                        <!--/label-->
						
						<!--label class="col-10 col-sm-2 input param" style="border:none;">closeUrl</label>
                        <label class="col-10 col-sm-9 input"-->
                            <input type="hidden" name="closeUrl" value="https://manual.inicis.com/pay/demo/pcDemo_close.php">
							<input type="hidden" name="popupUrl" value="https://manual.inicis.com/pay/demo/popup.php">
                        <!--/label-->
						
						<label class="col-10 col-sm-2 input param" style="border:none;">acceptmethod <span class="text_g">(추가옵션)</span></label>
                        <label class="col-10 col-sm-9 input">
                            <input type="text" name="acceptmethod" value="HPP(1):below1000:va_receipt:centerCd(Y)">
                        </label>
						
                    </div>
                </form>
				
				<button onclick="paybtn()" class="btn_solid_pri col-6 mx-auto btn_lg" style="margin-top:50px">결제 요청</button>

                </div>
            </section>
            <!-- //카드CONTENTS -->
			
        </main>
        <!-- <div style="height: 100px;"></div> -->
        <!-- //본문 -->

    <script src="https://resource.inicis.com/js/translate/translateLib.js" type="text/javascript"></script>
	<script type="text/javascript">
        //기준 설정 
        var windowWidth = window.matchMedia("screen and (min-width: 1240px)");
        if (windowWidth.matches) {
            var translate;
            // 페이지 로딩 완료 이벤트 등록 - Mozilla, Opera, Webkit 
            if (document.addEventListener) {
                document.addEventListener("DOMContentLoaded", function () {
                    document.removeEventListener("DOMContentLoaded", arguments.callee, false);
                    domReady();
                }, false);
            }
            // 페이지 로딩 완료 이벤트 등록 - Internet Explorer
            else if (document.attachEvent) {
                document.attachEvent("onreadystatechange", function () {
                    if (document.readyState === "complete") {
                        document.detachEvent("onreadystatechange", arguments.callee);
                        domReady();
                    }
                });
            }

            function domReady() {
                // 1. 초기화 – 필수
                translate = new inicis.Translate();
                var iniObj = {
                    mid: "INImobile1",
                    sourceLangCode: "KO",
                    isDebug: false,
                    isTest: false
                }
                translate.init(iniObj);
                // 1. 초기화 – 필수

                // 2. 번역국기 레이어 노출 명령
                translate.loadLayer({
                    //position : "absolute",
                    position: "fixed",
                    direction: "horizontal",
                    left: "1.6%",
                    top: "92%",
                    //langList : ["EN", "ZH_CN", "ZH_TW","ES","FR","VI","TH","ID"]
                    langList: ["EN", "ZH_CN", "JA"]
                });
            }
        }
    </script>
	
	<footer id="footer"></footer>
<!--PC(웹표준) 일반결제-->