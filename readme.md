# SpringBoot 核心特点：

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
 
# log
Spring boot 默认的是logback, sprint-boot-starter-logging包里，默认依赖
TRACE->DEBUG->INFO->WARN->ERROR->FATAL->OFF  默认是INFO
全局配置文件： 例如
logging.level.root=WARN
logging.level.org.springframework.web=DEBUG
默认日志是写在控制台，如何写入文件：
logging.file=e:\\springboot\info.log
logging.pattern.console=%d{yyyy/MM/dd-HH:mm:ss} [%thread] %-5level %logger- %msg%n
logging.pattern.file=%d{yyyy/MM/dd-HH:mm:ss} [%thread] %-5level %logger- %msg%n

log4j?

# springboot 开发模式
当修改代码后，服务器自动重启

<!-- 开发模式！ -->	
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>springloaded</artifactId>
	<version>1.2.8.RELEASE</version>			
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>			
</dependency>

# 静态资源
resource下的static文件夹可以直接外部访问
比如：localhost:8080/001.jpg
可以使用全局配置 spring.resources.static-locations=classpath:/static/

# 定义消息转换器，防止乱码
@Bean  //自动放入MVC容器
public StringHttpMessageConverter stringHttpMessageConverter() {
	StringHttpMessageConverter convert = new StringHttpMessageConverter(Charset.forName("UTF-8"));
	return convert;
}

# FastJson: 将Object转为json格式
@Bean
public HttpMessageConverters fastJsonMessageConverter() {
	//创建FastJson的消息转换器
	FastJsonHttpMessageConverter convert =  new FastJsonHttpMessageConverter();
	//创建FastJson的配置对象
	FastJsonConfig config = new FastJsonConfig();
	//对Json数据进行格式化
	config.setSerializerFeatures(SerializerFeature.PrettyFormat);
	convert.setFastJsonConfig(config);
	HttpMessageConverter<?> con = convert;
	return new HttpMessageConverters(con);
}

//使用了FastJson转换器， 详见HelloWorldSpringBootApplication.java
@RequestMapping("/person")    
public Object show() {
	Person person = new Person();
	person.setId(1);
	person.setName("zhourui");
	person.setDate(new Date());        
	return person;
}

注意防止乱码，在全局配置中： spring.http.encoding.force=true

# 拦截器 Interceptor

# 全局异常处理器
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

# 异步调用
@Service
public class AsyncServiceImpl implements AsyncService {

    private static Random random = new Random();
    
    @Async  //异步执行
    @Override
    public Future<String> doTask1() throws Exception {
        System.out.println("任务一开始执行");
        long start=System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end=System.currentTimeMillis();
        System.out.println("任务一结束，耗时：" + (end - start) + " 毫秒");        
        return new AsyncResult<>("任务一结束");
    }

    @Async
    @Override
    public Future<String> doTask2() throws Exception {
        System.out.println("任务二开始执行");
        long start=System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end=System.currentTimeMillis();
        System.out.println("任务二结束，耗时：" + (end - start) + " 毫秒");        
        return new AsyncResult<>("任务二结束");
    }

    @Async
    @Override
    public Future<String> doTask3() throws Exception {
        System.out.println("任务三开始执行");
        long start=System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end=System.currentTimeMillis();
        System.out.println("任务三结束，耗时：" + (end - start) + " 毫秒");        
        return new AsyncResult<>("任务三结束");
    }

启动类开启异步执行
@SpringBootApplication  
@EnableAsync   //启动类开启异步执行
public class HelloWorldSpringBootApplication {...}

