<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>펀딩 수정폼</title>
<script type="text/javascript">

</script>

</head>
<body>
<form action="/refresh/fund/edit.do?action=upform" method="post">
	<center>
	<input  type="hidden" name = "pnum" value="${fund.pnum }">
	<table border="1">
		<tr>
			 <!-- <td rowspan="4" width="80"> <input type="file" name ="img" size = 30></td> -->
			<td><center>제목 : <input type="text" value="${fund.pname }" name="pname" size="15"></center></td>
			<td><center>회사명 : <input type="text" value="${fund.bname }" name="bname" size="14"></center></td>
		</tr>
		<tr>
			<td>마감일 : <input type="text" value="${fund.deadline }" name="deadline" size = "14"></td>
			<td>목표금액 : <input type="text" value="${fund.gmoney }" name="gmoney" size = "13"></td>
		</tr>
		<tr>
			<td>대표명 : <input type="text" value="${fund.ceoname }" name="ceoname" size = "14"></td>
			<td>최소투자액 : <input type="text" value="200" name="minmoney" size = "10"></td>
		</tr>
		<tr>
			<td>
				펀딩종류 : <select name="pu">
					<option>대출형</option>
					<option>지분투자형</option>
					<option>후원형</option>
					<option>기부형</option>
				</select>
			</td>
			<td>
				카테고리 : <select name="category">
					<option>가전제품</option>
					<option>서비스</option>
					<option>재능기부</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="3"><center><textarea rows="20" cols="70" name="fcontent">${fund.fcontent }</textarea></center></td>
		</tr>
		<tr>
		<td colspan="3">
			<center>
				<input type="submit" value="올리기">
				<input type="reset" value="취소">
			</center>
		</td>
		</tr>
		<tr>
		<td>
		<center>
		<div id="replyList"><%@ include file="../reply/replyView.jsp" %></div>
		</center>
		</td>
		</tr>
	</table>
	</center>
	</form>
</body>
</html>