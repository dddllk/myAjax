<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/19
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全局刷新</title>
</head>
<body>
<p>全局刷新计算bmi</p>
<form action="/myWeb/bmiPrintServlet" method="get">
    姓名：<input type="text" name="name"><br/>
    体重（公斤）：<input type="text" name="weight"><br/>
    身高（米）：<input type="text" name="height"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>