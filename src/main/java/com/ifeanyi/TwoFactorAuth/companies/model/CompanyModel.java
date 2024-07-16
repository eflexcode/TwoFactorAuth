package com.ifeanyi.TwoFactorAuth.companies.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class CompanyModel {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String displayImg;
    private String description;
}
