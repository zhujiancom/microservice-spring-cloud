package com.zj.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
public class ZuulFileUploadApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ZuulFileUploadApplication.class, args);
    }
}
