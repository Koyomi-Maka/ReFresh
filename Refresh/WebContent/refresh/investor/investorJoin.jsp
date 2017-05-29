<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<table  width="350" border="1" align="center" cellpadding="4" cellspacing="5">
  <tbody>
    <tr>
      <td>
      <form action="" method="post">
      <table width="300" border="2" align="center" cellpadding="5" cellspacing="6">
  <tbody>
    <tr>
      <td><input type="text" name="" placeholder="이메일" size="25" maxlength="30" readonly  style="width: 186px; "><input type="button" value="중복확인" style="width: 66px; "></td>
    </tr>
    <tr>
      <td><input type="password" name="" placeholder="비밀번호" size="25" maxlength="30"></td>
    </tr>
    <tr>
      <td><input type="password" name="" placeholder="비밀번호 확인" size="25" maxlength="30"></td>
    </tr>
  </tbody>
</table>
      </form>
      </td>
    </tr>
    <tr>
      <td><table width="300" border="2" align="center" cellpadding="5" cellspacing="6">
  <tbody>
    <tr>
      <td><input type="text" placeholder="이름" size="25" maxlength="30"></td>
    </tr>
    <tr>
      <td><input type="text" size="25" readonly  placeholder="회원번호"></td>
    </tr>
    <tr>
      <td><input type="tel" placeholder="Tel" size="5" maxlength="3">-<input type="tel" size="6" maxlength="4">-<input type="tel" size="6" maxlength="4"></td>
    </tr>
  </tbody>
</table>
</td>
    </tr>
    <tr>
      <td>
      <table width="300" border="2" align="center" cellpadding="5" cellspacing="6">
  <tbody>
    <tr>
      <td width="100" align="center" valign="middle"> 
      <select>
        <option>=은행=</option>
        <option>국민은행</option>
        <option>신한은행</option>
        <option>하나은행</option>
        <option>우리은행</option>
        <option>우체국</option>
        <option>농협</option>
      </select> </td>
      <td width="200" align="center" valign="middle"><input type="text" placeholder="계좌번호"></td>
    </tr>
  </tbody>
</table>
</td>
    </tr>
    <tr>
      <td><table width="300" border="1" align="center" cellpadding="5" cellspacing="6">
  <tbody>
    <tr>
     
      <td align="center" valign="middle"><input type="submit" value="가입"></td>
      <td align="center" valign="middle"><input type="reset" value="취소" onclick="history.back()"></td>
    </tr>
  </tbody>
</table>
</td>
    </tr>
  </tbody>
</table>
</center>
</body>
</html>