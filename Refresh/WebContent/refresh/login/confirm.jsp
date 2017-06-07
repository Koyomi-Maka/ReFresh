<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 로그인</title>
  <script type="text/javascript">
  function checkpass(){
	 var pass = document.passForm.mpass.value;//비밀번호폼에 입력된 패스
	 var dpass = '7937';
	 if(pass==dpass){
		 opener.confCheck();
		 window.close();
	 }else{
		 alert('권한이 없습니다.');
		 window.close();                                                                                       
	 }
  }
  </script>
</head>
<body>
<center>
   <h4>관리자 비밀번호 확인</h4>
  
  <form name="passForm">
  <table cellpadding="5">
    <tr>
    
      <td><input type="password" name="mpass"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="button" value="확인" onclick="checkpass()">
      </td>
    </tr>
    
  </table>
  </form>
  </center>
</body>
</html>