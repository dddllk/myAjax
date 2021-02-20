package com.bjpowernode.dao;

import com.bjpowernode.entity.City;
import com.bjpowernode.entity.Province;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dlkyy on 2021/2/20 20:48
 */
public class QueryDao {

  Connection conn = null;
  PreparedStatement ps = null;
  ResultSet rs = null;
  String url = "jdbc:mysql://localhost:3306/bjpowernode";
  String username = "root";
  String password = "123456";

  // 查询所有省份信息
  public List<Province> queryProvince(){
    List<Province> list = new ArrayList();
    Province p = null;
    String sql = "";

    try {
      // 获取数据库驱动
      Class.forName("com.mysql.jdbc.Driver");
      // 获取数据库连接
      conn = DriverManager.getConnection(url, username, password);
      // 创建数据库操作对象
      sql = "select *from province order by id";
      ps = conn.prepareStatement(sql);
      // 执行
      rs = ps.executeQuery();
      while(rs.next()){
        Integer id = rs.getInt("id");
        String name = rs.getString("name");
        String jiancheng = rs.getString("jiancheng");
        String shenghui = rs.getString("shenghui");

        p = new Province(id, name, jiancheng, shenghui);
        list.add(p);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
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
    return list;
  }

  // 查询省份下面的所有城市
  public List<City> queryCity(Integer provinceId) {
    List<City> list = new ArrayList();
    City c = null;
    String sql = "";
    try {
      // 获取数据库驱动
      Class.forName("com.mysql.jdbc.Driver");
      // 获取数据库连接
      conn = DriverManager.getConnection(url, username, password);
      // 创建数据库操作对象
      sql = "select id,name from city where provinceid=?";
      ps = conn.prepareStatement(sql);
      // 设置省份参数值
      ps.setInt(1, provinceId);
      // 执行
      rs = ps.executeQuery();
      while(rs.next()){
        Integer id = rs.getInt("id");
        String name = rs.getString("name");

        c = new City();
        c.setId(id);
        c.setName(name);

        list.add(c);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
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
    return list;
  }
}
