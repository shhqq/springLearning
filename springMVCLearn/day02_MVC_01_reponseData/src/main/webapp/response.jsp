<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2020/6/27
  Time: 17:09
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>response home</title>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script>
        // 页面加载，绑定单击事件
        $(function () {
            $("#btn").click(function () {
                // ajax异步请求
                alert("hello ajax")
            })

        })
    </script>
</head>
<body>
<h3>无返回值</h3>
<a href="user/testVoid">testVoid</a>
<br/>
<br/>
<h3>testModelAndView作为返回值</h3>
<a href="user/testModelAndView">testModelAndView</a>

<br/>
<h3>testForwardOrRedirect关键字</h3>
<a href="user/testForwardOrRedirect">testForwardOrRedirect</a>
<br>
<br>
<button id="btn">button test</button>
</body>
</html>
