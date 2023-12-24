package com.general.ecommerce.service;

import com.general.ecommerce.model.request.ChangePasswordRequest;
import com.general.ecommerce.model.request.CreateUserRequest;
import com.general.ecommerce.model.request.LoginRequest;
import com.general.ecommerce.model.request.LogoutRequest;
import com.general.ecommerce.model.request.ResetPasswordRequest;
import com.general.ecommerce.model.response.GetUserResponse;

public interface UserService {

  /**
   * Creates a new user.
   *
   * @param user User object with the properties
   * @return NetworkingResponse
   */
  void createUser(CreateUserRequest user);

  /**
   * Deletes a user.
   *
   * @param email User's email
   * @return NetworkingResponse
   */
  void deleteUser(String email);

  /**
   * Changes a user password.
   *
   * @param passwordRequest User's change password request
   * @return NetworkingResponse
   */
  void changePassword(ChangePasswordRequest passwordRequest);

  /**
   * Get a user.
   *
   * @param email User's email
   * @return NetworkingResponse
   */
  GetUserResponse getUser(String email);

  /**
   * Login a user.
   *
   * @param loginRequest User's login request
   * @return NetworkingResponse
   */
  void login(LoginRequest loginRequest);

  /**
   * Logout a user.
   *
   * @param logoutRequest User's logout request
   * @return NetworkingResponse
   */
  void logout(LogoutRequest logoutRequest);

  /**
   * Resets a user password.
   *
   * @param passwordRequest User's reset password request
   * @return NetworkingResponse
   */
  void resetPassword(ResetPasswordRequest passwordRequest);
}
