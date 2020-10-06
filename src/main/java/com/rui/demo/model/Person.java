package com.rui.demo.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Person {
    
    private int id;
    private String name;
    
    @JSONField(format="yyyy-MM-dd HH")  //FastJson注解
    private Date date;    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }    

}
