package com.rui.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.rui.demo.controller.IndexController;

import junit.framework.TestCase;

//IndexController = 需要测试的类
@SpringBootTest(classes=IndexController.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
class HelloWorldSpringBootApplicationTests {
	
	@Autowired
	private IndexController indexController;

	@Test
	public void test1() {		
		TestCase.assertEquals(this.indexController.first(), "Hello World!");
	}
}
