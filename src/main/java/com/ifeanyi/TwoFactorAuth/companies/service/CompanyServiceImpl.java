package com.ifeanyi.TwoFactorAuth.companies.service;

import com.ifeanyi.TwoFactorAuth.companies.entity.Company;
import com.ifeanyi.TwoFactorAuth.companies.model.CompanyModel;
import com.ifeanyi.TwoFactorAuth.companies.repository.CompanyRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepo companyRepo;

    @Override
    public Company create(CompanyModel companyModel) {


        return null;
    }

    @Override
    public Company update(String id, CompanyModel companyModel) {
        return null;
    }

    @Override
    public Company get(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
