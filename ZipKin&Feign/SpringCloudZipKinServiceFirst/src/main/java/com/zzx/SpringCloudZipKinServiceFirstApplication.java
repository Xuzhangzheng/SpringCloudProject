package com.zzx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class SpringCloudZipKinServiceFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZipKinServiceFirstApplication.class, args);
		System.out.println("=================================>Spring Cloud Zipkin First Server start success<============================");
	}
}
