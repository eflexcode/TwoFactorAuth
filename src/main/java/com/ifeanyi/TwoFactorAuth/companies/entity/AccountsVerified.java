package com.ifeanyi.TwoFactorAuth.companies.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AccountsVerified {

    private String userId;
    private Date timeVerified;

}
