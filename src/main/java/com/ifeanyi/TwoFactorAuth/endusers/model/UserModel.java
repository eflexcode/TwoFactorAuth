package com.ifeanyi.TwoFactorAuth.endusers.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class UserModel {

    private String name;
    private String email;
    private String password;

}

