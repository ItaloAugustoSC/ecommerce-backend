package com.general.ecommerce.controller.interfaces;

import com.general.ecommerce.model.request.CreateProductRequest;
import com.general.ecommerce.model.response.ContractResponse;
import com.general.ecommerce.model.response.GetProductResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.data.repository.query.Param;

@Api(
    value = "ecommerce"
)
public interface ProductApi {

  @ApiOperation(
      tags = {"Product Controller - All Endpoints"},
      value = "Create a new product.",
      notes = "This endpoint is used to register a new product.")
  ContractResponse<Object> createProduct(
      @Valid @ApiParam(value = "product") CreateProductRequest user, HttpServletRequest request);

  @ApiOperation(
      tags = {"Product Controller - All Endpoints"},
      value = "Get a product.",
      notes = "This endpoint is used to get a product.")
  ContractResponse<List<GetProductResponse>> getProduct(
      @Param(value = "name") String name, HttpServletRequest request);

  @ApiOperation(
      tags = {"Product Controller - All Endpoints"},
      value = "Delete a product.",
      notes = "This endpoint is used to delete a product.")
  ContractResponse<Object> deleteProduct(
      @Param(value = "email") String email, HttpServletRequest request);

  @ApiOperation(
      tags = {"Product Controller - All Endpoints"},
      value = "Get a product.",
      notes = "This endpoint is used to get a product.")
  ContractResponse<List<GetProductResponse>> getAllProducts(HttpServletRequest request);
}
