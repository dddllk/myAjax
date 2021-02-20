package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/20 11:17
 */

import com.bjpowernode.dao.ProvinceDao;
import com.bjpowernode.entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class AjaxServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request,
                       HttpServletResponse response)
      throws ServletException, IOException {
    String json = "{}";
    Province p = null;
    // 获取参数
    String proid = request.getParameter("proid");

    if(proid != null && proid.trim().length() > 0){
      ProvinceDao d = new ProvinceDao();
      p = d.queryProvinceById(Integer.parseInt(proid));
    }
    // 需要使用jackson把province转换为json
    ObjectMapper om = new ObjectMapper();
    json = om.writeValueAsString(p);

    // 把获取的数据，通过网络传给ajax中的异步对象，响应结果数据
    // 指定服务器端（Servlet）返回给浏览器的是json格式的数据
    response.setContentType("application/json;charset=utf-8");
    // 获取PrintWriter
    PrintWriter pw = response.getWriter();
    pw.println(json);
    pw.flush();
    pw.close();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
