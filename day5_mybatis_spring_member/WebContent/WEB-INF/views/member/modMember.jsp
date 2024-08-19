<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정창</title>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
   .text_center{
     text-align:center;
   }
</style>
	<script type="text/javascript">
	$('form').submit(function(){
		var checkVal=$('input[name=gender]:checked').val();
		console.log('Selected gender', gender);
	});
	
	$('form').submit(function(){
		var checkVal=$('input[name=smssts_yn]:checked').val();
		console.log('Selected receive_or_not', receive_or_not);
	});
	
	$('form').submit(function(){
		var checkVal=$('input[name=emailsts_yn]:checked').val();
		console.log('Selected receive_or_not', receive_or_not);
	});
	
	$('form').submit(function(){
		var checkVal=$('input[name=member_birth_gn]:checked').val();
		console.log('Selected receive_or_not', receive_or_not);
	});
	</script>
</head>
<body>
	<form method="post"   action="${contextPath}/member/updateMember.do">
	<h1  class="text_center">회원 정보 수정창</h1>
	<table  align="center">
	   <tr>
	      <td width="200"><p align="right" >아이디</td>
	      <td width="400"><input type="text" name="id" value="${member.member_id}" readonly></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right" >비밀번호</td>
	      <td width="400"><input type="password" name="pwd" value="${member.member_pw}"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">이름</td>
	       <td width="400"><p><input type="text" name="name" value="${member.member_name}"></td>
	    </tr>
        <tr>
            <td width="200" style="text-align:right;">성별</td>
            <td width="400">
                <p><input type="radio" id="male" name="gender" value="남성" ${member.member_gender == '101' ? 'checked' : ''}>
                    <label for="male">남성</label>
                </p>
            </td>
            <td width="400">
                <p><input type="radio" id="female" name="gender" value="여성" ${member.member_gender == '102' ? 'checked' : ''}>
                    <label for="female">여성</label>
                </p>
            </td>
        </tr>
        <tr>
	      <td width="200"><p align="right" >유선번호</td>
	      <td width="400"><input type="text" name="id" value="${member.tel1}" ></td>
	      <td width="400"><input type="text" name="id" value="${member.tel2}" ></td>
	      <td width="400"><input type="text" name="id" value="${member.tel3}" ></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right" >핸드폰번호</td>
	      <td width="400"><input type="text" name="id" value="${member.hp1}" ></td>
	      <td width="400"><input type="text" name="id" value="${member.hp2}" ></td>
	      <td width="400"><input type="text" name="id" value="${member.hp3}" ></td>
	   </tr>
        <tr>
            <td width="200" style="text-align:right;">SMS수신여부</td>
            <td width="400">
                <p><input type="radio" id="receiveOK" name="smssts_yn" value="수신" ${member.smssts_yn == 'Y' ? 'checked' : ''}>
                    <label for="receiveOK">수신</label>
                </p>
            </td>   
            <td width="400">
                <p><input type="radio" id="receiveNo" name="smssts_yn" value="수신거부" ${member.smssts_yn == 'N' ? 'checked' : ''}>
                    <label for="receiveNo">수신거부</label>
                </p>
            </td>
        </tr>
	    <tr>
	       <td width="200"><p align="right">이메일</td>
	       <td width="400"><p><input type="text" name="email1" value="${member.email1}">@<input type="text" name="email2" value="${member.email2}"></td>
	    </tr>
        <tr>
            <td width="200" style="text-align:right;">EMAIL수신여부</td>
            <td width="400">
                <p><input type="radio" id="receiveOK" name="emailsts_yn" value="수신" ${member.emailsts_yn == 'Y' ? 'checked' : ''}>
                    <label for="receiveOK">수신</label>
                </p>
            </td>   
            <td width="400">
                <p><input type="radio" id="receiveNo" name="emailsts_yn" value="수신거부" ${member.emailsts_yn == 'N' ? 'checked' : ''}>
                    <label for="receiveNo">수신거부</label>
                </p>
            </td>
        </tr>
        <tr>
	      <td width="200"><p align="right" >우편번호</td>
	      <td width="400"><input type="text" name="zipcode" value="${member.zipcode}"></td>
	    </tr>
	    <tr>
	      <td width="200"><p align="right" >도로명주소</td>
	      <td width="400"><input type="text" name="roadAddress" value="${member.roadaddress}"></td>
	    </tr>
	     <tr>
	      <td width="200"><p align="right" >지번주소</td>
	      <td width="400"><input type="text" name="jibunaddress" value="${member.jibunaddress}"></td>
	    </tr>
        <tr>
	      <td width="200"><p align="right" >상세주소</td>
	      <td width="400"><input type="text" name="namujiaddress" value="${member.namujiaddress}"></td>
	    </tr>
	    <tr>
	      <td width="200"><p align="right" >생년월일</td>
	      <td width="400"><input type="text" name="member_birth_y" value="${member.member_birth_y}" ></td>
	      <td width="400"><input type="text" name="member_birth_m" value="${member.member_birth_m}" ></td>
	      <td width="400"><input type="text" name="member_birth_d" value="${member.member_birth_d}" ></td>
	   </tr>
        <tr>
            <td width="200" style="text-align:right;">음력양력</td>
            <td width="400">
                <p><input type="radio" id="gn" name="member_birth_gn" value="수신" ${member.member_birth_gn == '1' ? 'checked' : ''}>
                    <label for="gn">수신</label>
                </p>
            </td>   
            <td width="400">
                <p><input type="radio" id="gn" name="member_birth_gn" value="수신거부" ${member.member_birth_gn == '2' ? 'checked' : ''}>
                    <label for="gn">수신거부</label>
                </p>
            </td>
        </tr>
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="수정하기"><input type="reset" value="다시입력"></td>
	    </tr> 
	    
	</table>
	</form>

</body>
</html>