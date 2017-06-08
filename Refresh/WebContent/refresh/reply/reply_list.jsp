<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- reply_list.jsp 
    [
     {no:2,name:'길라임',content:'나두댓글'}
     ,
     {"no":"1","name":"홍길동","content":"첫댓글"}
    ]
--%>
[
<c:forEach items="${list }" var="reply" varStatus="stat">
    {"rnum":"${reply.rnum }","rname":"${reply.rname }","rcontent":"${reply.rcontent }","rdate":"${reply.rdate }"}
    <c:if test="${stat.count < list.size() }">,</c:if>
</c:forEach>
]
