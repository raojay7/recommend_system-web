package com.recommend_system.company.service.imp;

import com.recommend_system.company.dao.CompanyMapper;
import com.recommend_system.company.entity.Company;
import com.recommend_system.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public Company getCompany(int cid) {
        return companyMapper.selectByPrimaryKey(cid);
    }
}
