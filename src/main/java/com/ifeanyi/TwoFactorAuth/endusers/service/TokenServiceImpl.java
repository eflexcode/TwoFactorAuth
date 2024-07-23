package com.ifeanyi.TwoFactorAuth.endusers.service;

import com.ifeanyi.TwoFactorAuth.endusers.entity.Token;
import com.ifeanyi.TwoFactorAuth.endusers.model.TokenModel;
import com.ifeanyi.TwoFactorAuth.endusers.repository.TokenRepo;
import com.ifeanyi.TwoFactorAuth.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final TokenRepo tokenRepo;

    @Override
    public Token createToken(TokenModel tokenModel) {

        Token token = new Token();
        BeanUtils.copyProperties(tokenModel, token);

        return tokenRepo.save(token);
    }

    @Override
    public Token get(String id) throws NotFoundException {
        return tokenRepo.findById(id).orElseThrow(() -> new NotFoundException("No Token found with id: " + id));
    }

    @Override
    public Token getByToken(String token) throws NotFoundException {
        return tokenRepo.findByToken(token);
    }

    @Override
    public Token put(String id, TokenModel tokenModel) throws NotFoundException {

        Token token = get(id);
        token.setCompanyId(tokenModel.getCompanyId() != null ? tokenModel.getCompanyId() : token.getCompanyId());
        token.setOwnerId(tokenModel.getOwnerId() != null ? tokenModel.getOwnerId() : token.getOwnerId());
        token.setExpireTime(tokenModel.getExpireTime() != null ? tokenModel.getExpireTime() : token.getExpireTime());
        token.setToken(tokenModel.getToken() != null ? tokenModel.getToken() : token.getToken());

        return tokenRepo.save(token);
    }

    @Override
    public void delete(String id) throws NotFoundException {
        tokenRepo.delete(get(id));
    }
}
