<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/cltsh/cmm/admLeftMenu.jsp" %>
<div id="pro_answer">
    <h2>답변하기</h2>
    <div class="answer_box1">
        <select>
            <option>에디터</option>
            <option>test</option>
        </select>
        <select>
            <option>돋움</option>
            <option>굴림</option>
        </select>
        <select>
            <option>10pt</option>
            <option>12pt</option>
            <option>14pt</option>
            <option>16pt</option>
            <option>18pt</option>
        </select>
        <button>B</button>
        <button>I</button>
        <button>U</button>
        <button>T</button>
        <button>왼쪽정렬</button>
        <button>가운데정렬</button>
        <button>오른쪽정렬</button>
        <button>기본</button>
        <button>이미지</button>
        <button>동영상</button>
    </div>
    <div class="answer_box2">내용</div>
</div>
<button id="pro_save_btn"><a href="/cltsh/html/admin/product_postscript/product_postscript.html">저장</a></button>
<button id="pro_cancel_btn"><a href="/cltsh/html/admin/product_postscript/product_postscript.html">취소</a></button>
