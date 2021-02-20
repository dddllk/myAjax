package com.bjpowernode.test;

import com.bjpowernode.entity.Province;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by dlkyy on 2021/2/20 10:43
 */
public class TestMain {
  public static void main(String[] args) throws JsonProcessingException {
    // 使用jackson把java对象转为json格式的字符串

    // 创建省份对象
    Province p = new Province(1, "河北", "冀", "石家庄");

    // 使用jackson把 p 转为 json
    ObjectMapper om = new ObjectMapper();
    //writeValueAsString：把参数的java对象转为json格式的字符串
    String json = om.writeValueAsString(p);
    System.out.println(json);
  }
}
