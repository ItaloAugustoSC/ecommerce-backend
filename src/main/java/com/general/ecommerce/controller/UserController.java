package com.general.ecommerce.controller;

import com.general.ecommerce.controller.interfaces.UserApi;
import com.general.ecommerce.model.request.ChangePasswordRequest;
import com.general.ecommerce.model.request.CreateUserRequest;
import com.general.ecommerce.model.request.LoginRequest;
import com.general.ecommerce.model.request.LogoutRequest;
import com.general.ecommerce.model.request.ResetPasswordRequest;
import com.general.ecommerce.model.response.ContractResponse;
import com.general.ecommerce.model.response.GetUserResponse;
import com.general.ecommerce.service.UserService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController implements UserApi {

  private final UserService userService;

  @Override
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(produces = "application/json")
  public ContractResponse<Object> createUser(CreateUserRequest user, HttpServletRequest request) {

    userService.createUser(user);

    ContractResponse<Object> response =
        ContractResponse.builder().path(request.getServletPath()).build();

    return response;
  }

  @Override
  @GetMapping
  public ContractResponse<GetUserResponse> getUser(String email, HttpServletRequest request) {

    GetUserResponse userResponse = userService.getUser(email);

    ContractResponse<GetUserResponse> response = new ContractResponse<>();
    response.setPath(request.getServletPath());
    response.setResponse(userResponse);
    return response;
  }

  @Override
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping
  public ContractResponse<Object> deleteUser(
      @RequestHeader String email, HttpServletRequest request) {

    userService.deleteUser(email);

    ContractResponse<Object> response =
        ContractResponse.builder().path(request.getServletPath()).build();
    return response;
  }

  @Override
  @ResponseStatus(HttpStatus.OK)
  @PutMapping("/changePassword")
  public ContractResponse<Object> changePassword(
      @RequestBody ChangePasswordRequest passwordRequest, HttpServletRequest request) {

    userService.changePassword(passwordRequest);

    ContractResponse<Object> response =
        ContractResponse.builder().path(request.getServletPath()).build();
    return response;
  }

  @Override
  @ResponseStatus(HttpStatus.OK)
  @PutMapping("/resetPassword")
  public ContractResponse<Object> resetPassword(
      ResetPasswordRequest passwordRequest, HttpServletRequest request) {

    userService.resetPassword(passwordRequest);

    ContractResponse<Object> response =
        ContractResponse.builder().path(request.getServletPath()).build();
    return response;
  }

  @Override
  @ResponseStatus(HttpStatus.OK)
  @PostMapping("/login")
  public ContractResponse<Object> login(LoginRequest loginRequest, HttpServletRequest request) {

    userService.login(loginRequest);

    ContractResponse<Object> response =
        ContractResponse.builder().path(request.getServletPath()).build();
    return response;
  }

  @Override
  @ResponseStatus(HttpStatus.OK)
  @PostMapping("/logout")
  public ContractResponse<Object> logout(LogoutRequest logoutRequest, HttpServletRequest request) {

    userService.logout(logoutRequest);

    ContractResponse<Object> response =
        ContractResponse.builder().path(request.getServletPath()).build();
    return response;
  }
}
