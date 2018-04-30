package com.zj.cloud.service;

import com.zj.cloud.entity.User;
import com.zj.config.CustomFeignClientConfiguration;
import feign.Param;
import feign.RequestLine;
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
@FeignClient(name="microservice-provider-user",configuration = CustomFeignClientConfiguration.class)
public interface UserFeignClient {
    @RequestLine("GET /simple/{id}")
    User findById(@Param("id") Long id);
}
