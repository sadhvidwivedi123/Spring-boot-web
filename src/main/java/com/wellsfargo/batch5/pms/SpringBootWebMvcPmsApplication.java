package com.wellsfargo.batch5.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootWebMvcPmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebMvcPmsApplication.class, args);
	}

}
