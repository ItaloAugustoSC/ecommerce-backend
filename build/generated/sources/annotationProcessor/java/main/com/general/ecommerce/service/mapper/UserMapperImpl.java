package com.general.ecommerce.service.mapper;

import com.general.ecommerce.entity.UserEntity;
import com.general.ecommerce.model.request.CreateUserRequest;
import com.general.ecommerce.model.response.GetUserResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-24T16:21:12-0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity map(CreateUserRequest user) {
        if ( user == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.firstName( user.getFirstName() );
        userEntity.lastName( user.getLastName() );
        userEntity.emailAddress( user.getEmailAddress() );
        userEntity.gender( user.getGender() );
        userEntity.country( user.getCountry() );
        userEntity.language( user.getLanguage() );
        userEntity.password( user.getPassword() );
        userEntity.dateOfBirth( user.getDateOfBirth() );

        return userEntity.build();
    }

    @Override
    public GetUserResponse mapToGetUserResponse(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        GetUserResponse.GetUserResponseBuilder getUserResponse = GetUserResponse.builder();

        getUserResponse.firstName( entity.getFirstName() );
        getUserResponse.lastName( entity.getLastName() );
        getUserResponse.emailAddress( entity.getEmailAddress() );
        getUserResponse.password( entity.getPassword() );
        getUserResponse.gender( entity.getGender() );
        getUserResponse.dateOfBirth( entity.getDateOfBirth() );
        getUserResponse.country( entity.getCountry() );
        getUserResponse.language( entity.getLanguage() );

        return getUserResponse.build();
    }
}
