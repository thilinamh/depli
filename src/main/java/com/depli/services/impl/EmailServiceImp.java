package com.depli.services.impl;

/**
 * Created by lpsandaruwan on 5/21/17.
 */
/*
@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    // get admin mail address from application properties
    @Value("${spring.mail.username}")
    private String fromMail;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String toEmail, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom(fromMail);

        javaMailSender.send(mailMessage);
    }
}
**/