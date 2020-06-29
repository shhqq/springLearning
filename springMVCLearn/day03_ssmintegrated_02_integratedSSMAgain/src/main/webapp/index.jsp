<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2020/6/29
  Time: 18:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body>
<h3>再次整合ssm案例</h3>
<a href="account/testFindAll">测试</a>
<br/>

<h3>整合Mybatis测试</h3>
<form action="account/testSaveAccount" method="post">
    <label>name</label><input type="text" name="name"/><br/>
    <label>money</label><input type="text" name="money"><br/>
    <input type="submit" value="save"><br/>
</form>
</body>
</html>
