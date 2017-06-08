<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function passCheck(){
		var valpass = /^[A-Za-z0-9]{8,15}$/g;        
	
		var pass = document.getElementById("ipass").value;
		var passck = document.getElementById("ipassck").value;
		if(pass!=null&&pass!=''){
			if(pass==passck){
				if(valpass.test(pass)){	
					document.getElementById("pass_st").innerHTML ='<font color="green"><small>Check!!</small></font>';
				}else{
					document.getElementById("pass_st").innerHTML ='<font color="red"><small>비밀번호 보안취약!!</small></font>';					
				}
			}else{
				document.getElementById("pass_st").innerHTML ='<font color="red"><small>비밀번호 불일치!!</small></font>';
			}
	  	}	
	}
	function phoneCheck(){
		passCheck();
		var phone = document.getElementById("iphone").value;
		if(phone!=null&&phone!=''){
			document.getElementById("iphone_st").innerHTML ='<font color="green"><small>Check!!</small></font>';
		}
	}
	function payCheck(){
		phoneCheck();
		var pay = document.getElementById("ipay").value;
		if(pay!=null&&pay!=''){
				document.getElementById("ipay_st").innerHTML ='<font color="green"><small>Check!!</small></font>';		
		}
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
         <td><input type="text" name="idname" id="idname" placeholder="이메일"  maxlength="30" readonly  style="width: 260px;height:30px" value="${ investor.idmail}"></td>
        </tr>
        <tr>
         <td><input type="password" name="ipass" id="ipass" placeholder="비밀번호" maxlength="30" onkeyup="passCheck()" style="width: 260px;height:30px" value="${ investor.ipass}"></td>
        </tr>
        <tr>
         <td><input type="password" name="ipassck" id="ipassck" placeholder="비밀번호 확인" maxlength="30" onkeyup="passCheck()" style="width: 260px;height:30px" value="${ investor.ipass}"></td>
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
        <td><input type="text"  readonly  placeholder="회원번호" style="width: 260px;height:30px" value="${ investor.inum}"></td>
       </tr>
       <tr>
        <td><input type="text" placeholder="이름" id="iname" maxlength="30" style="width: 260px;height:30px" readonly value="${ investor.iname}"></td>
       </tr>
      <tr>
       <td><input type="text" placeholder="전화번호" id="iphone" onfocus="phoneCheck()" onkeyup="phoneCheck()" maxlength="11" style="width: 260px;height:30px" value="${ investor.iphone}"></td>
      </tr>
        <tr>
			<td style="width: 260px;height:10px"><div id="iphone_st"><small>전화번호 확인</small></div></td>
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
          <select id="ibank" name="ibank" onchange="payCheck()" style="width: 100px;height:30px">
           <option value="bank">=은행=</option>
           <option value="kb">국민은행</option>
           <option value="sh">신한은행</option>
           <option value="hn">하나은행</option>
           <option value="wr">우리은행</option>
           <option value="po">우체국</option>
           <option value="nh">농협</option>
          </select></td>
         <td align="center" valign="middle" ><input name="ipay" id="ipay" type="text" onkeyup="payCheck()" placeholder="계좌번호"  style="width: 220px;height:30px" value="${ inves.ipay}"></td>
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
         <td align="center" valign="middle"><input type="button" value="가입"></td>
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