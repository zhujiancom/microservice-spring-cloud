package com.zj.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zj.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhuji on 4/24/2018.
 */
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public User findById(@PathVariable Long id){
        //VIP: 虚拟ip：microservice-provider-user
        User user = restTemplate.getForObject("http://microservice-provider-user/simple/"+id,User.class);
        return user;
    }

    public User findByIdFallback(Long id){
        User user = new User();
        user.setId(0);
        return user;
    }
}
