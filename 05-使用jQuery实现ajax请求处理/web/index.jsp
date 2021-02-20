<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/20
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>省市级联查询</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
      $(function(){
        // $(function()) 在页面的dom的对象加载成功后执行的函数，
        // 在此发起ajax
        loadDataAjax();
        // 点击按钮时也加载
        $("#btnLoad").on("click",function (){
          loadDataAjax();
        });
        // 给省份的select绑定一个change事件，当select内容变化时，触发事件
        $("#province").on("change", function(){
          // 获取选中框的value值
          var obj = $("#province>option:selected");
          //alert(obj.val());
          // 根据省份的id查询城市
          var provinceId = obj.val();
          // 发起ajax get请求
          $.get("QueryCity", {provinceId}, callback, "json")
        });
      })
      // 调用函数加载数据
      function loadDataAjax(){
        $.ajax({
          url: "QueryProvince",
          type: "get",// 默认get
          dataType: "json", // 数据类型
          success: function(data){
            // 每点击一次就会添加一次数据
            // 所有有必要每次添加前清空以前的数据
            $("#province").empty();
            $("#province").append("<option value='0'>请选择......</option>")
            $.each(data, function (index, el){
              // 获取select-dom对象
              $("#province").append("<option value='"+el.id+"'>"+el.name+"</option>");
            });
          }
        });
      }
      // 定义处理返回数据的函数
      function callback(data){
        // alert(data);
        // 每点击一次就会添加一次数据
        // 所有有必要每次添加前清空以前的数据
        $("#city").empty();
        $.each(data, function(index, el){
          $("#city").append("<option value='"+el.id+"'>"+el.name+"</option>");
        })
      }
    </script>
  </head>
  <body>
    <table border="1">
      <tr>
        <td>省份：</td>
        <td>
          <select id="province">
            <option value="0">请选择......</option>
          </select>
          <input type="button" value="load数据" id="btnLoad">
        </td>
      </tr>
      <tr>
        <td>城市：</td>
        <td>
          <select id="city">
            <option value="0">请选择......</option>
          </select>
        </td>
      </tr>
    </table>
  </body>
</html>
