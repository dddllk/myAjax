package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/20 21:06
 */

import com.bjpowernode.dao.QueryDao;
import com.bjpowernode.entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class QueryProvinceServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //
    String json = "{}";
    // 调用dao，获取所有的省份信息，是一个list集合
    QueryDao dao = new QueryDao();
    List<Province> provinces = dao.queryProvince();
    // 把list集合转换成json格式的数据，输出给ajax请求
    if(provinces.size() > 0) {
       // 调用jackson工具库，实现List -- json
      ObjectMapper om = new ObjectMapper();
      json = om.writeValueAsString(provinces);
    }
    // 输出json数据，响应ajax请求
    // 设置格式
    response.setContentType("application/json;charset=utf-8");
    PrintWriter pw = response.getWriter();
    pw.println(json);
    pw.flush();
    pw.close();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
