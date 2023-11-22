<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- menu start -->
<%@ include file="/WEB-INF/jsp/cltsh/cmm/nomalMenu.jsp" %>
<style>
.wrap_center{
	width: 100%;
	height: 600px;
}
.container{
	margin: 0 auto;
	width: 100%;
	height: 600px;
	overflow: hidden;
}
.img_wrap{
	width: 100%;
	height: 600px;
	position: absolute;
	overflow: hidden;
}

/* 롤링 이미지 UL */
.rollimgs {
	list-style: none;
	padding: 0;
	margin: 0;
}

.rollimgs li{
	position: absolute;
	width: 100%;
	height: 600px;
	left: 3000px;
}
.rollimgs li img{
	width: 100%;
	height: 100%;
}
.rollimgs li.currentroll{
	left: 0;
	transition: left .5s ease-in-out, right .5s ease-in-out;
}
.rollimgs li.prevroll{
	left: -3000px;
	transition: left .5s ease-in-out, right .5s ease-in-out;
}
.rollimgs.reverse li.prevroll{
	transition: none;
}
.rollimgs li.nextroll{
	left: 3000px;
	display: block;
	transition: none;
}
.rollimgs.reverse li.nextroll{
	transition: left .5s ease-in-out, right .5s ease-in-out;
}

.img_wrap .btnmove{
	position: absolute;
	top: 270px;
	width: 30px;
	height: 30px;
	z-index: 1;
	font-size: 1.4em;
	opacity: 0.5;
	background-color: #444435;
	text-align: center;
	border-radius: 50%;
}
.img_wrap .btnmove.prev{
	cursor: pointer;
	left: 10px;
}
.img_wrap .btnmove.next{
	cursor: pointer;
	right: 10px;
}
.img_wrap i{
	color: #fff;
}
</style>
<div class="wrap_center">
	<div class="container">
		<div class="img_wrap">
			<div class="prev btnmove">
				<a href="#" title="이전"><i class="fa-solid fa-angle-left"></i></a>
			</div>
			<div class="next btnmove">
				<a href="#" title="다음"><i class="fa-solid fa-angle-right"></i></a>
			</div>
			<ul class="rollimgs">
				<!-- <li><img src="/img/cltsh/banner/banner1.jpg" /></li>
				<li><img src="/img/cltsh/banner/banner2.jpg" /></li>
				<li><img src="/img/cltsh/banner/banner3.jpg" /></li> -->
			</ul>
		</div>
	</div>
</div>

<script>
var eventList = null;
document.addEventListener('DOMContentLoaded', function(){
	fn_ajax({
		url: '/cltsh/adm/event/admEventListAjax.do',
		method: 'get',
		success: function(data){
			eventList = data.data
			for(var i=0; i<eventList.length; i++){
				document.querySelector(".rollimgs").innerHTML += '<li><img src="'+eventList[i].imgPath+eventList[i].imgNm+'"/></li>';
			}
			banner.rollInit(4000); // 배너 롤링
		}
	});
});
//앞뒤 클릭 이벤트 리스너
document.querySelectorAll('.btnmove').forEach(function(item){
	item.addEventListener('click', function(e){
		clearInterval(banner.rollId);//롤링 인터벌 해제
		//화살표 방향 구분
		if(e.target.parentElement.parentElement.classList.contains('prev')){
			banner.rollPrev();
		}else{
			banner.rollNext();
		}
		banner.rollId = setInterval(banner.rollNext, banner.interval);//롤링 인터벌 재호출
	});
});
let banner = {
	rollId: null,
	interval: 2000,

	//롤링 배너 초기화
	rollInit: function (newinterval) {
		if(parseInt(newinterval) > 0){
			this.interval = newinterval;
		}
		//현재 배너
		let firstitem = document.querySelector('.rollimgs li');
		if(firstitem){
			firstitem.classList.add('currentroll');
		}
		//다음 배너
		let seconditem = document.querySelectorAll('.rollimgs li')[1];
		if(seconditem){
			seconditem.classList.add('nextroll');
		}
		//이전 배너
		document.querySelector('.rollimgs li:last-child').classList.add('prevroll');
		this.rollId = setInterval(this.rollNext, this.interval);//롤링 인터벌 호출
	},

	//다음 배너 롤링
	rollNext: function () {
		if(document.querySelector('.prevroll')){
			document.querySelector('.prevroll').classList.remove('prevroll');
		}
		if(document.querySelector('.currentroll')){
			document.querySelector('.currentroll').classList.add('prevroll');
			document.querySelector('.currentroll').classList.remove('currentroll');
		}
		if(document.querySelector('.nextroll')){
			document.querySelector('.nextroll').classList.add('currentroll');
			document.querySelector('.nextroll').classList.remove('nextroll');
		}
		//다음 이미지 있으면 다음 롤링 이미지로 선택, 없으면 첫번째 이미지를 롤링 이미지로 지정
		if(document.querySelector('.currentroll').nextElementSibling){
			document.querySelector('.currentroll').nextElementSibling.classList.add('nextroll');
		}else{
			document.querySelector('.rollimgs li').classList.add('nextroll');
		}
	}
}
</script>