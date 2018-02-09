package com.xiduoduo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudConfigClientApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringCloudConfigClientApplication.class, args);
		System.out.println("=================================>Spring Cloud Config Client start success<============================");
	}

}
