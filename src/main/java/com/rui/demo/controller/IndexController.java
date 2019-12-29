package com.rui.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@RequestMapping("/")
	@ResponseBody
	public String first() {
		return "Hello World!";
	}
}
