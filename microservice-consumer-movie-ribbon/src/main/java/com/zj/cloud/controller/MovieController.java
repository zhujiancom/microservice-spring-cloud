package com.zj.cloud.controller;

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

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id){
        //VIP: 虚拟ip：microservice-provider-user
        User user = restTemplate.getForObject("http://microservice-provider-user/simple/"+id,User.class);
        return user;
    }

    @GetMapping("/test")
    public String test(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        System.out.println("1. "+serviceInstance.getHost()+":"+serviceInstance.getPort()+":"+ serviceInstance.getServiceId());



        ServiceInstance serviceInstance2 = loadBalancerClient.choose("microservice-provider-user-2");
        System.out.println("2. "+serviceInstance2.getHost()+":"+serviceInstance2.getPort()+":"+ serviceInstance2.getServiceId());
        System.out.println("-----------------------------------------");
        return "1";
    }
}
