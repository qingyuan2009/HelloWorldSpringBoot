# Spring boot 核心特点：

*	用jar包执行web程序
*	内嵌servlet容器， 比如tomcat, Jetty...
*	Maven配置
*	自动配置Bean
*	对项目进行监控
* 	Annotation

# Create Maven project

## POM 的父级依赖

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.2.0.RELEASE</version>		 
	</parent>
	
	* 对架包版本进行管理，例如：
	<mysql.version>8.0.18</mysql.version>

## POM dependency

	//spring-boot-starter-web 包含了spring + spring mvc + log + Tomcat ...
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>	
	
	* 包含了Spring MVC 和 Spring的架包...
	
## POM 指定JDK 版本

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

对POM中dependency的架包进行自动配置，原理是：
在依赖包：spring-boot-autoconfigure-2.2.0.release.jar/META-INF/spring.factories
例如调用redis的路径：
org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration,\ -> 它会调用RedisProperties.class
里面有很多初始化值，如果我们需要overwrite，则需要在我们自己的properties文件中重定义

# 如果要排除部分自动配置：
在spring-boot-autoconfigure-2.2.0.RELEASE.jar 下找到对应的configuration class
@EnableAutoConfiguration(exclude={**RedisAutoConfiguration.class**})

# 全局配置文件
application.properties 或 application.yml 通常在resource下，两种文件都会被访问

server.port=8080
server.context-path=/root

# profile
application-dev.properties
application-prod.properties
application-sit.properties
在application.properties中使用： spring.profiles.active=dev

# 如何创建父工程和子工程

**如果我们想拥有自己的父工程**，创建POM父工程：
<dependencyManagement>
    <dependencies>
    	<dependency>
    		<groupId>org.springframework.boot</groupId>
    		<artifactId>spring-boot-dependencies</artifactId>
    		<version>2.2.0.RELEASE</version>
    		<!-- 如果没有type和scope，子工程的dependency无法继承父工程的版本管理 -->
    		<type>pom</type>
    		<scope>import</scope>
    	</dependency>
    </dependencies>
</dependencyManagement>
 
<build>
	<plugins>			
		<!-- 指定JDK版本 -->
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-compiler-plugin</artifactId>
			<configuration>
				<source>1.8</source>
				<target>1.8</target>
			</configuration>
		</plugin>			
	</plugins>
</build>

**创建POM子工程**：
右击父工程，创建Maven Module
POM中可以看到使用了自己的父工程，并可以添加例如：
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>

# 整合测试
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>		
<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<scope>test</scope>
</dependency>

测试见test package
 


