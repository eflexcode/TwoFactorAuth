package com.ifeanyi.TwoFactorAuth.companies.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Company {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String displayImgUrl;
    private String description;
    private List<AccountsVerified> accountsVerified;//can be duplicate
}
