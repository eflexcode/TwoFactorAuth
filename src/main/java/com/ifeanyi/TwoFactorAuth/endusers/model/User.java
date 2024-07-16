package com.ifeanyi.TwoFactorAuth.endusers.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;

}

