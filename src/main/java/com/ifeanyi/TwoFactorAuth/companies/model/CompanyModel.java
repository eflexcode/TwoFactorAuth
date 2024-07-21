package com.ifeanyi.TwoFactorAuth.companies.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class CompanyModel {

    private String name;
    private String email;
    private String password;
    private String displayImgUrl;
    private String description;
}
