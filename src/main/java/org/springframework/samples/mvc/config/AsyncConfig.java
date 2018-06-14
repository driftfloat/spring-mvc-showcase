package org.springframework.samples.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableAsync
public class AsyncConfig extends WebMvcConfigurationSupport {

	@Bean(name= {"myThreadPoolTaskExecutor"})
    public ThreadPoolTaskExecutor getAsyncExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(30);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("geym-task-");
        executor.initialize();
        return executor;
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
    	super.configureAsyncSupport(configurer);
//    	getApplicationContext().getBean("asyncExecutor")
//        configurer.setTaskExecutor(getAsyncExecutor());
    	configurer.setTaskExecutor((ThreadPoolTaskExecutor)getApplicationContext().getBean("myThreadPoolTaskExecutor"));
    }
}