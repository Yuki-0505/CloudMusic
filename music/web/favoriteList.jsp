<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 20/12/30
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收藏夹列表</title>
</head>
<body>
<div id="app" v-cloak>
    <ul>
        <li v-for="item in favorites"><a href="">{{item}}</a></li>
    </ul>
</div>
<script src="./static/js/vue.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
<script>
    const app = new Vue({
        el: '#app',
        data: {
            // favorites: ['星际穿越', '大话西游', '盗梦空间', '源代码'],
            favorites: [],
        },
        methods: {
            send(){
                axios({
                    method:'get',
                    url:'http://localhost:8080/music/SelectFavoriteListServlet}'
                }).then(function(res){
                    // this.favorites = res.data;
                });
            }
        }
    });
</script>
</body>
</html>
