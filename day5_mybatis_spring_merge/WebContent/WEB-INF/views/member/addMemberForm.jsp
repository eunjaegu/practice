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
	      <td width="400"><input type="text" name="member_id"></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">비밀번호</td>
	      <td width="400"><input type="password" name="member_pw"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">이름</td>
	       <td width="400"><p><input type="text" name="member_name"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">집</td>
	       <td width="400"><p><input type="text" name="hp" class="form-control" oninput="oninputPhone(this)" maxlength="12" ></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">휴대폰</td>
	       <td width="400"><p><input type="text" name="tel" class="form-control" oninput="oninputPhone(this)" maxlength="14" ></td>
	    </tr>
	    
	    
	    <tr>
	       <td width="200"><p align="right">성별</td>
	       <td>
	        	<input name="member_gender" type="radio" value="101" checked/>남자
	        	<input name="member_gender" type="radio" value="100"/>여자
	       </td>
	    </tr>
	    
	    <tr>
	       <td width="200"><p align="right">문자 수신여부</td>
	       <td>
	        	<input name="smssts_yn" type="radio" value="Y" checked/>동의
	        	<input name="smssts_yn" type="radio" value="N"/>비동의
	       </td>
	    </tr>
	    
	    <tr>
	       <td width="200"><p align="right">이메일</td>
	       <td width="400"><p><input type="text" name="email"></td>
	    </tr>
	    
	    <tr>
	       <td width="200"><p align="right">이메일 수신여부</td>
	       <td>
	        	<input name="emailsts_yn" type="radio" value="Y" checked/>동의
	        	<input name="emailsts_yn" type="radio" value="N"/>비동의
	       </td>
	    </tr>
	    
	    <tr>
	       <td width="200"><p align="right">우편번호</td>
	       <td width="400"><p><input type="text" name="zipcode" value="40125"></td>
	    </tr>
	    
	    <tr>
	       <td width="200"><p align="right">도로명주소</td>
	       <td width="400"><p><input type="text" name="roadAddress" value="경기 성남시 분당구 고가로 25 (동원동)"></td>
	    </tr>
	    
	    <tr>
	       <td width="200"><p align="right">지번주소</td>
	       <td width="400"><p><input type="text" name="jibunAddress" value="경기 성남시 분당구 동원동 79-1"></td>
	    </tr>
	    
	    <tr>
	       <td width="200"><p align="right">상세주소</td>
	       <td width="400"><p><input type="text" name="namujiAddress" value="럭키 빌딩 102호"></td>
	    </tr>
	    
	    
	   	<tr>
	       <td width="200"><p align="right">생년월일</td>
	       <td width="400"><p><input type="date" name="member_birth"></td>
	    </tr>
	    
	    
	    <tr>
	       <td width="200"><p align="right">생일 양력/음력</td>
	       <td>
	        	<input name="member_birth_gn" type="radio" value="1"/>음력
	        	<input name="member_birth_gn" type="radio" value="2" checked/>양력
	       </td>
	    </tr>
	    
	    <tr>
	       <td width="200"><p align="right">회원 탈퇴 여부</td>
	       <td>
	        	<input name="del_yn" type="radio" value="Y"/>승인 
	        	<input name="del_yn" type="radio" value="N" checked/>거절
	       </td>
	    </tr>
	    
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="가입하기"><input type="reset" value="다시입력"></td>
	    </tr>
	</table>
	</form>
</body>
