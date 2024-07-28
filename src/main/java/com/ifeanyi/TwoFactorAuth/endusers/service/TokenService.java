package com.ifeanyi.TwoFactorAuth.endusers.service;

import com.ifeanyi.TwoFactorAuth.endusers.entity.Token;
import com.ifeanyi.TwoFactorAuth.endusers.model.TokenModel;
import com.ifeanyi.TwoFactorAuth.endusers.model.TokenResponse;
import com.ifeanyi.TwoFactorAuth.exception.NotFoundException;
import com.ifeanyi.TwoFactorAuth.exception.TokenExpiredException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface TokenService  {

    Token createToken(TokenModel tokenModel);
    Token get(String id) throws NotFoundException;
    TokenResponse verify(String token,String companyId) throws NotFoundException, TokenExpiredException;
    Token put(String id,TokenModel tokenModel) throws NotFoundException;
    void delete(String id) throws NotFoundException;

}
