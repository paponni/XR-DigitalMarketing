package com.orange.XRDigitalMarketing.services.impl;

import com.orange.XRDigitalMarketing.services.EmailSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@Slf4j
public class EmailImpl implements EmailSender {

    private final JavaMailSender mailSender;

    public EmailImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Confirm your email");
            helper.setFrom("projectXr@orange.ma");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.info("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }

    }

