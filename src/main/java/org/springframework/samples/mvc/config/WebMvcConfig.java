package org.springframework.samples.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/*  Author: kevin
 *	Date: 2018年6月10日
**/
//@Configuration("myWebMvcConfig")
//@EnableAsync
public class WebMvcConfig extends WebMvcConfigurationSupport {
//	@Override
	public void configureAsyncSupport(final AsyncSupportConfigurer configurer) {
		configurer.setDefaultTimeout(60 * 1000L);
		configurer.registerCallableInterceptors(timeoutInterceptor());
		configurer.setTaskExecutor(threadPoolTaskExecutor());
	}

//	@Bean
	public TimeoutCallableProcessingInterceptor timeoutInterceptor() {
		return new TimeoutCallableProcessingInterceptor();
	}

//	@Bean
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor t = new ThreadPoolTaskExecutor();
		t.setCorePoolSize(10);
		t.setMaxPoolSize(50);
		t.setThreadNamePrefix("YJH");
		return t;
	}
}
