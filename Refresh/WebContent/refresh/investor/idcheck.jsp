<%@page import="com.refresh.dao.InvestorDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <script type="text/javascript">
  
  
      function idcheck(useid){
    	 if(fomatcheck(useid)){
    	  	  opener.document.getElementById("idmail").value=useid;
    		  window.close();
		}
      }
      function fomatcheck(id){
        var emailExp = /^[a-zA-Z0-9]{6,15}@[a-zA-Z]+\.[a-zA-Z]+$/g;
        if(emailExp.test(id)){
        	return true;
        }else{
        	return false;
        }
      }
      function idvalied(){
  		var id = document.getElementById("id").value;
  		if(id!=null&&id!=''){
			if(fomatcheck(id)){		
				document.getElementById("idmail_ck").innerHTML ='<font color="green"><small>확인 버튼을 눌러주세요!!</small></font>';
			}else{
				document.getElementById("idmail_ck").innerHTML ='<font color="red"><small>부적절한 메일 형식입니다!!</small></font>';
			}  				
  		}else{
  			document.getElementById("idmail_ck").innerHTML ='<font color="red"><small>메일을 입력해주세요!!</small></font>';
  		}
      }
  </script>
</head>
<body>
     <h4>아이디 확인</h4>
     <form method="post">
              이메일: <input type="text" name="id" id="id" onkeyup="idvalied()" onmouseout="idvalied()" onmouseover="idvalied()"> 
           <input type="submit" value="확인">
           <div id="idmail_ck"><small>이메일 확인</small></div>
     </form><br>
     <a href="javascript:self.close()">창닫기</a>
     <%
        if(request.getMethod().equals("POST")){
        	String idmail = request.getParameter("id");
        	//아이디에 대한 중복검사
        	InvestorDAO dao = new InvestorDAO();
        	if(dao.invesIdcheck(idmail)){//중복아이디 발견!!
        		out.print("<script>document.getElementById(\"idmail_st\").innerHTML ='<font color=\"red\"><small>이미 사용중인 메일입니다!!</small></font>';</script>");
        	}else{
        	    out.print("<script>idcheck('"+idmail+"');</script>");	
        	}
        }
     
     %> 
</body>
</html>