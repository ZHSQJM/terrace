package com.terrace.service;

import com.terrace.entity.Demand;
import com.terrace.form.DemandForm;
import org.springframework.data.domain.Page;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/19 16:46
 * @package: com.terrace.service
 * @description:
 */
public interface IDemandService {


    /**
     * 新增需求
     * @param demandForm
     */
    void addDemand(DemandForm demandForm);

    /**
     * 需求列表
     * @param page
     * @param size
     * @param demand
     * @return
     */
    Page<Demand> findAllDemand(Integer page, Integer size, Demand demand);
}
