package com.app.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

//@Configuration
public class MailConfig {
   
	@Value("${spring.mail.host}")
	String host;
	
	@Value("${spring.mail.port}")
	int port;
	
	@Value("${spring.mail.username}")
	String username;
	
	@Value("${spring.mail.password}")
	String password;
	
	@Value("${spring.mail.properties.mail.smtp.auth}")
	boolean isauth;
	
	@Value("${spring.mail.properties.mail.smtp.starttls.enable}")
	boolean istls;
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost(host);
	    mailSender.setPort(port);
	     
	    mailSender.setUsername(username);
	    mailSender.setPassword(password);
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", isauth);
	    props.put("mail.smtp.starttls.enable", istls);
	    props.put("mail.debug", "true");
	     
	    return mailSender;
	}
}
