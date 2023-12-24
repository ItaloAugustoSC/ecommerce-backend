package com.general.ecommerce.service;

import com.general.ecommerce.entity.ProductEntity;
import com.general.ecommerce.exception.BadRequestException;
import com.general.ecommerce.model.request.CreateProductRequest;
import com.general.ecommerce.model.response.GetProductResponse;
import com.general.ecommerce.repository.ProductRepository;
import com.general.ecommerce.service.mapper.ProductMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired private ProductRepository productRepository;

  @Autowired private ProductMapper productMapper;

  @Override
  public void createProduct(CreateProductRequest productRequest) {
    ProductEntity productEntity = productMapper.mapToEntity(productRequest);

    productRepository.save(productEntity);
  }

  @Override
  public void deleteProduct(String name) {
    Optional<ProductEntity> products =
        Arrays.stream(productRepository.findAllByName(name)).findAny();

    if (products.isEmpty()) {
      throw new BadRequestException("Product does not exist.");
    }

    products.ifPresent(product -> productRepository.deleteById(String.valueOf(product.getId())));
  }

  @Override
  public List<GetProductResponse> getProduct(String name) {
    Optional<ProductEntity> productsEntity =
        Arrays.stream(productRepository.findAllByName(name)).findAny();

    if (productsEntity.isEmpty()) {
      throw new BadRequestException("Product does not exist.");
    }

    ArrayList<GetProductResponse> products = new ArrayList<>();

    productsEntity.ifPresent(
        productEntity -> products.add(productMapper.mapToGetProductResponse(productEntity)));
    return products;
  }

  @Override
  public List<GetProductResponse> getAllProducts() {
    Iterable<ProductEntity> productsEntity = productRepository.findAll();

    if (!productsEntity.iterator().hasNext()) {
      throw new BadRequestException("Product does not exist.");
    }

    ArrayList<GetProductResponse> products = new ArrayList<>();

    productsEntity.forEach(
        productEntity -> products.add(productMapper.mapToGetProductResponse(productEntity)));
    return products;
  }
}
