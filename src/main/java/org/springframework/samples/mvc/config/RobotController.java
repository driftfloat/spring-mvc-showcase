package org.springframework.samples.mvc.config;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*  Author: kevin
 *	Date: 2018年6月10日
**/
@Controller
public class RobotController {

    @Autowired
    private GitHubLookupService gitHubLookupService;

    @RequestMapping(value = "/async", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Callable<String> async() {

        return new Callable<String>() {

            @Override
            public String call() throws Exception {
                return gitHubLookupService.findUser("CloudFoundry");
            }
        };
    }
}