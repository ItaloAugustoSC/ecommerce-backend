package com.general.ecommerce.controller;

import com.general.ecommerce.controller.interfaces.EmailApi;
import com.general.ecommerce.model.request.EmailRequest;
import com.general.ecommerce.model.response.ContractResponse;
import com.general.ecommerce.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailController implements EmailApi {

  private final EmailService emailService;

  @PostMapping("/email")
  @Override
  public ContractResponse<Object> sendEmail(String email, EmailRequest emailRequest, HttpServletRequest request) {

    emailService.sendEmail(email, emailRequest.subject(), emailRequest.body());

    ContractResponse<Object> response =
            ContractResponse.builder().path(request.getServletPath()).build();
    return response;
  }
}
