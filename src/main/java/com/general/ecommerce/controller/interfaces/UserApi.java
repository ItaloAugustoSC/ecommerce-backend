package com.general.ecommerce.controller.interfaces;

import com.general.ecommerce.model.request.ChangePasswordRequest;
import com.general.ecommerce.model.request.CreateUserRequest;
import com.general.ecommerce.model.request.LoginRequest;
import com.general.ecommerce.model.request.LogoutRequest;
import com.general.ecommerce.model.request.ResetPasswordRequest;
import com.general.ecommerce.model.response.ContractResponse;
import com.general.ecommerce.model.response.GetUserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.data.repository.query.Param;

@Api(
    value = "ecommerce",
    tags = {"User Controller - All Endpoints"})
public interface UserApi {

  @ApiOperation(
      tags = {"User Controller - All Endpoints"},
      value = "Create a new user.",
      notes = "This endpoint is used to register a new Ecommerce app user.")
  @ApiResponses({
    @ApiResponse(code = 201, message = "Created", response = ContractResponse.class),
    @ApiResponse(code = 400, message = "Bad Request", response = ContractResponse.class),
    @ApiResponse(code = 404, message = "Not Found", response = ContractResponse.class),
    @ApiResponse(code = 500, message = "Internal Server Failure", response = ContractResponse.class)
  })
  ContractResponse<Object> createUser(
      @Valid @ApiParam(value = "user") CreateUserRequest user, HttpServletRequest request);

  @ApiOperation(
      tags = {"User Controller - All Endpoints"},
      value = "Get a user.",
      notes = "This endpoint is used to get a Ecommerce app user.")
  @ApiResponses({
    @ApiResponse(code = 201, message = "Created", response = ContractResponse.class),
    @ApiResponse(code = 400, message = "Bad Request", response = ContractResponse.class),
    @ApiResponse(code = 404, message = "Not Found", response = ContractResponse.class),
    @ApiResponse(code = 500, message = "Internal Server Failure", response = ContractResponse.class)
  })
  ContractResponse<GetUserResponse> getUser(
      @Param(value = "email") String email, HttpServletRequest request);

  @ApiOperation(
      tags = {"User Controller - All Endpoints"},
      value = "Delete an user.",
      notes = "This endpoint is used to delete an Ecommerce app user.")
  @ApiResponses({
    @ApiResponse(code = 201, message = "Created", response = ContractResponse.class),
    @ApiResponse(code = 400, message = "Bad Request", response = ContractResponse.class),
    @ApiResponse(code = 404, message = "Not Found", response = ContractResponse.class),
    @ApiResponse(code = 500, message = "Internal Server Failure", response = ContractResponse.class)
  })
  ContractResponse<Object> deleteUser(
      @Param(value = "email") String email, HttpServletRequest request);

  @ApiOperation(
      tags = {"User Controller - All Endpoints"},
      value = "Change an user password.",
      notes = "This endpoint is used to change an Ecommerce app user password.")
  @ApiResponses({
    @ApiResponse(code = 201, message = "Created", response = ContractResponse.class),
    @ApiResponse(code = 400, message = "Bad Request", response = ContractResponse.class),
    @ApiResponse(code = 404, message = "Not Found", response = ContractResponse.class),
    @ApiResponse(code = 500, message = "Internal Server Failure", response = ContractResponse.class)
  })
  ContractResponse<Object> changePassword(
      ChangePasswordRequest passworkRequest, HttpServletRequest request);

  @ApiOperation(
      tags = {"User Controller - All Endpoints"},
      value = "Reset an user password.",
      notes = "This endpoint is used to reset an Ecommerce app user password.")
  @ApiResponses({
    @ApiResponse(code = 201, message = "Created", response = ContractResponse.class),
    @ApiResponse(code = 400, message = "Bad Request", response = ContractResponse.class),
    @ApiResponse(code = 404, message = "Not Found", response = ContractResponse.class),
    @ApiResponse(code = 500, message = "Internal Server Failure", response = ContractResponse.class)
  })
  ContractResponse<Object> resetPassword(
      ResetPasswordRequest passworkRequest, HttpServletRequest request);

  @ApiOperation(
      tags = {"User Controller - All Endpoints"},
      value = "Login a user.",
      notes = "This endpoint is used to login a Ecommerce app user.")
  @ApiResponses({
    @ApiResponse(code = 201, message = "Created", response = ContractResponse.class),
    @ApiResponse(code = 400, message = "Bad Request", response = ContractResponse.class),
    @ApiResponse(code = 404, message = "Not Found", response = ContractResponse.class),
    @ApiResponse(code = 500, message = "Internal Server Failure", response = ContractResponse.class)
  })
  ContractResponse<Object> login(
      @Valid @ApiParam(value = "login") LoginRequest loginRequest, HttpServletRequest request);

  @ApiOperation(
      tags = {"User Controller - All Endpoints"},
      value = "Logout a user.",
      notes = "This endpoint is used to logout a Ecommerce app user.")
  @ApiResponses({
    @ApiResponse(code = 201, message = "Created", response = ContractResponse.class),
    @ApiResponse(code = 400, message = "Bad Request", response = ContractResponse.class),
    @ApiResponse(code = 404, message = "Not Found", response = ContractResponse.class),
    @ApiResponse(code = 500, message = "Internal Server Failure", response = ContractResponse.class)
  })
  ContractResponse<Object> logout(
      @Valid @ApiParam(value = "logout") LogoutRequest logoutRequest, HttpServletRequest request);
}
