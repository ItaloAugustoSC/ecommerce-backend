package com.general.ecommerce.repository;

import com.general.ecommerce.entity.ProductEntity;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, String> {

  ProductEntity[] findAllByName(String name);
}
