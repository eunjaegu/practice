<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">REGISTER BOARD</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <!-- form에 action을 따로 지정해주지 않으면 현재 경로를 그대로 action의 대상 경로로 잡는다. 
            	즉, 해당 form 에 데이터를 입력한 후 sumbit 버튼을 누르면 board/create의 경로에 post방식으로 호출되므로
            	이 URI에 매핑되는 컨트롤러에서 폼데이터를 받아서 처리할 것이다.-->
            <form role="form" method="post">
              <div class="box-body">
                <div class="form-group">
                  <label for="exampleInputEmail1">TITLE</label>
                  <input name="title" type="title" class="form-control" id="exampleInputEmail1" placeholder="Enter Title">
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">CONTENT</label>
                  <textarea name="content" class="form-control" placeholder="Enter Content" rows="3"></textarea>
                </div>
                
                <div class="form-group">
                  <label for="exampleInputEmail1 ">WRITER</label>
                  <input name="writer" type="text" class="form-control" placeholder="Enter Writer">
                </div>
                
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-primary">Submit</button>
              </div>
            </form>
          </div>
</body>
</html>
 <%@include file="../include/footer.jsp" %>
