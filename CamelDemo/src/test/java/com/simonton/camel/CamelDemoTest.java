package com.simonton.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.Test;

public class CamelDemoTest {

	@Test
	public void demo() throws Exception {
		//Camel 的上下文对象 类似Spring ApplicationContext
		CamelContext context = new DefaultCamelContext();
		// 添加路由
		context.addRoutes(new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("timer://foo?fixedRate=true&delay=0&period=10000")
				.to("http4:www.baidu.com?bridgeEndpoint=true")
				.to("file:/Users/simonton/tmp/baidu?fileName=baidu.html");
			}
		});
		//启动
		context.start();
		while(true) {
			
		}
	}
}
