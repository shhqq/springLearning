<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2020/6/29
  Time: 10:10
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body>
<h3>springMVC测试</h3>
<a href="account/testFindAll">springMVC测试</a>

<h3>Mybatis测试，保存账户</h3>
<form action="account/testSaveAccount" method="post"/><br/>
    <label>name</label><input type="text" name="name"/><br/>
    <label>money</label><input type="text" name="money"/><br/>
    <input type="submit" value="save"/><br/>
</form>
</body>
</html>
