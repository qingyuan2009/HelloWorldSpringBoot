package com.rui.demo.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 使用了@RestController 就不需要@Controller
public class Exe_001 {

	@RequestMapping("/")
	//@ResponseBody  使用了@RestController 就不需要@ResponseBody
	public String first() {
		return "Hello World!";
	}
	
	
	@RequestMapping("/hello/{msg}")  //localhost:8080/hello/rui
	//@ResponseBody  使用了@RestController 就不需要@ResponseBody
	public String hello(@PathVariable String msg) {
		return "Hello World! " + msg;
	}
}
