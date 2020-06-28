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
    <label>param1</label><input type="text" name="param4"/><br/>
    <label>param2</label><input type="text" name="param5"/><br/>
    <label>choose file</label><input type="file" name="fileParam1"/><br/>
    <input type="submit" value="upload file">
</form>

<br>
<h3>表单用于上传文件--使用springMVC进行单服务器上传</h3>
<form action="user/testUploadFile2" method="post" enctype="multipart/form-data">
    <label>param1</label><input type="text" name="param1"/><br/>
    <label>param2</label><input type="text" name="param2"/><br/>
    <label>choose file</label><input type="file" name="fileParam"/><br/>
    <input type="submit" value="upload file">
</form>

<br>
<h3>表单用于上传文件--使用springMVC进行跨服务器上传</h3>
<form action="user/testUploadFile3" method="post" enctype="multipart/form-data">
    <label>choose file</label><input type="file" name="fileParam"/><br/>
    <input type="submit" value="upload file">
</form>
</body>
</html>
