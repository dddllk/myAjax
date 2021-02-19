package com.bjpowernode.dao;

import java.sql.*;

/**
 * Created by dlkyy on 2021/2/20 0:18
 */
public class ProvinceDao {
  // 根据id获取省份名称
  public String queryProvinceNameById(Integer provinceId){
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String url = "jdbc:mysql://localhost:3306/bjpowernode";
    String username = "root";
    String password = "123456";
    String sql = "";
    String name = "";
    try {
      // 获取数据库驱动
      Class.forName("com.mysql.jdbc.Driver");
      // 获取数据库连接
      conn = DriverManager.getConnection(url, username, password);
      // 创建数据库操作对象
      sql = "select name from province where id=?";
      ps  = conn.prepareStatement(sql);
      // 设置参数值
      ps.setInt(1, provinceId);
      // 执行
      rs = ps.executeQuery();
      // 遍历结果集
      if(rs.next()){
        name = rs.getString("name");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }  finally {
      if(rs != null){
        try {
          rs.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if(ps != null){
        try {
          ps.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      if(conn != null){
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return name;
  }
}
