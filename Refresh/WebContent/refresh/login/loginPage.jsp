<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인폼</title>
  <script type="text/javascript">
    function movePage(page){
    	
    	document.frm.action='/Refresh/login/login.do?login='+page;//?login=login1
    	document.frm.submit();
    	
    	if(page=='join'){
    		location.href="join.do";
    	}
    	/* if(page=='login'){
    		location.href="/Refresh/login/login.do";
    	}else if(page=='join'){
    		location.href="join.do";
    	} */
     }
    
    function check(){
    	window.open('/Refresh/refresh/login/confirm.jsp','관리자 로그인','width=300,height=150');
    }
    function confCheck(){
        location.href="/Refresh/refresh/mypage/adminPage.jsp";
    }

  </script>
<!-- loginPage.jsp -->
</head>
<body>
 <center>

	 <form name="frm" method="post" action="/Refresh/login/login.do"><br><br><br><br>
	 <table cellpadding="10">
	 
		  <tr>
			    <th bgcolor=ffdddd width=40%>개인회원</th>
			    <th width=20%></th>
			    <th bgcolor=ffdddd wdith=40%>기업회원</th>
		  </tr>
		  <tr>
			    <td>
			     아이디 <br><input name="idmail" placeholder="이메일 주소 입력" type="text" /> <br><br>
			   비밀번호<br> <input name="ipass" placeholder="비밀번호 입력" type="password" />
			            
		       </td>
			   <td></td>
			   <td>
			    아이디 <br><input name="idbnum" placeholder="회사번호 입력" type="text" /> <br><br>
			   비밀번호<br> <input name="bpass" placeholder="비밀번호 입력" type="password" />
			            
			   </td>
		  </tr>
		  <tr>
		       <td align="right">
		       <input align="right" type="submit" value="로그인" onclick="movePage('login1')"/><br>
		       <input align="right" type="button" value="회원가입 하기" onclick="movePage('join')" /> 
		       
		       </td>
	            <td></td>
	           <td  align="right">
	           <input align="right" type="submit" value="로그인" onclick="movePage('login2')"/><br>
	           <input align="right" type="button" value="회원가입 하기" onclick="movePage('join')" />
	           
	           </td>
	      </tr>
	      
	  </table>
	  <br>
	  
	  <input type="button" value="관리자 로그인" onclick="check()">
	
	  </form>
  </center>
  </body>
  </html>