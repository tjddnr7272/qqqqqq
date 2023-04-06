<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록보기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">



</head>
<body>
 
<form action="writeAction" method="post">
 
  <div class="container mt-5 g-0">
    <h5 class="p-3 mb-2 bg-primary text-white rounded mb-4">공지 사항</h5>

    <div class="form-group">
      <div class="col">
        <div class="form-group">
          <label for="exampleSelect1" class="form-label mt-4 formtitle">관리자</label>
        </div>
      </div>
    </div>
   <label for="title">제목</label>
          <input type="text" name="notice_title"  class="form-control"  >
</div>

    <div class="form-group">
<textarea name="notice_content" class="form-control" id="summernote" rows="10">내용</textarea>
      
    </div>

    <div class="text-center">
    
    
    
    
    
    
      <!-- submit=> 버튼 전송 역할 -->
      <button type="submit" class="btn btn-primary mt-4">&nbsp&nbsp저장하기&nbsp&nbsp</button>
    </div>
  </div>

</form>

        
        
     

   
    <!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>