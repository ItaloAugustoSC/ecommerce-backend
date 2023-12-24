package com.general.ecommerce.controller;

import com.general.ecommerce.controller.interfaces.ProductApi;
import com.general.ecommerce.model.request.CreateProductRequest;
import com.general.ecommerce.model.response.ContractResponse;
import com.general.ecommerce.model.response.GetProductResponse;
import com.general.ecommerce.service.ProductService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController implements ProductApi {

  private final ProductService productService;

  @Override
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/product")
  public ContractResponse<Object> createProduct(
      CreateProductRequest product, HttpServletRequest request) {

    productService.createProduct(product);

    ContractResponse<Object> response =
        ContractResponse.builder().path(request.getServletPath()).build();

    return response;
  }

  @Override
  @GetMapping("/product")
  public ContractResponse<List<GetProductResponse>> getProduct(
      String name, HttpServletRequest request) {

    List<GetProductResponse> productResponse = productService.getProduct(name);

    ContractResponse<List<GetProductResponse>> response = new ContractResponse<>();
    response.setPath(request.getServletPath());
    response.setResponse(productResponse);
    return response;
  }

  @Override
  @GetMapping("/products")
  public ContractResponse<List<GetProductResponse>> getAllProducts(HttpServletRequest request) {

    List<GetProductResponse> productResponse = productService.getAllProducts();

    ContractResponse<List<GetProductResponse>> response = new ContractResponse<>();
    response.setPath(request.getServletPath());
    response.setResponse(productResponse);
    return response;
  }

  @Override
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping("/product")
  public ContractResponse<Object> deleteProduct(
      @RequestHeader String name, HttpServletRequest request) {

    productService.deleteProduct(name);

    ContractResponse<Object> response =
        ContractResponse.builder().path(request.getServletPath()).build();
    return response;
  }
}
