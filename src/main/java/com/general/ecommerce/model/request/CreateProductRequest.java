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
public class CreateProductRequest {

  @ApiModelProperty(example = "Mochila Marca")
  @NotBlank
  @ToString.Exclude
  private String name;

  @ApiModelProperty(example = "ahsusnflla")
  @NotBlank
  @ToString.Exclude
  private String image;

  @ApiModelProperty(example = "50.00")
  @ToString.Exclude
  private float price;
}
