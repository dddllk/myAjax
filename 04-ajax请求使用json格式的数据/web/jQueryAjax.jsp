<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/20
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jQueryAjax发送请求</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#btn").click(function(){
               // 获取dom的value值
               var proid = $("#proid").val();
               // 发起ajax请求
               $.ajax({
                  url: "queryjson", // web.xml--url-pattern--servlet名
                  data: {
                    "proid": proid // 参数
                  },
                  dataType: "json", // 数据类型
                  success: function (data) { // success：成功执行的函数，data：返回的数据
                    $("#proname").val(data.name);
                    $("#projiancheng").val(data.jiancheng);
                    $("#proshenghui").val(data.shenghui);
                  }
              });
            })
        })
    </script>
</head>
<body>
<p>jQuery----ajax请求使用json格式的数据</p>
<table>
    <tr>
        <td>省份编号：</td>
        <td>
            <input type="text" id="proid">
            <input type="button" value="搜索" id="btn">
        </td>
    </tr>
    <tr>
        <td>省份名称：</td>
        <td><input type="text" id="proname"></td>
    </tr>
    <tr>
        <td>省份简称：</td>
        <td><input type="text" id="projiancheng"></td>
    </tr>
    <tr>
        <td>省会名称：</td>
        <td><input type="text" id="proshenghui"></td>
    </tr>
</table>
</body>
</html>
