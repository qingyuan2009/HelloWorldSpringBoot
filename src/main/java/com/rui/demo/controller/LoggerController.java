package com.rui.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerController {
	
	//使用spring 默认的backlog
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/show")
	public String show() {
		logger.debug("debug 日志");
		logger.info("info 日志");
		logger.warn("warn 日志");
		logger.error("error 日志");		
		return "show";
	}
}
