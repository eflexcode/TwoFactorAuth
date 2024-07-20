package com.ifeanyi.TwoFactorAuth.exception;

import lombok.Data;


public class NotFoundException extends Exception {

    public static final long serialVersionUId = 1L;

    public NotFoundException(String message) {
        super(message);
    }
}
