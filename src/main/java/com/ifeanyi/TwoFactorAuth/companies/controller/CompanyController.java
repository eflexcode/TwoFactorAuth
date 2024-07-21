package com.ifeanyi.TwoFactorAuth.companies.controller;

import com.ifeanyi.TwoFactorAuth.companies.entity.Company;
import com.ifeanyi.TwoFactorAuth.companies.model.CompanyModel;
import com.ifeanyi.TwoFactorAuth.companies.service.CompanyService;
import com.ifeanyi.TwoFactorAuth.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/company/")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping()
    public Company Create(@RequestBody CompanyModel companyModel) {
        return companyService.create(companyModel);
    }

    @PutMapping("{id}")
    public Company update(@PathVariable String id, @RequestBody CompanyModel companyModel) throws NotFoundException {
        return companyService.update(id, companyModel);
    }

    @GetMapping("{id}")
    public Company get(@PathVariable String id) throws NotFoundException {
        return companyService.get(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) throws NotFoundException {
         companyService.delete(id);
    }
}
