package com.terrace.service.impl;

import com.terrace.entity.Company;
import com.terrace.entity.CompanyCategory;
import com.terrace.exception.ZhsException;
import com.terrace.form.ComPanyForm;
import com.terrace.repositroy.CompanyCategoryRepositroy;
import com.terrace.repositroy.CompanyRepository;
import com.terrace.service.ICompanyService;
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
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    @Autowired
    private CompanyCategoryRepositroy companyCategoryRepositroy;


    /**
     * 是否更新或者保存成功
     * @param comPanyForm
     * @return
     */
    @Override
    public void saveOrUpdate(ComPanyForm comPanyForm) {
        Company company = null;
        if(comPanyForm.getId()!=null ){
            company=companyRepository.getOne(comPanyForm.getId());
            company.setUpdateTime(new Date());
        }else{
            company = new Company();
            final Company company1 = companyRepository.findAllByCompanyName(comPanyForm.getCompanyName());
            if(company1!=null){
             throw  new ZhsException("公司名已存在");
            }
            BeanUtils.copyProperties(comPanyForm,company);
            company.setCreateTime(new Date());
        }
        companyRepository.save(company);
    }

    /**
     * 条件查询列表
     * @param page
     * @param size
     * @param company
     * @return
     */
    @Override
    public Page<Company> findAllCompany(Integer page, Integer size, Company company) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "id");
        Page<Company> companyPage = companyRepository.findAll((root, query, criteriaBuilder)->{
            List<Predicate> list = new ArrayList<Predicate>();
            if(null!= company.getCompanyName()&&!"".equals(company.getCompanyName())){
                list.add(criteriaBuilder.equal(root.get("companyName").as(String.class), company.getCompanyName()));
            }Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        }, pageable);
        return companyPage;
    }

    /**
     * 将公司的业务范围分配
     * @param companyId
     * @param ids
     */
    @Override
    public void distribution(int companyId, Integer[] ids) {

        /**
         * 1:查询出这个公司现有的功能范围
         * 2:删除这个公司的现有范围
         * 3:新增已有的功能范围
         */
        final List<CompanyCategory> allByCompanyId = companyCategoryRepositroy.findAllByCompanyId(companyId);
        allByCompanyId.stream().forEach(e->companyCategoryRepositroy.delete(e.getId()));

        for (int i = 0; i < ids.length; i++) {
            CompanyCategory companyCategory = new CompanyCategory();
            companyCategory.setCompanyId(companyId).setCategoryId(ids[i]);
        }
    }
}
