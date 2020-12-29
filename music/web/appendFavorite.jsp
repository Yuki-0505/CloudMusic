<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 20/12/29
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加收藏夹</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/AppendFavoriteServlet" method="post">
    <p>
        收藏夹名：<input type="text" name="favoriteName" id="favoriteName"/>
        <span id="info" style="color:red"></span>
    </p>
    <p><input type="submit" id="submit" value="提交" disabled="disabled"/></p>
</form>

<script src="./static/js/jquery-3.5.1.js"></script>

<script>
    $(function () {
        $('#favoriteName').blur(function () {
            const favoriteName = $('#favoriteName').val();
            const info = $('#info');
            const submit = $('#submit');
            if (favoriteName.toString() == "") {
                info.text("收藏夹名不能为空");
                return;
            }
            $.ajax({
                contentType: 'application/x-www-form-urlencoded',
                type: 'GET',
                data: "favoriteName=" + favoriteName,
                dataType: 'text',
                url: '${pageContext.request.contextPath}/FavoriteValidateServlet',
                success: function (data) {
                    if (data == 'true') {
                        info.text("收藏夹名可以使用");
                        info.attr("style", "color: green");
                        submit.removeAttr("disabled");
                    } else {
                        info.text("收藏夹名已存在");
                    }
                }
            });
        });
    });
</script>
</body>
</html>
