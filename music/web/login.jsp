<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 20/12/28
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
    <p>邮&nbsp&nbsp&nbsp箱：<input type="text" name="email" id="email" />${sessionScope.email}</p>
    <p>密&nbsp&nbsp&nbsp码：<input type="text" name="password" id="password" />${sessionScope.password}</p>
    <p><input type="submit" id="submit" value="提交" disabled="disabled" /></p>
</form>

<script src="./static/js/jquery-3.5.1.js"></script>

<script>
    $(function () {
        $('#email').blur(action);
        $('#password').blur(action);
    });
    function action() {
        if($('#email').val().toString() != "" && $('#password').val().toString() != "") {
            $('#submit').removeAttr("disabled");
        } else {
            $('#submit').attr("disabled", "disabled");
        }
    }
</script>
</body>
</html>
