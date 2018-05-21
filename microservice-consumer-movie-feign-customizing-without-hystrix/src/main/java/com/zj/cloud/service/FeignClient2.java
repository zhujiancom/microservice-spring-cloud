package com.zj.cloud.service;

import com.zj.config.Configuration2;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name="ccccc", url = "http://localhost:8761/", configuration = Configuration2.class, fallback = HystrixFallbackFeignClient2.class)
public interface FeignClient2 {
}
