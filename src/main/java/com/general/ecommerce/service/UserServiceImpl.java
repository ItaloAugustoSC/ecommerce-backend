package com.general.ecommerce.service;

import com.general.ecommerce.entity.UserEntity;
import com.general.ecommerce.exception.BadRequestException;
import com.general.ecommerce.model.request.*;
import com.general.ecommerce.model.response.GetUserResponse;
import com.general.ecommerce.repository.UserRepository;
import com.general.ecommerce.service.mapper.UserMapper;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired private UserRepository userRepository;
  @Autowired private UserMapper userRequestMapper;
  @Autowired private EmailService emailService;

  @Override
  public void createUser(CreateUserRequest user) {

    validateUserId(user);

    validateUserCountry(user);
    validateUserLanguage(user);

    UserEntity userEntity = userRequestMapper.map(user);

    userRepository.save(userEntity);

    emailService.sendEmail("User created - Ecommerce",
            "Your user was created successfully!");
  }

  @Override
  public void deleteUser(String email) {
    if (userRepository.findById(email).isEmpty()) {
      throw new BadRequestException("Email does not exist.");
    }

    userRepository.deleteById(email);

    emailService.sendEmail("User deleted - Ecommerce",
            "Your user was deleted successfully!");
  }

  @Override
  public void changePassword(ChangePasswordRequest passwordRequest) {
    if (userRepository.findById(passwordRequest.getEmailAddress()).isEmpty()) {
      throw new BadRequestException("User not found.");
    }

    Optional<UserEntity> user = userRepository.findById(passwordRequest.getEmailAddress());

    if (!user.get().getPassword().equals(passwordRequest.getActualPassword())) {
      throw new BadRequestException("Wrong password");
    }
    user.get().setPassword(passwordRequest.getNewPassword());
    UserEntity entity = user.get();
    userRepository.save(entity);
  }

  @Override
  public GetUserResponse getUser(String email) {
    Optional<UserEntity> user = userRepository.findById(email);

    if (user.isEmpty()) {
      throw new BadRequestException("User not found");
    }

    UserEntity entity = user.get();

    return userRequestMapper.mapToGetUserResponse(entity);
  }

  @Override
  public void login(LoginRequest loginRequest) {

    Optional<UserEntity> user = userRepository.findById(loginRequest.getEmailAddress());

    if (user.isEmpty()) {
      throw new BadRequestException("User not found!");
    }

    if (!user.get().getPassword().equals(loginRequest.getPassword())) {
      throw new BadRequestException("Wrong password");
    }
  }

  @Override
  public void logout(LogoutRequest logoutRequest) {

    Optional<UserEntity> user = userRepository.findById(logoutRequest.getEmailAddress());

    if (user.isEmpty()) {
      throw new BadRequestException("User not found!");
    }
  }

  @Override
  public void resetPassword(ResetPasswordRequest passwordRequest) {
    if (userRepository.findById(passwordRequest.getEmailAddress()).isEmpty()) {
      throw new BadRequestException("User not found.");
    }

    Optional<UserEntity> user = userRepository.findById(passwordRequest.getEmailAddress());

    user.get().setPassword(passwordRequest.getNewPassword());
    UserEntity entity = user.get();
    userRepository.save(entity);
  }

  /**
   * Validate if the user email already exists.
   *
   * @param user The user request
   */
  public void validateUserId(CreateUserRequest user) {

    if (userRepository.findById(user.getEmailAddress()).isPresent()) {
      throw new BadRequestException("Email address already exists!");
    }
  }

  /**
   * Validate if the user country are null or blank and set default values.
   *
   * @param user The user request
   */
  public void validateUserCountry(CreateUserRequest user) {
    if (user.getCountry() == null || user.getCountry().isBlank()) {
      user.setCountry("US");
    }
  }

  /**
   * Validate if the user language are null or blank and set default values.
   *
   * @param user The user request
   */
  public void validateUserLanguage(CreateUserRequest user) {
    if (user.getLanguage() == null || user.getLanguage().isBlank()) {
      user.setLanguage("en_US");
    }
  }
}
