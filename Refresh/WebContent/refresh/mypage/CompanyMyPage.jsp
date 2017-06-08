<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="body_style.css">
<title>FundFive</title>
<style type="text/css">
#meni{
 
 margin-bottom:60px;
}
 #meni ul {
   list-style-type:none;
 }
 #meni li {
 float: left;
 }
</style>


</script>


</head>
 
<body>
 <div id="header2(logout)"><jsp:include page="header2(logout).jsp"/></div>
 <!-- header -->
  <div id="main">
  
  <br/>
   <div id="menu" style="font-size:24px">
    <ul>
     <li><a href="">전체</a></li>
     <li><a href="">카테고리</a></li>
     <li><a href="">투자</a></li>
     <li><a href="">리워드</a></li>
    </ul>
  
   </div>
  <div id="meni" style="font-size:22px;">
  <ul>
  
  
  <table border="1" cellpadding="1">
      <tr class="td">
         <th width="100"><font size=5>회사명</font></th>
         <th><input type="text" size="5" readonly="readonly" value="${bname }"></th>
         <th width="100">회사번호</th>
         <th><input type="text" readonly="readonly" value="${idbnum }"></th>
        </tr>
     <c:forEach items="${list }" var="funding">
      <tr>
         <td>${funding.iname }</td>
         <td>${funding.idmail }</td>
      </tr>
     </c:forEach> 
    </table>
    
  </ul>
  </div>
   <body>
     <h3> ★ 크라우드 펀딩 : 투자 리스트</h3>
 
    <table border="1" cellpadding="5">
      <tr class="td">
         <th>펀딩번호</th>
         <th width=200>펀딩명</th>
         <th width=80>작성일</th>
         <th width=80>마감일</th>
         <th width=200>목표금액</th>
         <th width=200>현재모금액</th>
         <th width=300>내용</th>
         
        </tr>
     <c:forEach items="${PersonMyPage }" var="funding">
      <tr>
         <td><a href="/Refresh/d ${funding.id }">${funding.pnum }</a></td>
         
         <!-- 경로설정은 잠시 보류. 지욱씨(관리자페이지 -> 펀딩), 경준씨(메인 -> 펀딩)와 경로가 같아야 함 -->
         
         <td>${funding.pname }</td>
         <td>${funding.fdate }</td>
         <td>${funding.deadline }</td>
         <td>${funding.gmoney }</td>
         <td>${funding.cmoney }</td>
         <td>${funding.fcontent }</td>
      </tr>
     </c:forEach> 
    </table>
  
</body>
</html>



