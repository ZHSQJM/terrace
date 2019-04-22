package com.terrace.service.impl;

import com.terrace.entity.Business;
import com.terrace.exception.ZhsException;
import com.terrace.form.BusinessForm;
import com.terrace.repositroy.BusinessRepository;
import com.terrace.service.IBusinessService;
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
 * @date: 2019/4/18 16:33
 * @package: com.terrace.service.impl
 * @description:
 */
@Service
public class BusinessServiceImpl implements IBusinessService {

    @Autowired
    private BusinessRepository businessRepository;


    /**
     * 是否更新或者保存成功
     * @param businessForm
     * @return
     */
    @Override
    public Boolean saveOrUpdate(BusinessForm businessForm) {
        Business business = null;
        if(businessForm.getId()!=null){
            business=businessRepository.getOne(businessForm.getId());
        }else{
            business = new Business();
            final Business Business1 = businessRepository.findAllByBusinessName(businessForm.getBusinessName());
            if(Business1!=null){
             throw  new ZhsException("业务名不能重复");
            }
            BeanUtils.copyProperties(businessForm,business);
            business.setCreateTime(new Date());
        }
        businessRepository.save(business);
        return true;
    }

    @Override
    public Page<Business> findAllCompany(Integer page, Integer size, Business business) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "id");
        Page<Business> businessesPage = businessRepository.findAll((root, query, criteriaBuilder)->{
            List<Predicate> list = new ArrayList<Predicate>();
            if(null!= business.getBusinessName()&&!"".equals(business.getBusinessName())){
                list.add(criteriaBuilder.equal(root.get("BusinessName").as(String.class), business.getBusinessName()));
            }Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        }, pageable);
        return businessesPage;
    }

    @Override
    public List<Business> findAll() {
        return businessRepository.findAll();
    }
}
