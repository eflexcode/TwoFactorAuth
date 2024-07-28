package com.ifeanyi.TwoFactorAuth.endusers.controller;

import com.ifeanyi.TwoFactorAuth.endusers.entity.User;
import com.ifeanyi.TwoFactorAuth.endusers.model.UserModel;
import com.ifeanyi.TwoFactorAuth.endusers.service.UserService;
import com.ifeanyi.TwoFactorAuth.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

@RestController
@RequestMapping("/v1/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User create(@RequestBody UserModel userModel) {
        return userService.create(userModel);
    }

    @GetMapping("{id}")
    public User get(@PathVariable String id) throws NotFoundException {
        return userService.get(id);
    }

    @PutMapping("{id}")
    public User put(@PathVariable String id,@RequestBody UserModel userModel) throws NotFoundException {
        return userService.put(id, userModel);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) throws NotFoundException {
        userService.delete(id);
    }

}
