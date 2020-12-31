<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 20/12/30
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>音乐播放</title>
    <style>
        .audio {
            /*position: relative;*/
            /*display: block;*/
            position: fixed;
            /*top: 740px;*/
            left: 40%;
            bottom: 2px;
        }
    </style>
</head>
<body>

<div align="center" class="audio">
    <audio controls="controls">
        <source src="${pageContext.request.contextPath}/static/music/11609294352279/南拳妈妈 - 下雨天.mp3" type="audio/mp3"/>
    </audio>
</div>

<p>
    <div id="lrc_all1426112587" class="lyrics" align="center">
<p>下雨天 了怎么办 我好想你</p>
<p> 不敢打给你 我找不到原因</p>
<p> 为什么失眠的声音</p>
<p> 变得好熟悉</p>
<p> 沉默的场景 做你的代替</p>
<p> 陪我等雨停</p>
<p> 期待让人越来越沉溺</p>
<p> 谁和我一样</p>
<p> 等不到他的谁</p>
<p> 爱上你我总在学会</p>
<p> 寂寞的滋味</p>
<p> 一个人撑伞 一个人擦泪</p>
<p> 一个人好累</p>
<p> 怎样的雨 怎样的夜</p>
<p> 怎样的我能让你更想念</p>
<p> 雨要多大</p>
<p> 天要多黑 才能够有你的体贴</p>
<p> 其实 没有我你分不清那些</p>
<p> 差别 结局还能多明显</p>
<p> 别说你会难过</p>
<p> 别说你想改变</p>
<p> 被爱的人不用道歉</p>
<p> 期待让人越来越疲惫</p>
<p> 谁和我一样</p>
<p> 等不到他的谁</p>
<p> 爱上你我总在学会</p>
<p> 寂寞的滋味</p>
<p> 一个人撑伞 一个人擦泪</p>
<p> 一个人好累</p>
<p> 怎样的雨 怎样的夜</p>
<p> 怎样的我能让你更想念</p>
<p> 雨要多大</p>
<p> 天要多黑 才能够有你的体贴</p>
<p> 其实 没有我你分不清那些</p>
<p> 差别 结局还能多明显</p>
<p> 别说你会难过</p>
<p> 别说你想改变</p>
<p> 被爱的人不用道歉</p>
<p> 怎样的雨 怎样的夜</p>
<p> 怎样的我能让你更想念</p>
<p> 雨要多大</p>
<p> 天要多黑 才能够有你的体贴</p>
<p> 其实 没有我你分不清那些</p>
<p> 差别 结局还能多明显</p>
<p> 别说你会难过</p>
<p> 别说你想改变</p>
<p> 被爱的人不用道歉</p>
<p> Op：JVR Music Int’l Ltd.</p>
<p> Op：Alfa Music International Co., Ltd.</p>
<p> 钢琴：李咏恩 </p>
<p> 电吉他：陈逸宏、黄正安 </p>
<p> 弦乐编写：卢思蒨 </p>
<p> 录音工作室：荒原录音室</p>
<p> 人声编辑：Evalia</p>
<p> 混音/母带：Kinshi </p>
<p> 制作统筹：刘子衡</p>
<p> 制作公司：恒星制造所 HX Production</p>
<p> 监制：闫卡夫</p>
<p> 联合监制：叶 震声 </p>
<p> 出品：周 家磊 闫卡夫</p>
<p> 经纪公司：纳吉音 Negia Entertainment</p>
</div>
</p>
<script src="./static/js/jquery-3.5.1.js"></script>

<script>
    $(function () {
        window.setInterval(function () {
            $('body').scrollTop($('body').scrollTop() + 1);
        }, 100);
    });

</script>

</body>
</html>
