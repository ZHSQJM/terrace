package com.terrace.repositroy;

import com.terrace.entity.CompanyCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/19 15:55
 * @package: com.terrace.repositroy
 * @description:
 */
public interface CompanyCategoryRepositroy extends JpaRepository<CompanyCategory,Integer>,JpaSpecificationExecutor<CompanyCategory> {


    List<CompanyCategory> findAllByCategoryId(Integer categoryId);

    List<CompanyCategory> findAllByCompanyId(Integer companyId);
}
