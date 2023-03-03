<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
	<h1>회원가입 폼</h1>
	<ul>
		<li>아이디</li>
		<li><input type="text" name="userid" id="userid"/></li>
		<li>비밀번호</li>
		<li><input type="password" name="userpwd" id="userpwd"/></li>
		<li><input type="password" name="userpwd2" id="userpwd2"/></li>
		<li>이름</li>
		<li><input type="text" name="username" id="username"/></li>
		<li>연락처</li>
		<li>
			<select name="tel1" id="tel1">
				<option value="010">010</option>
				<option value="02">02</option>
				<option value="031">031</option>
				<option value="041">041</option>
				<option value="051">051</option>
			</select>
			<input type="text" name="tel2" id="tel2"/>
			<input type="text" name="tel3" id="tel3"/>
		</li>
		<li>이메일</li>
		<li><input type="text" name="email" id="email"/></li>
		<li>우편번호</li>
		<li><input type="text" name="zipcode" id="zipcode"/></li>
		<li>주소</li>
		<li><input type="text" name="addr" id="addr"/></li>
		<li>상세주소<li>
		<li><input type="text" name="detailaddr" id="detailaddr"/></li>
		<li>취미</li>
		<li>
			<input type="checkbox" name="hobby" value="야구"/>야구
			<input type="checkbox" name="hobby" value="바이크"/>바이크
			<input type="checkbox" name="hobby" value="등산"/>등산
			<input type="checkbox" name="hobby" value="쇼핑"/>쇼핑
			<input type="checkbox" name="hobby" value="자전거"/>자전거
			<input type="checkbox" name="hobby" value="걷기"/>걷기
			<input type="checkbox" name="hobby" value="영화감상"/>영화감상
		</li>
	</ul>
</div>