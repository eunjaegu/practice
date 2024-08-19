<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<html>
<head>
<meta charset=UTF-8">
<title>상품 출력창</title>
<style>
 	#goods_title, #goods_writer {
 		text-align : left;
 	}
</style>
</head>
<body>
	<table border="1" align="center" width="80%">
		<tr align="center" bgcolor="lightgreen">
			<td><b>상품 아이디</b></td>
			<td><b>상품 종류</b></td>
			<td><b>상품 이름</b></td>
			<td><b>저자</b></td>
			<td><b>상품 정가</b></td>
			<td><b>상품 판매가</b></td>
			<td><b>상품 분류</b></td>
			<td><b>수정 </b></td>
			<td><b>삭제</b></td>
		</tr>

		<c:forEach var="goods" items="${goodsList}">
			<tr align="center">
				<td>${goods.goods_id}</td>
				<td>${goods.goods_sort}</td>
				<td id="goods_title">${goods.goods_title}</td>
				<td id="goods_writer">${goods.goods_writer}</td>
				<td><fmt:formatNumber value="${goods.goods_price}" pattern="#,###"/></td>
				<td><fmt:formatNumber value="${goods.goods_sales_price}" pattern="#,###"/></td>
				<td>${goods.goods_status}</td>
				<td><a
					href="${contextPath}/goods/modGoodsForm.do?goods_id=${goods.goods_id}">수정하기</a>
				</td>
				<td><a
					href="${contextPath}/goods/removeGoods.do?goods_id=${goods.goods_id}">삭제하기</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${contextPath}/goods/addGoodsForm.do""><h1 style="text-align: center">상품 등록</h1></a>
</body>
</html>
