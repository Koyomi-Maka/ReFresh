<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/Refresh/refresh/main/body_style.css">

<title>FundFive</title>

</head>
<body>
 <!-- header -->
  <div id="main">
   <div class="container">
      <a href="/Refresh/refresh?action=main&sort=close" style="font-size:24px;">마감 직전 프로젝트</a>
      <a href="/Refresh/refresh?action=main&sort=ended" style="font-size:24px;">종료된 프로젝트</a>
     <!-- 진행 상태 -->
    <div class="dropdown">
     <button class="dropbtn">카테고리</button>
      <div class="dropdown-content">
       <a href="/Refresh/refresh?action=main&sort=all&page=1">전체</a>
       <a href="/Refresh/refresh?action=main&sort=it&page=1">인터넷 서비스</a>
       <a href="/Refresh/refresh?action=main&sort=culture&page=1">문화</a>
       <a href="/Refresh/refresh?action=main&sort=design&page=1">디자인</a>
       <a href="/Refresh/refresh?action=main&sort=product&page=1">제조/유통</a>
      </div>
     </div> <!-- 카테고리 -->
    <span style="color:#eeeeee; font-size:24px; 
          padding-right: 14px; float:right;">${page } Page</span> 
   </div> 
  <!-- 메뉴 종료 -->
   <div>
   <div class="w3-display-left w3-jumbo" style="margin-left:16px; margin-top:90px;">
    <c:if test="${page!=1 }">
     <a href="/Refresh/refresh?action=main&sort=${sort }&page=${page-1}">
      <button id="left" class="w3-teal"><i class="fa fa-arrow-left"></i></button>
     </a>
   </c:if>
   </div>
   <div class="w3-display-right w3-jumbo" style="margin-right:16px; margin-top:90px;">
   <c:if test="${page!= totalPage}">
     <a href="/Refresh/refresh?action=main&sort=${sort }&page=${page+1}">
      <button id="right" class="w3-teal"><i class="fa fa-arrow-right"></i></button>
     </a>
   </c:if>
   </div>
    <table width="100%" class="pages">
    <tr>
    <c:forEach var="i" items="${list }" varStatus="stat">
     <td colspan="2" id="title${stat.count }" class="title">${i.pname }</td>
    </c:forEach>
    </tr>
    <tr>
    <c:forEach var="i" items="${list }" varStatus="stat">
     <td colspan="2" id="gmoney${stat.count }" class="list">목표금액 : ${i.gmoney }원</td>
    </c:forEach>
    </tr>
    <tr>
    <c:forEach var="i" items="${list }" varStatus="stat">
     <td colspan="2" id="cmoney${stat.count }" class="list">총 후원액 : ${i.cmoney }원</td>
    </c:forEach>
    </tr>
    <tr>
     <c:forEach var="i" items="${list }" varStatus="stat">
      <td colspan="2" id="rate${stat.count }" class="list">
                달성률 : ${i.rate }%
      </td>
     </c:forEach>
    </tr>
    <tr>
     <c:forEach var="i" items="${list }" varStatus="stat">
      <td id="deadline${stat.count }" class="list">종료일 : ${i.deadline }</td>
      <td style="text-align:center;">진행 중/종료(state)</td>
     </c:forEach>
    </tr>
    </table>
   </div>
   
   <br>
   <center>
   <div id="navi">
   <c:if test="${startPage!=1 }">
    <a href="/Refresh/refresh?action=main&sort=${sort }&page=${startPage-5}">&laquo;</a>
   </c:if>
    <c:forEach var="i" begin="${startPage }" end="${endPage }">
     <c:if test="${page == i}">
      <span class="now">${i }</span>
     </c:if>
     <c:if test="${page!=i}">
      <a href="/Refresh/refresh?action=main&sort=${sort }&page=${i}">${i }</a>
     </c:if>
    </c:forEach>
    <c:if test="${endPage < totalPage}">
     <a href="/Refresh/refresh?action=main&sort=${sort }&page=${endPage+1}">&raquo;</a>
    </c:if>
   </div>
   </center>
  </div>
 <!-- main -->
 
</body>
</html>