package com.springboot.service;

import com.springboot.domain.mail.Mail;

public interface EmailService {

	void sendMessage(Mail mail);
	
}
