package com.ifeanyi.TwoFactorAuth.endusers.repository;

import com.ifeanyi.TwoFactorAuth.endusers.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User,String> {
}
