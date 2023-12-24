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
public class GetProductResponse {

  private int id;
  private String name;
  private String image;
  private double price;
}
