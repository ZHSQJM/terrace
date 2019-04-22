package com.terrace.service.impl;

import com.terrace.entity.Demand;
import com.terrace.form.DemandForm;
import com.terrace.repositroy.DemandRepository;
import com.terrace.service.IDemandService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/4/19 16:46
 * @package: com.terrace.service.impl
 * @description:
 */
@Service
public class DemandServiceImpl implements IDemandService {

    @Autowired
    private DemandRepository demandRepository;

    @Override
    public void addDemand(DemandForm demandForm) {
        Demand demand = new Demand();
        BeanUtils.copyProperties(demandForm,demand);
        demand.setCreateTime(new Date());
        demandRepository.save(demand);
    }

    @Override
    public Page<Demand> findAllDemand(Integer page, Integer size, Demand demand) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "id");
        Page<Demand> companyPage = demandRepository.findAll((root, query, criteriaBuilder)->{
            List<Predicate> list = new ArrayList<Predicate>();
            if(null!= demand.getFlag()&&!"".equals(demand.getFlag())){
                list.add(criteriaBuilder.equal(root.get("flag").as(Integer.class), demand.getFlag()));
            }Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        }, pageable);
        return companyPage;
    }
}
