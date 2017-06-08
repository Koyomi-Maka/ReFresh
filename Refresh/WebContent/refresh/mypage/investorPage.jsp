<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>FundFive</title>
 
<body>  
  <table border="1" cellpadding="1">
      <tr class="td">
         <th width="100"><font size=5>이름</font></th>
         <th><input type="text" size="5" readonly="readonly" value="${iname }"></th>
         <th width="100">E-MAIL</th>
         <th><input type="text" readonly="readonly" value="${idmail }"></th>
        </tr>
     <c:forEach items="${list }" var="funding">
      <tr>
         <td>${funding.iname }</td>
         <td>${funding.idmail }</td>
         
      </tr>
     </c:forEach> 
    </table>
    
  </ul>
  </div>
   <body>
     <h3> ★ 크라우드 펀딩 : 투자 리스트</h3>
 
    <table border="1" cellpadding="5">
      <tr class="td">
         <th>펀딩번호</th>
         <th width=200>펀딩명</th>
         <th width=80>작성일</th>
         <th width=80>마감일</th>
         <th width=200>목표금액</th>
         <th width=200>현재모금액</th>
         <th width=300>내용</th>
         
        </tr>
     <c:forEach items="${list }" var="funding">
      <tr>
         <td><a href="/Refresh/d ${funding.id }">${funding.pnum }</a></td>
                  
         <td>${funding.pname }</td>
         <td>${funding.fdate }</td>
         <td>${funding.deadline }</td>
         <td>${funding.gmoney }</td>
         <td>${funding.cmoney }</td>
         <td>${funding.fcontent }</td>
      </tr>
     </c:forEach> 
    </table>
  
</body>
</html>



