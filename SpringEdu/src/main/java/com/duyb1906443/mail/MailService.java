package com.duyb1906443.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	public static List<MailHolder> mailHolders;
	
	private JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("springedu2023@gmail.com");
		mailSender.setPassword("frygatdszvocteky");
		
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", "true");	
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.debug", "true");
		javaMailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		mailSender.setJavaMailProperties(javaMailProperties);
		
		return mailSender;
	}
	
	public void sendMail(String from, String to, String subject, String content) {
		if(mailHolders == null) {
			mailHolders = new ArrayList<MailHolder>();
		}
		
		String fromMailAddress = "tigerstranstudio69@gmail.com";
		if(from != null) {
			fromMailAddress = from;
		}
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setFrom(fromMailAddress);
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(content);
		
		getMailSender().send(simpleMailMessage);
	}
	
}
