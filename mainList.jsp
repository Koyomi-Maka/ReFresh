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
 <div id="header"><jsp:include page="/refresh/main/header.jsp"/></div>
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
 <div id="guide">
 <a name="guide"></a>
  <div class="w3-panel w3-blue">
  <h1>이용 안내</h1>
  </div>
  <ul>
   <li>펀드파이브에 프로젝트, 업데이트, 댓글 등 콘텐츠를 게시할 때에는, 아래 커뮤니티 운영원칙을 준수해주세요. <br>
      운영원칙을 어기는 사용자에 대해 펀드파이브는 경고 조치 또는 일시/영구적 계정 비활성화를 할 수 있습니다.
   </li>
   <li><p class="guideline">&nbsp;광고나 도배를 할 수 없습니다.</p></li>
   <li>프로젝트와 무관한 광고성 콘텐츠를 게시하거나 광고성 메시지를 보낼 수 없습니다. 후원자들을 호도하는 사기성 또는 
        유인성 콘텐츠, 임의로 후원자 수나 후원 금액을 늘리기 위한 허위 후원 또는 대량 자동 활동 역시 제재 대상입니다.</li>
   <li><p class="guideline">&nbsp;특정인 또는 소수자·약자를 비하할 수 없습니다.</p></li>
   <li>특정인을 지목·겨냥한 폭력적 표현이나 모욕을 게시할 수 없습니다. 특정인이 다른 펀드파이브 사용자인 경우에는 
      더욱 엄격하게 제재됩니다. <br><br>펀드파이브는 사회적 소수자 또는 약자에 대한 폭력이나 혐오를 조장하거나 지나치게 
      대상화한 콘텐츠를 용인하지 않습니다. 성별, 성적 정체성 및 지향, 인종, 종교, 출신 지역, 장애, 나이 등을 
      이유로 특정 집단 또는 계층을 비하하는 의도가 있다고 판단되는 프로젝트 또는 콘텐츠는 엄격히 금지됩니다.
</li>
   <li><p class="guideline">&nbsp;외설적인 내용을 게시할 수 없습니다.</p></li>
   <li>펀드파이브는 모든 연령대의 사용자가 이용하는 커뮤니티입니다. 따라서 방송통신심의위원회의 정보통신에 관한 심의규정과 
         인터넷내용등급서비스의 등급기준에 의거, 현행법상 미성년자에게 부적합한 콘텐츠는 업로드할 수 없습니다. 
         아동에 대한 성적 표현이나 강간·성적 폭력을 미화하는 표현은 더욱 엄격하게 금지됩니다.</li>
   <li><p class="guideline">&nbsp;타인, 다른 계정 또는 단체를 사칭할 수 없습니다.</p></li>
   <li style="padding-bottom:70px;">펀드파이브는 개인과 개인이 후원자와 진행자 등의 자격으로 만나 신뢰를 바탕으로 관계를 맺는 플랫폼입니다. 
     다른 이용자나 단체 등을 사칭하여 콘텐츠를 게시하거나 메시지를 보내는 등의 행위는 이러한 신뢰를 심각하게 저해할 수 있기에 금지됩니다.</li>
  </ul>
 </div>
  
</body>
</html>