<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
<div id="myCarousel" class="carousel slide mb-6" data-bs-ride="carousel">
	<div class="carousel-indicators" id="btn_list"></div>
	<div class="carousel-inner" id="img_list"></div>
	<button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
		<span class="carousel-control-prev-icon" aria-hidden="true"></span>
		<span class="visually-hidden">Previous</span>
	</button>
	<button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
		<span class="carousel-control-next-icon" aria-hidden="true"></span>
		<span class="visually-hidden">Next</span>
	</button>
</div>
<div class="container marketing">
	<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 g-5">
	<c:choose>
		<c:when test="${not empty mainHomeList }">
			<c:forEach var="obj" items="${mainHomeList}" varStatus="status">
				<div class="col" onclick="pageMove('product', '${obj.saleBoardSeq}')">
					<div class="card shadow-sm">
						<img class="bd-placeholder-img card-img-top" width="100%" height="225" src="${obj.imgPath}${obj.imgNm}">
						<div class="card-body">
							<p class="card-text">${obj.bulTitNm}</p>
							<div class="d-flex justify-content-between align-items-center">
								<small class="text-body-secondary">${String.format("%,d", obj.goodsPrc - obj.goodsSalePrc)}원</small>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<div>데이터가 없습니다.</div>
		</c:otherwise>
	</c:choose>
	
	</div>
<hr class="featurette-divider">
</div><!-- /.container -->
</main>

<script>
let eventList = null;
document.addEventListener('DOMContentLoaded', function(){
	fn_ajax({
		url: '/cltsh/adm/event/admEventListAjax.do',
		method: 'get',
		success: function(data){
			eventList = data.data;
			let btnListHtml = '';
			let imgListHtml = '';
			for(var i=0; i<eventList.length; i++){
				btnListHtml += '<button type="button" data-bs-target="#myCarousel" data-bs-slide-to="'+i+'" ';
				if(i==0){
					btnListHtml += 'class="active" aria-current="true"';
				}
				btnListHtml += ' aria-label="Slide '+i+'"></button>';
				
				imgListHtml += '<div class="carousel-item ';
				if(i==0){
					imgListHtml += 'active';
				}
				imgListHtml += '">';
				imgListHtml += '  <a href="/"><img class="bd-placeholder-img" width="100%" height="100%" src="'+eventList[i].imgPath+eventList[i].imgNm+'"></a>';
				imgListHtml += '</div>';
			}
			document.querySelector("#btn_list").innerHTML = btnListHtml;
			document.querySelector("#img_list").innerHTML = imgListHtml;
		}
	});
});
</script>