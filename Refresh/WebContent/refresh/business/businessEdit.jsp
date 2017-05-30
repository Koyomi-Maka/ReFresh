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
<table>
	<tr>
		<td colspan="2" align="center">기업회원가입</td>
	</tr>
	<tr>
		<td><input type="text" name="idbnum" value=${buis.idbnum} size=20 style="width: 250px; height: 45px" readonly></td>
		
	</tr>
	<tr>
		<td><input type="password" name="bpass1" placeholder="비밀번호" value=${buis.pass} size=15 maxlength="20" style="width: 250px;height: 45px"></td>
	</tr>
	<tr>
		<td><input type="password" name="bpass2" placeholder="비밀번호 Check" value=${buis.pass} size=15 maxlength="20" style="width: 250px;height: 45px"></td>
	</tr>
	<tr>
		<td><input type="text" name="bname" placeholder="회사명" value=${buis.bname} size=10 style="width: 250px;height: 45px"></td>
	</tr>
	<tr>
		<td><input type="text" name="ceoname"  placeholder="대표자명" value=${buis.ceoname} size=10 style="width: 250px;height: 45px"></td>
	</tr>
	<tr>
		<td><input type="text" name="btel"  placeholder="회사 전화번호" value=${buis.btel} size=4 maxlength="11"  style="width: 250px;height: 45px"></td>
	</tr>
	<tr>
		<td><input type="text" name="baddr"  placeholder="회사주소" value=${buis.baddr} style="width: 250px;height: 45px"></td>
	</tr>
	<tr>
		<td>
			<select name="bbank" value=${buis.bbank} style="height: 40px;">
				<option >==선택==</option>
				<option>국민은행</option>
				<option>신한은행</option>
				<option>우리은행</option>
				<option>하나은행</option>
				<option>농협</option>
			</select>
			<input type="text" name="bacc" value=${buis.bacc}  placeholder="회사계좌정보" size=18 style="width: 155px;height: 45px">
		</td>
	</tr>
	<tr >
		<td align="right">
			<input type="reset" value="수정취소">
			<input type="button" value="수정" onclick="">
         </td>
	</tr>
</table>
</center>


</body>
</html>