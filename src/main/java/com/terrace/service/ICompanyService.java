package com.terrace.service;

import com.terrace.entity.Company;
import com.terrace.form.ComPanyForm;
import org.springframework.data.domain.Page;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/18 16:33
 * @package: com.terrace.service
 * @description: 公司相关接口层
 */
public interface ICompanyService {


    /**
     * 是否添加或者更新成功
     * @param comPanyForm
     * @return
     */
    void saveOrUpdate(ComPanyForm comPanyForm);

    /**
     * 分页查询
     * @param page
     * @param size
     * @param record
     * @return
     */
    Page<Company> findAllCompany(Integer page, Integer size, Company record);


    void distribution(int companyId,Integer [] ids);

}
