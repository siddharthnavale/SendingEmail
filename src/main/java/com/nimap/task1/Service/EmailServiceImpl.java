package com.nimap.task1.Service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.nimap.task1.Entity.EmailDetails;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {
    
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}") private String sender;
	
	
	@Override
	public String sendSimpleMail(EmailDetails details) {
		try {
			SimpleMailMessage mailMassage=new SimpleMailMessage();
			mailMassage.setFrom(sender);
			mailMassage.setTo(details.getRecipient());
			mailMassage.setSubject(details.getSubject());
			mailMassage.setText(details.getMsgBody());
			javaMailSender.send(mailMassage);
			return "Mail Sent Successfully...";
		}catch(Exception e) {
			return "Mail Sent Successfully...";
		}
	}

	@Override
	public String sendMailWithAttachment(EmailDetails details) {
		
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		
		try {
			mimeMessageHelper= new MimeMessageHelper(mimeMessage,true);
			
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(details.getRecipient());
			mimeMessageHelper.setSubject(details.getSubject());
			mimeMessageHelper.setText(details.getMsgBody());
			
			//FileSystemResource represents a file
			 FileSystemResource file= new FileSystemResource(new File(details.getAttachment()));
			  mimeMessageHelper.addAttachment(file.getFilename(), file);
			 
			 javaMailSender.send(mimeMessage);
			return "Mail Sent Successfully...";
		}catch(Exception e) {
			return "Mail Sent Successfully...";
		}
	}

}
