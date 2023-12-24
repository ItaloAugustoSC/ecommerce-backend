package com.general.ecommerce.service.mapper;

import com.general.ecommerce.entity.UserEntity;
import com.general.ecommerce.model.request.CreateUserRequest;
import com.general.ecommerce.model.response.GetUserResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-24T12:40:05-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity map(CreateUserRequest user) {
        if ( user == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.country( user.getCountry() );
        userEntity.dateOfBirth( user.getDateOfBirth() );
        userEntity.emailAddress( user.getEmailAddress() );
        userEntity.firstName( user.getFirstName() );
        userEntity.gender( user.getGender() );
        userEntity.language( user.getLanguage() );
        userEntity.lastName( user.getLastName() );
        userEntity.password( user.getPassword() );

        return userEntity.build();
    }

    @Override
    public GetUserResponse mapToGetUserResponse(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        GetUserResponse.GetUserResponseBuilder getUserResponse = GetUserResponse.builder();

        getUserResponse.country( entity.getCountry() );
        getUserResponse.dateOfBirth( entity.getDateOfBirth() );
        getUserResponse.emailAddress( entity.getEmailAddress() );
        getUserResponse.firstName( entity.getFirstName() );
        getUserResponse.gender( entity.getGender() );
        getUserResponse.language( entity.getLanguage() );
        getUserResponse.lastName( entity.getLastName() );
        getUserResponse.password( entity.getPassword() );

        return getUserResponse.build();
    }
}
