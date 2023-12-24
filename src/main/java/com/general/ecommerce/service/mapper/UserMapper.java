package com.general.ecommerce.service.mapper;

import com.general.ecommerce.entity.UserEntity;
import com.general.ecommerce.model.request.CreateUserRequest;
import com.general.ecommerce.model.response.GetUserResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
  UserEntity map(CreateUserRequest user);

  GetUserResponse mapToGetUserResponse(UserEntity entity);
}
