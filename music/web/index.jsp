<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 20/12/26
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>首页</title>
</head>
<body>
<div id="app">
  <button @click="send">{{message}}</button>
  <%--    <button onclick="validate()">发送ajax请求</button>--%>
</div>
<script src="https://cdn.jsdelivr.net/npm/vue@2.6.12"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
  new Vue({
    el:"#app",
    data:{
      message:"发送ajax请求",
    },
    methods:{
      send(){
        axios({
          method:'get',
          url:'http://localhost:8080/music/AppServlet',
        }).then(function(result){
          console.log(result.data);
        });
      }
    },
  });
</script>
</body>
</html>

