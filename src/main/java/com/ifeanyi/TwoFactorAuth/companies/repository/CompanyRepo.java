package com.ifeanyi.TwoFactorAuth.companies.repository;

import com.ifeanyi.TwoFactorAuth.companies.entity.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends MongoRepository<Company,String> {
}
