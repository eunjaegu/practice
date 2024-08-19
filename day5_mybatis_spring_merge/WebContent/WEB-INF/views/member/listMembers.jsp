<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    


<html>
<head>
<meta charset=UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<table border="1"  align="center"  width="80%">
    <tr align="center"   bgcolor="lightgreen">
      <td ><b>아이디</b></td>
      <td><b>비밀번호</b></td>
      <td><b>이름</b></td>
      <td><b>성별</b></td>
      <td><b>이메일</b></td>
      <td><b>가입일</b></td>
      <td><b>수정</b></td>
      <td><b>삭제</b></td>
   </tr>
   
 <c:forEach var="member" items="${membersList}" >     
   <tr align="center">
      <td>${member.member_id}</td>
      <td>${member.member_pw}</td>
      <td>${member.member_name}</td>
      <c:set var="gender" value="${member.member_gender}" />
      <c:choose>
      	<c:when test="${gender eq '101'}">
      		<td>남</td>
      	</c:when>
      	<c:otherwise>
      		<td>여</td>
      	</c:otherwise>
      </c:choose>
      <td>${member.email1}@${member.email2}</td>
      <td>${member.joinDate}</td>
      <td><a href="${contextPath}/member/modMemberForm.do?id=${member.member_id}">수정하기</a></td>
      <td><a href="${contextPath}/member/removeMember.do?id=${member.member_id}">삭제하기</a></td>
    </tr>
  </c:forEach>   
</table>
<a  href="${contextPath}/member/addMemberForm.do"><h1 style="text-align:center">회원가입</h1></a>
</body>
</html>
