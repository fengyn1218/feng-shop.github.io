<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MyShop——个人注册</title>
    <link rel="stylesheet" type="text/css" href="/static/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="/static/css/ziy.css"/>
</head>
<body>

<div class="yiny">
    <div class="beij_center">
        <div class="dengl_logo">
            <img src="/static/images/logo_1.png">
            <h1>欢迎注册</h1>
        </div>
    </div>
</div>

<div class="beij_center">
    <div class="ger_zhuc_beij">
        <div class="ger_zhuc_biaot">
            <ul>
                <li class="ger_border_color"><a href="/register">个人注册</a></li>
                <i>丨</i>
                <li><a href="#">申请入驻</a></li>
                <p>我已经注册，现在就<a class="ftx-05 ml10" href="/login">登录</a></p>
            </ul>
        </div>

        <c:if test="${baseResult!=null}">
            <div class="red">
                    ${baseResult.message}
            </div>
        </c:if>

        <form method="post" action="/insert">
            <div class="zhuc_biaod">
                <div class="reg-items">
              	<span class="reg-label">
                	<label>用户名：</label>
              	</span>
                    <input name="username" class="i-text" type="text">
                    <!--备注————display使用 inline-block-->
                    <div class="msg-box">

                    </div>

                </div>

            </div>
            <div class="reg-items">
              	<span class="reg-label">
                	<label>设置密码：</label>
              	</span>
                <input name="password" class="i-text" type="password">
                <!--备注————display使用 inline-block-->
                <div class="msg-box">

                </div>
            </div>
            <div class="reg-items">
              	<span class="reg-label">
                	<label>邮箱：</label>
              	</span>
                <input name="email" class="i-text" type="email" >
                <!--备注————display使用 inline-block-->
                <div class="msg-box">

                </div>
            </div>
            <div class="reg-items">
              	<span class="reg-label">
                	<label >手机号码：</label>
              	</span>
                <input name="phone" class="i-text" type="text">
                <!--备注————display使用 inline-block-->
                <div class="msg-box">

                </div>
            </div>

            <div class="reg-items">
              	<span class="reg-label">
                	<label> </label>
              	</span>
                <div class="dag_biaod">
                    <input type="checkbox" value="english">
                    阅读并同意
                    <a href="#" class="ftx-05 ml10">《MyShop用户注册协议》</a>
                    <a href="#" class="ftx-05 ml10">《隐私协议》</a>
                </div>
            </div>
            <div class="reg-items">
              	<span class="reg-label">
                	<label > </label>
              	</span>

                <input class="reg-btn" value="立即注册" type="submit" >
            </div>


        </form>


        <div class="xiaogg">
            <img src="/static/images/cdsgfd.jpg">
        </div>
    </div>
</div>

<div class="jianj_dib jianj_dib_1">
    <div class="beia_hao">
        <p>京ICP备：123456789号 </p>
        <p class="gonga_bei">京公网安备：123456789号</p>
    </div>
</div>
</body>
</html>
