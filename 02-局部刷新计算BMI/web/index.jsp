<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/19
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>局部刷新计算BMI</title>
  <script type="text/javascript">
    function doAjax() {
      // 使用内存中的异步对象，代替浏览器发起请求。异步对象使用js创建管理

      //1.创建异步对象
      var xmlHttp = new XMLHttpRequest();
      //2.绑定事件
      xmlHttp.onreadystatechange = function(){
        if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {
          //alert(xmlHttp.responseText);
          var data = xmlHttp.responseText;
          //更新dom对象，更新页面数据
          document.getElementById("mydata").innerText = data;
        }
        // 处理服务器端返回的数据，更新当前页面
        // alert("readyState属性值： " + xmlHttp.readyState + "status: " + xmlHttp.status);
      }
      //3.初始请求数据
      // 获取dom对象的value属性值
      var name = document.getElementById("name").value;
      var height = document.getElementById("h").value;
      var weight = document.getElementById("w").value;

      // bmiAjaxServlet?name=dlkyy&weight=180&height=1.8
      var param = "name=" + name + "&weight=" + weight + "&height=" + height;
      // alert(param);
      xmlHttp.open("get", "bmiAjaxServlet?"+param, true);

      //4.发起请求
      xmlHttp.send();
    }
  </script>
</head>
<body>
  <!--没有使用form-->
  <p>局部刷新----计算bmi</p>
  姓名：<input type="text" name="name" id="name"/><br/>
  体重（公斤）：<input type="text" name="weight" id="w"/><br/>
  身高（米）：<input type="text" name="height" id="h"/><br/>
  <input type="submit" value="提交" onclick="doAjax()">
  <br>
  <br>
  <div id="mydata">等待加载数据...</div>
</body>
</html>