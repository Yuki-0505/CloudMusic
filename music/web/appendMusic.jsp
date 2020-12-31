<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 20/12/30
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加音乐</title>
    <script type="text/javascript">
        function validate() {
            var music = document.getElementById("music");
            if (music.value == "") {
                alert("请选择要上传的音乐！");
                music.focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>

<form action="${pageContext.request.contextPath}/AppendMusicServlet" method="post"
      enctype="multipart/form-data" onsubmit="return validate();">
    <input name="music" id="music" type="file" value="上传照片">
    <div align="center">
        <input name="submit" type="submit" value="保存">
        <input name="reset" type="reset" value="取消">
    </div>
</form>
</body>
</html>
