package com.ifeanyi.TwoFactorAuth.endusers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenResponse {
    private String message;
    private Integer statusCode;
}
