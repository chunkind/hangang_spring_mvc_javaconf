<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
.wrap_center {
	width: 100%;
	height: 100%;
}

.container {
	margin: 0 auto;
	width: 50%;
	height: 450px;
	overflow: hidden;
}

.img_wrap {
	width: 50%;
	height: 450px;
	position: absolute;
	overflow: hidden;
}

/* 롤링 이미지 UL */
.rollimgs {
	list-style: none;
	padding: 0;
	margin: 0;
}

.rollimgs li {
	position: absolute;
	width: 100%;
	height: 450px;
	left: 3000px;
}

.rollimgs li img {
	width: 100%;
	height: 100%;
}

.rollimgs li.currentroll {
	left: 0;
	transition: left .5s ease-in-out, right .5s ease-in-out;
}

.rollimgs li.prevroll {
	left: -3000px;
	transition: left .5s ease-in-out, right .5s ease-in-out;
}

.rollimgs.reverse li.prevroll {
	transition: none;
}

.rollimgs li.nextroll {
	left: 3000px;
	display: block;
	transition: none;
}

.rollimgs.reverse li.nextroll {
	transition: left .5s ease-in-out, right .5s ease-in-out;
}

.img_wrap .btnmove {
	position: absolute;
	top: 190px;
	width: 30px;
	height: 30px;
	z-index: 1;
	font-size: 1.4em;
	opacity: 0.5;
	background-color: #444435;
	text-align: center;
	border-radius: 50%;
}

.img_wrap .btnmove.prev {
	cursor: pointer;
	left: 10px;
}

.img_wrap .btnmove.next {
	cursor: pointer;
	right: 10px;
}

.img_wrap i {
	color: #fff;
}

.wrap_center {
	padding-top: 10px;
}

.wrap_center, .best_dresser_list, #dressroom_create_btn {
	background-color: #ffffff;
}

.best_dresser_list {
	display: flex;
	padding-top: 20px;
	justify-content: center;
}

.best_dresser_list .item {
	padding: 10px;
}

.best_dresser_list img {
	width: 100px;
	height: 100px;
}

.item_list_area .list_area .list_search {
	width: 100%;
	text-align: right;
	padding: 10px;
	margin-right: 10px;
}

.item_list_area .list_area .data_list {
	display: flex;
	padding: 10px;
}

.item_list_area .list_area .data_list .item {
	padding: 10px;
}
.item_list_area .list_area .data_list .item img {
	width: 100px;
	height: 100px;
}
</style>

<section class="title_area">
	<h3 class="title">베스트 드레서 top5</h3>
</section>

<c:if test="${not empty list}">
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
            	<c:forEach items="${list }" var="obj" begin="0" end="4">
	                <li><a href="/cltsh/dress/dressDetail.do?saleBoardRpySeq=${obj.saleBoardRpySeq}"><img src="${obj.imgPath}${obj.imgNm}"></a></li>
            	</c:forEach>
            </ul>
        </div>
    </div>
</div>
<section class="best_dresser_list">
<c:forEach items="${list }" var="obj" begin="0" end="4">
	<div class="item">
        <div><a href="/cltsh/dress/dressDetail.do?saleBoardRpySeq=${obj.saleBoardRpySeq}"><img src="${obj.imgPath}${obj.imgNm}"></a></div>
        <a href="/cltsh/dress/dressDetail.do?saleBoardRpySeq=${obj.saleBoardRpySeq}">${obj.bulTitNm}</a>
    </div>
</c:forEach>
    
</section>
</c:if>

<section class="item_list_area">
    <div class="list_area">
    	<c:if test="${empty list }">
     		<div class="nodata">데이터가 없습니다.</div>
       	</c:if>
        <div class="data_list">
            <c:forEach items="${list }" var="obj" begin="5">
            <a href="/cltsh/dress/dressDetail.do?saleBoardRpySeq=${obj.saleBoardRpySeq}">
            <div class="item">
                <img src="${obj.imgPath}${obj.imgNm}">
                <h3>${obj.bulTitNm}</h3>
                <h6>${obj.updtId}</h6>
                <span>${obj.updtDate} * ${obj.lkeCnt} </span>
            </div>
            </a>
            </c:forEach>
        </div>
    </div>
    <div class="btn_area">
        <a class="dressroom_create_btn_detail" href="/cltsh/dress/dressRegister.do">드레스룸 만들기</a>
    </div>
</section>
<script>
let listSize = '${listSize}'
document.addEventListener('DOMContentLoaded', function(){
	banner.rollInit(4000); // 배너 롤링    		
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