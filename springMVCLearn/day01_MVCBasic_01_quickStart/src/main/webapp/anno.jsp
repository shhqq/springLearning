<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2020/6/24
  Time: 15:26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>annotation</title>
</head>
<body>
    <h3>RequestParam注解的使用</h3>
    <a href="annotation/testRequestParam?username=Jack">RequestParam</a>
    <br/>
    <br/>

    <h3>RequestBody注解的使用</h3>
    <form action="annotation/testRequestBody" method="post">
        <label>name</label><input type="text" name="name"><br>
        <label>age</label><input type="text" name="age"><br>
        <input type="submit" value="submit"><br>
    </form>
    <br/>
    <br/>

    <h3>PathVariable注解的使用</h3>
    <a href="annotation/testPathVariable/10">PathVariable</a>
    <br/>
    <br/>

    <h3>RequestHeader注解的使用</h3>
    <a href="annotation/testRequestHeader">RequestHeader</a>

    <br/>
    <br/>

    <h3>CookieValue注解的使用</h3>
    <a href="annotation/testCookieValue">CookieValue</a>
    <br/>
    <br/>


    <h3>ModelAttribute注解的使用</h3>
    <form action="annotation/testModelAttribute" method="post">
        <label>name</label><input type="text" name="name"><br>
        <label>age</label><input type="text" name="age"><br>
        <input type="submit" value="submit"><br>
    </form>
    <br/>
    <br/>

    <h3>SessionAttributes注解的使用--添加sessionMap值</h3>
    <a href="annotation/testSessionAttributes">SessionAttributes</a>
    <h3>SessionAttributes注解的使用--查看sessionMap值</h3>
    <a href="annotation/getSessionAttributes">getSessionAttributes</a>
    <h3>SessionAttributes注解的使用--删除sessionMap值</h3>
    <a href="annotation/delSessionAttributes">delSessionAttributes</a>
</body>
</html>
