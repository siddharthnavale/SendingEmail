package com.nimap.task1.Service;

import com.nimap.task1.Entity.EmailDetails;

public interface EmailService {
	 
   
    String sendSimpleMail(EmailDetails details);
 
    
    String sendMailWithAttachment(EmailDetails details);
}
