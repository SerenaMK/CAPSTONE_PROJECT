package com.daedalus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("com.daedalus")
//@SpringBootApplication(scanBasePackages = {"com.daedalus"})
@SpringBootApplication
public class DaedalusApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaedalusApplication.class, args);
	}

}
