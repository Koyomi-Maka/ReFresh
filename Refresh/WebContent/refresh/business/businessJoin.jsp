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
			document.getElementById("bidnumCheck").innerHTML = "<font color='Red'>사업자번호(ID)를 입력하세요</font>"; 
		}
 	}
	
	function passCheck(){ //비밀번호,비밀번호 체크 일치불일치
		idbnumCheck();
		 var bpass1 = document.getElementById("bpass1").value; 
		 var bpass2 = document.getElementById("bpass2").value; 
		 if(bpass1==null||bpass1==''){
		      document.getElementById("bpassCheck").innerHTML = "<font color='red'>비밀번호를 입력하세요</font>"; 		     		
		  }else{
			 if(bpass1!=bpass2){ 
		  	  	document.getElementById("bpassCheck").innerHTML = "<font color='Red'>비밀번호 불일치!</font>"; 
			 }else if(bpass1==bpass2){ 
		    	document.getElementById("bpassCheck").innerHTML = "<font color='green'>비밀번호 일치!</font>"; 
		 	}
		 }
	}
	
	function nameCheck(){ //회사명 null
		passCheck();
		var bname = document.getElementById("bname").value;
		if(bname==null||bname==''){
			document.getElementById("bnameCheck").innerHTML = "<font color='Red'>회사명을 입력하세요</font>"; 
		}	
	}
		
	function ceonameCheck(){ //대표자명 null
		nameCheck();
		var ceoname = document.getElementById("ceoname").value;	
		if(ceoname==null||ceoname==''){
			document.getElementById("ceonameCheck").innerHTML = "<font color='Red'>대표자명을 입력하세요</font>"; 
		}
	} 	
	
	function btelCheck(){ //회사전화번호 null
		ceonameCheck();
		var btel = document.getElementById("btel").value;
		if(btel==null||btel==''){
			document.getElementById("btelCheck").innerHTML = "<font color='Red'>전화번호를 입력하세요</font>"; 
		}	
	}
		
	function baddrCheck(){ //주소 null
		btelCheck();
		var baddr = document.getElementById("baddr").value;	
		if(baddr==null||baddr==''){
			document.getElementById("baddrCheck").innerHTML = "<font color='Red'>주소를을 입력하세요</font>"; 
		}
	} 	
	function bbankCheck(){ //은행 null
		bbankCheck();
		var bbank = document.getElementById("bbank").value;
		if(bbank==null||bbank==''){
			document.getElementById("bbankCheck").innerHTML = "<font color='Red'>은행을 선택하세요</font>"; 
		}else if(bacc==null||bacc==''){
			document.getElementById("bbankCheck").innerHTML = "<font color='Red'>계좌를 입력하세요</font>"; 			
		}
	}
			
	
</script>
</head>
<body>

<center>
<form action="" method="POST">
<table >
	<tr>
		<td colspan="2" align="center">기업회원가입</td>
	</tr>
	<tr>
		<td><input type="text" name="idbnum" placeholder="사업자번호_ID" 
			 size=20 style="width: 175px;height: 35px" id="idbnum" readonly>
		<input type="button" value="중복확인" style="width: 75px; height: 35px"></td>
	</tr>
	<tr>
		<td><div id="bidnumCheck" style="height: 25px"></div></td>
	</tr>
	<tr>
		<td><input type="password" id="bpass1" onfocus="idbnumCheck()" name="bpass1" placeholder="비밀번호" size=15 maxlength="20" style="width: 250px;height: 35px"></td>
	</tr>
	<tr>
		<td><input type="password" id="bpass2" name="bpass2" onkeyup="passCheck()" placeholder="비밀번호 확인" size=15 maxlength="20" style="width: 250px;height: 35px"></td>
	</tr>
	<tr>
		<td><div id="bpassCheck"></div></td>
	</tr>
</table>
</form>

<form action="" method="POST">
<table>
	<tr>
		<td><input type="text" name="bnum" readonly="readonly"  placeholder="기업회원번호" size=10 style="width: 250px;height: 35px"></td> <!-- 기업회원_번호 -->
	</tr>
	<tr>
		<td><input type="text" id="bname"name="bname" onfocus="passCheck()"  placeholder="회사명" size=10 style="width: 250px;height: 35px"></td>
	</tr>
	<tr>
		<td><div id="bnameCheck"></div></td>
		</tr>
	<tr>
		<td><input type="text" id="ceoname" name="ceoname" onfocus="nameCheck()"  placeholder="대표자명" size=10 style="width: 250px;height: 35px"></td>
	</tr>
	<tr>
		<td><div id="ceonameCheck"></div></td>
		</tr>
	<tr>
		<td><input type="text" name="btel" ID="btel" onfocus="ceonameCheck()" placeholder="회사 전화번호" size=4 maxlength="11"  style="width: 250px;height: 35px"></td>
	</tr>
	<tr>
		<td><div id="btelCheck"></div></td>
		</tr>
	<tr>
		<td><input type="text" id="baddr" name="baddr" onfocus="btelCheck()"  placeholder="회사주소"  style="width: 250px;height: 35px"></td>
	</tr>
	<tr>
		<td><div id="baddrCheck"></div></td>
		</tr>
</table>
</form>

<form action="" method="POST">
<table>
	<tr>
		<td>
			<select id="bbank" style="height: 35px; width: 80px" onfocus="baddrCheck()" > 
				<option >==은행==</option>
				<option>국민은행</option>
				<option>신한은행</option>
				<option>하나은행</option>
				<option>우리은행</option>
				<option>우체국</option>
				<option>농협</option>
			</select>
			<input type="text" id="bacc" name="bacc"  placeholder="회사계좌정보" size=18 style="width: 168px;height: 35px">
		</td>
	</tr>
	<tr>
		<td><div id="bbankCheck"></div></td>
		</tr>
	<tr >
		<td align="right">
			<input type="reset" value="취소">
			<input type="button" value="등록">
         </td>
	</tr>
</table>
</form>
</center>


</body>
</html>