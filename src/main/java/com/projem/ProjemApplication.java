package com.projem;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ProjemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjemApplication.class, args);
	}

}
