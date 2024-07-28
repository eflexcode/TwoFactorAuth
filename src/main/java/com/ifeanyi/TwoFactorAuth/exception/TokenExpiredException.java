package com.ifeanyi.TwoFactorAuth.exception;


public class TokenExpiredException extends Exception {

    public static final long serialVersionUId = 1L;

    public TokenExpiredException(String message) {
        super(message);
    }
}
