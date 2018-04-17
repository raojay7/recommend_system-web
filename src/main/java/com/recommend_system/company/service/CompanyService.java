package com.recommend_system.company.service;

import com.recommend_system.company.entity.Company;

public interface CompanyService {
    /**
     *
     * @param cid 公司id
     * @return 公司bean
     */
    public Company getCompany(int cid);
}
