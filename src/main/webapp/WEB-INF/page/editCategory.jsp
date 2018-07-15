<%--
  Created by IntelliJ IDEA.
  User: Derek
  Date: 2018/7/15
  Time: 09:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--fmt标签常用来进行格式化--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>editCategory</title>
</head>
<body>
请输入需要修改的值:<br/>
<form action="updateCategory" method="post">
    <input type="hidden" name="startIndex" value=${startIndex}>
    <input type = "hidden" name="id" value="${category.id}"><br/>
    名称: <input type="text" name="name" value="${category.name}"><br/>
    <input type='submit' value='更新'>
</form>
</body>
</html>
