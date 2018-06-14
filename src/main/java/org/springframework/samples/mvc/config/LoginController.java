package org.springframework.samples.mvc.config;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.servlet.ModelAndView;

/*  Author: kevin
 *	Date: 2018年6月10日
 *  http://www.bkjia.com/Javabc/1300716.html   
 *
**/

@Controller
public class LoginController {
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public WebAsyncTask<ModelAndView> longTimeTask(){
	  System.out.println("/login被调用 thread id is : " + Thread.currentThread().getName());
	  Callable<ModelAndView> callable = new Callable<ModelAndView>() {
	      public ModelAndView call() throws Exception {
	        Thread.sleep(1000); //模拟长时间任务
	        ModelAndView mav = new ModelAndView("login/index");
	        System.out.println("执行成功 thread id is : " + Thread.currentThread().getName());
	        return mav;
	      }
	  };
	  return new WebAsyncTask<ModelAndView>(callable);
	}
}
