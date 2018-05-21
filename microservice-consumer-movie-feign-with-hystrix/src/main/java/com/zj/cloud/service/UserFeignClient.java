package com.zj.cloud.service;

import com.zj.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhuji on 4/29/2018.
 */
@FeignClient(name="microservice-provider-user",fallback = HystrixFallbackFeignClient.class)
public interface UserFeignClient {
    @RequestMapping(value = "/simple/{id}",method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);// @GetMapping 不支持， @PathVariable需要设置value

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public User postUser(@RequestBody User user);

}
