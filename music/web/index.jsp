<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 20/12/26
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <c:out value="userId:${sessionScope.user.userId}"></c:out><br/>
    <c:out value="userName:${sessionScope.user.userName}"></c:out><br/>
    <c:out value="password:${sessionScope.user.password}"></c:out><br/>
    <c:out value="email:${sessionScope.user.email}"></c:out><br/>
    <c:out value="birthday:${sessionScope.user.birthday}"></c:out><br/>
    <c:out value="isVIP:${sessionScope.user.isVIP}"></c:out><br/>
    <c:out value="createTime:${sessionScope.user.createTime}"></c:out><br/>
</body>
</html>

