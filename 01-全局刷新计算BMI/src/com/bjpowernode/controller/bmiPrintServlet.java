package com.bjpowernode.controller; /**
 * Created by dlkyy on 2021/2/19 22:12
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class bmiPrintServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request,
                       HttpServletResponse response)
      throws ServletException, IOException {
    //接收请求参数
    String strName = request.getParameter("name");
    String height = request.getParameter("height");
    String weight = request.getParameter("weight");

    // 计算bmi：bmi = 体重/身高的平方
    float h = Float.valueOf(height);
    float w = Float.valueOf(weight);
    float bmi = w / (h * h);

    // 判断bmi的范围
    String msg = "";
    if (bmi <= 18.5) {
      msg = "您比较瘦！";
    } else if (bmi <= 23.9) {
      msg = "您的bmi正常";
    } else if (bmi <= 27) {
      msg = "您身体比较胖！";
    } else {
      msg = "您的身体肥胖";
    }
    System.out.println("msg = " + msg);
    msg = "您好：" + strName + "先生/女生，您的bmi值是：" + bmi + "，" + msg;

    // 使用HttpServletResponse输出数据
    response.setContentType("text/html;charset=utf-8");
    // 获取Printer
    PrintWriter pw = response.getWriter();
    // 输出数据
    pw.println(msg);
    // 清空缓存
    pw.flush();
    // 关闭
    pw.close();
  }
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
