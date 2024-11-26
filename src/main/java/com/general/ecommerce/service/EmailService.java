package com.general.ecommerce.service;

public interface EmailService {

  /**
   * Send a new email from given email.
   *
   * @param to Email address
   * @param subject Email subject
   * @param body Email body
   * @return NetworkingResponse
   */
  void sendEmail(String to, String subject, String body);

  /**
   * Send a new email from default email address.
   *
   * @param subject Email subject
   * @param body Email body
   * @return NetworkingResponse
   */
  void sendEmail(String subject, String body);

}
