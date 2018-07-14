<%--
  Created by IntelliJ IDEA.
  User: Derek
  Date: 2018/7/14
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--fmt标签常用来进行格式化--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>listCategory</title>
</head>
<body>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <c:forEach items="${cs}" var="c" varStatus="st">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>

        </tr>
    </c:forEach>
</table>
<div align="center">
    <a href="listCategory?start=0">首页</a>
    <a href="listCategory?start=${page.start - page.count}">上一页</a>
    <a href="listCategory?start=${page.start + page.count}">下一页</a>
    <a href="listCategory?start=${page.last}">末页</a>
</div>
</body>
</html>
