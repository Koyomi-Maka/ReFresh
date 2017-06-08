<%@page import="com.refresh.dao.BusinessDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function validCheck(id){
		var idExp = /^[\d]{10}$/g;
		
		if(!idExp.test(id)){
			return true;
		}else{
			return false;
		}
	}

	
	/* function empCheck(id){
		
	} */
	
	function empButton(){
		var id = document.getElementById("id").value;
		var idC = document.bIdCheck.id.value;
		var button = document.getElementById("idcheckButton");
		if(idC == ""||idC==''){
			document.getElementById("idresult").innerHTML = "<font color='red'><small>값을 입력 하세요.<small></font>";
		}else if(id==null||id==''){
			document.getElementById("idresult").innerHTML = "<font color='red'><small>사업자 번호를 입력하세요<small></font>";
		}else if(validCheck(id)){
			document.getElementById("idresult").innerHTML = "<font color='red'><small>사업자번호를 정확히 입력해주세요<small></font>"; 
		}else if(id.length == 10){
			document.getElementById("idresult").innerHTML = "";	
		}else{
			document.bIdCheck.submit();
		}
	}
		
</script>
</head>
<body>
<h4>아이디 확인</h4>
	<hr>
     <form method="post" name="bIdCheck" action="/Refresh/idCheck.do">
           아이디: <input type="text" name="id" id="id" onkeypress="empButton()" maxlength="10"> 
           <input type="submit" onclick="empButton()" value="중복확인">
     </form><br>
     <center><div id="idresult"></div></center>
     

</html>