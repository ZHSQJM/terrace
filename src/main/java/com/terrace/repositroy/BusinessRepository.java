package com.terrace.repositroy;

import com.terrace.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/18 16:25
 * @package: com.terrace.repositroy
 * @description:
 */
@Repository
public interface BusinessRepository extends JpaRepository<Business,Integer>,JpaSpecificationExecutor<Business> {


    /**
     * 通过业务名称查找
     * @param businessName
     * @return
     */
    Business findAllByBusinessName(String businessName);
}
