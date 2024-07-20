package com.ifeanyi.TwoFactorAuth.companies.service;

import com.ifeanyi.TwoFactorAuth.companies.entity.Company;
import com.ifeanyi.TwoFactorAuth.companies.model.CompanyModel;
import com.ifeanyi.TwoFactorAuth.exception.NotFoundException;

public interface CompanyService {

    Company create(CompanyModel companyModel);
    Company update(final String id,CompanyModel companyModel);
    Company get(final String id) throws NotFoundException;
    void delete(final String id) throws NotFoundException;

}
