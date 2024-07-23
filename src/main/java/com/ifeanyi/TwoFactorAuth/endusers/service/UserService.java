package com.ifeanyi.TwoFactorAuth.endusers.service;

import com.ifeanyi.TwoFactorAuth.endusers.entity.User;
import com.ifeanyi.TwoFactorAuth.endusers.model.UserModel;
import com.ifeanyi.TwoFactorAuth.exception.NotFoundException;

public interface UserService {

    User create(UserModel userModel);
    User get(String id) throws NotFoundException;
    User put(String id,UserModel userModel) throws NotFoundException;
    void delete(String id) throws NotFoundException;

}
