package com.zzx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class SpringCloudZipKinServiceSecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZipKinServiceSecondApplication.class, args);
		System.out.println("=================================>Spring Cloud Zipkin Second Server start success<============================");
	}
}
