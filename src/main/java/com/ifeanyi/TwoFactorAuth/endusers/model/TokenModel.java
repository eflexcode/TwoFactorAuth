package com.ifeanyi.TwoFactorAuth.endusers.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class TokenModel {

    private String ownerId;
    private String CompanyId;
    private String token;
    private String expireTime;

}
