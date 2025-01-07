<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main class="container">
	<div class="p-4 p-md-5 mb-4 product_menu">
		<div class="col-lg-6 px-0 text-center">
			<img alt="메인이미지" src="${detail.imgPath}${detail.imgNm} " width="90%" height="90%">
		</div>
		<div class="col-lg-6 px-0">
		   <h1 class="display-4 fst-italic">${detail.bulTitNm}</h1>
		<p class="lead my-3">${(detail.goodsSalePrc/detail.goodsPrc * 100).intValue()}%<del> ${String.format("%,d", detail.goodsPrc)}원</del> ${String.format("%,d", detail.goodsPrc - detail.goodsSalePrc)}원</p>
		<p class="lead my-1">배송비 ${String.format("%,d", detail.dlvPrc)}원</p>
		<p class="lead my-1">예상 구매가 ${String.format("%,d", detail.goodsPrc - detail.goodsSalePrc + detail.dlvPrc)}원</p>
		<p class="lead my-1">적립 ${String.format("%,d", ((detail.goodsPrc - detail.goodsSalePrc) * 0.03).intValue())}원</p>
		
		 
		<c:if test="${not empty optList}">
			<c:forEach var="entry" items="${optList}">
			<select class="form-select my-1" name="option_${entry.key}" id="colorOption">
				<option value="">[${entry.value[0].optsNm}] 옵션을 선택하세요.</option>
				
				<c:forEach var="option" items="${entry.value}">
				<option value="${option.optsCd}">${option.optsVal}</option>
				</c:forEach>
			</select>
			<br/>
			</c:forEach>
		</c:if>
		
		
		<p class="lead my-1">총 상품 금액 ${String.format("%,d", detail.goodsPrc - detail.goodsSalePrc + detail.dlvPrc)}원</p>
		<c:if test="${not empty sessionScope.loginInfo }">
			<p class="lead mb-2"><a href="#" class="text-body-emphasis fw-bold" onclick="fn_add_basket('${detail.saleBoardSeq}')">장바구니</a></p>
		</c:if>
		<p class="lead mb-2"><a href="#" class="text-body-emphasis fw-bold" onclick="fn_order()">바로구매</a></p>
		</div>
	</div>
	
	
<div class="accordion" id="accordionExample">
	<div class="accordion-item">
		<h2 class="accordion-header">
		  <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">상품정보</button>
		</h2>
		<div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">
			<div class="accordion-body">
				<div class="product_detail_image">
				   	<img src="${detail.imgPath}${detail.imgNm}" width="90%" height="90%" /></br>
				</div>
				<div class="product_detail_document">
				    <h3>상품 설명</h3>
				    ${detail.bulCont}
				</div>
				<div class="product_detail_document">
				    <h3>사이즈 정보</h3>
				    <img src="/img/cltsh/top_size.png" width="90%" height="90%"/></br>
				    <img src="/img/cltsh/pants_size.png" width="90%" height="90%"/>
				</div>
			</div>
		</div>
	</div>
	<div class="accordion-item">
		<h2 class="accordion-header">
		  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">상품리뷰</button>
		</h2>
		<div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
			<div class="accordion-body">
				<div class="product_review_titlebar">
					<div class="product_review_title">
						<h4>드레스룸</h4>
					</div>
					<div class="product_review_sort">
						
					</div>
				</div>
				<c:if test="${empty rvo }">
					<div class="nodata">작성된 드레스룸이 없습니다.</div>
				</c:if>
				<c:forEach items="${rvo}" var="obj">
					<div class="product_review_box">
						<div class=""><a href="/cltsh/dress/dressDetail.do?saleBoardRpySeq=${obj.saleBoardRpySeq}">제목 : ${obj.bulTitNm}</a></div> <!-- 제목 -->
						<div class="product_review_detail">
							<div class="product_review_profile">
								<div class="product_review_profile_detail">
									<div>${obj.rgstId }<br>${obj.rgstDate }</div> <!-- 작성자, 작성일 -->
								</div>
							</div>
						</div>
						<div class="product_review_document">내용 : ${obj.bulCont }</div> <!-- 내용 -->
						<div class="product_review_image"><img src="${obj.imgPath }${obj.imgNm }" width="298" height="298"/></div> <!-- 이미지 -->
					</div>
				</c:forEach>
				<button class="btn btn-primary" onclick="location.href='/cltsh/main/mainDrssList.do'">더 많은 드레스룸 보기 ></button>
			</div>
		</div>
	</div>
	<div class="accordion-item">
		<h2 class="accordion-header">
		  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">상품 QnA</button>
		</h2>
		<div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
			<div class="accordion-body">
				<div class="product_qna_titlebar">
		            <div class="product_qna_title">
		                <h4>Q&A</h4>
		            </div>
		            <div class="product_qna_buttonbar">
		                <button class="btn btn-primary" onclick="location.href='/cltsh/qna/goodsDtlQnaInsert.do?goodsCd='+${detail.goodsCd}">문의 내용 작성하기</button>
		            </div>
		        </div>
		        <div class="product_qna_detail">
		            <div class="product_qna_table_title">
		                <ul>
		                    <li>답변상태</li>
		                    <li>내용</li>
		                    <li>작성자</li>
		                    <li>작성일</li>
		                </ul>
		            </div>
		            <c:if test="${empty rqvo }">
		            	<div class="nodata">문의가 없습니다.</div>
					</c:if>
		            <c:forEach items="${rqvo}" var="obj">
			           <div class="product_qna_table_content">
			               <ul>
			                   <li>${obj.ansrStat }</li>
			                   <li><a href="/cltsh/qna/qnaDetail.do?qnaBoardSeq=${obj.qnaBoardSeq}">${obj.cont }</a></li>
			                   <li>${obj.rgstId }</li>
			                   <li>${obj.rgstDate }</li>
			               </ul>
			           </div>
		            </c:forEach>
		    	</div>
				<c:if test="${not empty rqvo }"> <!-- rqvo가 비어 있지 않을 때 실행 -->
					${paging }
				</c:if>
			</div>
		</div>
	</div>
	<div class="accordion-item">
		<h2 class="accordion-header">
		  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">상품 주문 정보</button>
		</h2>
		<div id="collapseFour" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
			<div class="accordion-body">
				<div class="product_order_title">
		            <h4>배송 정보</h4>
		        </div>
		        <table class="product_order_table">
		            <tr>
		                <th class="product_order_table_title">배송 기간</th>
		                <th class="product_order_table_document">평일기준 익일 순차적 배송</br>
		                	정상 배송 당일, 순차적으로 출고되어 정상 운영일에 발송되지 않을 수 있습니다.</br>
		                	(최대 2~3일 소요)</br>
							배송 일정 및 기타 상품 관련 문의는 아래 고객센터로 접수 바랍니다.</br>
							고객센터 : 070-0000-0000</th>
		            </tr>
		            <tr>
		                <th class="product_order_table_title">배송 마감일</th>
		                <th class="product_order_table_document">평일기준 오후 3시마감</th>
		            </tr>
		            <tr>
		                <th class="product_order_table_title">상담 가능일</th>
		                <th class="product_order_table_document">운영시간 10시 ~ 17시</th>
		            </tr>
		        </table>
		        <div class="product_order_title">
		            <h4>교환/반품 안내</h4>
		        </div>
		        <table class="product_order_table"> <!-- 주문 정보 -->
		            <tr>
		                <th class="product_order_table_title">교환/반품 정보</th>
		                <th class="product_order_table_document">반품 및 교환은 상품 수령 후 7일 이내에 신청하실 수 있습니다.</br>
							재화 등의 내용이 표시, 광고의 내용과 다르거나 계약내용과 다르게 이행된 경우에는 전자상거래법 제17조3항에 따라 청약철회를 할 수 있습니다.</br>
							교환/환불이 발생하는 경우 그 원인을 제공한 자가 배송비를 부담합니다.</br>
							- 고객변심 : 최초 배송비 + 반품 배송비 + (교환의 경우) 교환 배송비는 고객이 부담</br>
							- 판매자귀책 : 최초 배송비 + 반품 배송비 + (교환의 경우) 교환 배송비는 판매자가 부담</br>
							다음의 경우는 교환 및 환불이 불가능합니다.</br>
							- 반품/교환 가능 기간을 초과한 경우</br>
							- 상품 및 구성품을 분실하였거나 취급부주의로 인한 오염/파손/고장된 경우</br>
							- 상품을 착용하였거나 세탁, 수선한 경우</br>
							- 소비자 과실로 인한 옷의 변색(예 : 착생, 화장품 오염 등)</br>
							- 착용으로 인한 니트류 상품의 늘어남 발생 및 가죽 제품의 주름 발생</br>
							- 명품은 택 제거 후 반품 불가</br>
							- 상품의 가치가 현저히 감소하여 재판매가 불가할 경우</br>
							- 구매확정된 주문의 경우</br>
							- 귀금속류의 경우는 소비자분쟁해결 기준에 의거 교환만 가능합니다.</br>
							(단, 함량미달의 경우에는 환불이 가능함)</br>
		        </table>
		        <div class="product_order_title"> <!-- 판매자 정보 -->
		            <h4>판매자 정보</h4>
		        </div>
		        <table class="product_order_table">
		            <tr>
		                <th class="product_order_table_title">상호 / 대표자</th>
		                <th class="product_order_table_document">CLTshop / 성영식</th>
		            </tr>
		            <tr>
		                <th class="product_order_table_title">연락처</th>
		                <th class="product_order_table_document">010-1234-5678</th>
		            </tr>
		            <tr>
		                <th class="product_order_table_title">E-mail</th>
		                <th class="product_order_table_document">cltshop@gmail.com</th>
		            </tr>
		            <tr>
		                <th class="product_order_table_title">사업장 소재지</th>
		                <th class="product_order_table_document">경기 부천시 소사로 56</th>
		            </tr>
		            <tr>
		                <th class="product_order_table_title">통신판매업신고</th>
		                <th class="product_order_table_document">2022-부천소사-0001</th>
		            </tr>
		            <tr>
		                <th class="product_order_table_title">사업자 번호</th>
		                <th class="product_order_table_document">123-12-12345</th>
		            </tr>
		        </table>
				
				
			</div>
		</div>
	</div>
</div>
</main>
<script>
//상품 선택 화면 --------------------------------------------------
//상품 중간 메뉴 선택시 해당 부분으로 이동(상단 포함)
const productMenu = document.querySelector(".product_menu_list");
const productMenuUpperbar = document.querySelector(".product_menu_list_upperbar");
productMenu.addEventListener("click", (event) => { //클릭 이벤트 발생시
 const target = event.target; //마우스 클릭 타겟
 const link = target.dataset.link; //data-link와 연동
 if (link == null) { //data-link가 null일 경우
     return; //아무것도 안함
 }
 const scrollTo = document.querySelector(link);
 scrollTo.scrollIntoView({behavior : 'smooth'}); //이동
});
productMenuUpperbar.addEventListener("click", (event) => { //상단
 const target = event.target;
 const link = target.dataset.link;
 if (link == null) {
     return;
 }
 const scrollTo = document.querySelector(link);
 scrollTo.scrollIntoView({behavior : 'smooth'}); //이동
});

//일정 아래로 스크롤 하면 상품 중간 메뉴 상단에 나타남
const productUpperbar = document.querySelector('#product_menu_upperbar');
const productMenuTop = window.pageYOffset + productMenu.getBoundingClientRect().top - 10;
document.addEventListener("scroll", () => {
 if(window.scrollY > productMenuTop) {
     productUpperbar.classList.remove('invisible');
     productUpperbar.classList.add('visible');
 } else {
     productUpperbar.classList.remove('visible');
     productUpperbar.classList.add('invisible');
 }
});
//바로 구매 버튼 클릭시
function fn_order(){
	let select_color_option = document.querySelector("#colorOption");
	let select_size_option = document.querySelector("#sizeOption");
	let usrId = '${sessionScope.loginInfo.usrId}';
	
    if (usrId === null || usrId === '') {
        alert('로그인이 필요합니다. 로그인 후 이용해주세요.');
        location.href='/cltsh/user/userLogin.do';
    } else{
		 if(select_color_option.value != "" &&  select_size_option.value != ""){
			location.href='/cltsh/order/order.do?searchSaleBoardSeq='+${detail.saleBoardSeq}+'&colorOption='+select_color_option.value+'&sizeOption='+select_size_option.value;
		} else{
			alert("옵션을 선택해주세요.");
		}
   }
}
</script>