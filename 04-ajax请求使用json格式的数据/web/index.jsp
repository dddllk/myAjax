<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/20
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>使用json格式的数据</title>
    <script type="text/javascript">
      function doSearch(){
        // 创建XMLHttpRequest对象
        var xmlHttp = new XMLHttpRequest();
        // 绑定事件
        xmlHttp.onreadystatechange = function (){
          if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
            var data = xmlHttp.responseText;
            // eval 是执行括号中的代码，把json字符串转为json对象
            var jsonObj = eval("(" + data +")");
            // 更新dom
             document.getElementById("proname").value = jsonObj.name;
             document.getElementById("projiancheng").value = jsonObj.jiancheng;
             document.getElementById("proshenghui").value = jsonObj.shenghui;
          }
        }
        // 初始化异步对象
        var proid = document.getElementById("proid").value;
        xmlHttp.open("get", "AjaxServlet?proid="+proid, true);
        // 发送请求
        xmlHttp.send();
      }
    </script>
  </head>
  <body>
    <p>ajax请求使用json格式的数据</p>
    <table>
      <tr>
        <td>省份编号：</td>
        <td>
          <input type="text" id="proid">
          <input type="button" value="搜索" onclick="doSearch()">
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
