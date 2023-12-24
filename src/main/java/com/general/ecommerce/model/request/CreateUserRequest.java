package com.general.ecommerce.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CreateUserRequest {
    @ApiModelProperty(example = "First")
    @NotBlank
    @ToString.Exclude
    private String firstName;

    @ApiModelProperty(example = "Last")
    @NotBlank
    @ToString.Exclude
    private String lastName;

    @ApiModelProperty(example = "testing@test.com")
    @NotBlank
    @ToString.Exclude
    private String emailAddress;

    @ApiModelProperty(example = "testing")
    @ToString.Exclude
    @NotBlank
    private String password;

    @ApiModelProperty(example = "M")
    @NotBlank
    @ToString.Exclude
    private String gender;

    @ApiModelProperty(example = "20101205")
    @NotBlank
    @ToString.Exclude
    private String dateOfBirth;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String country;

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String language;
}
