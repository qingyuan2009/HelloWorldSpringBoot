package com.rui.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ConfigurationProperties(prefix="book")
public class PropertyController {
		
	//方法1-----------------------------------------------------------
	@Value("${book.author}")
	private String author2;
		
	@Value("${book.name}")
	private String name2;	
	
	//方法2:----------------------------------------------------------
	//@ConfigurationProperties(prefix="book") 类型安全的配置
	//@Value("${book.author}")     不需要使用@Value
	private String author;
		
	//@Value("${book.name}")
	private String name;	
		
	//但必须实现Get， Set 方法
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
		
	public String getName() {
		return name;
	}
	
	public void setname(String name) {
		this.name = name;
	}	

	//---------------------------------------------------------------
	@RequestMapping("/property")
	@ResponseBody	
	public String showInfo() {
		return author2 + ":" + name2 + ";" + author + ":" + name ;
		
	}	
}
