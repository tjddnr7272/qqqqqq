<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

  
  

</head>
<body> 
  <form action="updateAction" method="post">
<input type="hidden" name="notice_id" value="${dto.notice_id}">
  <div class="container-lg m">

<h7 class="d-flex p-2 border-bottom text-primary mb-4">공지사항</h7>

</div>

<div class="container-lg border-bottom">


  <h5 class="mb-4"><input type="text" name="notice_title" value="${dto.notice_title} "> 제목입니다 </h5>
  
 <textarea name ="notice_content"type="text"> ${dto.notice_content} 내용입니다 </textarea>
</div>

<div class="container-lg mt-3">
  <div class="d-flex justify-content-between">
    <div class="d-grid gap-2 d-md-block btn-primar">
      <button class="btn btn-outline-secondary" type="button"> < 이전글 </button>
      <button class="btn btn-outline-secondary" type="button"> 다음글 > </button>
    </div>
        <button class="btn btn-secondary" type="submit" value="수정하기">수정하기</button>
     <a href="listForm"><button class="btn btn-secondary" type="button" value="목록보기">목록보기</button></a>
     <a href="deleteAction?notice_id=${dto.notice_id}"><button class="btn btn-secondary" type="button" value="삭제하기">삭제하기</button></a>&nbsp;&nbsp;
     
     
     
  </div>
</div>
<!-- 
<div class="container-lg mt-1">
<form id="comment-form">
    <div class="form-group">
        <label for="author">작성자</label>
        <input type="text" class="form-control" id="author" required></input>
        </div>
    </div>
    <div class="form-group">
        <label for="content">내용</label>
        <textarea class="form-control" id="content" name="content" required></textarea>
    </div>
    <button type="submit" class="btn btn-primary">댓글 작성</button>
</form>
 -->

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>