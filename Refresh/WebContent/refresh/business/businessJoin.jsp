<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" scr=""></script>
<script type="text/javascript">

	function validCheck(){
		var idbnumExp = /^[0-9]{10};
		var passExp = /^[a-z0-9]{6,15}
		var telExp = /^[0-9]{11}
		var accExp = /^[0-9]{15}
		
		var f=document.frm;  
		var idbnum = f.idbnum.value;
		
		if(idbnum ==''){
			alert('사업자 등록번호를 입력하세요.');
			f.idbnum.focus();
		}else if(idbnum.length==10){ //사업자번호 10자리
           	alert(숫자 10자리만 입력해주세요(-사용불가));
           	f.idbnum.focus();
        }else if(f.bpass1.value == ''){//데이터내용 비교
        	alert('비밀번호를 입력하세요');
        	f.bpass.focus();
        }else if(f.bpass2.value === ''){//자료형 비교후 내용 비교
        	alert('비번입력!!');
        	f.bpass2.focus();
        }else if(f.bpass.value!=f.pass2.value){
            alert('비번이 일치하지 않습니다!!');
            f.bpass.value=''; f.bpass2.value='';
            f.bpass.focus();
        }else if(f.ceoname.value === ''){
        	alert('대표자명으르 입력하세요.');
        	f.ceoname.focus();
        }
        else if(f.btel.value === ''){
        	alert('전화번호를 입력하세요.');
        	f.btel.focus();
        }else if(f.baddr.value === ''){
        	alert('주소를 입력하세요.');
        	f.baddr.focus();
        }else if(f.bbank.value === ''){
        	alert('은행을 선택하세요.');
        	f.bbank.focus();
        }else if(f.bacc.value === ''){
        	alert('계좌번호를 입력하세요');
        	f.bacc.focus();
        }else{ f.submit(); }
	}//validCheck
</script>
</head>
<body>

<center>
<table >
	<tr>
		<td><input type="text" name="idbnum" placeholder="사업자번호_ID()" 
			 size=20 style="width: 175px;height: 45px"  readonly>
		<input type="button" value="중복확인" style="width: 75px; height: 40px"></td>
		
	</tr>
	<tr>
		<td><input type="password" name="bpass1" placeholder="비밀번호" size=15 maxlength="20" style="width: 250px;height: 45px"></td>
	</tr>
	<tr>
		<td><input type="password" name="bpass2" placeholder="비밀번호 확인" size=15 maxlength="20" style="width: 250px;height: 45px"></td>
	</tr>
	<tr>
		<td><input type="text" name="bname" placeholder="회사명" size=10 style="width: 250px;height: 45px"></td>
	</tr>
	<tr>
		<td><input type="text" name="ceoname"  placeholder="대표자명" size=10 style="width: 250px;height: 45px"></td>
	</tr>
	<tr>
		<td><input type="text" name="btel"  placeholder="회사 전화번호" size=4 maxlength="11"  style="width: 250px;height: 45px"></td>
	</tr>
	<tr>
		<td><input type="text" name="baddr"  placeholder="회사주소"  style="width: 250px;height: 45px"></td>
	</tr>
	<tr>
		<td>
			<select style="height: 40px; width: 80px">
				<option >선택</option>
				<option>국민은행</option>
				<option>신한은행</option>
				<option>우리은행</option>
				<option>하나은행</option>
				<option>농협</option>
			</select>
			<input type="text" name="bacc"  placeholder="회사계좌정보" size=18 style="width: 168px;height: 45px">
		</td>
	</tr>
	<tr >
		<td align="right">
			<input type="reset" value="취소">
			<input type="button" value="등록" onclick="validCheck()">
         </td>
	</tr>
</table>
</center>


</body>
</html>