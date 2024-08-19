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
<title>게시물등록</title>
<style>
   .text_center{
     text-align:center;
   }
</style>
<script>
	function checkOnlyOne(element) {
	    const checkboxes = document.getElementsByName("importance");
	    
	    checkboxes.forEach((cb) => {
	    	cb.checked = false;
	    })
	    element.checked = true;
	}
</script>
</head>
<body>
	<form method="post"   action="${contextPath}/list/addlist.do">
	<h1  class="text_center">게시물 작성</h1>
	<table  align="center">
	    <tr>
	       <td width="200"><p align="right">제목</td>
	       <td width="400"><p><input type="text" name="title" style="width: 50%;"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">작성자</td>
	        <td width="400"><p><input type="text" name="writer" style="width: 50%;"></td>
	    </tr>
		<tr>
		    <td width="200"><p align="right">중요도</td>
		    <td width="400">
		        <p>
		            <input type="checkbox" id="HIGH" name="importance" value="H" onclick="checkOnlyOne(this)">
		            <label for="HIGH">상</label>
		            <input type="checkbox" id="MIDDLE" name="importance" value="M" onclick="checkOnlyOne(this)">
		            <label for="MIDDLE">중</label>
		            <input type="checkbox" id="LOW" name="importance" value="L" onclick="checkOnlyOne(this)">
		            <label for="LOW">하</label>
		        </p>
		    </td>
		</tr>
	    <tr>
	       <td width="200"><p align="right">내용</td>
	       <td width="400"><textarea name="tododata" rows="5" cols="50"></textarea></td>
	    </tr>
	    
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="button" value="목록" onclick="moveList();"><input type="submit" value="작성"><input type="reset" value="다시입력"></td>
	    </tr>
	    
	</table>
	</form>
	
	<script>
		function moveList(){
			location.href = "<c:url value="/list/lists.do"/>";
		}
	</script>
</body>
