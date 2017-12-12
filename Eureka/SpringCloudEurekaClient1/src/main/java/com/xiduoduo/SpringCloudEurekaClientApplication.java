package com.xiduoduo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudEurekaClientApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringCloudEurekaClientApplication.class, args);
		System.out.println("=================================>Spring Cloud EureKa Client start success<============================");
	}
}
