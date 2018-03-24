package com.simonton.camel.router;

import org.apache.camel.builder.RouteBuilder;

public abstract class BaseRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		handleException();
		doConfigure();
	}
	
	public abstract void doConfigure();
	
	public void handleException() {
		onException(Exception.class)
		.handled(true)
		.transform()
		.body()
		.setBody(constant("系统异常"))
		.end();
	}

}
