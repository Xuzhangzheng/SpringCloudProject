package com.zzx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class SpringCloudZipKinServiceThirdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZipKinServiceThirdApplication.class, args);
		System.out.println("=================================>Spring Cloud Zipkin Third Server start success<============================");
	}
}
