package com.terrace.service;

import com.terrace.entity.Business;
import com.terrace.form.BusinessForm;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/18 16:50
 * @package: com.terrace.service
 * @description: 业务接口层
 */
public interface IBusinessService {

    /**
     * 是否添加或者更新成功
     * @param businessForm
     * @return
     */
    Boolean saveOrUpdate(BusinessForm businessForm);

    Page<Business> findAllCompany(Integer page, Integer size, Business business);


    List<Business> findAll();
}
