<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 20/12/28
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
    <p>
        邮&nbsp&nbsp&nbsp箱：<input type="text" name="email" id="email" />
        <span id="info" style="color:red"></span>
    </p>
    <p>用户名：<input type="text" name="userName" /></p>
    <p>密&nbsp&nbsp&nbsp码：<input type="text" name="password" /></p>
    <p><input type="submit" id="submit" value="提交" disabled="disabled" /></p>
</form>

<script src="./static/js/jquery-3.5.1.js"></script>

<script>
    $(function () {
        $('#email').blur(function () {
            const email = $('#email').val();
            const info = $('#info');
            const submit = $('#submit');
            if(email.toString() == "") {
                info.text("邮箱不能为空");
                return;
            }
            $.ajax({
                contentType: 'application/x-www-form-urlencoded',
                type: 'GET',
                data: "email=" + email,
                dataType: 'text',
                url: '${pageContext.request.contextPath}/EmailValidateServlet',
                success: function (data) {
                    if (data == 'true') {
                        info.text("邮箱可以使用");
                        info.attr("style", "color: green");
                        submit.removeAttr("disabled");
                    } else {
                        info.text("邮箱已经被占用");
                    }
                }
            });
        });
    });
</script>
</body>
</html>
