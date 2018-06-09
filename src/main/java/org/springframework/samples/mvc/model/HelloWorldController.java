package org.springframework.samples.mvc.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {  
	  
    @RequestMapping(value = "/helloworld.do")  
    @ModelAttribute("attributeName")  
    public String helloworld() {  
       return "hi";  
    }  
}
