package com.bjpowernode.entity;

/**
 * Created by dlkyy on 2021/2/20 10:44
 */
public class Province {
  private Integer id;
  private String name;
  private String jiancheng;
  private String shenghuid;

  public Province() {
  }

  public Province(Integer id, String name, String jiancheng, String shenghuid) {
    this.id = id;
    this.name = name;
    this.jiancheng = jiancheng;
    this.shenghuid = shenghuid;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getJiancheng() {
    return jiancheng;
  }

  public void setJiancheng(String jiancheng) {
    this.jiancheng = jiancheng;
  }

  public String getShenghuid() {
    return shenghuid;
  }

  public void setShenghuid(String shenghuid) {
    this.shenghuid = shenghuid;
  }
}
