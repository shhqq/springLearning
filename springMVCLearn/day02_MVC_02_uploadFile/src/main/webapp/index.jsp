<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2020/6/28
  Time: 11:25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>update file test</h3>
<%--<a href="user/testUploadFile">update file test</a>--%>

<br>
<h3>表单用于上传文件--传统文件上传</h3>
<form action="user/testUploadFile" method="post" enctype="multipart/form-data">
    <label>param1</label><input type="text" name="param1"/><br/>
    <label>param2</label><input type="text" name="param2"/><br/>
    <label>choose file</label><input type="file" name="fileParam"/><br/>
    <input type="submit" value="upload file">
</form>
</body>
</html>
