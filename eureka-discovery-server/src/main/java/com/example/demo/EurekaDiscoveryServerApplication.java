package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
/*
 * We have configured eureka-discovery-server micro service in which we can see
 * our all the registered micro services that can be accessed in localhost by
 * using below URL: http://localhost:8761/
 */
@EnableEurekaServer // to make this micro service as eureka discovery server to monitor and view all
					// the micro services
public class EurekaDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDiscoveryServerApplication.class, args);
	}

}
