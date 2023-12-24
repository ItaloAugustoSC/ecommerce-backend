package com.general.ecommerce.model.request;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class ChangePasswordRequest {

  @ApiModelProperty(example = "testing@test.com")
  @NotBlank
  @ToString.Exclude
  private String emailAddress;

  @ApiModelProperty(example = "testing")
  @ToString.Exclude
  @NotBlank
  private String actualPassword;

  @ApiModelProperty(example = "testing12")
  @ToString.Exclude
  @NotBlank
  private String newPassword;
}
