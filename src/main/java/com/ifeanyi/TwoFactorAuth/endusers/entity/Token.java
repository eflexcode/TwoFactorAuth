package com.ifeanyi.TwoFactorAuth.endusers.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class Token {

    @Id
    private String id;
    private String ownerId;
    private String companyId;
    private String accountId;//email or whatever
    private String token;
    private Date expireTime;

}
