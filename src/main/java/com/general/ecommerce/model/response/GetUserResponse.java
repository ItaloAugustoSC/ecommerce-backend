package com.general.ecommerce.model.response;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ApiModel
public class GetUserResponse {

  private String firstName;
  private String lastName;
  private String emailAddress;
  private String password;
  private String gender;
  private String dateOfBirth;
  private String country;
  private String language;
}
