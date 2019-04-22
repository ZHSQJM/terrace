package com.terrace.repositroy;

import com.terrace.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/18 16:24
 * @package: com.terrace.repositroy
 * @description: 公司相关DAO
 */
public interface CompanyRepository extends JpaRepository<Company,Integer>,JpaSpecificationExecutor<Company> {


    /**
     * 通过公司的名称来查找公司
     * @param companyName
     * @return
     */
    Company findAllByCompanyName(String companyName);

}
