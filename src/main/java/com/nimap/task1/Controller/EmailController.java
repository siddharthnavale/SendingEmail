package com.nimap.task1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.task1.Entity.EmailDetails;
import com.nimap.task1.Service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;

	// sending simple text
	@PostMapping("/sendMail")
	public String sendEmail(@RequestBody EmailDetails details) {

		return emailService.sendSimpleMail(details);

	}

	// Sending Email With Attachment
	@PostMapping("/sendEmailWithAttachment")
	public String sendEmailWithAttachment(@RequestBody EmailDetails details) {
		
		return emailService.sendMailWithAttachment(details);
	}
}
