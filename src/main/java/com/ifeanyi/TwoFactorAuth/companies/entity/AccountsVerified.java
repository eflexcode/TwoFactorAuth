package com.ifeanyi.TwoFactorAuth.companies.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AccountsVerified {

    private String userId;
    private Date timeVerified;

}
