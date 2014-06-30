package com.fabiale.vegetarianguide.spring;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailConfig {
	
	public static final String EMAIL_ADDRESS = System.getenv("EMAIL_ADDRESS");
	public static final String EMAIL_PASSWORD = System.getenv("EMAIL_PASSWORD");

	@Bean
	public Session mailSession() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								EMAIL_ADDRESS, EMAIL_PASSWORD);
					}
				});
		return session;
	}

}
