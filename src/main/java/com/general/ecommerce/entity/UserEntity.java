package com.general.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class UserEntity {

    @Exclude
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Exclude
    @Column(name = "LAST_NAME")
    private String lastName;

    @Id
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Exclude
    @Column(name = "GENDER")
    private String gender;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "DATE_OF_BIRTH")
    private String dateOfBirth;
}

