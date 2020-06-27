<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <title>home page</title>
</head>
<body>
<h3>quick start demo</h3>
<%--<a href="hello?username=Jack&userAge=23">quick start demo</a>--%>

<form action="userHandler/saveUser" method="post">
    <label>username</label><input type="text" name="name"><br/>
    <label>age</label><input type="text" name="age"><br/>
    <label>birthday</label><input type="text" name="birthday"/><br/>
    <label>account-id</label><input type="text" name="account.id"><br/>
    <label>account-money</label><input type="text" name="account.money"><br/>
    <label>account[0]-id</label><input type="text" name="accounts[0].id"><br/>
    <label>account[0]-money</label><input type="text" name="accounts[0].money"><br/>
    <label>map[0]-id</label><input type="text" name="accountMap['one'].id"><br/>
    <label>map[0]-money</label><input type="text" name="accountMap['one'].money"><br/>
    <input type="submit" value="submit">
</form>

<%--尝试直接传list，并不可行--%>
<form action="userHandler/saveUsers" method="post">
    <label>username</label><input type="text" name="users[0].name"><br/>
    <label>age</label><input type="text" name="users[0].age"><br/>
    <label>birthday</label><input type="text" name="users[0].birthday"/><br/>
    <input type="submit" value="submit">
</form>

<%--获取ServletAPI--%>
<h3>还是尝试传list，看一下请求参数是什么样的</h3>
<form action="userHandler/getServletAPI" method="post">
    <label>username</label><input type="text" name="users[0].name"><br/>
    <label>age</label><input type="text" name="users[0].age"><br/>
    <label>birthday</label><input type="text" name="users[0].birthday"/><br/>
    <input type="submit" value="submit">
</form>
</body>
</html>
