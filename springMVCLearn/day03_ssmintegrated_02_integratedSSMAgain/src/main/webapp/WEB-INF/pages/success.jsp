<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2020/6/29
  Time: 18:51
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>success</title>
</head>
<body>
<h3>跳转成功</h3>
<c:forEach items="${accounts}" var="account">
    ${account.name}<br/>
    ${account.money}<br/>
</c:forEach>
</body>
</html>
