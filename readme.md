# Create Maven project

# POM 的父级依赖

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.2.0.RELEASE</version>		 
	</parent>

# POM dependency

	//spring-boot-starter-web 包含了spring + spring mvc + log + Tomcat ...
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>	
	
# POM 指定JDK 版本

	<!-- 指定JDK版本 -->
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-compiler-plugin</artifactId>
		<configuration>
			<source>1.8</source>
			<target>1.8</target>
		</configuration>
	</plugin>

# @SpringBootApplication
会调用@EnableAutoConfiguration: 启用自动配置

# 如果要排除部分自动配置：
在spring-boot-autoconfigure-2.2.0.RELEASE.jar 下找到对应的configuration class
@EnableAutoConfiguration(exclude={**RedisAutoConfiguration.class**})


