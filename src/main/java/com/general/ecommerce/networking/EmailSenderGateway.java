package com.general.ecommerce.networking;

public interface EmailSenderGateway {

    void sendEmail(String to, String subject, String body);
}
