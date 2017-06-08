<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/Refresh/refresh/main/header_style.css">
 <%-- 로고 --%>
<div id="header">
 <span class="image">
 <a href=""><img src="" width=200px height=100px/></a></span>
 <span class="span"><a href="/Refresh/refresh?action=main">투자하기</a></span>
 <span class="span"><a href="">투자받기</a></span>
 <span class="span"><a href="/Refresh/refresh?action=main#guide">이용안내</a></span>
 <% 
  String login = (String) session.getAttribute("login");
  if(login==null || login.equals("fail")){ %>
 <span class="join"><a href="/Refresh/refresh/login/loginPage.jsp" style="text-decoration: none;">로그인</a>
                    <font color="black">/</font>
                    <a href="/Refresh/refresh/login/joinPage.jsp" style="text-decoration: none;">회원가입</a></span>
 <% }else if(login.equals("inve")){ %>
 <span class="space"><a href="/Refresh/refresh?action=logout">로그아웃</a></span>
 <span class="space"><a href="/Refresh/refresh?action=mypage">마이페이지</a></span>
 <% }else if(login.equals("busi")){ %>
 <span class="space"><a href="/Refresh/refresh?action=logout">로그아웃</a></span>
 <span class="space"><a href="/Refresh/refresh?action=mypage">마이페이지</a></span>
 <% } %>
</div>