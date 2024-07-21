package com.ifeanyi.TwoFactorAuth.endusers.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Token {

    @Id
    private String id;
    private String ownerId;
    private String CompanyId;
    private String token;
    private String expireTime;

}
