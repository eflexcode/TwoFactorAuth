package com.ifeanyi.TwoFactorAuth.companies.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.ifeanyi.TwoFactorAuth.companies.entity.AccountsVerified;
import com.ifeanyi.TwoFactorAuth.companies.entity.Company;
import com.ifeanyi.TwoFactorAuth.companies.model.CompanyModel;
import com.ifeanyi.TwoFactorAuth.companies.repository.CompanyRepo;
import com.ifeanyi.TwoFactorAuth.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepo companyRepo;

    @Override
    public Company create(CompanyModel companyModel) {

        Company company = new Company();

        BeanUtils.copyProperties(companyModel, company);

        return companyRepo.save(company);
    }

    @Override
    public Company update(String id, CompanyModel companyModel) throws NotFoundException {

        Company company = get(id);

        company.setName(companyModel.getName() != null ? companyModel.getName() : company.getName());
        company.setEmail(companyModel.getEmail() != null ? companyModel.getEmail() : company.getEmail());
        company.setDescription(companyModel.getDescription() != null ? companyModel.getDescription() : company.getDescription());
        company.setDisplayImg(companyModel.getDisplayImg() != null ? companyModel.getDisplayImg() : company.getDisplayImg());
        company.setPassword(companyModel.getPassword() != null ? companyModel.getPassword() : company.getPassword());

        return companyRepo.save(company);
    }

    @Override
    public void addAccountVerified(String id, AccountsVerified accountsVerified) throws NotFoundException {

        Company company = get(id);
        company.getAccountsVerified().add(accountsVerified);
        companyRepo.save(company);

    }

    @Override
    public AccountsVerified getAccountsVerified(String id, int lastPosition, int pageSize) {
        return null;
    }

    @Override
    public Company get(String id) throws NotFoundException {
        return companyRepo.findById(id).orElseThrow(() -> new NotFoundException("No company found with id"));
    }

    @Override
    public void delete(String id) throws NotFoundException {
        get(id);
        companyRepo.deleteById(id);
    }
}
