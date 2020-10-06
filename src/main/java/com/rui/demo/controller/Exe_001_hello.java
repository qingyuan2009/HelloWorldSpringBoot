package com.rui.demo.controller;


import java.nio.charset.Charset;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 使用了@RestController 就不需要@Controller
public class Exe_001_hello {
    
  //定义消息转换器，防止乱码
    @Bean  //自动放入MVC容器
    public StringHttpMessageConverter stringHttpMessageConverter() {
        StringHttpMessageConverter convert = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return convert;
    }

	@RequestMapping("/")
	//@ResponseBody  使用了@RestController 就不需要@ResponseBody
	public String first() {
		return "Hello World, 周睿!!!";
	}	
	
	@RequestMapping("/hello/{msg}")  //localhost:8080/hello/rui
	//@ResponseBody  使用了@RestController 就不需要@ResponseBody
	public String hello(@PathVariable String msg) {
		return "Hello World! " + msg;
	}	
	
}
