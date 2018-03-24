package com.simonton.camel.router.demo;

import org.springframework.stereotype.Component;

import com.simonton.camel.router.BaseRoute;
import com.simonton.camel.router.utils.ContentTypeUtils;

@Component
public class HelloRouter extends BaseRoute{

	@Override
	public void doConfigure() {
		rest()
		.produces(ContentTypeUtils.textPlain())
		.get("/hello")
		.route()
		.process(exchange -> {
			System.out.println(" invoke /hello");
			throw new RuntimeException();
		})
		.to("direct:done");
		
		
		from("direct:done")
		.transform()
		.body()
		.setBody(constant("hello world"))
		.end();
		
	}

}
