package com.rui.demo.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Log4jController {
	
	//使用spring 默认的backlog
 	//private static Logger logger = LoggerFactory.getLogger(Log4jController.getClass());

	@RequestMapping("/log4j")
	public String show() {
//		logger.debug("debug 日志");
//		logger.info("info 日志");
//		logger.warn("warn 日志");
//		logger.error("error 日志");		
		return "show";
	}
}
