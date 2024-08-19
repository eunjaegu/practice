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
<title>게시물수정</title>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
   .text_center{
     text-align:center;
   }
</style>
<script type="text/javascript">
	$('form').submit(function(){
		var checkVal=$('input[name=result]:checked').val();
		console.log('Selected result', result);
	});
	
	<script type="text/javascript">
	$('form').submit(function(){
		var checkVal=$('input[name=importance]:checked').val();
		console.log('Selected importance', importance);
	});
</script>	
<script>	
function checkOnlyOne(element) {
    const checkboxes = document.getElementsByName("importance");
    
    checkboxes.forEach((cb) => {
    	cb.checked = false;
    })
    element.checked = true;
}
</script>	
<script>
	function checkOnlyOneR(element) {
	    const checkboxes = document.getElementsByName("result");
	    
	    checkboxes.forEach((cb) => {
	    	cb.checked = false;
	    })
	    element.checked = true;
	}
</script>
</head>
<body>
	<form method="post"   action="${contextPath}/list/modifylist.do">
	<h1  class="text_center">게시글 수정</h1>
	<table  align="center">
	   <tr>
	      <td width="200"><p align="right" >번호</td>
	      <td width="400"><input type="text" name="tno" value="${todolist.tno}" readonly></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right" >제목</td>
	      <td width="400"><input type="text" name="title" value="${todolist.title}"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">작성자</td>
	       <td width="400"><p><input type="text" name="writer" value="${todolist.writer}" readonly></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">등록일</td>
	       <td width="400"><p><input type="text" name="date" value="${todolist.regdate}" readonly></td>
	    </tr>
	    <tr>
            <td width="200" style="text-align:right;">중요도</td>
            <td width="400">
                   <p>
               		<input type="checkbox" id="HIGH" name="importance" value="H" ${todolist.importance == 'H' ? 'checked' : ''} onclick="checkOnlyOne(this)">
                   		<label for="HIGH">상</label>     
              		<input type="checkbox" id="MIDDLE" name="importance" value="M" ${todolist.importance == 'M' ? 'checked' : ''} onclick="checkOnlyOne(this)">
                   		<label for="MIDDLE">중</label>
                	<input type="checkbox" id="LOW" name="importance" value="L" ${todolist.importance == 'L' ? 'checked' : ''} onclick="checkOnlyOne(this)">
                    	<label for="LOW">하</label>
				 </p>
            </td>
        </tr>
        <tr>
            <td width="200" style="text-align:right;">완료여부</td>
            <td width="400">
                <p><input type="checkbox" id="OK" name="result" value="T" onclick= "checkOnlyOneR(this)" ${todolist.result == 'T' ? 'checked' : ''}>
                    <label for="OK">완료</label>
               <input type="checkbox" id="NO" name="result" value="F" onclick= "checkOnlyOneR(this)" ${todolist.result == 'F' ? 'checked' : ''}>
                    <label for="NO">미완료</label>
				 </p>
            </td>
        </tr>
       	    <tr>
	       <td width="200"><p align="right">내용</td>
	       <td width="400"><textarea name=tododata rows="5" cols="50" >${todolist.tododata}</textarea></td>
	    </tr>
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400">
	       <input type="button" value="목록" onclick="moveList();"> 
	       <input type="submit" value="수정하기" >
	       <input type="reset" value="다시입력"></td>
	    </tr> 
	    
	</table>
	</form>

	<script>
		function moveList(){
			location.href="${contextPath}/list/lists.do";
		}
	</script>

</body>
</html>