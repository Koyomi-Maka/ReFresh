<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function idCheck(){
		var id = document.getElementById("idname").value;
		if(id!=null&&id!=''){
			document.getElementById("idmail_st").innerHTML ='<font color="green"><small>Check!!</small></font>';
		}else{
			document.getElementById("idmail_st").innerHTML ='<font color="red"><small>메일을 입력해주세요!!</small></font>';
		}
	}
	function passCheck(){
		idCheck();
		var pass = document.getElementById("ipass").value;
		var passck = document.getElementById("ipassck").value;
		if(pass==null||pass==''){
			document.getElementById("pass_st").innerHTML ='<font color="red"><small>비밀번호를 입력하세요!!</small></font>';
		}else{
			if(pass==passck){
				document.getElementById("pass_st").innerHTML ='<font color="green"><small>Check!!</small></font>';
			}else{
				document.getElementById("pass_st").innerHTML ='<font color="red"><small>비밀번호 불일치!!</small></font>';
			}
		}	
	}
	function nameCheck(){
		passCheck();
		var name = document.getElementById("iname").value;
		if(name!=null&&name!=''){
			document.getElementById("iname_st").innerHTML ='<font color="green"><small>Check!!</small></font>';
		}else{
			document.getElementById("iname_st").innerHTML ='<font color="red"><small>이름을 입력해주세요!!</small></font>';
		}
		
	}
	function phoneCheck(){
		nameCheck();
		var phone = document.getElementById("iphone").value;
		if(phone!=null&&phone!=''){
			document.getElementById("iphone_st").innerHTML ='<font color="green"><small>Check!!</small></font>';
		}else{
			document.getElementById("iphone_st").innerHTML ='<font color="red"><small>전화번호를 입력해주세요!!</small></font>';
		}
	}
	function payCheck(){
		
	}
	
</script>
</head>
<body>
<center>
 <table bgcolor="#009933"  width="380" border="0" align="center" cellpadding="4" cellspacing="5">
  <tbody>
   <tr>
    <td>
     <form  action="" method="post" name="invesInfo">
      <table bgcolor="#ffffff"  width="360" border="0" align="center" cellpadding="5" cellspacing="6">
       <tbody>
        <tr>
         <td><input type="text" name="idname" id="idname" placeholder="이메일"  maxlength="30" readonly  style="width: 260px;height:30px  ">
             <input type="button" value="중복확인" style="width: 65px; "></td>
        </tr>
        <tr>
			<td style="width: 260px;height:10px" ><div id="idmail_st"><small>이메일 확인</small></div></td>
        </tr>
        <tr>
         <td><input type="password" name="ipass" id="ipass" placeholder="비밀번호" maxlength="30" onfocus="idCheck()" onkeyup="passCheck()" style="width: 260px;height:30px"></td>
        </tr>
        <tr>
         <td><input type="password" name="ipassck" id="ipassck" placeholder="비밀번호 확인" maxlength="30" onfocus="idCheck()" onkeyup="passCheck()" style="width: 260px;height:30px"></td>
        </tr>
        <tr>
			<td><div id="pass_st"><small>비밀번호 확인</small></div></td>
        </tr>
       </tbody>
      </table>
     </form>
    </td>
   </tr>
   <tr>
    <td>
     <form action="" method="post">
     <table bgcolor="#ffffff" width="360" border="0" align="center" cellpadding="5" cellspacing="6">
      <tbody>
       <tr>
        <td><input type="text"  readonly  placeholder="회원번호" style="width: 260px;height:30px"></td>
       </tr>
       <tr>
        <td><input type="text" placeholder="이름" id="iname" maxlength="30" onfocus="nameCheck()" onkeyup="nameCheck()" style="width: 260px;height:30px"></td>
       </tr>
        <tr>
			<td style="width: 260px;height:10px"><div id="iname_st"><small>이름 확인</small></div></td>
        </tr>
      <tr>
       <td><input type="tel" placeholder="전화번호" id="iphone" onfocus="phoneCheck()" onkeyup="phoneCheck()" maxlength="11" style="width: 260px;height:30px"></td>
      </tr>
        <tr>
			<td><div id="iphone_st"><small>전화번호 확인</small></div></td>
        </tr>
     </tbody>
    </table>
    </form>
   </td>
  </tr>
  <tr>
     <td>
      <form action="" method="post">
      <table bgcolor="#ffffff" width="360" border="0" align="center" cellpadding="5" cellspacing="6">
       <tbody>
        <tr>
         <td align="center" valign="middle"> 
          <select style="width: 100px;height:30px">
           <option>=은행=</option>
           <option>국민은행</option>
           <option>신한은행</option>
           <option>하나은행</option>
           <option>우리은행</option>
           <option>우체국</option>
           <option>농협</option>
          </select></td>
         <td align="center" valign="middle" ><input type="text" placeholder="계좌번호"  style="width: 220px;height:30px" ></td>
        </tr>
        <tr>
			<td style="width: 260px;height:10px"><div id="ipay_st"><small>결제정보 확인</small></div></td>
        </tr>
       </tbody>
      </table>
      </form>
     </td>
    </tr>
    <tr>
      <td>
      <form action="" method="post">
      <table bgcolor="#ffffff" width="360" border="0" align="center" cellpadding="5" cellspacing="6">
       <tbody>
         <tr>
         <td align="center" valign="middle"><input type="submit" value="가입"></td>
         <td align="center" valign="middle"><input type="reset" value="취소" onclick="history.back()"></td>
    	</tr>
  	   </tbody>
	  </table>
	  </form>
	 </td>
    </tr>
   </tbody>
  </table>
 </center>
</body>
</html>