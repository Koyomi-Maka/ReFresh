<%@page import="com.refresh.dto.Reply"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>입력폼</title>
<link rel="stylesheet" type="text/css" href="../css/guest.css">
</head>
<%-- adminpage.jsp --%>
<body>
	<center>
	<h2><관리자페이지></h3>
		<table border="3" cellpadding="3" width="100%"  height="700">
			 <tr bgcolor="eeffcc" height="40" >
				<th>개인/기업회원관리</th>
				<th>게시판관리</th>
				<th>댓글관리</th>
			</tr>

			<tr>
				<td>
					<center>
					
						<table border="1" cellpadding="5">
								<th width="50">번호</th>
								<th width="80">개인회원</th>
								<th width="80">email</th>
							</tr>
							<c:forEach items="${investor_list }" var="investor">
								<tr>
									<!-- DB에 저장된 개인정보list받아오기 -->
									<td>${investor.inum } </td>
									<td>${investor.iname}</td>
									<td><a href="/Refresh/fund?action=investoredit&rnum=${inverstor.inum }">${investor.idmail }</a></td>
								</tr>
							</c:forEach>
						</table>
					</center>
				</td>

				<td rowspan="2">
					<center>
						<table border="1" cellpadding="5">
							<tr class="td">
								<th width="50">번호</th>
								<th width="100">펀딩명</th>
								<th width="60">등록일</th>
								<th width="60">달성률</th>
							</tr>

							<c:forEach items="${funding_list }" var="funding">
								<tr>
									<td>${funding.pnum }</td>
									<td>${funding.pname }</td>
									<td>${funding.fdate }</td>
									<td><a
										href="/TomTest/guest/control?action=fundingedit&id=${funding.pnum }">${funding.rate }</a></td>
								</tr>
							</c:forEach>
						</table>
					</center>
				</td> 


				<td rowspan="2">
					<center>
						<table border="1" cellpadding="5">
							<tr class="td">
								<th width="50">번호</th>
								<th width="60">작성자</th>
								<th width="60">작성일</th>
								<th width="150">댓글내용</th>
							</tr>
							<c:forEach items="${reply_list }" var="reply">
								<tr>
									<td>${reply.rnum }</td>
									<td>${reply.rname }</td>
									<td>${reply.rdate }</td>
									<td><a
										href="/Refresh/fund?action=replyedit&rnum=${reply.rnum }">${reply.rcontent }</a></td>
								</tr>
							</c:forEach>
						</table>
					</center>
				</td>
			</tr>
			 <tr>
				<td>
					<center>
						<table border="1" cellpadding="5">
							<tr class="td">
								<th width="50">번호</th>
								<th width="80">기업회원</th>
								<th width="80">회사번호</th>
							</tr>
							<c:forEach items="${business_list }" var="business">
								<tr>
									<td>${business.bnum }</td>
									<td>${business.bname}</td>
									<td><a href="/Refresh/fund?action=businessedit&id=${business.bnum }">${investor.btel }</a></td>
								</tr>
							</c:forEach>
						</table>
					</center>
				</td>
			</tr> 
		</table>
	</center>
</body>
</html>





