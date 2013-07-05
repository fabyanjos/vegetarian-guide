package com.fabiale.vegetarianguide.service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.fabiale.vegetarianguide.model.Contact;

public interface MailService {
	
	public void send(Contact contact) throws AddressException, MessagingException;

}
