package com.general.ecommerce.service;

import com.general.ecommerce.model.request.CreateProductRequest;
import com.general.ecommerce.model.response.GetProductResponse;
import java.util.List;

public interface ProductService {

  /**
   * Creates a new product.
   *
   * @param user Product object with the properties
   * @return NetworkingResponse
   */
  void createProduct(CreateProductRequest user);

  /**
   * Deletes a product.
   *
   * @param name Product's name
   * @return NetworkingResponse
   */
  void deleteProduct(String name);

  /**
   * Get a product.
   *
   * @param name Product's name
   * @return NetworkingResponse
   */
  List<GetProductResponse> getProduct(String name);

  /**
   * Get all products.
   *
   * @return NetworkingResponse
   */
  List<GetProductResponse> getAllProducts();
}
