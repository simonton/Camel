package com.simonton.camel.router.baidu;

import org.springframework.stereotype.Component;

import com.simonton.camel.router.BaseRoute;
import com.simonton.camel.router.utils.ContentTypeUtils;

@Component
public class DownloadRouter extends BaseRoute{

	@Override
	public void doConfigure() {
		//restful 手动触发url
		rest("/baidu")
		.produces(ContentTypeUtils.textPlain())
		.get("/download")
		.route()
		.to("direct:download");
		
		//定时任务触发
		from("quartz2:demo/download?cron=0 */30 8-10 * * ? *&job.name=download&stateful=true")
		.to("direct:download");
		
		//下载业务实现
		from("direct:download")
		.process(exchange -> {
			System.out.println(" download active...");
		})
		.to("http4:www.baidu.com?bridgeEndpoint=true&connectionClose=true")
		.to("file:/Users/simonton/tmp/baidu?fileName=baidu.html")
		.setBody(constant("download success..."))
		.end();
	}

}
