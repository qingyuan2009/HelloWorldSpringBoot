package com.rui.demo.controller;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rui.demo.service.AsyncService;


@RestController
public class Exe_005_AsyncTest {
    
    @Autowired
    AsyncService asyncService;
    
    
    @RequestMapping("/async")    
    public String Async() throws Exception {
        
        long start=System.currentTimeMillis();
        long end;
             
        Future<String> task1 = asyncService.doTask1();
        Future<String> task2 = asyncService.doTask2();
        Future<String> task3 = asyncService.doTask3();
        
        while(true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                end=System.currentTimeMillis();
                break;
            }
            Thread.sleep(1000);  //防止主线程一直检查task是否完成
        }
        return "全部执行完成，总耗时：" + (end-start) + " 毫秒";
    }   

}
