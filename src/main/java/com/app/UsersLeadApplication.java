package com.app;

import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.app.property.FileStorageProperties;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableWebMvc
@EnableConfigurationProperties({
	FileStorageProperties.class
})
@EnableScheduling
@EnableSwagger2
public class UsersLeadApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersLeadApplication.class, args);
	}
}
