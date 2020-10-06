package com.rui.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Exe_004_ExceptionTest {
    
    @RequestMapping("/exception")    
    public String error() {
        int a = 5/0; 
        //int[] array = new int[3];
        //System.out.println(array[3]); //下标越界异常
        return Integer.toString(a);
    }   

}
