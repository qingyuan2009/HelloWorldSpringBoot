package com.rui.demo.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


//全局异常处理器
@ControllerAdvice
public class Exe_004_GlobalExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handleException(Exception exception){
        Map<String, Object> map = new HashMap<>();
        map.put("errorCode", 500);
        map.put("errorMessage", exception.toString());
        return map;        
    }

}
