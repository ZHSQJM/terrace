package com.terrace.service.impl;

import com.terrace.entity.Business;
import com.terrace.entity.Category;
import com.terrace.exception.ZhsException;
import com.terrace.form.CategoryForm;
import com.terrace.repositroy.BusinessRepository;
import com.terrace.repositroy.CategoryRepository;
import com.terrace.service.ICategoryService;
import com.terrace.vo.CategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BusinessRepository businessRepository;

    /**
     * 是否更新或者保存成功
     * @param categoryForm
     * @return
     */
    @Override
    public Boolean saveOrUpdate(CategoryForm categoryForm) {
        Category category = null;
        if(categoryForm.getId()!=null ){
            category=categoryRepository.getOne(categoryForm.getId());
        }else{
            category = new Category();
            final Category category1 = categoryRepository.findAllByCategoryName(categoryForm.getCategoryName());
            if(category1!=null){
             throw  new ZhsException("类目已存在");
            }
            BeanUtils.copyProperties(categoryForm,category);
            category.setCreateTime(new Date());
        }
        categoryRepository.save(category);
        return true;
    }

    @Override
    public Page<CategoryVo> findAllCategory(Integer page, Integer size, Category category) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "id");
        Page<Category> categoryPage = categoryRepository.findAll((root, query, criteriaBuilder)->{
            List<Predicate> list = new ArrayList<Predicate>();
            if(null!= category.getCategoryName()&&!"".equals(category.getCategoryName())){
                list.add(criteriaBuilder.equal(root.get("categoryName").as(String.class), category.getCategoryName()));
            }Predicate[] p = new Predicate[list.size()];
            return criteriaBuilder.and(list.toArray(p));
        }, pageable);

        List<CategoryVo> list = new ArrayList<>(10);
        final List<Category> content = categoryPage.getContent();
        content.stream().forEach(e->{
            CategoryVo categoryVo = new CategoryVo();
            final Business one = businessRepository.getOne(e.getBusinessId());
            categoryVo.setBusinessName(one.getBusinessName());
            BeanUtils.copyProperties(e,categoryVo);
            list.add(categoryVo);
        });
        return new PageImpl<>(list, pageable, categoryPage.getTotalElements());
    }

    @Override
    public List<Category> findAllByBusinessId(Integer business) {
        return categoryRepository.findAllByBusinessId(business);
    }
}
