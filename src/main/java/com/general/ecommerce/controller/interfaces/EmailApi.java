package com.general.ecommerce.controller.interfaces;

import com.general.ecommerce.model.request.EmailRequest;
import com.general.ecommerce.model.response.ContractResponse;
import feign.Param;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@Api(
    value = "ecommerce"
)
public interface EmailApi {

  @ApiOperation(
      tags = {"Email Controller - All Endpoints"},
      value = "Send a new email.",
      notes = "This endpoint is used to send a new email.")
  @ApiResponses({
    @ApiResponse(code = 200, message = "Sent", response = ContractResponse.class),
    @ApiResponse(code = 400, message = "Bad Request", response = ContractResponse.class),
    @ApiResponse(code = 404, message = "Not Found", response = ContractResponse.class),
    @ApiResponse(code = 500, message = "Internal Server Failure", response = ContractResponse.class)
  })
  ContractResponse<Object> sendEmail(
          @Param String email,
          @RequestBody EmailRequest emailRequest, HttpServletRequest request);

}
