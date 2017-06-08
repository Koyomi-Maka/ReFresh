<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<header>
	<center>
		<table>
			<tr>
				<td><tiles:insert attribute="header"/></td>
			</tr>
		</table>
	</center>
</header>
<body>
	<center>
	<hr>
	<hr>
	<hr>
	
		<table>
			<tr>
				<td><tiles:insert attribute="body"/></td>
			</tr>
		</table>
	</center>
</body>
</html>