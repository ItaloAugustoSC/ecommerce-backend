package com.general.ecommerce.service.mapper;

import com.general.ecommerce.entity.ProductEntity;
import com.general.ecommerce.model.request.CreateProductRequest;
import com.general.ecommerce.model.response.GetProductResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
  ProductEntity mapToEntity(CreateProductRequest request);

  GetProductResponse mapToGetProductResponse(ProductEntity entity);
}
