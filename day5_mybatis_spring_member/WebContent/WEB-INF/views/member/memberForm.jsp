<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입창</title>
<style>
   .text_center{
     text-align:center;
   }
</style>
<script>
	function oninputPhone(target) {
	    target.value = target.value
	        .replace(/[^0-9]/g, '')
	        .replace(/(^02.{0}|^01.{1}|[0-9]{3,4})([0-9]{3,4})([0-9]{4})/g, "$1-$2-$3");
	}
</script>
</head>
<body>
	<form method="post"   action="${contextPath}/member/addMember.do">
	<h1  class="text_center">회원 가입창</h1>
	<table  align="center">
	   <tr>
	      <td width="200"><p align="right">아이디</td>
	      <td width="400"><input type="text" name="id" placeholder = "아이디를 입력하세요"></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">비밀번호</td>
	      <td width="400"><input type="password" name="pwd" placeholder = "비밀번호를 입력하세요"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">이름</td>
	       <td width="400"><p><input type="text" name="name"></td>
	    </tr>
   		<tr>
	       <td width="200"><p align="right">성별</td>
	       <td width="400"><p><input type="radio" id="male" name="gender" value="남성">
	       		<label for = "male">남성</td>
	       <td width="400"><p><input type="radio" id="femaile" name="gender" value="여성">
	       		<label for = "female">여성</td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">유선번호</td>
	        <td width="400"><p><input type="text" name="tel" oninput="oninputPhone(this)" maxlength="12" placeholder="- 없이 숫자만 입력하세요"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">휴대폰번호</td>
	        <td width="400"><p><input type="text" name="hp" oninput="oninputPhone(this)" maxlength="14" placeholder="- 없이 숫자만 입력하세요"></td>
	    </tr>
	   <tr>
	       <td width="200"><p align="right">SMS수신여부</td>
	       <td width="400"><p><input type="radio" id="receiveOK" name="smssts_yn" value="수신">
	       		<label for = "receiveOK">수신</td>
	       <td width="400"><p><input type="radio" id="receiveNo" name="smssts_yn" value="수신거부">
	       		<label for = "receiveNo">수신거부</td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">이메일</td>
	        <td width="400"><p><input type="email" name="email1" >@<input type="text" name="email2" ></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">EMAIL수신여부</td>
	       <td width="400"><p><input type="radio" id="receiveOK" name="emailsts_yn" value="수신">
	       		<label for = "receiveOK">수신</td>
	       <td width="400"><p><input type="radio" id="receiveNo" name="emailsts_yn" value="수신거부">
	       		<label for = "receiveNo">수신거부</td>
	    </tr>
	    <tr>
	      <td width="200"><p align="right">우편번호</td>
	      <td width="400"><input type="text" name="zipcode"></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">도로명주소</td>
	      <td width="400"><input type="text" name="roadaddress"></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">지번주소</td>
	      <td width="400"><input type="text" name="jibunaddress"></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">상세주소</td>
	      <td width="400"><input type="text" name="namujiaddress"></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">생일</td>
	      <td width="400"><input type="text" name="member_birth" oninput="oninputPhone(this)" maxlength="10" placeholder="- 없이 숫자만 입력하세요"></td>
	   </tr>
	   <tr>
	       <td width="200"><p align="right">음력 양력</td>
	       <td width="400"><p><input type="radio" id="gn" name="member_birth_gn" value="음력">
	       		<label for = "gn">음력</td>
	       <td width="400"><p><input type="radio" id="gn" name="member_birth_gn" value="양력">
	       		<label for = "gn">양력</td>
	    </tr>
	   
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="가입하기"><input type="reset" value="다시입력"></td>
	    </tr>
	    
	</table>
	</form>
	
</body>
