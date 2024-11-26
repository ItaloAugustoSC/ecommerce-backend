package com.general.ecommerce.service;

import com.general.ecommerce.networking.EmailSenderGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

  private final String TO_EMAIL_ADDRESS = "italo.augusto.ct@gmail.com";
  private final EmailSenderGateway emailSenderGateway;

  @Autowired
  public EmailServiceImpl(EmailSenderGateway emailSenderGateway) {
    this.emailSenderGateway = emailSenderGateway;
  }

  @Override
  public void sendEmail(String to, String subject, String body) {
      this.emailSenderGateway.sendEmail(to, subject, body);
  }

  @Override
  public void sendEmail(String subject, String body) {
    this.emailSenderGateway.sendEmail(TO_EMAIL_ADDRESS, subject, body);
  }
}
