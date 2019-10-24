<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>上传excel</title>
</head>
<body>
<h1>上传excel文件并存入到mysql数据库</h1>
<form action="uploadexcel.action" method="post" enctype="multipart/form-data">
    <p>文件上传</p>
    <input type="file" name="file">
    <p><input type="submit" value="上传"></p>
</form>
		<span style="color:red">${message}</span>

</body>
</html>