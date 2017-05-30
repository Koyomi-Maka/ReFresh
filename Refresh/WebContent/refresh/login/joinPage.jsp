<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개인/기업 회원가입하기</title>
  <script type="text/javascript">
    function movePage2(page2){
    	if(page2=='inve'){
    		location.href="/Refresh/refresh/investor/investorJoin.jsp";
    	}else if(page2=='busi'){
    		location.href="/Refresh/refresh/business/businessJoin.jsp";
    	}
    }
  </script>
<!-- joinPage.jsp -->
</head>
<body>

 <center>
    <form method="post" action="join.do"><br><br><br><br>
	 <table cellpadding="10">
	 
		 
		  <tr>
		 
		  <th colspan="5" bgcolor="ffdddd" > 회원가입</th>
		  <th></th>
		  <th></th>
		  </tr>
		  <tr style="height: 30px;"></tr>
		  <tr>
		     <td><input type="button" value="개인회원" style="width: 80px; height: 100px;" onclick="movePage2('inve')"></td>
		     <td></td><td></td><td></td>
		     <td><input type="button" value="기업회원" style="width: 80px; height: 100px;" onclick="movePage2('busi')"></td>
		  
		  </tr>
		
	  
	  </table>
	
	  </form>
  </center>


</body>
</html>