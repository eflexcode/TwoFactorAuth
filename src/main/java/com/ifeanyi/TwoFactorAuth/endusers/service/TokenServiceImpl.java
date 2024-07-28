package com.ifeanyi.TwoFactorAuth.endusers.service;

import com.ifeanyi.TwoFactorAuth.companies.entity.AccountsVerified;
import com.ifeanyi.TwoFactorAuth.companies.service.CompanyService;
import com.ifeanyi.TwoFactorAuth.endusers.entity.Token;
import com.ifeanyi.TwoFactorAuth.endusers.model.TokenModel;
import com.ifeanyi.TwoFactorAuth.endusers.model.TokenResponse;
import com.ifeanyi.TwoFactorAuth.endusers.repository.TokenRepo;
import com.ifeanyi.TwoFactorAuth.exception.NotFoundException;
import com.ifeanyi.TwoFactorAuth.exception.TokenExpiredException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final TokenRepo tokenRepo;
    private final CompanyService companyService;

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
    public TokenResponse verify(String token, String companyId) throws NotFoundException, TokenExpiredException {
        Token tokenClass = tokenRepo.findByToken(token).orElseThrow(() -> new NotFoundException("No Token found with id: " + token));

        if (!tokenClass.getCompanyId().equals(companyId)){
            throw new NotFoundException("Company id did not match");
        }

        Date tokenDate = tokenClass.getExpireTime();
        Date now = new Date();

        if (tokenDate.before(now)){
            throw new TokenExpiredException("Token expired");
        }

        companyService.addAccountVerified(companyId,new AccountsVerified(tokenClass.getOwnerId(),new Date()));

        return new TokenResponse("success",200);
    }

    @Override
    public Token put(String id, TokenModel tokenModel) throws NotFoundException {

        Token token = get(id);
        token.setCompanyId(tokenModel.getCompanyId() != null ? tokenModel.getCompanyId() : token.getCompanyId());
        token.setOwnerId(tokenModel.getOwnerId() != null ? tokenModel.getOwnerId() : token.getOwnerId());
        token.setExpireTime(new Date(System.currentTimeMillis()+60000));
        token.setToken(tokenModel.getToken() != null ? tokenModel.getToken() : token.getToken());

        return tokenRepo.save(token);
    }

    @Override
    public void delete(String id) throws NotFoundException {
        tokenRepo.delete(get(id));
    }
}
