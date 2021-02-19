package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/20 0:42
 */

import com.bjpowernode.dao.ProvinceDao;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryProvinceServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 处理get请求
    String strProid = request.getParameter("proid");
    String name = "默认是无数据！";

    // 访问dao
    if(strProid != null && !"".equals(strProid.trim())) {
      // 创建dao对象
      ProvinceDao dao = new ProvinceDao();
      name = dao.queryProvinceNameById(Integer.valueOf(strProid));
    }

    // 使用HttpServlet输出数据
    response.setContentType("text/html;charset=utf-8");
    PrintWriter pw = response.getWriter();
    pw.println(name);
    pw.flush();
    pw.close();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
