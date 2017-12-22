<%--
  Created by IntelliJ IDEA.
  User: 郭
  Date: 2017/12/21
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<fieldset>
    <legend>个人信息</legend>
    <form action="/reg" method="post">
        姓名：<input type="text" name="name"><br/>
        密码：<input type="text" name="password"><br/>
        <input type="submit" value="提交">
    </form>
</fieldset>
</body>
</html>
