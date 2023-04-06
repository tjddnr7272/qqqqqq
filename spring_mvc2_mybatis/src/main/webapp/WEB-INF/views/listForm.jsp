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
  <div class="container-lg m">
  
    <h5 class="p-3 mb-2 bg-primary text-white rounded mb-4">공지사항</h5>

<div class="d-flex justify-content-end">
  <div class="form-group me-2">
    <select class="form-select" id="exampleSelect1">
         <option>제목</option>
           <option>내용</option>
           <option>작성자</option>
    </select>
  </div>


  <form class="d-flex">
  <input class="form-control me-sm-2" name="searchKeyword" type="search" placeholder="Search">
  <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
</form>
  
</div>

  
  <div class="mb-3 ms-2" style="font-size: 1rem;">
  

</div>


  <table class="table table-hover text-center">
    <thead>
      <tr class="table-active">
        <th scope="col-1">번호</th>
        <th scope="col-5">제목</th>
        <th scope="col-2">작성자</th>
        <th scope="col-3">작성날짜</th>
        <th scope="col-1">조회수</th>
      </tr>
      
    </thead>
     <tbody>
     <c:forEach var="dto" items="${ list }">
     <tr>
     <td scope="col-1"> ${ dto.notice_id } </td>
     
     
        <td scope="col-5">
        <a href="contentForm?notice_id=${dto.notice_id}"> ${ dto.notice_title } </a>
        </td>
        
        <td scope="col-2">
        관리자 </td>
        <td scope="col-3">
        
        <c:set var="dateVar" value="${ dto.notice_date }"/>
        <fmt:formatDate value="${dateVar}" pattern="yyyy-MM-dd" />
         
         </td> 
        
        <td scope="col-1">${ dto.notice_hit } </td>
     </tr>
     </c:forEach>
      
    
   
  </tbody>
  </table>
  

  <div>
  
 


  
  
  


</ul>
  </div>
</div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>