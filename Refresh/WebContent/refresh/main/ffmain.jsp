<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
	<center>
		<table>
			<tr>
				<td><tiles:insert attribute="header"/></td>
			</tr>
		</table>
	</center>
	</header>
	<center>
		<h3></h3>
		<hr>
		<table border="1" width="100%">
			<tr>
				<td><tiles:insert attribute="body"/></td>
			</tr>
		</table>
	</center>
	<footer>
		<table>
			<tr>
				<td><tiles:insert attribute="footer"/></td>
			</tr>
		</table>
	</footer>
</body>
</html>