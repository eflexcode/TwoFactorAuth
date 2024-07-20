package com.ifeanyi.TwoFactorAuth.exception.model;

import lombok.Data;

import java.util.Date;

@Data
public class CustomError {
    private Integer statusCode;
    private String message;
    private Date timestamp;
}
