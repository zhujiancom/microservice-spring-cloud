package com.zj.cloud.service;

import com.zj.cloud.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class HystrixFallbackFeignClient implements UserFeignClient {
    @Override
    public User findById(@PathVariable("id") Long id) {
        return null;
    }

    @Override
    public User postUser(@RequestBody User user) {
        return null;
    }
}
