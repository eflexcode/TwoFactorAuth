package com.ifeanyi.TwoFactorAuth.endusers.service;

import com.ifeanyi.TwoFactorAuth.endusers.entity.Token;
import com.ifeanyi.TwoFactorAuth.endusers.model.TokenModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface TokenService  {

    Token createToken(TokenModel tokenModel);
    Token get(String id);
    Token put(String id,TokenModel tokenModel);
    void delete(String id);

}
