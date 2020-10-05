package com.rui.demo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableAutoConfiguration //启用自动配置， 对POM中dependency的架包进行自动配置
@Controller
public class Exe_000 {
    
    @RequestMapping("/first")
    //ResponseBody: 返回的是Restful内容，不使用会进行跳转
    @ResponseBody
    public String first() {
        return "Hello World!";
    }
    
    //标准执行入口，一般会使用启动类取代
    public static void main(String[] args) {
        SpringApplication.run(Exe_000.class, args);
    }

}
