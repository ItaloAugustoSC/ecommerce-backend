package com.general.ecommerce.service.mapper;

import com.general.ecommerce.entity.ProductEntity;
import com.general.ecommerce.model.request.CreateProductRequest;
import com.general.ecommerce.model.response.GetProductResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-24T20:41:47-0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductEntity mapToEntity(CreateProductRequest request) {
        if ( request == null ) {
            return null;
        }

        ProductEntity.ProductEntityBuilder productEntity = ProductEntity.builder();

        productEntity.name( request.getName() );
        productEntity.price( request.getPrice() );
        productEntity.image( request.getImage() );

        return productEntity.build();
    }

    @Override
    public GetProductResponse mapToGetProductResponse(ProductEntity entity) {
        if ( entity == null ) {
            return null;
        }

        GetProductResponse.GetProductResponseBuilder getProductResponse = GetProductResponse.builder();

        getProductResponse.id( entity.getId() );
        getProductResponse.name( entity.getName() );
        getProductResponse.image( entity.getImage() );
        if ( entity.getPrice() != null ) {
            getProductResponse.price( entity.getPrice() );
        }

        return getProductResponse.build();
    }
}
