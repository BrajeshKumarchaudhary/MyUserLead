package com.app.util;

import java.io.File;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

/*
 *Uncommnet when all properties is set
 */
@Component
public class SendMailer {
	@Autowired
	private JavaMailSender emailSender;
	@Autowired
	private SpringTemplateEngine templateEngine;
	@Value("${mail.from}")
	String from;
	@Value("${mail.subject}")
	String subject;

	
	/**
	 * @param to
	 * @param text
	 * Send Simple text message to email
	 */
	public void sendSimpleMessage(String to,String text) {
		try {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("New Lead");
		message.setText(text);
		emailSender.send(message);
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * @param to
	 * @throws MessagingException
	 * send mailer to Email
	 */
	public void sendmailer(String to) throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());
		Context context = new Context();
		String html = templateEngine.process("LeadMailer", context);
		helper.setTo(to);
		helper.setText(html, true);
		helper.setSubject(subject);
		helper.setFrom(from);
        emailSender.send(message);
	}

	/**
	 * @param to
	 * @param subject
	 * @param text
	 * @param pathToAttachment
	 * @throws MessagingException
	 * send  mail with attachment
	 */
	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment)
			throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(from);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(text);
		FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
		helper.addAttachment("Invoice", file);
		emailSender.send(message);
	}

}
