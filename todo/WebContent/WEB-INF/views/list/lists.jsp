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
<title>게시물목록</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function(){
		if("${listVO.result}" == "T"){
			$('#result').prop('checked',true);
		}
	});

	function deleteList(tno){
		if(confirm("정말 삭제하시겠습니까?")){
			location.href ="${contextPath}/list/removeList.do?tno="+tno;
		}
	}
</script>

</head>
<body>
<div class="row content">
	<div class="col">
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Search</h5>
				<form action="<c:url value="/list/lists.do"/>" method="get">
					<input type="hidden" name="size" value="${pageRequestDTO.size}">
						<div class="mb-3">
							<input type="checkbox" id="result" name="result" value="T">완료여부
							<input type="radio" name="types" value="a">전체
							<input type="radio" name="types" value="t">제목
							<input type="radio" name="types" value="w">작성자
							<input type="text" name="keyword" value="">
						</div>
						<div class="input-group mb-3 dueDateDiv">
							<input type="date" name="form" class="form-control">
							<input type="date" name="to" class="form-control">
						</div>
						<div class="input-group mb-3">
							<div class="float-end">
								<button class="btn btn-primary" type="submit">Search</button>
								<button class="btn btn-primary" type="reset">reset</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<h2 style="text-align:center">게시물 목록</h2>
<table border="1"  align="center"  width="80%">
    <tr align="center"   bgcolor="lightgreen">
      <td ><b>번호</b></td>
      <td><b>제목</b></td>
      <td><b>작성자</b></td>
      <td><b>등록일</b></td>
      <td><b>중요도</b></td>
      <td><b>완료여부</b></td>
      <td><b>수정</b></td>
      <td><b>삭제</b></td>
   </tr>
 <c:forEach var="list" items="${todolist}" >     
   <tr align="center">
      <td>${list.tno}</td>
      <td>${list.title}</td>
      <td>${list.writer}</td>
      <td>${list.regdate}</td>
      <td>${list.importance}</td>
      <td>${list.result}</td>


       <td><a href="${contextPath}/list/modListForm.do?tno=${list.tno }">수정하기</a></td>
       <td><a href="javascript:deleteList('${ list.tno }');">탈퇴하기</a></td>
    </tr>
  </c:forEach>   
</table>
<a  href="${contextPath}/list/rigForm.do"><h1 style="text-align:center">게시물 작성</h1></a>

</body>
</html>
