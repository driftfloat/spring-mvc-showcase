package org.springframework.samples.mvc.config;

import org.springframework.stereotype.Service;

/*  Author: kevin
 *	Date: 2018年6月10日
 *  https://blog.csdn.net/RO_wsy/article/details/51334504
 *    为Spring MVC开启异步任务
**/
@Service
public class GitHubLookupService {

//    RestTemplate restTemplate = new RestTemplate();

    public String findUser(String user) throws InterruptedException {

        System.out.println("Looking up " + user);
//        String results = restTemplate.getForObject("https://api.github.com/users/" + user, User.class);
        String results = "https://api.github.com/users/" + user;
        Thread.sleep(200L);//sleep 5s，可以更显著的看到效果
        return results;
    }

}
