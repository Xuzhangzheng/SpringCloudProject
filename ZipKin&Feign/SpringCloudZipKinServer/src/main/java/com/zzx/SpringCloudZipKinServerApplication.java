package com.zzx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class SpringCloudZipKinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZipKinServerApplication.class, args);
		System.out.println("=================================>Spring Cloud ZipKin Server start success<============================");
	}
}
