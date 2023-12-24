package com.general.ecommerce.repository;

import com.general.ecommerce.entity.UserEntity;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {}
