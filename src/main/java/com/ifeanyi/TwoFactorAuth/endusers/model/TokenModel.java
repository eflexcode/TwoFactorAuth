package com.ifeanyi.TwoFactorAuth.endusers.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
public class TokenModel {

    private String ownerId;
    private String companyId;
    private String accountId;//email or whatever
    private String token;
    private Date expireTime;

}
