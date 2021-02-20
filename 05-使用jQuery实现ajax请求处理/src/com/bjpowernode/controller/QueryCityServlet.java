package com.bjpowernode.controller;
/**
 * Created by dlkyy on 2021/2/20 22:38
 */

import com.bjpowernode.dao.QueryDao;
import com.bjpowernode.entity.City;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class QueryCityServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<City> cityList = new ArrayList();
    String json = "{}";
    // 获取传递过来的参数
    String provinceId = request.getParameter("provinceId");

    if(provinceId != null && provinceId.trim().length() > 0){
      QueryDao dao = new QueryDao();
      cityList = dao.queryCity(Integer.parseInt(provinceId));
      
      // 调用jackson工具库，实现List -- json
      ObjectMapper om = new ObjectMapper();
      json = om.writeValueAsString(cityList);
    }

    // 数据json数据，响应ajax请求
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
