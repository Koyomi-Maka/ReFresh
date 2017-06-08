<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	
	function idbnumCheck(){ //사업자번호 null
		var idbnum = document.getElementById("idbnum").value;
		if(idbnum==null||idbnum==''){
		  document.getElementById("bidnumCheck").innerHTML = "<font color='red'><small>아이디를 입력하세요<small></font>"; 		     		
		}
 	}
	
	function passCheck(){ //비밀번호,비밀번호 체크 일치불일치
		idbnumCheck();
		 var bpass1 = document.getElementById("bpass1").value; 
		 var bpass2 = document.getElementById("bpass2").value; 
		 if(bpass1==null||bpass1==''){
		      document.getElementById("bpassCheck").innerHTML = "<font color='red'><small>비밀번호를 입력하세요<small></font>"; 		     		
		  }else{
			 if(bpass1!=bpass2){ 
		  	  	document.getElementById("bpassCheck").innerHTML = "<font color='Red'><small>비밀번호 불일치!<small></font>"; 
			 }else if(bpass1==bpass2){ 
		    	document.getElementById("bpassCheck").innerHTML = "<font color='green'><small>비밀번호 일치!<small></font>"; 
		 	}
		 }
	}
	
	function nameCheck(){ //회사명 null
		passCheck();
		var bname = document.getElementById("bname").value;
		if(bname==null||bname==''){
			document.getElementById("bnameCheck").innerHTML = "<font color='Red'><small>회사명을 입력하세요<small></font>"; 
		}	
	}
		
	function ceonameCheck(){ //대표자명 null
		nameCheck();
		var ceoname = document.getElementById("ceoname").value;	
		if(ceoname==null||ceoname==''){
			document.getElementById("ceonameCheck").innerHTML = "<font color='Red'><small>대표자명을 입력하세요<small></font>"; 
		}
	} 	
	
	function btelCheck(){ //회사전화번호 null
		ceonameCheck();
		var btel = document.getElementById("btel").value;
		if(btel==null||btel==''){
			document.getElementById("btelCheck").innerHTML = "<font color='Red'><small>전화번호를 입력하세요<small></font>"; 
		}	
	}
		
	function baddrCheck(){ //주소 null
		btelCheck();
		var baddr = document.getElementById("baddr").value;	
		if(baddr==null||baddr==''){
			document.getElementById("baddrCheck").innerHTML = "<font color='Red'><small>주소를을 입력하세요<small></font>"; 
		}
	} 	
	

	function bbankCheck(){ 
		baddrCheck();
		var bacc = document.getElementById("bacc").value;
		var bbank = document.getElementById("bbank").value;
		if(bbank.value('==은행==')){
			document.getElementById("bbankCheck").innerHTML = "<font color='Red'><small>은행을 선택하세요</small></font>"; 
		}else if(bacc==null||bacc.length==0){
			document.getElementById("bbankCheck").innerHTML = "<font color='Red'><small>계좌를 입력하세요<small></font>"; 			
		}
	}
			
	 function bIdCheck(){ //중복확인
	    	window.open('bIdCheck.jsp','confirm','width=350,height=170');
	     }
</script>
</head>
<body>
 <center>
	  <form action="../login/loginPage.jsp" method="POST">
  <table bgcolor="#009933"  width="380" border="0" align="center" cellpadding="4" cellspacing="5">
   <tbody>
	<tr>
	 <td>
	   <table bgcolor="#ffffff"  width="360" border="0" align="center" cellpadding="5" cellspacing="6">
		<tbody>
		<tr>
	 	 <td colspan="2" align="center">기업회원가입</td>
		</tr>
		<tr>
		 <td><input type="text" name="idbnum" placeholder="사업자번호_ID" style="width: 260px;height:30px" id="idbnum" readonly></td>
		 <td><input type="button" value="중복확인" style="width: 65px" onclick="bIdCheck()"></td>
		</tr>
		<tr>
		 <td style="width: 260px;height:10px"><div id="bidnumCheck"><small>사업자번호 확인</small></div></td>
		</tr>
		<tr>
		 <td><input type="password" id="bpass1" onfocus="idbnumCheck()" name="bpass1" placeholder="비밀번호"  maxlength="20" style="width: 260px;height: 30px"></td>
		</tr>
		<tr>
		 <td><input type="password" id="bpass2" name="bpass2" onkeyup="passCheck()" placeholder="비밀번호 확인"  maxlength="20" style="width: 260px;height: 30px"></td>
		</tr>
	    <tr>
		 <td style="width: 260px;height:10px"><div id="bpassCheck"><small>비밀번호 확인</small></div></td>
	    </tr>
	   </tbody>
	   </table>
     </td>
    </tr>
    <tr> 
     <td>
       <table  bgcolor="#ffffff" width="360" border="0" align="center" cellpadding="5" cellspacing="6">
	    <tr>
		 <td><input type="text" name="bnum" readonly="readonly"  placeholder="기업회원번호" style="width: 260px;height: 30px"></td> <!-- 기업회원_번호 -->
	    </tr>
	    <tr>
		 <td><input type="text" id="bname"name="bname" onfocus="passCheck()"  placeholder="회사명" style="width: 260px;height: 30px"></td>
	    </tr>
	    <tr>
		 <td style="width: 260px;height:10px"><div id="bnameCheck"><small>회사명 확인</small></div></td>
		</tr>
	    <tr>
		 <td><input type="text" id="ceoname" name="ceoname" onfocus="nameCheck()"  placeholder="대표자명" style="width: 260px;height: 30px"></td>
	    </tr>
	    <tr>
		 <td style="width: 260px;height:10px"><div id="ceonameCheck"><small>대표자명 확인</small></div></td>
		</tr>
	    <tr>
		 <td><input type="text" name="btel" ID="btel" onfocus="ceonameCheck()" placeholder="회사 전화번호"  maxlength="11"  style="width: 260px;height: 30px"></td>
	    </tr>
	    <tr>
		 <td style="width: 260px;height:10px"><div id="btelCheck"><small>회사전화번호 확인</small></div></td>
		</tr>
	    <tr>
		 <td><input type="text" id="baddr" name="baddr" onfocus="btelCheck()"  placeholder="회사주소"  style="width: 260px;height: 30px"></td>
	    </tr>
	    <tr>
		 <td style="width: 260px;height:10px"><div id="baddrCheck"><small>회사주소 확인</small></div></td>
		</tr>
       </table>
     </td>
    </tr>
    <tr>   
     <td>
       <table  bgcolor="#ffffff" width="360" border="0" align="center" cellpadding="5" cellspacing="6">
	    <tbody>
	    <tr>
		 <td align="center" valign="middle">
			<select id="bbank" style="width: 100px;height:30px" onkeydown="bbankCheck()"> 
				<option value="==은행==">==은행==</option>
				<option value="국민은행">국민은행</option>
				<option value="신한은행">신한은행</option>
				<option value="하나은행">하나은행</option>
				<option value="우리은행">우리은행</option>
				<option value="우체국">우체국</option>
				<option value="농협">농협</option>
			 </select>
		  </td>
		  <td align="center" valign="middle" >
			 <input type="text" id="bacc" onkeypress="bbankCheck()" name="bacc" placeholder="회사계좌정보" style="width: 220px;height:30px"  >
		  </td>
	     </tr>
	     <tr>
		  <td colspan="2" style="width: 260px;height:10px"><div id="bbankCheck"><small>계좌정보 확인</small></div></td>
	     </tr>
	     </tbody>
        </table>
      </td>
     </tr>
     <tr>
	  <td>

	  	 <table  bgcolor="#ffffff" width="360" border="0" align="center" cellpadding="5" cellspacing="6">
		  <tr>
		   <td align="center" valign="middle"><input type="submit" value="등록"></td>
		   <td align="center" valign="middle"><input type="reset" value="취소" onclick="history.back()"></td>
		  </tr>
		 </table>
	  </td>
     </tr>	
    </tbody>
   </table>
		</form>
  </center>
 </body>
</html>