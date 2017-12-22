<%--
  Created by IntelliJ IDEA.
  User: 郭
  Date: 2017/12/21
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>功能页面</title>
</head>
<body>
<c:forEach items="${gns}" var="gns">
    <a href="${gns.url}">${gns.name}</a><br/>
</c:forEach>
<a href="/logout">退出</a>
</body>
</html>
