<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<!-- jstl forEach  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jstl 날짜 fotmat -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>​
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="row">

        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">LIST ALL PAGE</h3>
              
              

              <div class="box-tools">
              	<button id="newBtn" class="btn btn-default" style="width:50px"> New Board</button>
              
                <!-- 검색 타입 선택 리스트 -->
				<select name="searchType" class="form-control input-sm">
					<option value="n" <c:out value="${pageMaker.cri.searchType == null? 'selected' : ''}" />>---</option>
					<option value="t" <c:out value="${pageMaker.cri.searchType == 't'? 'selected' : ''}" /> >Title</option>
					<option value="c" <c:out value="${pageMaker.cri.searchType == 'c'? 'selected' : ''}" />>Content</option>
					<option value="w" <c:out value="${pageMaker.cri.searchType == 'w'? 'selected' : ''}" />>Writer</option>
				</select>
	            <!-- 검색 타입 선택 리스트  끝 -->
                
                <div class="input-group input-group-sm" style="width:150px; ">
				  <!-- 키워드 입력 부분 -->
                  <input type="text" name="keyword" class="form-control pull-right" placeholder="Search"
                  	value="${pageMaker.cri.keyword}">

			      <!-- 검색 버튼 -->
                  <div class="input-group-btn">
                    <button type="submit" id="searchBtn" class="btn btn-default"><i class="fa fa-search"></i></button>
                  </div>
                  
                </div>
              </div><!-- box-tools -->
              
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tbody>
                <tr class="scrollLocation">
                  <th>BNO</th>
                  <th>TITLE</th>
                  <th>WRITER</th>
                  <th>REGDATE</th>
                  <th>VIEWCNT</th>
                </tr>
               
               	<!-- bno, 제목, 작가, 등록일, 조회수 -->
               	<c:forEach items="${list}" var="boardVO">
        			<tr class="listToChange">
        				<td class="scrolling" data-bno="${boardVO.bno}">
        					${boardVO.bno}
        				</td>
        				<td><!-- /sboard/read?page=4&perPageNum=10&searchType=?&keyword=?&bno=693  -->
        					<a href="/sboard/read${pageMaker.makeSearch(pageMaker.cri.page)}&bno=${boardVO.bno}">${boardVO.title}</a>
        				</td>
        				<td>${boardVO.writer}</td>
        				<td>
        					<fmt:formatDate value="${boardVO.regdate}" pattern="yyyy-MM-dd"/>
        				</td>
            			<td>
            				<span class="label label-success">${boardVO.viewcnt}</span>
						</td>
 			
        			</tr> 
				</c:forEach>

               
              </tbody></table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
      </div>



<!-- pagination -->

	<div class="dataTables_paginate paging_simple_numbers" id="example1_paginate">
		<ul class="pagination">
			<!-- 이전 -->
			<!-- ${pageMaker.prev} == true 이면 class 그대로, false이면 disabled 추가 -->
			<c:choose>
				<c:when test="${pageMaker.prev}">
					<li class="paginate_button previous" id="example1_previous">
						<a href="/sboard/list${pageMaker.makeSearch(pageMaker.startPage-1)}">		
							Previous
						</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="paginate_button previous disabled" id="example1_previous">		
						<a href="/sboard/list${pageMaker.makeSearch(pageMaker.startPage-1) }">
							Previous
						</a>
					</li>
				
				</c:otherwise>
			</c:choose>

			<!-- 페이지 번호 -->
			<!-- forEach써서 ${pageMaker.startPage} 부터 ${pageMaker.endPage} 까지  li태그로 출력-->
			<c:forEach  var="idx" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
				<li class="paginate_button">
					<a href="/sboard/list${pageMaker.makeSearch(idx)}" >
						${idx}
					</a>
				</li>
			</c:forEach>

			<!-- 이후 -->
			<c:choose>
				<c:when test="${pageMaker.next}">
					<li class="paginate_button next" id="example1_next">
						<a href="/sboard/list${pageMaker.makeSearch(pageMaker.endPage+1)}">
							Next
						</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="paginate_button next disabled" id="example1_next">
						<a href="/sboard/list${pageMaker.makeSearch(pageMaker.endPage+1)}">						
							Next
						</a>	
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>


<script>

$(function(){
	
	/* <a> 태그에 class로 disalbed를 추가한다고해서 클릭 이벤트가 막히진 않았다. 그냥 '불가'라는 아이콘 표시만 될뿐,
		따라서 이렇게 따로 event.preventDefault()하여 click이벤트를 막아주어야 했다. */
	$('.disabled').on('click', function(event){
		console.log("여기 들어옴");
		console.log(event);
		event.preventDefault();
	});
	
	/* 삭제 후 다시 리스트 페이지 돌아올때 삭제 확인 */
	var msg = '${msg}';

	if (msg == 'SUCCESS'){
		console.log("삭제 메세지 들어옴!!!");
		alert("삭제 성공");
		
	}// if()

	/* 수정 후 다시 리스트 페이지 돌아올때 수정 확인 */
	var updateMsg = '${updateMsg}';

	if (updateMsg == 'success'){
		console.log("수정 메세지 들어옴!!!");
		alert("수정 성공");	
	}// if()

	/* 검색 버튼 클릭 이벤트 핸들러 */
	$('#searchBtn').on("click", function(event){
		
		// 검색옵션 값 가져오고
		var searchType = $("select[name=searchType]").val();
		
		// 키워드 값 가져와서
		var keyword = $("input[name=keyword]").val();
		
		console.log("searchType : " + searchType);
		console.log("keyword : " + keyword+keyword);
		
		alert("잠깐");
		
		// 서버쪽 url 스트링 완성해서 self.location으로 창 이동.
		// -> 서버쪽에서 해당 파라미터들을 수집하여 검색결과 리스트를 뿌려줄 것이다.
		console.log("localhost:/8081/sboard/list${pageMaker.makeQuery(1)}&searchType="+searchType+"&keyword="+keyword);
		
		self.location = "/sboard/list${pageMaker.makeQuery(1)}&searchType=" + searchType + "&keyword=" + keyword;
		
	});//on()
		
	/* New Board 버튼 클릭시 이벤트 핸들러 */	
	$('#newBtn').on("click", function(event){
		self.location = "/sboard/create";
		
	});
		
	/* 등록 후 다시 리스트 페이지 돌아올때 등록 확인 */
	var createMsg = '${createMsg}';

	if (createMsg == 'success'){
		console.log("등록 메세지 들어옴!!!");
		alert("등록 성공");	
	}// if()
		
});//$(function(){})
	
	
	

</script>

</body>
</html>
<%@include file="../include/footer.jsp" %>
