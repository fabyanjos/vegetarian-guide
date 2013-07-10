package com.fabiale.vegetarianguide.service.impl;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiale.vegetarianguide.model.Contact;
import com.fabiale.vegetarianguide.service.MailService;
import com.fabiale.vegetarianguide.spring.MailConfig;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired Session session;

	public void send(Contact contact) throws AddressException, MessagingException {
		Message message = new MimeMessage(session);
		message.setReplyTo(InternetAddress.parse(contact.getEmail()));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(MailConfig.EMAIL_ADDRESS));
		message.setSubject(contact.getSubject());
		String msg = "<b>From: </b>" + contact.getName() + " " + contact.getEmail();
		msg += "<br/><br/>" + contact.getDescription();
		message.setContent(msg, "text/html; charset=utf-8");

		Transport.send(message);
	}
}
