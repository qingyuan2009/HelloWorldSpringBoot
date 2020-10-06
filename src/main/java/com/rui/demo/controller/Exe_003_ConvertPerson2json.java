package com.rui.demo.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rui.demo.model.Person;

@RestController
public class Exe_003_ConvertPerson2json {
    
    //使用了FastJson转换器， 详见HelloWorldSpringBootApplication.java
    @RequestMapping("/person")    
    public Object show() {
        Person person = new Person();
        person.setId(1);
        person.setName("zhourui");
        person.setDate(new Date());        
        return person;
    }

}
