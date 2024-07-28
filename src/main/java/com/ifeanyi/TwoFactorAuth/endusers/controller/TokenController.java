package com.ifeanyi.TwoFactorAuth.endusers.controller;

import com.ifeanyi.TwoFactorAuth.endusers.entity.Token;
import com.ifeanyi.TwoFactorAuth.endusers.model.TokenModel;
import com.ifeanyi.TwoFactorAuth.endusers.service.TokenService;
import com.ifeanyi.TwoFactorAuth.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/token/")
@RequiredArgsConstructor
public class TokenController {

    private final TokenService tokenService;

    @PostMapping
    public Token createToken(@RequestBody TokenModel tokenModel) {
        return tokenService.createToken(tokenModel);
    }

    @GetMapping("{id}")
    public Token get(@PathVariable String id) throws NotFoundException {
        return tokenService.get(id);
    }

    @GetMapping("token/{token}")
    public Token getByToken(@PathVariable String token) throws NotFoundException {
        return tokenService.getByToken(token);
    }

    @PutMapping("{id}")
    public Token put(@PathVariable String id, TokenModel tokenModel) throws NotFoundException {
        return tokenService.put(id,tokenModel);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) throws NotFoundException {
        tokenService.delete(id);
    }

}
