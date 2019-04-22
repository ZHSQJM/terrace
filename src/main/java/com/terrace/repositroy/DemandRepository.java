package com.terrace.repositroy;

import com.terrace.entity.Demand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/19 16:44
 * @package: com.terrace.repositroy
 * @description: 需求Dao
 */
public interface DemandRepository extends JpaRepository<Demand,Integer>,JpaSpecificationExecutor<Demand> {
}
