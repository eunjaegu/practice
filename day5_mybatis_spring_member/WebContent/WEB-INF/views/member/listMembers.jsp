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
<h2 style="text-align:center">탈퇴 안 한 회원</h2>
<table border="1"  align="center"  width="80%">
    <tr align="center"   bgcolor="lightgreen">
      <td ><b>아이디</b></td>
      <td><b>비밀번호</b></td>
      <td><b>이름</b></td>
      <td><b>이메일</b></td>
      <td><b>수정</b></td>
      <td><b>삭제</b></td>
   </tr>
 <c:forEach var="member" items="${memberList}" > 
 	<c:if test="${ member.del_yn eq 'N'}">    
   <tr align="center">
      <td>${member.member_id}</td>
      <td>${member.member_pw}</td>
      <td>${member.member_name}</td>
      <td>${member.email1}@${member.email2 }</td>
       <td><a href="${contextPath}/member/modMember.do?id=${member.member_id }">수정하기</a></td>
       <td><a href="javascript:deleteMember('${ member.member_id }');">삭제하기</a></td>
    </tr>
    </c:if>
  </c:forEach>   
</table>
<h2 style="text-align:center">탈퇴 한 회원</h2>
<table border="1"  align="center"  width="80%">
    <tr align="center"   bgcolor="lightgreen">
      <td ><b>아이디</b></td>
      <td><b>비밀번호</b></td>
      <td><b>이름</b></td>
      <td><b>이메일</b></td>
      <td><b>수정</b></td>
      <td><b>삭제</b></td>
   </tr>
 <c:forEach var="member" items="${memberList}" >     
   <c:if test="${ member.del_yn eq 'Y'}">
   <tr align="center">
      <td>${member.member_id}</td>
      <td>${member.member_pw}</td>
      <td>${member.member_name}</td>
      <td>${member.email1}@${member.email2 }</td>
       <td><a href="${contextPath}/member/modMember.do?id=${member.member_id }">수정하기</a></td>
       <td><a href="javascript:deleteMember('${ member.member_id }');">삭제하기</a></td>
    </tr>
    </c:if>
  </c:forEach>   
</table>
<a  href="${contextPath}/member/memberForm.do"><h1 style="text-align:center">회원가입</h1></a>
<script>
	function deleteMember(id){
		if(confirm("정말 삭제하시겠습니까?")){
			location.href ="${contextPath}/member/removeMember.do?id="+id;
		}
	}
</script>
</body>
</html>
