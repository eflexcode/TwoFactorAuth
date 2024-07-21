package com.ifeanyi.TwoFactorAuth.endusers.repository;

import com.ifeanyi.TwoFactorAuth.endusers.entity.Token;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepo extends MongoRepository<Token,String > {
}
