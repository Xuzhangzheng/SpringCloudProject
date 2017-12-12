package com.xiduoduo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
// 断路器 start
@EnableHystrix
// 断路器 end
public class SpringCloudSpringRibbonApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringCloudSpringRibbonApplication.class, args);
		System.out.println("=================================>Spring Cloud Ribbon start success<============================");
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate() ;
	}
}
