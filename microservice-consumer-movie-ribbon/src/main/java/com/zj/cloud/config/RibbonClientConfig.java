package com.zj.cloud.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhuji on 4/26/2018.
 */
@Configuration
@RibbonClient(name = "microservice-provider-user",configuration = MyRibbonClientConfiguration.class)
public class RibbonClientConfig {
}
