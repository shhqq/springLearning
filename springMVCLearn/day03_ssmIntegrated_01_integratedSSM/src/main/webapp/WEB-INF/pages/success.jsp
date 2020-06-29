<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2020/6/29
  Time: 10:12
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h3>执行成功</h3>
${accounts}

<br/>
<%--遍历--%>
<c:forEach items="${accounts}" var="account">
    ${account.name}
    ${account.money}
</c:forEach>
</body>
</html>
