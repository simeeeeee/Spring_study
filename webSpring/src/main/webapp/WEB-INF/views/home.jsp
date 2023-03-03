<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 요기에 session false는 세션에 저장못하게하는  -->
<div class="container">
	<h1>
		Hello world!  
	</h1>
	<div class="desc">
		javascript외부파일 script.js<br/>
		css외부파일 style.css<br/>
		이미지파일
	</div>
	<div>
		번호 : ${num }<br/>
		이름 : ${name }
	</div>
	<img src="img/01.jpg" onclick="test()"/>
</div>
