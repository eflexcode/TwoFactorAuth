package com.ifeanyi.TwoFactorAuth.endusers.service;

import com.ifeanyi.TwoFactorAuth.endusers.entity.User;
import com.ifeanyi.TwoFactorAuth.endusers.model.UserModel;
import com.ifeanyi.TwoFactorAuth.endusers.repository.UserRepo;
import com.ifeanyi.TwoFactorAuth.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public User create(UserModel userModel) {

        User user = new User();

        BeanUtils.copyProperties(userModel, user);

        return userRepo.save(user);
    }

    @Override
    public User get(String id) throws NotFoundException {
        return userRepo.findById(id).orElseThrow(() -> new NotFoundException("No user found with id: " + id));
    }

    @Override
    public User put(String id, UserModel userModel) throws NotFoundException {

        User user = get(id);
        user.setEmail(userModel.getEmail() != null ? userModel.getEmail() : user.getEmail());
        user.setName(userModel.getName() != null ? userModel.getName() : user.getName());
        user.setPassword(userModel.getPassword() != null ? userModel.getPassword() : user.getPassword());

        return userRepo.save(user);
    }

    @Override
    public void delete(String id) throws NotFoundException {
        userRepo.delete(get(id));
    }
}
