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
    <script type="text/javascript" src="jquery-3.3.1.min.js"></script>
</head>
<body>
请输入需要修改的值:<br/>
<form>
    <input type="hidden" id="startIndex" value=${startIndex}>
    <input type = "hidden" id= "id" value="${category.id}"><br/>
    名称: <input type="text" id = "name"  value="${category.name}"><br/>
    <input type='button' value='更新' id="submit">
</form>
<div id="divMessage"></div>
<%--用AJAX以JSON方式提交数据--%>
<script>
    $(function () {
        $("#submit").on('click', function(){
            // var name = $("#id").valueOf();
            // var id = $("#name").valueOf();
            var name = document.getElementById('name').value;
            var id = document.getElementById('id').value;
            var category = {"name": name, "id": id};
            var page = "updateCategory?startIndex=" + ${startIndex};
            var jsonData = JSON.stringify(category);

            $.ajax({
                type:"post",
                url: page,
                data:jsonData,
                dataType:"json",
                contentType : "application/json;charset=UTF-8",
                success: function(result){
                    //TODO:怎么把更新好的数据返回前端?
                    $("#divMessage").html(result);
                    alert("数据更新成功, 数据为:" + result);
                },
                error:function () {
                    alert("错误.没有提交成功.")
                }
            });

        });
    })

</script>
</body>
</html>
